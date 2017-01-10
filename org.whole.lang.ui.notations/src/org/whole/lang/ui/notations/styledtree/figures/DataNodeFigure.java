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
package org.whole.lang.ui.notations.styledtree.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;

/**
 * @author Riccardo Solmi
 */
public class DataNodeFigure extends NodeFigure {
	protected EntityFigure typeFigure;
	
	public DataNodeFigure(IEntityStyling entityStyling) {
		initContentPanes(getDataPaneIndex()+1);

		setLayoutManager(new RowLayout() {
			protected int getIndent() {
				return typeFigure.getBounds().width + DrawUtils.SPACING/2;
			};
			public int getIndent(org.eclipse.draw2d.IFigure container) {
				return super.getIndent(container);
			};
		}.withSpacing(DrawUtils.SPACING).withMargin(2, 4, 2, 8));

		typeFigure = new EntityFigure(new RowLayout()
				.withSpacing(2).withMargin(2, 4, 2, 0)) {

		};
		typeFigure.add(createTypeLabelFigure());

		add(typeFigure);
		add(createDataFigure());
	}

	protected int getDataPaneIndex() {
		return 1;
	}
	protected IEntityFigure createTypeLabelFigure() {
		return createContentPane(0);
	}
	protected IEntityFigure createDataFigure() {
		return createContentPane(getDataPaneIndex());
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createLeftMiddleAnchor(typeFigure)
		};
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setLineWidth(1);
		g.setForegroundColor(FigureConstants.blueColor);
		g.setBackgroundColor(FigureConstants.blueColor);

		Rectangle bounds = getBounds();
		Rectangle nodeBounds = bounds.getResized(-1, -1).getShrinked(4, 2);

		int oldAlpha = g.getAlpha();
		g.setAlpha(60);
		g.drawRoundRectangle(nodeBounds, 8, 8);
		g.setClip(nodeBounds.getResized(-(nodeBounds.width - typeFigure.getBounds().width)+DrawUtils.SPACING/2, 1));
		g.fillRoundRectangle(nodeBounds, 8, 8);
		g.setAlpha(oldAlpha);
		g.drawRoundRectangle(nodeBounds, 8, 8);
	}
}
