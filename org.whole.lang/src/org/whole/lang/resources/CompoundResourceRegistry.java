/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.resources;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.ICloneable;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class CompoundResourceRegistry<T extends IResource> extends ResourceRegistry<T> {
	public CompoundResourceRegistry() {
		super();//TODO test WAS new URLURIResolver(), new WholeURIResolver(), new FileURIResolver());
	}
	public CompoundResourceRegistry(IURIResolver... uriResolvers) {
		super(uriResolvers);
	}

	public <E extends IEntity> E getFunctionLibrary(String libraryUri, boolean loadOnDemand, String contextUri) {
		E functionLibrary = getResourceModel(libraryUri, false, contextUri);
		final boolean needInterpretation = functionLibrary == null;
		if (needInterpretation && loadOnDemand) {
			functionLibrary = getResourceModel(libraryUri, loadOnDemand, contextUri);
			IBindingManager args = BindingManagerFactory.instance.createArguments();
			args.wDefValue("LazyInterpretation", true);
			InterpreterOperation.interpret(functionLibrary, args);
		}
		return functionLibrary;
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> E getFunctionModel(String functionUri, boolean loadOnDemand, String contextUri) {
		IEntity functionModel = uriModelMap.get(functionUri);
		if (functionModel == null && loadOnDemand && ResourceUtils.hasFragmentPart(functionUri)) {
			String libraryUri = ResourceUtils.getResourcePart(functionUri);
			getFunctionLibrary(libraryUri, loadOnDemand, contextUri);
			functionModel = uriModelMap.get(functionUri);
		}
		return (E) functionModel;
	}

	protected Map<String, IEntity> uriModelMap = new HashMap<String, IEntity>();
	public void putFunctionModel(String functionUri, IEntity functionModel) {
		IEntity oldModel = uriModelMap.put(functionUri, functionModel);
		if (oldModel != null && !Matcher.match(oldModel, functionModel))
			uriCodeMap.remove(functionUri);
	}

	protected Map<String, ICloneable> uriCodeMap = new HashMap<String, ICloneable>();
	public void putFunctionCode(String functionUri, ICloneable functionCode) {
		uriCodeMap.put(functionUri, functionCode);

		String functionName = ResourceUtils.getFragmentPart(functionUri);
		uriCodeMap.put(functionName, functionCode);
	}
	@SuppressWarnings("unchecked")
	public <B extends ICloneable> B getFunctionCode(String functionUri, boolean loadOnDemand, String contextUri) {
		ICloneable functionCode = uriCodeMap.get(functionUri);
		if (functionCode == null) {
			IEntity functionModel = getFunctionModel(functionUri, loadOnDemand, contextUri);
			functionCode = uriCodeMap.get(functionUri);

			if (functionModel != null && functionCode == null) {
				IBindingManager args = BindingManagerFactory.instance.createArguments();
				DynamicCompilerOperation.compile(functionModel, args);
				functionCode = uriCodeMap.get(functionUri);
			}
		}
		
		if (functionCode == null)
			functionCode = IteratorFactory.emptyIterator();//TODO should be configurable
			
		return (B) functionCode.clone();
	}
}
