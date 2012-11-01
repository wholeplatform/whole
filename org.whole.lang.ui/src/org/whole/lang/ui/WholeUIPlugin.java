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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.whole.lang.ui.editors.WholeGraphicalEditor;


/**
 * @author Riccardo Solmi
 */
public class WholeUIPlugin extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "org.whole.lang.ui";
	private static final int INTERNAL_ERROR = 120;

	private static WholeUIPlugin plugin;
	private ColorRegistry colorRegistry;
	private FontRegistry fontRegistry;
	
	public WholeUIPlugin() {
		super();
		plugin = this;
	}
	public static WholeUIPlugin getDefault() {
		return plugin;
	}
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return getDefault().getWorkbench().getActiveWorkbenchWindow();
	}	
	public static Shell getActiveWorkbenchShell() {
		 IWorkbenchWindow window= getActiveWorkbenchWindow();
		 if (window != null) {
		 	return window.getShell();
		 }
		 return null;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		Platform.getExtensionRegistry().addRegistryChangeListener(GlobalActionExtensions.instance());
		Platform.getExtensionRegistry().addRegistryChangeListener(ResourceBindingsContributorExtensions.instance());
		Platform.getExtensionRegistry().addRegistryChangeListener(SearchScopeFilterExtensions.instance());
	}

	public void stop(BundleContext context) throws Exception {
		Platform.getExtensionRegistry().removeRegistryChangeListener(GlobalActionExtensions.instance());
		Platform.getExtensionRegistry().removeRegistryChangeListener(ResourceBindingsContributorExtensions.instance());
		Platform.getExtensionRegistry().removeRegistryChangeListener(SearchScopeFilterExtensions.instance());
		super.stop(context);
	}

	/**
	 * Returns a <code>org.eclipse.jface.resource.ImageDescriptor</code> representing
	 * the image loaded using the relative path.
	 *  
	 * @param relativePath plugin's relative path to the image resource
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(String relativePath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, relativePath);
	}

	/**
	 * Logs the specified status with this plug-in's log.
	 * 
	 * @param status status to log
	 */
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	/**
	 * Logs the specified throwable with this plug-in's log.
	 * 
	 * @param t throwable to log 
	 */
	public static void log(Throwable t) {
		log(newErrorStatus("Error logged from Whole plug-in: ", t)); //$NON-NLS-1$
	}
	
	/**
	 * Returns a new error status for this plugin with the given message
	 * @param message the message to be included in the status
	 * @param exception the exception to be included in the status or <code>null</code> if none
	 * @return a new error status
	 */
	public static IStatus newErrorStatus(String message, Throwable exception) {
		return new Status(IStatus.ERROR, getUniqueIdentifier(), INTERNAL_ERROR, message, exception);
	}
	
	/**
	 * Convenience method which returns the unique identifier of this plugin.
	 */
	public static String getUniqueIdentifier() {
		if (getDefault() == null) {
			return PLUGIN_ID;
		}
		return getDefault().getBundle().getSymbolicName();
	}

	public ColorRegistry getColorRegistry() {
		if (colorRegistry == null)
			colorRegistry = new ColorRegistry(Display.getCurrent());
		return colorRegistry;
	}
	public FontRegistry getFontRegistry() {
		if (fontRegistry == null) {
			Display display = Display.getCurrent();
			fontRegistry = new FontRegistry(display);
			initFontRegistry(display, fontRegistry);
		}
		return fontRegistry;
	}
	protected void initFontRegistry(Display display, FontRegistry fontRegistry) {
		try {
			URL url = getBundle().getEntry("/fonts/opensymbol.ttf");
			IPath fontPath = new Path(FileLocator.toFileURL(url).getPath());
			if (display.loadFont(fontPath.toOSString())) {
				fontRegistry.put(OPEN_SYMBOL_SMALL, new FontData[]{new FontData("OpenSymbol", 8, SWT.NONE)} );
				fontRegistry.put(OPEN_SYMBOL, new FontData[]{new FontData("OpenSymbol", 12, SWT.NONE)} );
				fontRegistry.put(OPEN_SYMBOL_MEDIUM, new FontData[]{new FontData("OpenSymbol", 14, SWT.NONE)} );
				fontRegistry.put(OPEN_SYMBOL_LARGE, new FontData[]{new FontData("OpenSymbol", 21, SWT.NONE)} );
			} else
				throw new SWTException("Device.loadFont failed");				

//			url = getBundle().getEntry("/fonts/STIXMath-Regular.otf");
//			fontPath = new Path(FileLocator.toFileURL(url).getPath());
//			if (display.loadFont(fontPath.toOSString())) {
//				fontRegistry.put(OPEN_SYMBOL_SMALL, new FontData[]{new FontData("STIXMath", 8, SWT.NONE)} );
//				fontRegistry.put(OPEN_SYMBOL, new FontData[]{new FontData("STIXMath", 12, SWT.NONE)} );
//				fontRegistry.put(OPEN_SYMBOL_MEDIUM, new FontData[]{new FontData("STIXMath", 14, SWT.NONE)} );
//				fontRegistry.put(OPEN_SYMBOL_LARGE, new FontData[]{new FontData("STIXMath", 21, SWT.NONE)} );
//			} else
//				throw new SWTException("Device.loadFont failed");				
		} catch (Exception e) {
			log(new IllegalStateException("Unable to load OpenSymbol font", e));
		}
	}

	public static final String OPEN_SYMBOL_SMALL = PLUGIN_ID+".opensymbol-small";
	public static final String OPEN_SYMBOL = PLUGIN_ID+".opensymbol";
	public static final String OPEN_SYMBOL_MEDIUM = PLUGIN_ID+".opensymbol-medium";
	public static final String OPEN_SYMBOL_LARGE = PLUGIN_ID+".opensymbol-large";
	public static Font getOpenSymbolSmallFont() {
		return getDefault().getFontRegistry().get(OPEN_SYMBOL_SMALL);
	}
	public static Font getOpenSymbolFont() {
		return getDefault().getFontRegistry().get(OPEN_SYMBOL);
	}
	public static Font getOpenSymbolMediumFont() {
		return getDefault().getFontRegistry().get(OPEN_SYMBOL_MEDIUM);
	}
	public static Font getOpenSymbolLargeFont() {
		return getDefault().getFontRegistry().get(OPEN_SYMBOL_LARGE);
	}

	public static IEditorPart[] getGraphicalEditors() {
		List<IEditorPart> result= new ArrayList<IEditorPart>(10);
		IWorkbench workbench= getDefault().getWorkbench();
		IWorkbenchWindow[] windows= workbench.getWorkbenchWindows();
		for (int windowIndex= 0; windowIndex < windows.length; windowIndex++) {
			IWorkbenchPage[] pages= windows[windowIndex].getPages();
			for (int pageIndex= 0; pageIndex < pages.length; pageIndex++) {
				IEditorReference[] references= pages[pageIndex].getEditorReferences();
				for (int refIndex= 0; refIndex < references.length; refIndex++) {
					IEditorPart editor= references[refIndex].getEditor(false);
					if (editor instanceof WholeGraphicalEditor)
						result.add(editor);
				}
			}
		}
		return (IEditorPart[])result.toArray(new IEditorPart[result.size()]);
	}

	public static IViewPart findView(String viewId) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (activePage == null)
			return null;
		return activePage.findView(viewId);
	}

	public static boolean isViewVisible(String viewId) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart part = activePage.findView(viewId);
		if (part == null)
			return false;
		return activePage.isPartVisible(part);
	}
	public static boolean isViewVisible(IViewPart view) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (activePage == null)
			return false;
		return activePage.isPartVisible(view);
	}

	public static void revealPerspective(String perspectiveId) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();		
		IPerspectiveDescriptor perspectiveDescriptor = PlatformUI.getWorkbench().getPerspectiveRegistry().findPerspectiveWithId(perspectiveId);
		activePage.setPerspective(perspectiveDescriptor);
	}

	public static IViewPart revealView(String viewId) {
		return revealView(viewId, null);
	}
	public static IViewPart revealView(String viewId, String secondaryID) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart part = activePage.findView(viewId);
		if (part == null)
			try {
				part = activePage.showView(viewId, secondaryID, IWorkbenchPage.VIEW_VISIBLE);
			} catch (PartInitException e) {
			}
		else
			activePage.bringToTop(part);
		return part;
	}
}
