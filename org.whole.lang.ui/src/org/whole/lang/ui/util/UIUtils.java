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
package org.whole.lang.ui.util;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.Fragment;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class UIUtils {
	public static final String LOCATION_REGEXP = "/(?:(?:(?:\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|(?:\\d+))/)*(?:(?:\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|(?:\\d+))?";
	public static final Pattern LOCATION_PATTERN = Pattern.compile(LOCATION_REGEXP);

	public static List<IEntityPart> getSelectedEntityParts(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size()>0 && structuredSelection.getFirstElement() instanceof IEntityPart)
				return getSelectedEntityParts(structuredSelection);
		}
		return Collections.emptyList();
	}
	@SuppressWarnings("unchecked")
	public static List<IEntityPart> getSelectedEntityParts(IStructuredSelection structuredSelection) {
		return (List<IEntityPart>) structuredSelection.toList();
	}
	public static IEntity getSelectedEntities(List<IEntityPart> selectedEntityParts) {
		IEntity selectedEntities = BindingManagerFactory.instance.createTuple();
		for (IEntityPart selectedEntityPart : selectedEntityParts)
			selectedEntities.wAdd(selectedEntityPart.getModelEntity());
		return selectedEntities;
	}

	public static void defSelectedEntities(IBindingManager bm, ISelection selection) {
		defSelectedEntities(bm, getSelectedEntityParts(selection));
	}
	public static void defSelectedEntities(IBindingManager bm, List<IEntityPart> selectedEntityParts) {
		defSelectedEntities(bm, getSelectedEntities(selectedEntityParts));
	}
	public static void defSelectedEntities(IBindingManager bm, IEntity entities) {
		bm.wDef("selectedEntities", entities);
		if (entities.wSize() > 0)
			bm.wDef("primarySelectedEntity", entities.wGet(0));
	}

	public static int getButtonWidthHint(Composite composite) {
		GC gc = new GC(composite);
		gc.setFont(composite.getFont());
		FontMetrics fFontMetrics = gc.getFontMetrics();
		int widthHint = Dialog.convertHorizontalDLUsToPixels(fFontMetrics, IDialogConstants.BUTTON_WIDTH);
		gc.dispose();
		return widthHint;
	}

	public static IEditorKit getEditorKit(IEntityPart selectedPart) {
		IEditorKit editorKit;

		IEntity parent = selectedPart.getParentModelEntity();
		if (parent != null && EntityUtils.isFragment(parent))
			editorKit = ((Fragment) parent).getRootEntity().wGetEditorKit();
		else
			editorKit = ReflectionFactory.getEditorKit((IEntity) selectedPart.getModelEntity());

		return editorKit;
	}

	public static Monitor getActiveMonitor() {
		Display display = Display.getDefault();
		Point cursorLocation = display.getCursorLocation();
		Monitor[] monitors = display.getMonitors();
		for (Monitor monitor : monitors)
			if (monitor.getBounds().contains(cursorLocation))
				return monitor;
		return display.getPrimaryMonitor();
	}

	private static ColorRegistry colorRegistry;
	private static FontRegistry fontRegistry;
	public static ColorRegistry getColorRegistry() {
		if (colorRegistry == null)
			colorRegistry = new ColorRegistry(Display.getCurrent());
		return colorRegistry;
	}
	public static FontRegistry getFontRegistry() {
		if (fontRegistry == null) {
			Display display = Display.getCurrent();
			fontRegistry = new FontRegistry(display);
			initFontRegistry(display, fontRegistry);
		}
		return fontRegistry;
	}
	protected static void initFontRegistry(Display display, FontRegistry fontRegistry) {
		try {
			URL url = Platform.getBundle("org.whole.lang.ui").getEntry("/fonts/opensymbol.ttf");
			IPath fontPath = new Path(FileLocator.toFileURL(url).getPath());
			if (display.loadFont(fontPath.toOSString())) {
				fontRegistry.put(OPEN_SYMBOL_SMALL, new FontData[]{new FontData("OpenSymbol", 8, SWT.NONE)} );
				fontRegistry.put(OPEN_SYMBOL, new FontData[]{new FontData("OpenSymbol", 12, SWT.NONE)} );
				fontRegistry.put(OPEN_SYMBOL_MEDIUM, new FontData[]{new FontData("OpenSymbol", 14, SWT.NONE)} );
				fontRegistry.put(OPEN_SYMBOL_LARGE, new FontData[]{new FontData("OpenSymbol", 21, SWT.NONE)} );
			} else
				return; // FIXME workaround font not loading on some mac os x 10.11.4 configurations
				//throw new SWTException("Device.loadFont failed");				

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
			throw new IllegalStateException("Unable to load OpenSymbol font", e);
		}
	}

	public static final String PLUGIN_ID = "org.whole.lang.ui";
	public static final String OPEN_SYMBOL_SMALL = PLUGIN_ID+".opensymbol-small";
	public static final String OPEN_SYMBOL = PLUGIN_ID+".opensymbol";
	public static final String OPEN_SYMBOL_MEDIUM = PLUGIN_ID+".opensymbol-medium";
	public static final String OPEN_SYMBOL_LARGE = PLUGIN_ID+".opensymbol-large";
	public static Font getOpenSymbolSmallFont() {
		return getFontRegistry().get(OPEN_SYMBOL_SMALL);
	}
	public static Font getOpenSymbolFont() {
		return getFontRegistry().get(OPEN_SYMBOL);
	}
	public static Font getOpenSymbolMediumFont() {
		return getFontRegistry().get(OPEN_SYMBOL_MEDIUM);
	}
	public static Font getOpenSymbolLargeFont() {
		return getFontRegistry().get(OPEN_SYMBOL_LARGE);
	}
	public static ColorRegistry getDefaultColorRegistry() {
		return getColorRegistry();
	}
	public static FontRegistry getDefaultFontRegistry() {
		return getFontRegistry();
	}

	//FIXME workaround for E4 products, should migrate to IEclipsePreferences
	protected static IPreferenceStore preferenceStore = null;
	public static IPreferenceStore getPreferenceStore() {
		try {
			ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
			Class<?> uiPluginClass = Class.forName("org.whole.lang.e4.ui.E4CompatibilityPlugin", true, cl);
			Object bundle = uiPluginClass.getMethod("getDefault").invoke(null);
			return (IPreferenceStore) uiPluginClass.getMethod("getPreferenceStore").invoke(bundle);
		} catch (Exception e) {
	        if (preferenceStore == null) {
	            preferenceStore = new PreferenceStore();
	            PreferenceConstants.initializeDefaultValues(preferenceStore,
	            		getColorRegistry(),
	    				getFontRegistry());

	        }
	        return preferenceStore;
		}
	}
	public static ImageDescriptor getImageDescriptor(String relativePath) {
		return getImageDescriptor(PLUGIN_ID, relativePath);
	}
	public static ImageDescriptor getImageDescriptor(String bundleId, String relativePath) {
		URL entry = Platform.getBundle(bundleId).getEntry(relativePath);
		if (entry == null)
			relativePath.length();
		ImageDescriptor createFromURL = ImageDescriptor.createFromURL(entry);
		if (createFromURL == ImageDescriptor.getMissingImageDescriptor())
			relativePath.length();
		return createFromURL;
	}
}