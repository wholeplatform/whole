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
package org.whole.lang.builders;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;


/**
 * @author Riccardo Solmi
 */
public abstract class AbstractBuilderOperation implements IBuilderOperation {
	private IBindingManager bindings;
	private final Map<String, IBuilder> builderMap = new HashMap<String, IBuilder>();
	protected IBuilder genericBuilder;
	protected IBuilderOperation genericBuilderOperation;
	protected IBuilderOperation specificBuilderOperation;

	public IBindingManager getBindings() {
		if (bindings == null)
			bindings = BindingManagerFactory.instance.createBindingManager();
		return bindings;
	}
	public IBuilderOperation withBindings(IBindingManager bindings) {
		this.bindings = bindings;
		return this;
	}
	public String getContextURI() {
		return bindings != null && getBindings().wIsSet("contextURI") ?
			getBindings().wStringValue("contextURI") : null;
	}

	public IBuilder wGetBuilder() {
	    if (genericBuilder == null)
	    	genericBuilder = createGenericBuilder();
	    return genericBuilder;
	}
	public IBuilder wGetBuilder(String languageURI) {
	    return wGetBuilder(languageURI, false);
	}
	public IBuilder wGetBuilder(String languageURI, boolean log) {
		IBuilder builder = builderMap.get(languageURI);
	    if (builder == null) {
	    	builder = createSpecificBuilder(languageURI);
	    	if (builder == null)
		    	builder = createSpecificBuilderAdapter(languageURI, log);

	    	builderMap.put(languageURI, builder);
	    }
	    return builder;
	}

	protected IBuilder createGenericBuilder() {
		throw new UnsupportedOperationException("The generic builder for the operation: "+wGetOperationId()+" is not available");
	}
	protected IBuilder createSpecificBuilder(String languageURI) {
//TODO		ReflectionFactory.getLanguageKit(languageURI)
//			.getBuilder(wGetOperationId()).create(strategy, entityContext);
		return null; //TODO ? default = forwardGeneric
	}
	protected IBuilder createGenericBuilderAdapter(String languageURI, boolean log) {
		if (genericBuilderOperation == null)
			genericBuilderOperation = createGenericBuilderAdapterOperation(wGetBuilder(languageURI, log));
		return genericBuilderOperation.wGetBuilder(languageURI, log);
	}
	protected IBuilderOperation createGenericBuilderAdapterOperation(IBuilder targetBuilder) {
		return new GenericBuilderAdapterOperation(targetBuilder).withBindings(getBindings());
	}
	protected IBuilder createSpecificBuilderAdapter(String languageURI, boolean log) {
		if (specificBuilderOperation == null)
			specificBuilderOperation = createSpecificBuilderAdapterOperation(wGetBuilder());
		return specificBuilderOperation.wGetBuilder(languageURI, log);
	}
	protected IBuilderOperation createSpecificBuilderAdapterOperation(IBuilder targetBuilder) {
		return new SpecificBuilderAdapterOperation(targetBuilder).withBindings(getBindings());
	}
}
