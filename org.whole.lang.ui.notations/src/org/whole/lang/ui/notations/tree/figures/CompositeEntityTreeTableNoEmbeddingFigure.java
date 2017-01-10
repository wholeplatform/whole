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
package org.whole.lang.ui.notations.tree.figures;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityTreeTableNoEmbeddingFigure extends NodeFigure {
	protected boolean isRightToLeft;
	protected EntityFigure titleFigure;

	public CompositeEntityTreeTableNoEmbeddingFigure(boolean isRightToLeft) {
		this.isRightToLeft = isRightToLeft;

		setLayoutManager(new MonoLayout());
		initContentPanes(1);

		add(createContentPane(0, createCompositeFigure()));
	}
	public CompositeEntityTreeTableNoEmbeddingFigure(boolean isRightToLeft, String tabLabel) {
		this.isRightToLeft = isRightToLeft;

		setLayoutManager(new ColumnLayout());
		initContentPanes(1);

		titleFigure = TreeNotationUtils.createTitleFigureWithAlpha(tabLabel, null);
		add(titleFigure);
		add(createContentPane(0, createCompositeFigure()));
	}

	protected IEntityFigure createCompositeFigure() {
		CompositeFigure figure = new CompositeFigure(false);
		figure.getLayoutManager().withSpacing(4)
				.withMarginLeft(DrawUtils.SPACING*2).withMarginRight(2);
		figure.setBorder(null);
		return figure;
	}

	public boolean isRightToLeft() {
		return isRightToLeft;
	}

	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		// TODO
		return super.createSourceAnchors();
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(getContentPane(0), isRightToLeft() ? 1.0 : 0, 0.5)
		};
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}
	@SuppressWarnings("unchecked")
	protected void paintConnections(Graphics g) {
		List<IFigure> children = getContentPane(0).getChildren();
		int childrenSize = children.size();
		if (childrenSize > 0) {
			Point start = getTargetAnchor(0).getLocation(null);
			translateToRelative(start);

			Point[] end = new Point[childrenSize];
			for (int i=0; i<childrenSize; i++) {
				IFigure child = children.get(i);
				if (child instanceof INodeFigure) {
					end[i] = ((INodeFigure) child).getTargetAnchor(0).getLocation(null);
					translateToRelative(end[i]);
				} else
					end[i] = child.getBounds().getLeft();
			}

			g.setForegroundColor(FigureConstants.relationsColor);
			DrawUtils.drawHorizontalTree(g, start, DrawUtils.SPACING, end);			
		}
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle b = getBounds();
		Rectangle tb = null;

		int oldAlpha = g.getAlpha();
		if (titleFigure != null) {
			g.setAlpha(60);

			tb = titleFigure.getBounds();
			b = b.getResized(-1, -tb.height).translate(0, tb.height-1);
		} else
			b = b.getResized(-1, -1);

		if (titleFigure != null || getContentPane(0).getChildren().isEmpty()) {
			g.setForegroundColor(FigureConstants.blueColor);
			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] {4,2});
			g.drawRoundRectangle(b, 8, 8);
			g.setLineStyle(SWT.LINE_SOLID);
			g.setLineDash((int[]) null);
		}

		if (titleFigure != null) {
			g.setClip(tb);
			tb = tb.getResized(0, 4);

			g.drawRoundRectangle(tb.getResized(-1, -1), 8, 8);

//			int oldAlpha = g.getAlpha();
//			g.setAlpha(60);
			g.setBackgroundColor(FigureConstants.blueColor);
			g.fillRoundRectangle(tb, 8, 8);
//			g.setAlpha(oldAlpha);

			g.setAlpha(oldAlpha);
		}
	}
}
