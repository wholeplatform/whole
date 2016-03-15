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
package org.whole.lang.ui.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

public class LabelCellEditorLocator implements CellEditorLocator {
	public static final int DX, DY;
	static {
		String platform = SWT.getPlatform();
		if (platform.equals("cocoa")) {//$NON-NLS-1$
			DX = -5;
			DY = +1;
		} else if (platform.equals("win32")) {//$NON-NLS-1$
			DX = -1;//TODO test
			DY = -1;
		} else {
			DX = 0;
			DY = 0;
		}
	}

	private Label label;

	public LabelCellEditorLocator(Label label) {
		setLabel(label);
	}
	
	public void relocate(CellEditor celleditor) {
		Text text = (Text) celleditor.getControl();
		Point pref = text.computeSize(-1, -1);
		Rectangle rect = label.getTextBounds().getCopy();
		label.translateToAbsolute(rect);
		SWT.getPlatform();
		text.setBounds(rect.x + DX, rect.y + DY, pref.x, pref.y);	
	}
	
	protected Label getLabel() {
		return label;
	}
	
	protected void setLabel(Label label) {
		this.label = label;
	}
}
