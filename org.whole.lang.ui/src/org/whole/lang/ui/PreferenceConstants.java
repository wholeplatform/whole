/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.RGB;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Riccardo Solmi
 */
public class PreferenceConstants {
	public static final RGB BACKGROUND_DARKER_COLOR = new RGB(0, 43, 54);
	public static final RGB BACKGROUND_DARK_COLOR = new RGB(7, 54, 66);
	public static final RGB BACKGROUND_LIGHT_COLOR = new RGB(238, 232, 213);
	public static final RGB BACKGROUND_LIGHTER_COLOR = new RGB(253, 246, 227);
	public static final RGB GREEN_LIGHT_COLOR = new RGB(225, 235, 224);
	public static final RGB ORANGE_COLOR = new RGB(0xfe, 0xd7, 0x8c);
	public static final RGB ORANGE_LIGHT_COLOR = new RGB(0xff, 0xe8, 0xbc);
	public static final RGB NAV_BLUE_DARK_COLOR = new RGB(0xcc, 0xd6, 0xf7);
	public static final RGB NAV_BLUE_COLOR = new RGB(0xf0, 0xf4, 0xff);
	public static final RGB BLUE_LIGHT_COLOR = new RGB(232, 242, 254);
	public static final RGB GRAY_COLOR = new RGB(240, 240, 240);

	public static final String FONT = "font";

	public static final String SELECTION_COLOR = "selectionColor";
	public static final String MATCHING_SELECTION_COLOR = "matchingSelectionColor";
	public static final String HOST_LANGUAGE_COLOR = "hostColor";
	public static final String TEMPLATE_LANGUAGE_COLOR = "templateColor";

	public static final String MODULES_COLOR = "modulesColor";
	public static final String DECLARATIONS_COLOR = "declarationsColor";
	public static final String RELATIONS_COLOR = "relationsColor";
	public static final String KEYWORDS_COLOR = "keywordsColor";
	public static final String IDENTIFIERS_COLOR = "identifiersColor";
	public static final String LITERALS_COLOR = "literalsColor";
	public static final String ERRORS_COLOR = "errorsColor";
	public static final String CONTENT_COLOR = "contentColor";
	public static final String CONTENT_DARK_COLOR = "contentDarkColor";
	public static final String CONTENT_LIGHT_COLOR = "contentLightColor";
	public static final String CONTENT_LIGHTER_COLOR = "contentLighterColor";
	
	public static final String BOLD = "Bold";
	public static final String ITALIC = "Italic";

	public static void initializeDefaultValues(IPreferenceStore store, ColorRegistry colorRegistry, FontRegistry fontRegistry) {
		PreferenceConverter.setDefault(store, FONT, JFaceResources.getTextFont().getFontData());

		PreferenceConverter.setDefault(store, SELECTION_COLOR, GREEN_LIGHT_COLOR);
		PreferenceConverter.setDefault(store, MATCHING_SELECTION_COLOR, darker(GREEN_LIGHT_COLOR));
		PreferenceConverter.setDefault(store, HOST_LANGUAGE_COLOR, new RGB(255, 255, 255));
		PreferenceConverter.setDefault(store, TEMPLATE_LANGUAGE_COLOR, new RGB(238, 232, 213));

		PreferenceConverter.setDefault(store, MODULES_COLOR, new RGB(115, 153, 0));
		store.setDefault(MODULES_COLOR+BOLD, false);
		store.setDefault(MODULES_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, DECLARATIONS_COLOR, new RGB(0, 0, 0));
		store.setDefault(DECLARATIONS_COLOR+BOLD, true);
		store.setDefault(DECLARATIONS_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, RELATIONS_COLOR, new RGB(230, 123, 0));
		store.setDefault(RELATIONS_COLOR+BOLD, true);
		store.setDefault(RELATIONS_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, KEYWORDS_COLOR, new RGB(127, 0, 85));
		store.setDefault(KEYWORDS_COLOR+BOLD, true);
		store.setDefault(KEYWORDS_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, IDENTIFIERS_COLOR, new RGB(0, 112, 191));
		store.setDefault(IDENTIFIERS_COLOR+BOLD, false);
		store.setDefault(IDENTIFIERS_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, LITERALS_COLOR, new RGB(128, 63, 0));
		store.setDefault(LITERALS_COLOR+BOLD, false);
		store.setDefault(LITERALS_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, ERRORS_COLOR, new RGB(255, 0, 0));
		store.setDefault(ERRORS_COLOR+BOLD, false);
		store.setDefault(ERRORS_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, CONTENT_COLOR, new RGB(0, 0, 0));
		store.setDefault(CONTENT_COLOR+BOLD, false);
		store.setDefault(CONTENT_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, CONTENT_DARK_COLOR, new RGB(7, 54, 66));
		store.setDefault(CONTENT_DARK_COLOR+BOLD, false);
		store.setDefault(CONTENT_DARK_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, CONTENT_LIGHT_COLOR, new RGB(88, 110, 117));
		store.setDefault(CONTENT_LIGHT_COLOR+BOLD, false);
		store.setDefault(CONTENT_LIGHT_COLOR+ITALIC, false);

		PreferenceConverter.setDefault(store, CONTENT_LIGHTER_COLOR, new RGB(147, 161, 161));
		store.setDefault(CONTENT_LIGHTER_COLOR+BOLD, false);
		store.setDefault(CONTENT_LIGHTER_COLOR+ITALIC, false);
		
		restoreRegistries(store, colorRegistry, fontRegistry);
	}

