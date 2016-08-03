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
package org.whole.lang.queries.ui.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * @author Riccardo Solmi
 */
public class ScopeBracketsBorder extends MarginBorder {
	public ScopeBracketsBorder(int margin) {
		super(margin);
	}
	public ScopeBracketsBorder(int top, int left, int bottom, int right) {
		super(top, left, bottom, right);
	}

	@SuppressWarnings("unchecked")
	public void paint(IFigure f, Graphics g, Insets i) {
		List<IFigure> children = (List<IFigure>) f.getChildren();
		Rectangle bounds0 = children.get(0).getBounds();
		int rightFirstChild = bounds0.right();
		int bottomFirstChild = bounds0.bottom();
		int heightLastChild = children.size() < 3 ? 4 : children.get(children.size()-1).getBounds().height;

		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;

		g.setForegroundColor(getDelimiterColor());

		g.drawLine(r.x, r.y, rightFirstChild, r.y);
		g.drawLine(r.x, r.y, r.x, bottomFirstChild);		
		g.drawLine(rightFirstChild, r.y, rightFirstChild, bottomFirstChild);		
		g.drawLine(rightFirstChild, bottomFirstChild-4, r.right(), bottomFirstChild-4);
		g.drawLine(r.right(), bottomFirstChild-4, r.right(), bottomFirstChild);

		g.drawLine(r.x, r.bottom(), r.right(), r.bottom());
		g.drawLine(r.x, r.bottom(), r.x, r.bottom()-heightLastChild);
		g.drawLine(r.right(), r.bottom(), r.right(), r.bottom()-heightLastChild);
	}
	protected Color getDelimiterColor() {
		return ColorConstants.black;
	}
}
