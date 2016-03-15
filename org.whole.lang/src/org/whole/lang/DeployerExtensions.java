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
package org.whole.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;


/**
 * @author Riccardo Solmi
 */
public class DeployerExtensions implements IRegistryChangeListener {
	private static final String EXTENSION_POINT_ID = "org.whole.lang.deployers";

	private static class SingletonHolder {
		private static final DeployerExtensions instance = new DeployerExtensions();
	}
	public static DeployerExtensions instance() {
		return SingletonHolder.instance;
	}

	private DeployerExtensions() {
		initDeployers();
	}

	private void initDeployers() {
    	IExtensionRegistry registry = Platform.getExtensionRegistry();
    	IExtensionPoint extensionPoint = registry.getExtensionPoint(EXTENSION_POINT_ID);
    	IExtension[] extensions = extensionPoint.getExtensions();
    
    	List<IDeployer> deployers = new ArrayList<IDeployer>(64);

   		for (int i=0; i<extensions.length; i++)
   			addDeployers(extensions[i], deployers);

   		Collections.sort(deployers, new Comparator<IDeployer>() {
			public int compare(IDeployer arg0, IDeployer arg1) {
				return arg0.getDeployLevel() - arg1.getDeployLevel();
			}   			
   		});

   		int i=0;
   		try {
	   	   	for (int size=deployers.size(); i<size; i++)
				ReflectionFactory.deploy(deployers.get(i));
   		} catch (Throwable e) {
			WholePlugin.log(new IllegalStateException("Error Deploying: "+deployers.get(i).toString()+" of: "+deployers.toString(), e));
   		}

	}
    private void addDeployers(IExtension extension, List<IDeployer> deployers) {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (int j=0; j<elements.length; j++) {
        	try {
        		deployers.add((IDeployer) elements[j].createExecutableExtension("class"));
        	} catch (CoreException e) {
        		WholePlugin.log(e);
        	}
        }
    }
	
    public void registryChanged(IRegistryChangeEvent event) {
	    IExtensionDelta[] delta = event.getExtensionDeltas();//FIXME params
	    for (int i=0; i<delta.length; i++) {
	        IExtensionDelta extensionDelta = delta[i];
	        
	        if (extensionDelta.getKind() == IExtensionDelta.ADDED)
	            addDeployer(extensionDelta.getExtension());
	        else if (extensionDelta.getKind() == IExtensionDelta.REMOVED)
	            removeDeployer(extensionDelta.getExtension());
	    }
	}
    private void addDeployer(IExtension extension) {
        IConfigurationElement[] elements = extension.getConfigurationElements();

        for (int j=0; j<elements.length; j++) {
        	try {
        		IDeployer deployer = (IDeployer) elements[j].createExecutableExtension("class");
//		        DeployerClassLoader.instance().addKit(deployer);
        		ReflectionFactory.deploy(deployer);
        	} catch (CoreException e) {
        		WholePlugin.log(e);
        	}
        }
    }
    private void removeDeployer(IExtension extension) {
        IConfigurationElement[] elements = extension.getConfigurationElements();

        for (int j = 0; j < elements.length; j++) {
        	try {
        		IDeployer deployer = (IDeployer) elements[j].createExecutableExtension("class");
        		ReflectionFactory.undeploy(deployer);
//        		DeployerClassLoader.instance().removeKit(deployer);
        	} catch (CoreException e) {
        		WholePlugin.log(e);
        	}
        }
    }
}
