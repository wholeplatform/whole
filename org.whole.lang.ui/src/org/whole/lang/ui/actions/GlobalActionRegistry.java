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
package org.whole.lang.ui.actions;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.RetargetAction;
import org.osgi.framework.Bundle;
import org.whole.lang.ui.WholeUIPlugin;

public class GlobalActionRegistry {
	private static GlobalActionRegistry instance = new GlobalActionRegistry();
	
	private List<IConfigurationElement> globalActionList;
	private Map<String,IConfigurationElement> globalActionMap;
	private ListenerList listenerList;

	private GlobalActionRegistry() {
		globalActionList = new ArrayList<IConfigurationElement>();
		globalActionMap = new HashMap<String, IConfigurationElement>();
		listenerList = new ListenerList();
	}

	public static List<IConfigurationElement> getGlobalActionConfigurations() {
		return new ArrayList<IConfigurationElement>(instance.globalActionList);
	}

	public static IConfigurationElement getGlobalActionConfiguration(String actionId) {
		return instance.globalActionMap.get(actionId);
	}

	public static boolean register(IConfigurationElement element) {
		//FIXME workaround, should unregister the old configuration element and add the new one
		if (instance.globalActionMap.containsKey(element.getAttribute("id")))
			return false;

		if (instance.globalActionList.add(element)) {
			instance.globalActionMap.put(element.getAttribute("id"), element);
			instance.fireRegistryEvent(new GlobalActionRegistryEvent(element, GlobalActionRegistryEvent.ADDED));
			return true;
		}
		return false;
	}

	public static boolean unregister(IConfigurationElement element) {
		if (instance.globalActionList.remove(element)) {
			instance.fireRegistryEvent(new GlobalActionRegistryEvent(element, GlobalActionRegistryEvent.REMOVED));
			instance.globalActionMap.remove(element.getAttribute("id"));
			return true;
		}
		return false;
	}

	private void fireRegistryEvent(GlobalActionRegistryEvent event) {
		for(Object listener : listenerList.getListeners()) {
			((IGlobalActionRegistryListener)listener).registryChanged(event);
		}
	}

	public static void addRegistryListener(IGlobalActionRegistryListener listener) {
		instance.listenerList.add(listener);
	}

	public static void removeRegistryListener(IGlobalActionRegistryListener listener) {
		instance.listenerList.remove(listener);
	}
	
	public static String getGlobalActionId(IConfigurationElement element) {
		return element.getAttribute("id");		
	}
	
	public static GlobalActionProxy createGlobalActionProxy(IWorkbenchPart part, IConfigurationElement element) {
		GlobalActionProxy action = null;

		try {
			IEditorActionDelegate delegate = (IEditorActionDelegate) 
				element.createExecutableExtension("class");
			String id = element.getAttribute("id");
			action = new GlobalActionProxy(part, delegate);
			action.setId(id);
		} catch (CoreException e) {
			WholeUIPlugin.log(e);
		}
		return action;
	}

	public static RetargetAction createRetargetAction(IConfigurationElement element) {
		String id = element.getAttribute("id");
		ImageDescriptor icon = null;
		String label = element.getAttribute("label");
		String tooltip = element.getAttribute("tooltip");
		String iconPath = element.getAttribute("icon");
		if(iconPath != null) {
			String declaringBundeId = element.getContributor().getName();
			Bundle bundle = Platform.getBundle(declaringBundeId);
			URL url = FileLocator.find(bundle, new Path(iconPath), null);
			if(url != null)
				icon = ImageDescriptor.createFromURL(url);
		}
		RetargetAction action = new RetargetAction(id, label, IAction.AS_PUSH_BUTTON);
		if(icon != null)
			action.setImageDescriptor(icon);
		action.setToolTipText(tooltip);
		return action;
	}
}
