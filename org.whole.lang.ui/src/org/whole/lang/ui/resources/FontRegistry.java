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
package org.whole.lang.ui.resources;

import static  org.eclipse.jface.resource.FontDescriptor.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Riccardo Solmi
 */
public class FontRegistry implements IFontRegistry {//TODO ? extends ResourceRegistry
	private IEntityPartViewer viewer;
	private Map<String, Font> fontMap = new HashMap<String, Font>();

	public FontRegistry(IEntityPartViewer viewer) {
		this.viewer = viewer;
	}

	public ResourceManager getResourceManager() {
		return viewer.getResourceManager();
	}

	public Set<String> getKeySet() {
		return Collections.unmodifiableSet(fontMap.keySet());
	}
	public boolean hasValueFor(String fontKey) {
		return fontMap.containsKey(fontKey);
	}

	public boolean put(String fontKey, String fontName, int fontSize, int fontStyle) {
		return put(fontKey, new FontData[] { new FontData(fontName, fontSize, fontStyle) });
	}
	public boolean put(String fontKey, FontData[] fontData) {
		Font oldFont = fontMap.get(fontKey);
		fontMap.put(fontKey, getResourceManager().createFont(createFrom(fontData)));

		if (oldFont != null)
			getResourceManager().destroyFont(createFrom(oldFont));

		boolean changed = oldFont != null && !Arrays.equals(oldFont.getFontData(), fontData);
		if (changed)
			viewer.getControl().getDisplay().asyncExec(() -> {
				viewer.rebuildNotation();
			});

		return changed;
	}

	public FontData[] getFontData(String fontKey) {
		return fontMap.get(fontKey).getFontData();
	}
	public Font get(String fontKey) {
		return fontMap.get(fontKey);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, Font> entry : fontMap.entrySet()) {
			result.append(entry.getKey());
			result.append(": ");
			FontData[] fontData = entry.getValue().getFontData();
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
