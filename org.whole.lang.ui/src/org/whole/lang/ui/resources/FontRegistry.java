/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * @author Riccardo Solmi
 */
public class FontRegistry implements IFontRegistry {//TODO ? extends ResourceRegistry
	private ResourceManager resourceManager;
	private Map<String, Font> fontMap = new HashMap<String, Font>();
	private Map<String, FontData[]> fontDataMap = new HashMap<String, FontData[]>();

	public FontRegistry(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	public Set<String> getKeySet() {
		return Collections.unmodifiableSet(fontDataMap.keySet());
	}
	public boolean hasValueFor(String fontKey) {
		return fontDataMap.containsKey(fontKey);
	}

	public FontData[] getFontData(String fontKey) {
		return fontDataMap.get(fontKey);
	}

	public boolean put(String fontKey, String fontName, int fontSize, int fontStyle) {
		return put(fontKey, new FontData[] { new FontData(fontName, fontSize, fontStyle) });
	}
	public boolean put(String fontKey, FontData[] fontData) {
		FontData[] oldFontData = fontDataMap.get(fontKey);
		if (Arrays.equals(oldFontData, fontData))
			return false;

		Font oldFont = fontMap.remove(fontKey);
		fontDataMap.put(fontKey, fontData);
		if (oldFont != null)
			;//TODO staleFonts.add(oldFont);

		//fireMappingChanged
		return true;
	}

	public Font get(String fontKey) {
		Font font = fontMap.get(fontKey);
		if (font != null)
			return font;

		FontData[] fontData = fontDataMap.get(fontKey);
		if (fontData == null)
			return null;//TODO delegate to a parent fontRegistry

		fontMap.put(fontKey, font = createFont(fontData));
		return font;
	}
	protected Font createFont(FontData[] fontData) {
		return getResourceManager().createFont(FontDescriptor.createFrom(fontData));
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, FontData[]> entry : fontDataMap.entrySet()) {
			result.append(entry.getKey());
			result.append(": ");
			FontData[] fontData = entry.getValue();
			for (FontData data : fontData) {
				result.append(data.getName());
				result.append(' ');
				result.append(data.getHeight());
				if ((data.getStyle() & SWT.BOLD) == 1) 
					result.append(" bold");
				if ((data.getStyle() & SWT.ITALIC) == 1) 
					result.append(" italic");
				result.append(';');
			}
			result.append('\n');
		}
		return result.toString();
	}
}
