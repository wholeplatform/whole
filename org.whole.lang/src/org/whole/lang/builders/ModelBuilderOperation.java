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
import org.whole.lang.contexts.EntityContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class ModelBuilderOperation implements IBuilderOperation {
	public static final String ID = "ModelBuilderOperation";
	private final IEntityContext entityContext = new EntityContext();
	private final IEntityRegistryProvider entityRegistryProvider;
	private final Map<String, IBuilder> builderMap = new HashMap<String, IBuilder>();
	private IBuilder genericBuilder;
	private IBindingManager bindings;
	
	public ModelBuilderOperation() {
		this(RegistryConfigurations.DEFAULT);
	}
	public ModelBuilderOperation(IEntityRegistryProvider provider) {
		entityRegistryProvider = provider;
	}
	
	public String wGetOperationId() {
		return ID;
	}

	public IBindingManager getBindings() {
		if (bindings == null)
			bindings = BindingManagerFactory.instance.createBindingManager();
		return bindings;
	}
	public ModelBuilderOperation withBindings(IBindingManager bindings) {
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
	        builder = createSpecificBuilderAdapter(languageURI, log);
			//TODO remove builder = log ? GenericLoggerBuilder.instance(builder) : builder;

	        builderMap.put(languageURI, builder);
	    }
	    return builder;
	}

	protected IBuilder createGenericBuilder() {
		return new ModelBuilder(entityContext, entityRegistryProvider);
	}
	protected IBuilder createSpecificBuilderAdapter(String languageURI, boolean log) {
		return createSpecificBuilderAdapter(languageURI, log, wGetBuilder());
	}
	protected IBuilder createSpecificBuilderAdapter(String languageURI, boolean log, IBuilder builder) {
		return ReflectionFactory.getLanguageKit(languageURI, true, getContextURI()).getBuilder(SpecificBuilderAdapterOperation.ID).create(
				log ? GenericLoggerBuilder.instance(builder) : builder,
				entityContext);
	}
	//TODO test me
	public IBuilder wGetNewBuilder(String languageURI) {
	    IBuilder builder = ReflectionFactory.getLanguageKit(languageURI).getBuilder(SpecificBuilderAdapterOperation.ID)
	    .create(
	    		new ModelBuilder(entityContext, entityRegistryProvider),
	    		new EntityContext((EntityContext) entityContext));
	    return builder;
	}

	public IEntity wGetResult() {
		//TODO add resolve references behavior or resolve on change trigger
		return entityContext.wGetResult();
	}
}
