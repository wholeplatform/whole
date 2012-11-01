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
package org.whole.lang.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;

/**
 * @author Riccardo Solmi
 */
public class WholeTextCellEditorLocator implements CellEditorLocator {
	private IFigure textFigure;

	public WholeTextCellEditorLocator(IFigure textFigure) {
		setTextFigure(textFigure);
	}
	
	public void relocate(CellEditor celleditor) {
		Text text = (Text) celleditor.getControl();
		Rectangle rect = textFigure.getClientArea().getCopy();
		textFigure.translateToAbsolute(rect);
		
		org.eclipse.swt.graphics.Rectangle trim = text.computeTrim(0, 0, 0, 0);
		rect.translate(trim.x, trim.y);
		rect.width += trim.width;
		rect.height += trim.height;
		text.setBounds(rect.x, rect.y, rect.width, rect.height);

//		Point pref = text.computeSize(-1, -1);
//		text.setBounds(rect.x - 1, rect.y - 1, pref.x + 1, pref.y + 1);	
	}
	
	protected IFigure getTextFigure() {
		return textFigure;
	}
	protected void setTextFigure(IFigure textFigure) {
		this.textFigure = textFigure;
	}
}
