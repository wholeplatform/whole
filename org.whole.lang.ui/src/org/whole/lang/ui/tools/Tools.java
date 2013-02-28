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
package org.whole.lang.ui.tools;

import java.util.List;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.gef.tools.PanningSelectionTool;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.whole.lang.ui.palette.TextualSelectionToolEntry;
import org.whole.lang.ui.palette.WholePaletteFactory;

public enum Tools {
	PANNING("org.eclipse.gef.tools.PanningSelectionTool", PanningSelectionTool.class, PanningSelectionToolEntry.class),
	TEXTUAL("org.whole.lang.ui.tools.TextualSelectionTool", TextualSelectionTool.class, TextualSelectionToolEntry.class),
	MARQUEE("org.eclipse.gef.tools.MarqueeSelectionTool", MarqueeSelectionTool.class, MarqueeToolEntry.class);

	private final String entryId;
	private final Class<?> toolClass;
	private final Class<?> toolEntryClass;
	
	private Tools(String entryId, Class<?> toolClass, Class<?> toolEntryClass) {
		this.entryId = entryId;
		this.toolClass = toolClass;
		this.toolEntryClass = toolEntryClass;
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
		EditDomain editDomain = viewer.getEditDomain();
		PaletteViewer paletteViewer = editDomain.getPaletteViewer();
		if (paletteViewer != null)
			return isActive(paletteViewer);
		else
			return isActive(editDomain);
	}

	public boolean isActive(PaletteViewer paletteViewer) {
		return entryId.equals(paletteViewer.getActiveTool().getId());
	}

	public boolean isActive(EditDomain editDomain) {
		return toolClass.isInstance(editDomain.getActiveTool());
	}

	public boolean ensureActive(EditPartViewer viewer) {
		if (isActive(viewer))
			return true;

		EditDomain editDomain = viewer.getEditDomain();
		PaletteViewer paletteViewer = editDomain.getPaletteViewer();
		if (paletteViewer != null)
			return ensureActive(paletteViewer);
		else
			return ensureActive(editDomain);
	}

	@SuppressWarnings("unchecked")
	public boolean ensureActive(PaletteViewer paletteViewer) {
		PaletteGroup toolsGroup = WholePaletteFactory.getPaletteToolsGroup(paletteViewer, this);

		List<ToolEntry> toolEntries = (List<ToolEntry>) toolsGroup.getChildren();
		for (ToolEntry toolEntry : toolEntries)
			if (entryId.equals(toolEntry.getId())) {
				paletteViewer.setActiveTool(toolEntry);
				return true;
			}

		return false;
	}

	public boolean ensureActive(EditDomain editDomain) {
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

	public ToolEntry createToolEntry() {
		try {
			ToolEntry toolEntry = (ToolEntry) toolEntryClass.newInstance();
			toolEntry.setId(entryId);
			return toolEntry;
		} catch (Exception e) {
			throw new IllegalStateException("Cannot create tool entry", e);
		}
	}

	public static Tools getActiveTool(EditPartViewer viewer) {
		return getActiveTool(viewer.getEditDomain());
	}

	public static Tools getActiveTool(EditDomain editDomain) {
		Tool activeTool = editDomain.getActiveTool();
		for (Tools tool : values())
			if (tool.toolClass.isInstance(activeTool))
				return tool;

		throw new IllegalStateException("Unknown selected tool");
	}
}
