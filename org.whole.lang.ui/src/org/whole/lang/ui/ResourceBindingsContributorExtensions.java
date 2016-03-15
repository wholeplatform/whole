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
package org.whole.lang.ui;

import java.util.Collection;
import java.util.Collections;
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
import org.whole.lang.ui.util.IResourceBindingsContributor;

public class ResourceBindingsContributorExtensions implements IRegistryChangeListener {
	private static final String EXTENSION_POINT_ID = "org.whole.lang.ui.resourceBindingsContributors";

	private static class SingletonHolder {
		private static final ResourceBindingsContributorExtensions instance = new ResourceBindingsContributorExtensions();
	}
	public static ResourceBindingsContributorExtensions instance() {
		return SingletonHolder.instance;
	}

	private Map<String,IResourceBindingsContributor> contributors;

	private ResourceBindingsContributorExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(EXTENSION_POINT_ID);
		IExtension[] extensions = extensionPoint.getExtensions();
		contributors = new HashMap<String, IResourceBindingsContributor>();
		
		for (IExtension extension : extensions)
			addResourceBindingsContributor(extension);
	}

	public void registryChanged(IRegistryChangeEvent event) {
		IExtensionDelta[] extensionDeltas = event.getExtensionDeltas();

		for (IExtensionDelta extensionDelta : extensionDeltas)
			if (extensionDelta.getKind() == IExtensionDelta.ADDED)
				addResourceBindingsContributor(extensionDelta.getExtension());
			else if (extensionDelta.getKind() == IExtensionDelta.REMOVED)
				removeResourceBindingsContributor(extensionDelta.getExtension());
	}

	private void addContributor(String id, IResourceBindingsContributor contributor) {
		contributors.put(id, contributor);
	}

	private IResourceBindingsContributor removeContributor(String id) {
		return contributors.remove(id);
	}
	public Collection<IResourceBindingsContributor> getContributors() {
		return Collections.unmodifiableCollection(contributors.values());
	}

	private void addResourceBindingsContributor(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();

		for (IConfigurationElement element : elements) {
			IResourceBindingsContributor contributor;
			try {
				contributor = (IResourceBindingsContributor) element.createExecutableExtension("class");
				addContributor(element.getAttribute("id"), contributor);
			} catch (CoreException e) {
				throw new IllegalStateException(e);
			}
		}
	}

	private void removeResourceBindingsContributor(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();

		for (IConfigurationElement element : elements)
			removeContributor(element.getAttribute("id"));
	}
}
