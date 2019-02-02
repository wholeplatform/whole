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
	public static final String MONOSPACE_FONT = "monospaceFont";
	public static final String SANSERIF_FONT = "sanserifFont";
	public static final String SERIF_FONT = "serifFont";

	public static final String SELECTION_CATEGORY = "selectionCategory";
	public static final String MATCHING_SELECTION_CATEGORY = "matchingSelectionCategory";
	public static final String HOST_LANGUAGE_CATEGORY = "hostCategory";
	public static final String TEMPLATE_LANGUAGE_CATEGORY = "templateCategory";

	public static final String MODULES_CATEGORY = "modulesCategory";
	public static final String DECLARATIONS_CATEGORY = "declarationsCategory";
	public static final String RELATIONS_CATEGORY = "relationsCategory";
	public static final String KEYWORDS_CATEGORY = "keywordsCategory";
	public static final String IDENTIFIERS_CATEGORY = "identifiersCategory";
	public static final String LITERALS_CATEGORY = "literalsCategory";
	public static final String ERRORS_CATEGORY = "errorsCategory";
	public static final String CONTENT_CATEGORY = "contentCategory";
	public static final String CONTENT_DARK_CATEGORY = "contentDarkCategory";
	public static final String CONTENT_LIGHT_CATEGORY = "contentLightCategory";
	public static final String CONTENT_LIGHTER_CATEGORY = "contentLighterCategory";

	public static final String CLASS = "Class";
	public static final String STYLE = "Style";
	public static final String SIZE = "Size";

	public static enum FontClass {
		Monospace, Sanserif, Serif;

		public static String nameOf(int ordinal) {
			return values()[ordinal].name();
		}
		public static int ordinalOf(String name) {
			return valueOf(name).ordinal();
		}
}
	public static enum FontStyle {
		Regular, Italic, Bold, BoldItalic;

		public boolean isBold() {
			return this == Bold || this == BoldItalic;
		}

		public boolean isItalic() {
			return this == Italic || this == BoldItalic;
		}

		public static String nameOf(int ordinal) {
			return values()[ordinal].name();
		}
		public static int ordinalOf(String name) {
			return valueOf(name).ordinal();
		}
	}
	public static enum FontSize {
		Small(9f/12f), Regular(1f), Medium(14f/12f), Large(21f/12f);
		
		public final float ratio;

		FontSize(float ratio) {
			this.ratio = ratio;
		}

		public static String nameOf(int ordinal) {
			return values()[ordinal].name();
		}
		public static int ordinalOf(String name) {
			return valueOf(name).ordinal();
		}
	}

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
	public static final FontClass lookUpFontClass(String bundleId, String key) {
		return FontClass.valueOf(lookUpPreference(bundleId, key));
	}
	public static final FontStyle lookUpFontStyle(String bundleId, String key) {
		return FontStyle.valueOf(lookUpPreference(bundleId, key));
	}
	public static final FontSize lookUpFontSize(String bundleId, String key) {
		return FontSize.valueOf(lookUpPreference(bundleId, key));
	}	
}
