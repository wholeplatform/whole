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
package org.whole.lang.ui;

import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
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

	public static void initializeDefaultValues(String bundleId, ColorRegistry colorRegistry, FontRegistry fontRegistry) {
		IEclipsePreferences preferences = DefaultScope.INSTANCE.getNode(bundleId);

		preferences.put(FONT, PreferenceConverter.getStoredRepresentation(JFaceResources.getTextFont().getFontData()));

		preferences.put(SELECTION_COLOR, StringConverter.asString(GREEN_LIGHT_COLOR));
		preferences.put(MATCHING_SELECTION_COLOR, StringConverter.asString(UIUtils.darker(GREEN_LIGHT_COLOR)));
		preferences.put(HOST_LANGUAGE_COLOR, StringConverter.asString(new RGB(255, 255, 255)));
		preferences.put(TEMPLATE_LANGUAGE_COLOR, StringConverter.asString(new RGB(238, 232, 213)));

		preferences.put(MODULES_COLOR, StringConverter.asString(new RGB(115, 153, 0)));
		preferences.putBoolean(MODULES_COLOR+BOLD, false);
		preferences.putBoolean(MODULES_COLOR+ITALIC, false);

		preferences.put(DECLARATIONS_COLOR, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.putBoolean(DECLARATIONS_COLOR+BOLD, true);
		preferences.putBoolean(DECLARATIONS_COLOR+ITALIC, false);

		preferences.put(RELATIONS_COLOR, StringConverter.asString(new RGB(230, 123, 0)));
		preferences.putBoolean(RELATIONS_COLOR+BOLD, true);
		preferences.putBoolean(RELATIONS_COLOR+ITALIC, false);

		preferences.put(KEYWORDS_COLOR, StringConverter.asString(new RGB(127, 0, 85)));
		preferences.putBoolean(KEYWORDS_COLOR+BOLD, true);
		preferences.putBoolean(KEYWORDS_COLOR+ITALIC, false);

		preferences.put(IDENTIFIERS_COLOR, StringConverter.asString(new RGB(0, 112, 191)));
		preferences.putBoolean(IDENTIFIERS_COLOR+BOLD, false);
		preferences.putBoolean(IDENTIFIERS_COLOR+ITALIC, false);

		preferences.put(LITERALS_COLOR, StringConverter.asString(new RGB(128, 63, 0)));
		preferences.putBoolean(LITERALS_COLOR+BOLD, false);
		preferences.putBoolean(LITERALS_COLOR+ITALIC, false);

		preferences.put(ERRORS_COLOR, StringConverter.asString(new RGB(255, 0, 0)));
		preferences.putBoolean(ERRORS_COLOR+BOLD, false);
		preferences.putBoolean(ERRORS_COLOR+ITALIC, false);

		preferences.put(CONTENT_COLOR, StringConverter.asString(new RGB(0, 0, 0)));
		preferences.putBoolean(CONTENT_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_COLOR+ITALIC, false);

		preferences.put(CONTENT_DARK_COLOR, StringConverter.asString(new RGB(7, 54, 66)));
		preferences.putBoolean(CONTENT_DARK_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_DARK_COLOR+ITALIC, false);

		preferences.put(CONTENT_LIGHT_COLOR, StringConverter.asString(new RGB(88, 110, 117)));
		preferences.putBoolean(CONTENT_LIGHT_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_LIGHT_COLOR+ITALIC, false);

		preferences.put(CONTENT_LIGHTER_COLOR, StringConverter.asString(new RGB(147, 161, 161)));
		preferences.putBoolean(CONTENT_LIGHTER_COLOR+BOLD, false);
		preferences.putBoolean(CONTENT_LIGHTER_COLOR+ITALIC, false);

		colorRegistry.put(SELECTION_COLOR, StringConverter.asRGB(preferences.get(SELECTION_COLOR, null), null));
		colorRegistry.put(MATCHING_SELECTION_COLOR, StringConverter.asRGB(preferences.get(MATCHING_SELECTION_COLOR, null), null));
		colorRegistry.put(HOST_LANGUAGE_COLOR, StringConverter.asRGB(preferences.get(HOST_LANGUAGE_COLOR, null), null));
		colorRegistry.put(TEMPLATE_LANGUAGE_COLOR, StringConverter.asRGB(preferences.get(TEMPLATE_LANGUAGE_COLOR, null), null));

		colorRegistry.put(MODULES_COLOR, StringConverter.asRGB(preferences.get(MODULES_COLOR, null), null));
		colorRegistry.put(DECLARATIONS_COLOR, StringConverter.asRGB(preferences.get(DECLARATIONS_COLOR, null), null));
		colorRegistry.put(RELATIONS_COLOR, StringConverter.asRGB(preferences.get(RELATIONS_COLOR, null), null));
		colorRegistry.put(KEYWORDS_COLOR, StringConverter.asRGB(preferences.get(KEYWORDS_COLOR, null), null));
		colorRegistry.put(IDENTIFIERS_COLOR, StringConverter.asRGB(preferences.get(IDENTIFIERS_COLOR, null), null));
		colorRegistry.put(LITERALS_COLOR, StringConverter.asRGB(preferences.get(LITERALS_COLOR, null), null));
		colorRegistry.put(ERRORS_COLOR, StringConverter.asRGB(preferences.get(ERRORS_COLOR, null), null));
		colorRegistry.put(CONTENT_COLOR, StringConverter.asRGB(preferences.get(CONTENT_COLOR, null), null));
		colorRegistry.put(CONTENT_DARK_COLOR, StringConverter.asRGB(preferences.get(CONTENT_DARK_COLOR, null), null));
		colorRegistry.put(CONTENT_LIGHT_COLOR, StringConverter.asRGB(preferences.get(CONTENT_LIGHT_COLOR, null), null));
		colorRegistry.put(CONTENT_LIGHTER_COLOR, StringConverter.asRGB(preferences.get(CONTENT_LIGHTER_COLOR, null), null));

		fontRegistry.put(FONT, PreferenceConverter.basicGetFontData(preferences.get(FONT, null)));
	}
}
