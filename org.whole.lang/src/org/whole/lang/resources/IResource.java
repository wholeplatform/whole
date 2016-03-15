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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.ITemplate;


/**
 * @author Riccardo Solmi
 */
public interface IResource extends ITemplate {
	public <T extends IResource> IResourceRegistry<T> getResourceRegistry();

	public IPersistenceKit getResourcePersistenceKit();
	public void setResourcePersistenceKit(IPersistenceKit persistenceKit);
	public IPersistenceProvider getResourcePersistenceProvider();
	public void setResourcePersistenceProvider(IPersistenceProvider persistenceProvider);

	public <E extends IEntity> E getEntity();
	public void setEntity(IEntity entity);

	public <E extends IEntity> E getEntity(String uriFragment);
	public String getURIFragment(IEntity entity);

	//public void call(IEntity selfModel, IBindingManager bindings);

	public <E extends IEntity> IEntityIterator<E> apply(IEntity query, IBindingManager bindings);
	public <E extends IEntity> IEntityIterator<E> apply(String uriFragment, IEntity query, IBindingManager bindings);

	public void apply(String uriFragment, IBuilderOperation operation);

//	public boolean isLoaded();
//	public void load(IBindingManager bindings);
//	public void unload();
//	public void save(IBindingManager bindings);
//	public void delete(IBindingManager bindings);

	public String getURI();
	public String getNamespace();	
	public String getName();
	public String getVersion();
//	public String getBuild();

	public String getQualifiedName(); //derived: namespace+'.'+name
}
