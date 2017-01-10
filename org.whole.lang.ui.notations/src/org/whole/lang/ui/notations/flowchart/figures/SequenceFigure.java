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
package org.whole.lang.ui.notations.flowchart.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.NotationImages;

/**
 * @author Riccardo Solmi
 */
public class SequenceFigure extends NodeFigure {
	public SequenceFigure() {
		setLayoutManager(new ColumnLayout().withMinorAlignment(Alignment.CENTER));
		initContentPanes(2);

		EntityFigure topFigure = new EntityFigure(new RowLayout().withSpacing(2));
		topFigure.addLabel(NotationImages.SEQUENCE16);
		topFigure.add(createContentPane(0));
		topFigure.add(createFoldingToggle(1));

		add(topFigure);
		add(createContentPane(1));
		setBorder(createBorder(true));
	}

	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopOrBottomMiddleAnchor(this)};
	}

	protected AbstractBorder createBorder(final boolean isHorizontal) {
		return new AbstractBorder() {
			private /*static*/ final Insets INSETS = new Insets(10,20,10,20);
			public Insets getInsets(IFigure figure) {
				return INSETS;
			}
			public void paint(IFigure figure, Graphics graphics, Insets insets) {
				Rectangle rect = getPaintRectangle(figure, insets).resize(-1, -1);
				graphics.setForegroundColor(ColorConstants.lightGray);
//				graphics.setLineStyle(SWT.LINE_CUSTOM);
//				graphics.setLineDash(new int[] {8,3});
				graphics.drawRoundRectangle(rect,10,10);
			}
		};
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.relationsColor;
	}

	@SuppressWarnings("unchecked")
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		Rectangle r = getBounds();
		List<IFigure> children = ((IFigure) getContentPane(1).getChildren().get(0)).getChildren();

		if (children.size() > 0) {
			Rectangle rh = children.get(0).getBounds();

			int xm = rh.x + rh.width/2;
			int y1 = rh.y;

			if (getContentPane(1).isVisible()) {
				g.drawLine(xm, r.y, xm, rh.y);

				for (int i=1; i<children.size(); i++) {
					Rectangle ri = children.get(i).getBounds();
					int yh = rh.y + rh.height;
					int yi = ri.y;

					g.drawLine(xm, yh, xm, yi);

					rh = ri;
				}

				y1 =  rh.y + rh.height-1;

				g.drawLine(xm, y1, xm, r.y+r.height-1);
			}
		}
	}
}
