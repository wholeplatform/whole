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

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.DeviceResourceDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.whole.lang.ui.PreferenceConstants;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class UIUtils {
	public static int getButtonWidthHint(Composite composite) {
		GC gc = new GC(composite);
		gc.setFont(composite.getFont());
		FontMetrics fFontMetrics = gc.getFontMetrics();
		int widthHint = Dialog.convertHorizontalDLUsToPixels(fFontMetrics, IDialogConstants.BUTTON_WIDTH);
		gc.dispose();
		return widthHint;
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

	public static final void destroyResource(Object resource) {
		if (resource instanceof DeviceResourceDescriptor)
			JFaceResources.getResources().destroy((DeviceResourceDescriptor) resource);
		else if (resource instanceof Color)
			destroyResource(ColorDescriptor.createFrom((Color) resource));
		else if (resource instanceof Font)
			destroyResource(FontDescriptor.createFrom((Font) resource));
		else if (resource instanceof Image)
			destroyResource(ImageDescriptor.createFromImage((Image) resource));
		else
			throw new IllegalArgumentException("unknown resoure type");
	}
	public static final <T> T replaceResource(T replaced, T replacement) {
		destroyResource(replaced);
		return replacement;
	}
	public static final Color createColor(ColorDescriptor colorDescriptor) {
		return JFaceResources.getResources().createColor(colorDescriptor);
	}
	public static final Color createColor(String bundleId, String key) {
		return createColor(PreferenceConstants.lookUpColorDescriptor(bundleId, key));
	}

	public static final Font createFont(FontDescriptor fontDescriptor) {
		return JFaceResources.getResources().createFont(fontDescriptor);
	}
	public static final Font createFont(FontData[] fontData) {
		return createFont(FontDescriptor.createFrom(fontData));
	}
	public static final Font scaleFont(Font font, float scale) {
		FontData[] fontData = font.getFontData();
		fontData[0].setHeight(Math.round(fontData[0].getHeight()*scale));
		return createFont(fontData);
	}
	public static final Font createFont(String bundleId, String key) {
		return createFont(PreferenceConstants.lookUpFontDescriptor(bundleId, PreferenceConstants.MONOSPACE_FONT));
	}
	public static final Font createStyledFont(String bundleId, String key) {
		FontDescriptor fontDescriptor = PreferenceConstants.lookUpFontDescriptor(bundleId, PreferenceConstants.MONOSPACE_FONT);
		return createFont(fontDescriptor.setStyle(getStyle(bundleId, key)));
	}
	public static final int getStyle(String bundleId, String key) {
		int style = SWT.NORMAL;
		if (PreferenceConstants.lookUpBooleanPreference(bundleId, key+PreferenceConstants.BOLD))
			style += SWT.BOLD;
		if (PreferenceConstants.lookUpBooleanPreference(bundleId, key+PreferenceConstants.ITALIC))
			style += SWT.ITALIC;
		return style;
	}

	public static ImageDescriptor getImageDescriptor(String relativePath) {
		return getImageDescriptor(IUIConstants.BUNDLE_ID, relativePath);
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

	private static final float RGB_VALUE_MULTIPLIER = 0.6f;
	public static RGB darker(RGB color) {
		return new RGB(
				(int) (color.red * RGB_VALUE_MULTIPLIER),
				(int) (color.green * RGB_VALUE_MULTIPLIER),
				(int) (color.blue * RGB_VALUE_MULTIPLIER)
		);
	}
	public static RGB lighter(RGB color) {
		return new RGB(
				Math.max(2, Math.min((int) (color.red / RGB_VALUE_MULTIPLIER), 255)),
				Math.max(2, Math.min((int) (color.green / RGB_VALUE_MULTIPLIER), 255)),
				Math.max(2, Math.min((int) (color.blue / RGB_VALUE_MULTIPLIER), 255))
		);
	}
}
