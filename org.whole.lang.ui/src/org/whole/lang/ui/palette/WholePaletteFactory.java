/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.palette;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.templates.IUITemplate;
import org.whole.lang.ui.templates.PaletteBuilder;
import org.whole.lang.ui.tools.Tools;

/**
 * @author Riccardo Solmi
 */
public class WholePaletteFactory {
	private static final String PALETTE_DOCK_LOCATION = "WholePaletteFactory.Location";
	private static final String PALETTE_SIZE = "WholePaletteFactory.Size";
	private static final String PALETTE_STATE = "WholePaletteFactory.State";
	private static final String PALETTE_TOOLS_GROUP = "org.whole.lang.ui.palette.WholePaletteFactory.Tools";

	public static FlyoutPreferences createPalettePreferences() {
		return new FlyoutPreferences() {
			private IPreferenceStore getPreferenceStore() {
				return WholeUIPlugin.getDefault().getPreferenceStore();
			}
			public int getDockLocation() {
				return getPreferenceStore().getInt(PALETTE_DOCK_LOCATION);
			}
			public int getPaletteState() {
				return getPreferenceStore().getInt(PALETTE_STATE);
			}
			public int getPaletteWidth() {
				return getPreferenceStore().getInt(PALETTE_SIZE);
			}
			public void setDockLocation(int location) {
				getPreferenceStore().setValue(PALETTE_DOCK_LOCATION, location);
			}
			public void setPaletteState(int state) {
				getPreferenceStore().setValue(PALETTE_STATE, state);
			}
			public void setPaletteWidth(int width) {
				getPreferenceStore().setValue(PALETTE_SIZE, width);
			}
		};
	}

	public static PaletteRoot createPalette() {
		PaletteRoot palette = new PaletteRoot();

		PaletteGroup toolsGroup = new PaletteGroup("Tools");

		for (Tools tool : Tools.values()) {
			ToolEntry toolEntry = tool.createToolEntry();
			toolsGroup.add(toolEntry);
			if (Tools.PANNING.equals(tool))
				palette.setDefaultEntry(toolEntry);
		}

		toolsGroup.add(new PaletteSeparator());
		toolsGroup.setId(PALETTE_TOOLS_GROUP);

		palette.add(toolsGroup);
		return palette;
	}

	@SuppressWarnings("unchecked")
	public static PaletteGroup getPaletteToolsGroup(PaletteViewer viewer, Tools tool) {
		List<PaletteEntry> entries = viewer.getPaletteRoot().getChildren();

		for (PaletteEntry entry : entries)
			if (PALETTE_TOOLS_GROUP.equals(entry.getId()))
				return (PaletteGroup) entry;

		throw new IllegalStateException("Cannot find tools group in palette viewer");
	}

	private static Set<String> templateIds = new HashSet<String>();
	public static void ensurePaletteTemplate(PaletteRoot palette, IUITemplate template) {
		if (templateIds.add(template.getId()))
			template.applyPalette(new PaletteBuilder(palette));
	}
}
