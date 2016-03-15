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

import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.CONSOLE_VIEW;
import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.OPERATION_ID;
import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.PERSIST_CHANGES;
import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.TARGET_MODEL_PATH;
import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.TARGET_MODEL_PERSISTENCE;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.ui.console.IOConsole;
import org.whole.lang.WholePlugin;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.console.WholeConsoleFactory;
import org.whole.lang.ui.util.ResourceUtils;

/**
 * @author Enrico Persiani
 */
public class WholeOperationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
	private static final String PLUGIN_ID = "org.whole.product.lw";

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		if (!"run".equals(mode))
			throw new CoreException(new Status(Status.CANCEL, PLUGIN_ID, 1, "Only 'run' mode supported by this launcher", null));

		String operationId = configuration.getAttribute(OPERATION_ID, (String) null);
		if (operationId == null)
			throw new CoreException(new Status(Status.CANCEL, PLUGIN_ID, 1, "No operation selected", null));

		String targetModelPath = configuration.getAttribute(TARGET_MODEL_PATH, (String) null);
		if (targetModelPath == null)
			throw new CoreException(new Status(Status.CANCEL, PLUGIN_ID, 1, "No target model selected", null));

		String targetModelPersistence = configuration.getAttribute(TARGET_MODEL_PERSISTENCE, (String) null);
		if (targetModelPersistence == null)
			throw new CoreException(new Status(Status.CANCEL, PLUGIN_ID, 1, "No persistence selected", null));

		try {
			monitor.beginTask("Executing "+operationId+" operation...", 100);
			if (monitor.isCanceled())
				return;

			IOperationProgressMonitor operationProgressMonitor = new OperationProgressMonitorAdapter(monitor);

			IFile targetModelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromPortableString(targetModelPath));
			IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
			ResourceUtils.defineResourceBindings(bindings, targetModelFile);
			IBindingScope scope = LaunchConfigurationUtils.loadBindingScope(configuration);
			bindings.wEnterScope(scope, true);

			IPersistenceKit persistenceKit = ReflectionFactory.getPersistenceKit(targetModelPersistence);
			IEntity model = persistenceKit.readModel(new IFilePersistenceProvider(targetModelFile));
			IOperationLauncher operationLauncher = OperationLauncherRegistry.instance.getOperationLauncher(operationId);

			InputStream is = System.in;
			OutputStream os = System.out;
			if (configuration.getAttribute(CONSOLE_VIEW, false)) {
				IOConsole ioConsole = WholeConsoleFactory.getIOConsole();
				is = ioConsole.getInputStream();
				os = ioConsole.newOutputStream();
			}

			operationLauncher.launch(model, bindings, is, os, operationProgressMonitor);

			if (configuration.getAttribute(PERSIST_CHANGES, false))
				persistenceKit.writeModel(model, new IFilePersistenceProvider(targetModelFile));
		} catch (Throwable t) {
			WholePlugin.log(t);
		} finally {
			monitor.done();
		}
	}
}