	public static void restoreRegistries(IPreferenceStore store) {
		restoreRegistries(store, UIUtils.getColorRegistry(), UIUtils.getFontRegistry());
	}
	public static void restoreRegistries(IPreferenceStore store, ColorRegistry colorRegistry, FontRegistry fontRegistry) {
		colorRegistry.put(SELECTION_COLOR, PreferenceConverter.getColor(store, SELECTION_COLOR));
		colorRegistry.put(MATCHING_SELECTION_COLOR, PreferenceConverter.getColor(store, MATCHING_SELECTION_COLOR));
		colorRegistry.put(HOST_LANGUAGE_COLOR, PreferenceConverter.getColor(store, HOST_LANGUAGE_COLOR));
		colorRegistry.put(TEMPLATE_LANGUAGE_COLOR, PreferenceConverter.getColor(store, TEMPLATE_LANGUAGE_COLOR));

		colorRegistry.put(MODULES_COLOR, PreferenceConverter.getColor(store, MODULES_COLOR));
		colorRegistry.put(DECLARATIONS_COLOR, PreferenceConverter.getColor(store, DECLARATIONS_COLOR));
		colorRegistry.put(RELATIONS_COLOR, PreferenceConverter.getColor(store, RELATIONS_COLOR));
		colorRegistry.put(KEYWORDS_COLOR, PreferenceConverter.getColor(store, KEYWORDS_COLOR));
		colorRegistry.put(IDENTIFIERS_COLOR, PreferenceConverter.getColor(store, IDENTIFIERS_COLOR));
		colorRegistry.put(LITERALS_COLOR, PreferenceConverter.getColor(store, LITERALS_COLOR));
		colorRegistry.put(ERRORS_COLOR, PreferenceConverter.getColor(store, ERRORS_COLOR));
		colorRegistry.put(CONTENT_COLOR, PreferenceConverter.getColor(store, CONTENT_COLOR));
		colorRegistry.put(CONTENT_DARK_COLOR, PreferenceConverter.getColor(store, CONTENT_DARK_COLOR));
		colorRegistry.put(CONTENT_LIGHT_COLOR, PreferenceConverter.getColor(store, CONTENT_LIGHT_COLOR));
		colorRegistry.put(CONTENT_LIGHTER_COLOR, PreferenceConverter.getColor(store, CONTENT_LIGHTER_COLOR));

		fontRegistry.put(FONT, PreferenceConverter.getFontDataArray(store, FONT));
	}

	public static RGB darker(RGB color) {
		final float RGB_VALUE_MULTIPLIER = 0.6f;

		return new RGB(
			(int)(color.red * RGB_VALUE_MULTIPLIER),
			(int)(color.green * RGB_VALUE_MULTIPLIER),
			(int)(color.blue * RGB_VALUE_MULTIPLIER));
	}
}
