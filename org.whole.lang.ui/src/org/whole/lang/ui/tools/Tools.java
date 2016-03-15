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
package org.whole.lang.ui.tools;

import org.eclipse.gef.LightweightEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.gef.tools.PanningSelectionTool;

public enum Tools {
	PANNING("org.eclipse.gef.tools.PanningSelectionTool", PanningSelectionTool.class),
	TEXTUAL("org.whole.lang.ui.tools.TextualSelectionTool", TextualSelectionTool.class),
	MARQUEE("org.eclipse.gef.tools.MarqueeSelectionTool", MarqueeSelectionTool.class);

	private final String entryId;
	private final Class<?> toolClass;
	
	private Tools(String entryId, Class<?> toolClass) {
		this.entryId = entryId;
		this.toolClass = toolClass;
	}

	public boolean isPanning() {
		return equals(PANNING);
	}
	public boolean isTextual() {
		return equals(TEXTUAL);
	}
	public boolean isMarquee() {
		return equals(MARQUEE);
	}

	public boolean isActive(EditPartViewer viewer) {
		LightweightEditDomain editDomain = viewer.getEditDomain();
		return isActive(editDomain);
	}

	public boolean isActive(LightweightEditDomain editDomain) {
		return toolClass.isInstance(editDomain.getActiveTool());
	}

	public boolean ensureActive(EditPartViewer viewer) {
		if (isActive(viewer))
			return true;

		LightweightEditDomain editDomain = viewer.getEditDomain();
		return ensureActive(editDomain);
	}

	public boolean ensureActive(LightweightEditDomain editDomain) {
		try {
			editDomain.setActiveTool(createTool());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Tool createTool() {
		try {
			return (Tool) toolClass.newInstance();
		} catch (Exception e) {
			throw new IllegalStateException("Cannot create tool entry", e);
		}
	}

	public static Tools getActiveTool(EditPartViewer viewer) {
		return getActiveTool(viewer.getEditDomain());
	}

	public static Tools getActiveTool(LightweightEditDomain editDomain) {
		Tool activeTool = editDomain.getActiveTool();
		for (Tools tool : values())
			if (tool.toolClass.isInstance(activeTool))
				return tool;

		throw new IllegalStateException("Unknown selected tool");
	}
}
