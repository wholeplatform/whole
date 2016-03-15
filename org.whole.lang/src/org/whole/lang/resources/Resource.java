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

import java.io.File;
import java.net.URI;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class Resource implements IResource {
	private IResourceRegistry<? extends IResource> resourceRegistry;
	private IPersistenceKit resourcePersistenceKit;
	private IPersistenceProvider resourcePersistenceProvider;
	private IResourceInfo resourceInfo = StateDerivedResourceInfo.instance;
	protected IEntity entity;
	private String uri;
	private String namespace;
	private String name;
	private String version;

	@SuppressWarnings("unchecked")
	public IResourceRegistry<?> getResourceRegistry() {
		return resourceRegistry;
	}
	public void setResourceRegistry(IResourceRegistry<?> resourceRegistry) {
		if (this.resourceRegistry == resourceRegistry)
			return;

		if (this.resourceRegistry != null && resourceRegistry != null)
			throw new IllegalArgumentException("The resource is already indexed: "+this);

		this.resourceRegistry = resourceRegistry;
	}

	public IPersistenceKit getDefaultResourcePersistenceKit() {
		return ReflectionFactory.getDefaultPersistenceKit();
	}	
	public IPersistenceKit getResourcePersistenceKit() {
		if (resourcePersistenceKit == null)
			resourcePersistenceKit = getDefaultResourcePersistenceKit();//TODO delegate resourceRegistry
		return resourcePersistenceKit;
	}
	public void setResourcePersistenceKit(IPersistenceKit persistenceKit) {
		this.resourcePersistenceKit = persistenceKit;
	}

	public IPersistenceProvider getResourcePersistenceProvider() {
		if (resourcePersistenceProvider == null)
			try {//TODO delegate resourceRegistry
				resourcePersistenceProvider = new FilePersistenceProvider(new File(new URI(getURI())));
			} catch (Exception e) {
				throw new IllegalStateException("cannot load resource from specified uri", e);
			}
		return resourcePersistenceProvider;
	}
	public void setResourcePersistenceProvider(IPersistenceProvider persistenceProvider) {
		this.resourcePersistenceProvider = persistenceProvider;
	}

	public void setResourceInfo(IResourceInfo resourceInfo) {
		this.resourceInfo = resourceInfo;
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> E getEntity() {
		if (entity == null) {
			try {
				setEntity(getResourcePersistenceKit().readModel(getResourcePersistenceProvider()));

				IBindingManager bm = BindingManagerFactory.instance.createArguments();
				bm.wDefValue("languageKit", this);
				InterpreterOperation.interpret(entity, bm);
			} catch (Exception e) {
			}
		}
		return (E) entity;
	}
	public void setEntity(IEntity entity) {
		this.entity = entity;
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> E getEntity(String uriFragment) {
		return (E) EntityUtils.getEntity(getEntity(), uriFragment);
	}

	public String getURIFragment(IEntity entity) {
		return EntityUtils.getLocation(entity);
	}

	public <E extends IEntity> IEntityIterator<E> apply(IEntity query, IBindingManager bindings) {
		return apply((IEntity) getEntity(), query, bindings);//FIXME workaround for Java 8 compiler
	}
	public <E extends IEntity> IEntityIterator<E> apply(String uriFragment, IEntity query, IBindingManager bindings) {
		return apply((IEntity) getEntity(uriFragment), query, bindings);//FIXME workaround for Java 8 compiler
	}
	protected <E extends IEntity> IEntityIterator<E> apply(IEntity entity, IEntity query, IBindingManager bindings) {
		IEntityIterator<E> iterator = IteratorFactory.templateInterpreterIterator(query);
		iterator.setBindings(bindings);
		iterator.reset(entity);
		return iterator;
	}

	public void apply(IBuilderOperation operation) {
		apply((IEntity) getEntity(), operation);//FIXME workaround for Java 8 compiler
	}
	public void apply(String uriFragment, IBuilderOperation operation) {
		apply((IEntity) getEntity(uriFragment), operation);//FIXME workaround for Java 8 compiler
	}
	protected void apply(IEntity entity, IBuilderOperation operation) {
		new ModelTemplate(entity).apply(operation);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IResource))
			return false;
		IResource other = (IResource) obj;
		return getURI().equals(other.getURI());
	}

	public String getURI() {
		return resourceInfo.getURI(uri);
	}
	public void setURI(String uri) {
		resourceInfo.setURI(this.uri = uri);
	}

	public String getNamespace() {
		return resourceInfo.getNamespace(namespace);
	}
	public void setNamespace(String namespace) {
		resourceInfo.setNamespace(this.namespace = namespace);
	}

	public String getName() {
		return resourceInfo.getName(name);
	}
	public void setName(String name) {
		resourceInfo.setName(this.name = name);
	}

	public String getVersion() {
		return resourceInfo.getVersion(version);
	}
	public void setVersion(String version) {
		resourceInfo.setVersion(this.version = version);
	}

	public String getQualifiedName() {
		String namespace = getNamespace();
		return namespace != null && namespace.length() > 0 ? namespace+"."+getName() : getName();
	}

	@Override
	public String toString() {
		return getName()+'('+getURI()+')';
	}
}
