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

import org.eclipse.gef.palette.ToolEntry;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.tools.TextualSelectionTool;

public class TextualSelectionToolEntry extends ToolEntry {
	public TextualSelectionToolEntry() {
		this(null);
	}
	public TextualSelectionToolEntry(String label) {
		this(label, null);
	}
	public TextualSelectionToolEntry(String label, String shortDesc) {
		super(label, shortDesc, WholeImages.DESC_TEXT_TOOL_16, WholeImages.DESC_TEXT_TOOL_24,
				TextualSelectionTool.class);
		if (label == null || label.length() == 0)
			setLabel("Text");
		if (shortDesc == null || shortDesc.length() == 0)
			setDescription("Text editing tool");
	}
}
