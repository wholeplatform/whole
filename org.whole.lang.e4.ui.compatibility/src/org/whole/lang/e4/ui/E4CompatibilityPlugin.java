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
package org.whole.lang.e4.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.resources.GEFResources;
import org.eclipse.gef.resources.IImageDescriptorFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.ResourceBindingsContributorExtensions;

/**
 * @author Riccardo Solmi
 */
public class E4CompatibilityPlugin extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "org.whole.lang.e4.ui.compatibility";
	private static final int INTERNAL_ERROR = 120;

	private static E4CompatibilityPlugin plugin;

	public E4CompatibilityPlugin() {
		super();
		plugin = this;
	}
	public static E4CompatibilityPlugin getDefault() {
		return plugin;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		Platform.getExtensionRegistry().addRegistryChangeListener(ResourceBindingsContributorExtensions.instance());
		GEFResources.getInstance().setImageRegistry(getImageRegistry());
		IImageDescriptorFactory factory = new IImageDescriptorFactory() {
			public ImageDescriptor createFolder() {
				ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
				return sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER);
			}
			public ImageDescriptor createDeleteDisabled() {
				ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
				return sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE);
			}
			public ImageDescriptor createDelete() {
				ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
				return sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED);
			}
		};
		GEFResources.getInstance().setImageDescriptorFactory(factory);
	}

	public void stop(BundleContext context) throws Exception {
		Platform.getExtensionRegistry().removeRegistryChangeListener(ResourceBindingsContributorExtensions.instance());
		super.stop(context);
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(Throwable t) {
		log(newErrorStatus("Error logged from Whole plug-in: ", t)); //$NON-NLS-1$
	}

	public static IStatus newErrorStatus(String message, Throwable exception) {
		return new Status(IStatus.ERROR, getUniqueIdentifier(), INTERNAL_ERROR, message, exception);
	}

	public static void reportError(final Shell activeShell, final String title, final String message) {
		reportError(activeShell, title, message, null);		
	}
	public static void reportError(final Shell activeShell, final String title, final String message, final Throwable t) {
		if (t != null)
			E4CompatibilityPlugin.log(t);
		Display display = activeShell != null && !activeShell.isDisposed() ?
				activeShell.getDisplay() : Display.getDefault();
		display.syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(activeShell, title, message + (t != null ? "\n\nSee the error log for more details." : ""));
			}
		});
	}

	public static String getUniqueIdentifier() {
		if (getDefault() == null) {
			return PLUGIN_ID;
		}
		return getDefault().getBundle().getSymbolicName();
	}

	public static void revealPerspective(String perspectiveId) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();		
		IPerspectiveDescriptor perspectiveDescriptor = PlatformUI.getWorkbench().getPerspectiveRegistry().findPerspectiveWithId(perspectiveId);
		activePage.setPerspective(perspectiveDescriptor);
	}
	public static boolean openEditor(IEclipseContext context, IFile file, IPersistenceKit persistenceKit) {
		IEditorPart editorPart = context.get(IEditorPart.class);
		try {
			if (editorPart != null) {
				IWorkbenchPage page = editorPart.getEditorSite().getPage();
				if (page != null) {
					String editorID = ReflectionFactory.getEditorIdFromPersistenceKit(persistenceKit);
					IDE.setDefaultEditor(file, editorID);
					IDE.openEditor(page, file, true);
				}
			}
		} catch (PartInitException e) {
			E4CompatibilityPlugin.reportError((Shell) context.get(IServiceConstants.ACTIVE_SHELL), "Open editor error", "Error while trying to open an editor");
			return false;
		}
		return true;
	}
}
