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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ResourceRegistry<T extends IResource> implements IResourceRegistry<T> {
	protected List<IResourceRegistryListener<T>> resourceRegistryListeners = new ArrayList<IResourceRegistryListener<T>>();
	protected IResourceFactoryRegistry resourceFactoryRegistry;
	protected IURIResolverRegistry uriResolverRegistry;
	private Set<T> publicResources = new HashSet<T>();
	private Map<String, T> uriResourceMap = new HashMap<String, T>();
	private Map<String, Set<T>> qnameResourcesMap = new HashMap<String, Set<T>>();
	private Map<String, Integer> nameOccurrencesMap = new HashMap<String, Integer>();

	protected ResourceRegistry() {
		this(new URLURIResolver(), new ClasspathURIResolver(), new WholeURIResolver(), new FileURIResolver());
	}
	protected ResourceRegistry(IURIResolver... uriResolvers) {
		resourceFactoryRegistry = new ResourceFactoryRegistry(this);
		uriResolverRegistry = new URIResolverRegistry(this);
		for (IURIResolver uriResolver : uriResolvers)
			uriResolverRegistry.addURIResolver(uriResolver);
	}

	public void addResourceRegistryListener(IResourceRegistryListener<T> listener) {
		resourceRegistryListeners.add(listener);
	}
	public void removeResourceRegistryListener(IResourceRegistryListener<T> listener) {
		resourceRegistryListeners.remove(listener);
	}

	public IResourceFactoryRegistry getResourceFactoryRegistry() {
		return resourceFactoryRegistry;
	}
	public IURIResolverRegistry getURIResolverRegistry() {
		return uriResolverRegistry;
	}

	private static Map<String, IResourceRegistry<?>> registryMap = new HashMap<String, IResourceRegistry<?>>();
	public static boolean hasRegistry(String id) {
		return registryMap.containsKey(id);
	}
	@SuppressWarnings("unchecked")
	public static <T extends IResource> IResourceRegistry<T> getRegistry(String id) {
		IResourceRegistry<T> registry = (IResourceRegistry<T>) registryMap.get(id);
		if (registry == null)
			putRegistry(id, registry = new ResourceRegistry<T>());
		return registry;
	}
	public static void putRegistry(String id, IResourceRegistry<?> registry) {
		registryMap.put(id, registry);
	}


	public int getResourceNameOccurrences(T resource) {
		Integer occurrences = nameOccurrencesMap.get(resource.getName());
		return occurrences != null ? occurrences : 0;
	}

	public int getResourceQualifiedNameOccurrences(T resource) {
		Set<T> resourceSet = qnameResourcesMap.get(resource.getQualifiedName());
		return resourceSet != null ? resourceSet.size() : 0;
	}

	public boolean isResourceVersionAmbiguous(T resource) {
		Set<T> resourceSet = qnameResourcesMap.get(resource.getQualifiedName());
		if (resourceSet != null && resourceSet.size() >= 2) {
			String version = resource.getVersion();
			for (T other : resourceSet)
				if (version.equals(other.getVersion()) && !resource.equals(other))
					return true;
		}
		return false;
	}

	public boolean containsResource(String uri, boolean loadOnDemand, String contextUri) {
		return getResource(uri, loadOnDemand, contextUri) != null;
	}

	protected Set<String> uriFailureSet = new HashSet<String>();

	@SuppressWarnings("unchecked")
	public T getResource(String uri, boolean loadOnDemand, String contextUri) {
		T resource = uriResourceMap.get(uri);
		if (resource == null && loadOnDemand && !uriFailureSet.contains(uri))
			try {
				IPersistenceProvider pp = getURIResolverRegistry().resolve(contextUri, uri);
				if (pp.exists()) {
					resource = (T) getResourceFactoryRegistry().createResource(uri);
					resource.setResourcePersistenceProvider(pp);

					uriResourceMap.put(uri, resource);
					final boolean isValidResource = resource.getEntity() != null && resource.getName() != null;
					uriResourceMap.remove(uri);

					if (isValidResource)
						addResource(resource, false);
					else {
						resource = null;
						uriFailureSet.add(uri);
					}
				}
			} catch (IllegalArgumentException e) {
			}

		return resource;
	}

	public <E extends IEntity> E getResourceModel(String uri, boolean loadOnDemand, String contextUri) {
		IResource resource = getResource(uri, loadOnDemand, contextUri);
		return resource == null ? null : resource.<E>getEntity();
	}

	@SuppressWarnings("unchecked")
	public T createResource(String uri, boolean hidden) {
		T resource = (T) getResourceFactoryRegistry().createResource(uri);
		try {
			IPersistenceProvider pp = getURIResolverRegistry().resolve(null, uri);
			resource.setResourcePersistenceProvider(pp);
		} catch (IllegalArgumentException e) {
		}
		addResource(resource, hidden);
		return resource;
	}

	@SuppressWarnings("unchecked")
	public boolean addResource(IEntity entity, String uri, boolean hidden) {
		T resource = (T) getResourceFactoryRegistry().createResource(uri, entity.wGetEntityDescriptor());
		resource.setEntity(entity);
		return addResource(resource, hidden);
	}
	public boolean addResource(T resource, boolean hidden) {
		T oldResource = getResource(resource.getURI(), false, null);
		boolean removed = removeResource(resource.getURI());

		uriResourceMap.put(resource.getURI(), resource);
		((Resource) resource).setResourceRegistry(this);//TODO InternalIResource

		if (!hidden)
			publicResources.add(resource);

		String resourceQName = resource.getQualifiedName();
		if (resourceQName != null) {
			Set<T> resourceSet = qnameResourcesMap.get(resourceQName);
			if (resourceSet == null)
				qnameResourcesMap.put(resourceQName, resourceSet = new HashSet<T>());
			resourceSet.add(resource);
		}

		String resourceName = resource.getName();
		if (resourceName != null) {
			Integer occurrences = nameOccurrencesMap.get(resourceName);
			if (occurrences == null)
				nameOccurrencesMap.put(resourceName, new Integer(1));
			else
				nameOccurrencesMap.put(resourceName, new Integer(occurrences.intValue() + 1));
		}

		if (removed)
			for (IResourceRegistryListener<T> resourceChangeHandler : resourceRegistryListeners)
				resourceChangeHandler.notifyChanged(oldResource, resource);
		else
			for (IResourceRegistryListener<T> resourceChangeHandler : resourceRegistryListeners)
				resourceChangeHandler.notifyAdded(resource);

		return !removed;
	}
	public boolean removeResource(String uri) {
		T resource = uriResourceMap.remove(uri);
		if (resource == null)
			return false;
		publicResources.remove(resource);
		((Resource) resource).setResourceRegistry(null);//TODO InternalIResource

		String resourceQName = resource.getQualifiedName();
		if (resourceQName != null) {
			Set<T> resourceSet = qnameResourcesMap.get(resourceQName);
			if (resourceSet != null) {
				resourceSet.remove(resource);
				if (resourceSet.isEmpty())
					qnameResourcesMap.remove(resourceQName);
			}
		}

		String resourceName = resource.getName();
		if (resourceName != null && nameOccurrencesMap.containsKey(resourceName)) {
			int occurrences = nameOccurrencesMap.get(resourceName);
			if (occurrences == 1)
				nameOccurrencesMap.remove(resourceName);
			else
				nameOccurrencesMap.put(resourceName, new Integer(occurrences - 1));
		}

		for (IResourceRegistryListener<T> resourceChangeHandler : resourceRegistryListeners)
			resourceChangeHandler.notifyRemoved(resource);

		return true;
	}

	public Set<T> getResourceVersions(String qualifiedName) {
		Set<T> resourceVersions = qnameResourcesMap.get(qualifiedName);
		return resourceVersions != null ?
				resourceVersions : Collections.<T>emptySet();
	}

	public Collection<T> getResources(boolean includeHidden) {
		return Collections.unmodifiableCollection(
				includeHidden ? uriResourceMap.values() : publicResources);
	}
	public SortedSet<T> getResources(boolean includeHidden, Comparator<? super T> comparator) {
		SortedSet<T> sortedSet = new TreeSet<T>(comparator);
		sortedSet.addAll(
				includeHidden ? uriResourceMap.values() : publicResources);
		return sortedSet;
	}
}
