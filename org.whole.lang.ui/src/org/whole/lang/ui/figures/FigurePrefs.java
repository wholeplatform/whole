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
package org.whole.lang.ui.figures;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.ui.IEditorPart;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.views.WholeGraphicalViewer;


/**
 * @author Riccardo Solmi
 */
public class FigurePrefs extends PreferenceConstants {
	public static Color darkerColor = new Color(null, 0, 43, 54);
	public static Color darkColor = new Color(null, 7, 54, 66);
	public static Color lightColor = new Color(null, 238, 232, 213);
	public static Color lighterColor = new Color(null, 253, 246, 227);
	public static Color brightBlueColor = new Color(null, 180, 213, 255);
	public static Color blueColor = new Color(null, 112, 158, 230);
	public static Color lightBlueColor = new Color(null, 194, 212, 243);
	public static Color yellowColor = new Color(null, 255, 181, 21);
	public static Color lightGray = new Color(null, 233, 233, 233);

	public static Color selectionColor;
	public static Color matchingSelectionColor;
	public static Color hostLanguageColor;
	public static Color templateLanguageColor;
	
	public static int templateLanguageAlpha = 130;
	public static int hostLanguageAlpha = 30;

	public static Color defaultColor = new Color(null, 255, 255, 255);
	public static Color modulesColor;
	public static Font modulesFont;
	public static Color declarationsColor;
	public static Font declarationsFont;
	public static Color relationsColor;
	public static Font relationsFont;
	public static Color keywordsColor;
	public static Font keywordsFont;
	public static Color identifiersColor;
	public static Font identifiersFont;
	public static Color literalsColor;
	public static Font literalsFont;
	public static Color errorsColor;
	public static Font errorsFont;
	public static Color contentColor;
	public static Font contentFont;
	public static Color contentDarkColor;
	public static Font contentDarkFont;
	public static Color contentLightColor;
	public static Font contentLightFont;
	public static Color contentLighterColor;
	public static Font contentLighterFont;

