/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.whole.lang.ui.actions.GlobalActionRegistry;

public class GlobalActionExtensions implements IRegistryChangeListener {
	private static final String EXTENSION_POINT_ID = "org.whole.lang.ui.globalactions";

	private static class SingletonHolder {
		private static final GlobalActionExtensions instance = new GlobalActionExtensions();
	}
	public static GlobalActionExtensions instance() {
		return SingletonHolder.instance;
	}

	private GlobalActionExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(EXTENSION_POINT_ID);
		IExtension[] extensions = extensionPoint.getExtensions();
		
		for (IExtension extension : extensions)
			addGlobalAction(extension);
	}

	public void registryChanged(IRegistryChangeEvent event) {
		IExtensionDelta[] extensionDeltas = event.getExtensionDeltas();// FIXME params

		for (IExtensionDelta extensionDelta : extensionDeltas)
			if (extensionDelta.getKind() == IExtensionDelta.ADDED)
				addGlobalAction(extensionDelta.getExtension());
			else if (extensionDelta.getKind() == IExtensionDelta.REMOVED)
				removeGlobalAction(extensionDelta.getExtension());
	}

	private void addGlobalAction(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();

		for (IConfigurationElement element : elements)
				GlobalActionRegistry.register(element);
	}

	private void removeGlobalAction(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();

		for (IConfigurationElement element : elements)
			GlobalActionRegistry.unregister(element);
	}
}
