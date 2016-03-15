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

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public interface IResourceRegistry<T extends IResource> {
	public void addResourceRegistryListener(IResourceRegistryListener<T> listener);
	public void removeResourceRegistryListener(IResourceRegistryListener<T> listener);

	public IResourceFactoryRegistry getResourceFactoryRegistry();
	public IURIResolverRegistry getURIResolverRegistry();

	public int getResourceNameOccurrences(T resource);
	public int getResourceQualifiedNameOccurrences(T resource);
	public boolean isResourceVersionAmbiguous(T resource);

	public boolean containsResource(String uri, boolean loadOnDemand, String contextUri);
	public T getResource(String uri, boolean loadOnDemand, String contextUri);
	public <E extends IEntity> E getResourceModel(String uri, boolean loadOnDemand, String contextUri);
	public T createResource(String uri, boolean hidden);
	public boolean addResource(IEntity entity, String uri, boolean hidden);
	public boolean addResource(T resource, boolean hidden);
	public boolean removeResource(String uri);

	public Set<T> getResourceVersions(String qualifiedName);
	public Collection<T> getResources(boolean includeHidden);
	public SortedSet<T> getResources(boolean includeHidden, Comparator<? super T> comparator);
}