	static {
		final IPreferenceStore store = WholeUIPlugin.getDefault().getPreferenceStore();
		store.addPropertyChangeListener(new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				final String prop = event.getProperty();

				if (prop.equals(FONT)) {
					modulesFont = getFont(store, MODULES_COLOR);
					declarationsFont = getFont(store, DECLARATIONS_COLOR);
					relationsFont = getFont(store, RELATIONS_COLOR);
					keywordsFont = getFont(store, KEYWORDS_COLOR);
					identifiersFont = getFont(store, IDENTIFIERS_COLOR);
					literalsFont = getFont(store, LITERALS_COLOR);
					errorsFont = getFont(store, ERRORS_COLOR);
					contentFont = getFont(store, CONTENT_COLOR);
					contentDarkFont = getFont(store, CONTENT_DARK_COLOR);
					contentLightFont = getFont(store, CONTENT_LIGHT_COLOR);
					contentLighterFont = getFont(store, CONTENT_LIGHTER_COLOR);

				} else if (prop.equals(SELECTION_COLOR))
					selectionColor = getColor(store, SELECTION_COLOR);
				else if (prop.equals(MATCHING_SELECTION_COLOR))
					matchingSelectionColor = getColor(store, MATCHING_SELECTION_COLOR);
				else if (prop.equals(HOST_LANGUAGE_COLOR)) {
					hostLanguageColor = getColor(store, HOST_LANGUAGE_COLOR);
				} else if (prop.equals(TEMPLATE_LANGUAGE_COLOR)) {
					templateLanguageColor = getColor(store, TEMPLATE_LANGUAGE_COLOR);
				}

				else if (prop.equals(MODULES_COLOR))
					modulesColor = getColor(store, MODULES_COLOR);
				else if (prop.startsWith(MODULES_COLOR))
					modulesFont = getFont(store, MODULES_COLOR);

				else if (prop.equals(DECLARATIONS_COLOR))
					declarationsColor = getColor(store, DECLARATIONS_COLOR);
				else if (prop.startsWith(DECLARATIONS_COLOR))
					declarationsFont = getFont(store, DECLARATIONS_COLOR);

				else if (prop.equals(RELATIONS_COLOR))
					relationsColor = getColor(store, RELATIONS_COLOR);
				else if (prop.startsWith(RELATIONS_COLOR))
					relationsFont = getFont(store, RELATIONS_COLOR);

				else if (prop.equals(KEYWORDS_COLOR))
					keywordsColor = getColor(store, KEYWORDS_COLOR);
				else if (prop.startsWith(KEYWORDS_COLOR))
					keywordsFont = getFont(store, KEYWORDS_COLOR);

				else if (prop.equals(IDENTIFIERS_COLOR))
					identifiersColor = getColor(store, IDENTIFIERS_COLOR);
				else if (prop.startsWith(IDENTIFIERS_COLOR))
					identifiersFont = getFont(store, IDENTIFIERS_COLOR);

				else if (prop.equals(LITERALS_COLOR))
					literalsColor = getColor(store, LITERALS_COLOR);
				else if (prop.startsWith(LITERALS_COLOR))
					literalsFont = getFont(store, LITERALS_COLOR);

				else if (prop.equals(ERRORS_COLOR))
					errorsColor = getColor(store, ERRORS_COLOR);
				else if (prop.startsWith(ERRORS_COLOR))
					errorsFont = getFont(store, ERRORS_COLOR);

				else if (prop.equals(CONTENT_COLOR))
					contentColor = getColor(store, CONTENT_COLOR);
				else if (prop.startsWith(CONTENT_COLOR))
					contentFont = getFont(store, CONTENT_COLOR);

				else if (prop.equals(CONTENT_LIGHT_COLOR))
					contentLightColor = getColor(store, CONTENT_LIGHT_COLOR);
				else if (prop.startsWith(CONTENT_LIGHT_COLOR))
					contentLightFont = getFont(store, CONTENT_LIGHT_COLOR);

				else if (prop.equals(CONTENT_LIGHTER_COLOR))
					contentLighterColor = getColor(store, CONTENT_LIGHTER_COLOR);
				else if (prop.startsWith(CONTENT_LIGHTER_COLOR))
					contentLighterFont = getFont(store, CONTENT_LIGHTER_COLOR);

				invalidateEditors();
			}
		});

		selectionColor = getColor(store, SELECTION_COLOR);
		matchingSelectionColor = getColor(store, MATCHING_SELECTION_COLOR);
		hostLanguageColor = getColor(store, HOST_LANGUAGE_COLOR);
		templateLanguageColor = getColor(store, TEMPLATE_LANGUAGE_COLOR);

		modulesColor = getColor(store, MODULES_COLOR);
		modulesFont = getFont(store, MODULES_COLOR);
		declarationsColor = getColor(store, DECLARATIONS_COLOR);
		declarationsFont = getFont(store, DECLARATIONS_COLOR);
		relationsColor = getColor(store, RELATIONS_COLOR);
		relationsFont = getFont(store, RELATIONS_COLOR);
		keywordsColor = getColor(store, KEYWORDS_COLOR);
		keywordsFont = getFont(store, KEYWORDS_COLOR);
		identifiersColor = getColor(store, IDENTIFIERS_COLOR);
		identifiersFont = getFont(store, IDENTIFIERS_COLOR);
		literalsColor = getColor(store, LITERALS_COLOR);
		literalsFont = getFont(store, LITERALS_COLOR);
		errorsColor = getColor(store, ERRORS_COLOR);
		errorsFont = getFont(store, ERRORS_COLOR);
		contentColor = getColor(store, CONTENT_COLOR);
		contentFont = getFont(store, CONTENT_COLOR);
		contentLightColor = getColor(store, CONTENT_LIGHT_COLOR);
		contentLightFont = getFont(store, CONTENT_LIGHT_COLOR);
		contentLighterColor = getColor(store, CONTENT_LIGHTER_COLOR);
		contentLighterFont = getFont(store, CONTENT_LIGHTER_COLOR);
		
		invalidateEditors();
	}

	private static final Color getColor(IPreferenceStore store, String key) {
		ColorRegistry registry = WholeUIPlugin.getDefault().getColorRegistry();
		registry.put(key, PreferenceConverter.getColor(store, key));
		return registry.get(key);
	}

	private static final Font getFont(IPreferenceStore store, String key) {
		FontRegistry registry = WholeUIPlugin.getDefault().getFontRegistry();
		registry.put(key, setStyle(FontDescriptor.copy(PreferenceConverter.getFontDataArray(store, FONT)), getStyle(store, key)));
		return registry.get(key);
	}

	private static final FontData[] setStyle(FontData[] fontData, int style) {
		for (FontData f : fontData)
			f.setStyle(f.getStyle() | style);
		return fontData;
	}
	private static final int getStyle(IPreferenceStore store, String key) {
		int style = SWT.NORMAL;
		if (store.getBoolean(key+BOLD))
			style += SWT.BOLD;
		if (store.getBoolean(key+ITALIC))
			style += SWT.ITALIC;
		
		return style;
	}

	private static final void invalidateEditors() {
		IEditorPart[] editors = WholeUIPlugin.getGraphicalEditors();
		for (int i=0; i<editors.length; i++) {
			WholeGraphicalViewer viewer = (WholeGraphicalViewer) editors[i].getAdapter(GraphicalViewer.class);
			if (viewer != null)
				viewer.refreshNotation();
		}
	}
}
