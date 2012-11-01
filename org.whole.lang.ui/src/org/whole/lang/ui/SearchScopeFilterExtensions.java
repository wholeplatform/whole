/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.whole.lang.ui.search.WholeSearchScope;
import org.whole.lang.ui.search.WholeSearchScope.ISearchScopeFilter;

public class SearchScopeFilterExtensions implements IRegistryChangeListener {
	private static final String EXTENSION_POINT_ID = "org.whole.lang.ui.searchScopeFilters";

	private static class SingletonHolder {
		private static final SearchScopeFilterExtensions instance = new SearchScopeFilterExtensions();
	}
	public static SearchScopeFilterExtensions instance() {
		return SingletonHolder.instance;
	}

	private Map<String,ISearchScopeFilter> filters;

	private SearchScopeFilterExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(EXTENSION_POINT_ID);
		IExtension[] extensions = extensionPoint.getExtensions();
		filters = new HashMap<String, ISearchScopeFilter>();
		
		for (IExtension extension : extensions)
			addSearchScopeFilter(extension);
	}

	public void registryChanged(IRegistryChangeEvent event) {
		IExtensionDelta[] extensionDeltas = event.getExtensionDeltas();

		for (IExtensionDelta extensionDelta : extensionDeltas)
			if (extensionDelta.getKind() == IExtensionDelta.ADDED)
				addSearchScopeFilter(extensionDelta.getExtension());
			else if (extensionDelta.getKind() == IExtensionDelta.REMOVED)
				removeSearchScopeFilter(extensionDelta.getExtension());
	}

	private void addFilter(String id, ISearchScopeFilter filter) {
		filters.put(id, filter);
	}

	private ISearchScopeFilter removeFilter(String id) {
		return filters.remove(id);
	}

	private void addSearchScopeFilter(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();

		for (IConfigurationElement element : elements) {
			ISearchScopeFilter filter;
			try {
				filter = (ISearchScopeFilter) element.createExecutableExtension("class");
				addFilter(element.getAttribute("id"), filter);
				WholeSearchScope.addSearchScopeFilter(filter);
			} catch (CoreException e) {
				WholeUIPlugin.log(e);
			}
		}
	}

	private void removeSearchScopeFilter(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();

		for (IConfigurationElement element : elements)
			WholeSearchScope.addSearchScopeFilter(removeFilter(element.getAttribute("id")));
	}
}
