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
package org.whole.lang.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class TypeRelationBorder extends MarginBorder {
	public static final int H = 5;
	private boolean isLanguageSpecific;

	public TypeRelationBorder(boolean isSubtype, boolean isLanguageSpecific) {
		super(isSubtype ? 0 : H, 0, isSubtype ? H : 0, 0);
		this.isLanguageSpecific = isLanguageSpecific;
	}

	public void paint(IFigure f, Graphics g, Insets i) {
		Rectangle r = getPaintRectangle(f, i);
		r.width--;
		r.height--;

		drawTypeSymbol(g, r.x, insets.top > 0 ? r.y+H : r.bottom(), r.width, isLanguageSpecific);
	}

	public static void drawTypeSymbol(Graphics g, int x, int y, int w, boolean isLanguageSpecific) {
		int center = x + w/2;

		g.setForegroundColor(
				isLanguageSpecific ? FigureConstants.modulesColor : FigureConstants.declarationsColor);

		g.drawLine(x, y, center-H, y);
		g.drawLine(center+H, y, x+w, y);

		g.drawLine(center-H, y, center, y-H);
		g.drawLine(center, y-H, center+H, y);
	}
}
