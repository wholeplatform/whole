/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
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
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.PreferenceConstants.FontClass;
import org.whole.lang.ui.PreferenceConstants.FontSize;
import org.whole.lang.ui.PreferenceConstants.FontStyle;
import org.whole.lang.util.EntityUtils;

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
	public static final Font scaleFont(Font font, FontSize fontSize) {
		FontData[] fontData = font.getFontData();
		fontData[0].setHeight(Math.round(fontData[0].getHeight() * fontSize.ratio));
		return createFont(fontData);
	}
	public static final Font createFont(String bundleId, String fontId) {
		return createFont(PreferenceConstants.lookUpFontDescriptor(bundleId, fontId));
	}
	public static final Font createStyledFont(String bundleId, String key) {
		FontDescriptor fontDescriptor = PreferenceConstants.lookUpFontDescriptor(bundleId, getFontClass(bundleId, key));
		return createFont(fontDescriptor
				.setStyle(getFontStyle(bundleId, key))
				.setHeight(getFontSize(bundleId, key)));
	}
	public static final String getFontClass(String bundleId, String key) {
		FontClass fontClass = PreferenceConstants.lookUpFontClass(bundleId, key+PreferenceConstants.CLASS);
		switch (fontClass) {
		case Monospace:
			return PreferenceConstants.MONOSPACE_FONT;
		case Sanserif:
			return PreferenceConstants.SANSERIF_FONT;
		case Serif:
			return PreferenceConstants.SERIF_FONT;
		default:
			throw new IllegalArgumentException("Unknown font");
		}
	}
	public static final int getFontStyle(String bundleId, String key) {
		int style = SWT.NORMAL;
		FontStyle fontStyle = PreferenceConstants.lookUpFontStyle(bundleId, key+PreferenceConstants.STYLE);
		if (fontStyle.isBold())
			style += SWT.BOLD;
		if (fontStyle.isItalic())
			style += SWT.ITALIC;
		return style;
	}
	public static final int getFontSize(String bundleId, String key) {
		FontSize fontSize = PreferenceConstants.lookUpFontSize(bundleId, key+PreferenceConstants.SIZE);
		FontDescriptor descriptor = PreferenceConstants.lookUpFontDescriptor(bundleId, getFontClass(bundleId, key));
		return Math.round(descriptor.getFontData()[0].getHeight() * fontSize.ratio);
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

	public static KeySequence convertKeyEvent(KeyEvent event) {
		int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(event);
		return KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
	}

	public static boolean parentHasDifferentLanguage(IEntity entity) {
		IEntity parentEntity = entity.wGetParent();
		if (EntityUtils.isNull(parentEntity))
			return true;

		ILanguageKit parentLaguage = parentEntity.wGetLanguageKit();
		
		return !entity.wGetLanguageKit().equals(parentLaguage) &&
				!parentLaguage.getURI().equals("whole:org.whole.lang.changes:ChangesModel");//ChangesLanguageKit.URI);
	}
}
