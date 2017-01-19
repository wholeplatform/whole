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

import static org.eclipse.jface.resource.ColorDescriptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Riccardo Solmi
 */
public class ColorRegistry implements IColorRegistry {//TODO ? extends ResourceRegistry
	private IEntityPartViewer viewer;
	private Map<String, Color> colorMap = new HashMap<String, Color>();

	public ColorRegistry(IEntityPartViewer viewer) {
		this.viewer = viewer;
	}

	protected ResourceManager getResourceManager() {
		return viewer.getResourceManager();
	}

	public boolean hasValueFor(String colorKey) {
		return colorMap.containsKey(colorKey);
	}
	public Set<String> getKeySet() {
		return Collections.unmodifiableSet(colorMap.keySet()); 
	}

	public boolean put(String colorKey, int red, int green, int blue) {
		return put(colorKey, new RGB(red, green, blue));
	}
	public boolean put(String colorKey, RGB rgb) {
		Color oldColor = colorMap.get(colorKey);
		colorMap.put(colorKey, getResourceManager().createColor(createFrom(rgb)));

		if (oldColor != null)
			getResourceManager().destroyColor(createFrom(oldColor));

		boolean changed = oldColor != null && !oldColor.getRGB().equals(rgb);
		if (changed)
			viewer.getControl().getDisplay().asyncExec(() -> {
				viewer.refreshNotation();
			});

		return changed;
	}
	public RGB getRGB(String colorKey) {
		return get(colorKey).getRGB();
	}
	public Color get(String colorKey) {
		return colorMap.get(colorKey);
	}
	protected Color createColor(RGB rgb) {
		return getResourceManager().createColor(rgb);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, Color> entry : colorMap.entrySet()) {
			result.append(entry.getKey());
			result.append(": ");
			RGB rgb = entry.getValue().getRGB();
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
