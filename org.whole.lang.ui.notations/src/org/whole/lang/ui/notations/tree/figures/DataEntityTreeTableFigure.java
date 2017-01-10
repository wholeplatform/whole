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

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class DataEntityTreeTableFigure extends NodeFigure {
	protected boolean isRightToLeft;
	protected final EntityFigure titleFigure;

	public DataEntityTreeTableFigure(EntityDescriptor<?> ed, boolean isRightToLeft) {
		this.isRightToLeft = isRightToLeft;
		initContentPanes(1);

		setLayoutManager(new ColumnLayout()//.setStretchingWidthFactor(1)
		//.setMarginLeft(4)
		);

		titleFigure = TreeNotationUtils.createTitleFigure(ed.getName(), createFoldingToggle(0));

		add(titleFigure);
		add(createContentPane(0, createDataFigure()));
	}

	protected IEntityFigure createDataFigure() {
		EntityLabel figure = LabelFactory.createLiteral();
		figure.setBorder(new MarginBorder(1, 5, 1, 5));
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

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle titleBounds = titleFigure.getBounds();
		g.setForegroundColor(FigureConstants.blueColor);
		
		if (getContentPane(0).isVisible()) {
			Rectangle b = getBounds();
			g.drawRoundRectangle(b.getResized(-1, -titleBounds.height).translate(0, titleBounds.height-1), 8, 8);

			g.setClip(titleBounds);
			titleBounds = titleBounds.getResized(0, 4);
		}

		g.drawRoundRectangle(titleBounds.getResized(-1, -1), 8, 8);

		int oldAlpha = g.getAlpha();
		g.setAlpha(60);
		g.setBackgroundColor(FigureConstants.blueColor);
		g.fillRoundRectangle(titleBounds, 8, 8);
		g.setAlpha(oldAlpha);
	}
}
