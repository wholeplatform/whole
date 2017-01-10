/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.changes.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 *  @author  Riccardo Solmi
 */
public class RevisionTrackFigure extends ContentPaneFigure {
    public RevisionTrackFigure() {
    	super(new ColumnLayout().withSpacing(10).withMargin(10));
    	initContentPanes(2);

    	add(createContentPane(0));
		add(createContentPane(1));
    }

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle bounds = getBounds();
		Rectangle bounds1 = getContentPane(1).getBounds();

		g.setBackgroundColor(FigureConstants.collapseBackgroundColor);
		g.fillRectangle(bounds.x, bounds.y, 10, bounds.height);
		g.fillRectangle(bounds.right()-10, bounds.y, 10, bounds.height);
		g.fillRectangle(bounds.x, bounds.y, bounds.width, bounds1.y-bounds.y);
		g.fillRectangle(bounds.x, bounds1.bottom()+1, bounds.width, 10);
	}
}
