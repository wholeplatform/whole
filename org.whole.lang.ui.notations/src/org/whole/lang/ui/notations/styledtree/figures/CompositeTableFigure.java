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
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.IFeatureStyling;

/**
 * @author Riccardo Solmi
 */
public class CompositeTableFigure extends NodeFigure {
	protected IEntityFigure nodeFigure;
	protected IEntityFigure typeFigure;
	protected IEntityFigure tableFigure;
	protected IFeatureStyling[] featuresStyling;

	public CompositeTableFigure(IEntityStyling entityStyling) {
		featuresStyling = entityStyling.getFeaturesStyling();

		initContentPanes(getChildrenPaneIndex()+1);

		setLayoutManager(new ColumnLayout().withAutoresizeWeight(1f));

		add(typeFigure = createTypeLabelFigure());
		add(tableFigure = createChildrenFigure());
	}

	protected int getChildrenPaneIndex() {
		return 1;
	}
	protected IEntityFigure createTypeLabelFigure() {
		IEntityFigure typeFigure = createContentPane(0, ViewportTracking.HORIZONTAL);
		typeFigure.getLayoutManager().withMargin(2, 4, 2, 8);
		return typeFigure;
	}
	protected IEntityFigure createChildrenFigure() {
		return createContentPane(getChildrenPaneIndex());
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createLeftMiddleAnchor(typeFigure)
		};
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		Rectangle b = getBounds();
		Rectangle tableBounds = tableFigure.getBounds();
		g.setForegroundColor(FigureConstants.blueColor);
		g.drawRoundRectangle(b.getResized(-1, -1), 8, 8);
		g.drawLine(b.x, tableBounds.y, b.right(), tableBounds.y);

		int oldAlpha = g.getAlpha();
		g.setAlpha(60);

		b = b.getCopy();
		b.height = typeFigure.getBounds().height;
		g.setBackgroundColor(FigureConstants.blueColor);
		g.setClip(b);
		g.fillRoundRectangle(b.getResized(0, 4), 8, 8);

		g.setAlpha(oldAlpha);
	}
}
