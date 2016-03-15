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
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.contexts.IdentityEntityContext;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractBuilderAdapterOperation implements IBuilderOperation {
	private IBindingManager bindings;
	private final IBuilder targetBuilder;
	private final IEntityContext entityContext;
	private final Map<String, IBuilder> builderMap = new HashMap<String, IBuilder>();

	public AbstractBuilderAdapterOperation(IBuilder targetBuilder) {
		this.targetBuilder = targetBuilder;
		entityContext = createEntityContext();
	}

	public IBuilderOperation withBindings(IBindingManager bindings) {
		this.bindings = bindings;
		return this;
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			bindings = BindingManagerFactory.instance.createBindingManager();
		return bindings;
	}

	public String getContextURI() {
		return bindings != null && getBindings().wIsSet("contextURI") ?
			getBindings().wStringValue("contextURI") : null;
	}

	protected IEntityContext createEntityContext() {
		return new IdentityEntityContext();
	}

	public IBuilder wGetBuilder() {
		return targetBuilder;
	}
	public IBuilder wGetBuilder(String languageURI) {
	    return wGetBuilder(languageURI, false);
	}
	public IBuilder wGetBuilder(String languageURI, boolean log) {
	    IBuilder builder = builderMap.get(languageURI);
	    if (builder == null) {
	        builder = ReflectionFactory.getLanguageKit(languageURI, true, getContextURI()).getBuilder(wGetOperationId()).create(
	        		log ? GenericLoggerBuilder.instance(targetBuilder) : targetBuilder, entityContext);
	        builderMap.put(languageURI, builder);
	    }
	    return builder;
	}
}