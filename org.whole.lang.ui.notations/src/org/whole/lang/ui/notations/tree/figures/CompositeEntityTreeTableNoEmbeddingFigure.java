/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityTreeTableNoEmbeddingFigure extends NodeFigure {
	protected boolean isRightToLeft;
	protected final EntityFigure titleFigure;

	public CompositeEntityTreeTableNoEmbeddingFigure(EntityDescriptor<?> ed, boolean isRightToLeft) {
		this.isRightToLeft = isRightToLeft;

		setLayoutManager(new ColumnLayout()//.setStretchingWidthFactor(1)
				//.setMarginLeft(4)
				);
		initContentPanes(1);

		titleFigure = TreeNotationUtils.createTitleFigure(ed.getName(), createFoldingToggle(0));

		add(titleFigure);
		add(createContentPane(0, createCompositeFigure()));
	}

	protected IEntityFigure createCompositeFigure() {
		CompositeFigure figure = new CompositeFigure(false);
		figure.getLayoutManager().withSpacing(2)
				.withMarginLeft(DrawUtils.SPACING*2).withMarginRight(4);
		figure.setBorder(null);
		return figure;
	}

	public boolean isRightToLeft() {
		return isRightToLeft;
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(this, isRightToLeft() ? 1.0 : 0, 0.5)
		};
	}

	@SuppressWarnings("unchecked")
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle tb = titleFigure.getBounds();

		if (getContentPane(0).isVisible()) {
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
	
				g.setForegroundColor(FigurePrefs.relationsColor);
				DrawUtils.drawHorizontalTree(g, start, DrawUtils.SPACING, end);			
			}
	
			Rectangle b = getBounds();
			Rectangle titleBounds = titleFigure.getBounds();
			g.setForegroundColor(FigurePrefs.blueColor);
			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] {4,2});
			g.drawRoundRectangle(b.getResized(-1, -titleBounds.height).translate(0, titleBounds.height-1), 8, 8);
			g.setLineStyle(SWT.LINE_SOLID);
			g.setLineDash((int[]) null);

			g.setClip(tb);
			tb = tb.getResized(0, 4);
		}

		g.setForegroundColor(FigurePrefs.blueColor);
		g.drawRoundRectangle(tb.getResized(-1, -1), 8, 8);

		int oldAlpha = g.getAlpha();
		g.setAlpha(60);
		g.setBackgroundColor(FigurePrefs.blueColor);
		g.fillRoundRectangle(tb, 8, 8);
		g.setAlpha(oldAlpha);
	}
}
