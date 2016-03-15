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
package org.whole.product.lw.launching;

import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.ENVIRONMENT;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.whole.lang.WholePlugin;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Enrico Persiani
 */
public class LaunchConfigurationUtils {
	@SuppressWarnings("unchecked")
	public static IBindingScope loadBindingScope(ILaunchConfiguration configuration) throws CoreException {
		Map<String, String> environmentMap = configuration.getAttribute(ENVIRONMENT, (Map<String, String>) null);
		IBindingScope scope = BindingManagerFactory.instance.createSimpleScope();

		if (environmentMap == null)
			return scope;

		for (String name : environmentMap.keySet())
			try {
				IEntity entity = XmlBuilderPersistenceKit.instance().readModel(
						new StringPersistenceProvider(environmentMap.get(name)));
				scope.wDef(name, entity);
			} catch (Exception e) {
				WholePlugin.log(e);
			}
		return scope;
	}

	public static void saveBindingScope(ILaunchConfigurationWorkingCopy configuration, IBindingScope scope) {
		Map<String, String> environmentMap = new HashMap<String, String>();
		for (String name : scope.wLocalNames())
			try {
				StringPersistenceProvider pp = new StringPersistenceProvider();
				XmlBuilderPersistenceKit.instance().writeModel(scope.wGet(name), pp); 
				environmentMap.put(name, pp.getStore());
			} catch (Exception e) {
				WholePlugin.log(e);
			}
		configuration.setAttribute(ENVIRONMENT, environmentMap);
	}
}
