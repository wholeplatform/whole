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
import org.whole.lang.ui.layout.OverColumnLayout;

/**
 *  @author  Riccardo Solmi
 */
public class CommentFigure extends ContentPaneFigure {
	public static final int CONTENT_MARGIN = 2;

    public CommentFigure() {
		super(new OverColumnLayout().withMargin(CONTENT_MARGIN));
		initContentPanes(2);

		add(createContentPane(0));
		add(createContentPane(1));
    }

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		Rectangle bounds = getBounds();
		Rectangle commentBounds = getContentPane(0).getBounds();
		Rectangle contentBounds = getContentPane(1).getBounds();

		g.setBackgroundColor(FigureConstants.reviewCommentBackgroundColor);
		g.fillRectangle(bounds.x, bounds.y, bounds.width, commentBounds.height);
		g.setBackgroundColor(FigureConstants.reviewCommentBackgroundColor);
//		g.fillRectangle(bounds.x, contentBounds.y, bounds.width, contentBounds.height);
		g.setForegroundColor(FigureConstants.reviewCommentColor);
		g.drawRectangle(bounds.x, bounds.y, bounds.width-1, bounds.height-1);
	}
}
