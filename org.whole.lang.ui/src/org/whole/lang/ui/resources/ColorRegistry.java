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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * @author Riccardo Solmi
 */
public class ColorRegistry implements IColorRegistry {//TODO ? extends ResourceRegistry
	private ResourceManager resourceManager;
	private Map<String, Color> colorMap = new HashMap<String, Color>();
	private Map<String, RGB> rgbMap = new HashMap<String, RGB>();

	public ColorRegistry(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	public boolean hasValueFor(String colorKey) {
		return rgbMap.containsKey(colorKey);
	}
	public Set<String> getKeySet() {
		return Collections.unmodifiableSet(rgbMap.keySet()); 
	}

	public void put(String colorKey, int red, int green, int blue) {
		put(colorKey, new RGB(red, green, blue));
	}
	public void put(String colorKey, RGB rgb) {
		RGB oldRgb = rgbMap.get(colorKey);
		if (rgb.equals(oldRgb))
			return;

		Color oldColor = colorMap.remove(colorKey);
		rgbMap.put(colorKey, rgb);
		if (oldColor != null)
			;//TODO staleColors.add(oldColor);

		//fireMappingChanged
	}
	public RGB getRGB(String colorKey) {
		return rgbMap.get(colorKey);
	}
	public Color get(String colorKey) {
		Color color = colorMap.get(colorKey);
		if (color != null)
			return color;

		RGB rgb = rgbMap.get(colorKey);
		if (rgb == null)
			return null;//TODO delegate to a parent colorRegistry

		colorMap.put(colorKey, color = createColor(rgb));
		return color;
	}
	protected Color createColor(RGB rgb) {
		return getResourceManager().createColor(rgb);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, RGB> entry : rgbMap.entrySet()) {
			result.append(entry.getKey());
			result.append(": ");
			RGB rgb = entry.getValue();
			result.append(rgb.red);
			result.append(",");
			result.append(rgb.green);
			result.append(",");
			result.append(rgb.blue);
			result.append('\n');
		}
		return result.toString();
	}
}
