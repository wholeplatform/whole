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

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
 * @author Riccardo Solmi
 */
public class PreferenceConstants {
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

	private static final IScopeContext[] CONTEXTS = new IScopeContext[] { 
			InstanceScope.INSTANCE, ConfigurationScope.INSTANCE, DefaultScope.INSTANCE };

	public static final String lookUpPreference(String bundleId, String key) {
		for (int i = 0; i < CONTEXTS.length; ++i) {
			String value = CONTEXTS[i].getNode(bundleId).get(key, null);
			if (value != null)
				return value;
		}
		throw new IllegalArgumentException("unknown preference key: "+key);
	}
	public static final boolean lookUpBooleanPreference(String bundleId, String key) {
		return Boolean.parseBoolean(lookUpPreference(bundleId, key));
	}
	public static ColorDescriptor lookUpColorDescriptor(String bundleId, String key) {
		String value = lookUpPreference(bundleId, key);
		RGB rgb = StringConverter.asRGB(value);
		return ColorDescriptor.createFrom(rgb);
	}
	public static FontDescriptor lookUpFontDescriptor(String bundleId, String key) {
		String value = lookUpPreference(bundleId, key);
		FontData[] fontData = PreferenceConverter.basicGetFontData(value);
		FontDescriptor fontDescriptor = FontDescriptor.createFrom(fontData);
		return fontDescriptor;
	}
}
