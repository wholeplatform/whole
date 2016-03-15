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
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class TypeRelationFigure extends ContentPaneFigure {
	public TypeRelationFigure(boolean isSubtype) {
		super(new ColumnLayout() {
			@Override
			protected int getAscent(int height) {
				return childSize[0].height+TypeRelationBorder.H+1;
			}
		}.withSpacing(TypeRelationBorder.H*2).withMinorAlignment(Alignment.CENTER));
		initContentPanes(2);

		add(createContentPane(0));
		add(createContentPane(1));
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle r = getBounds();
		Rectangle r0 = getContentPane(0).getBounds();
		TypeRelationBorder.drawTypeSymbol(g, r.x, r0.y+r0.height+TypeRelationBorder.H+1, r.width, false);
	}
}
