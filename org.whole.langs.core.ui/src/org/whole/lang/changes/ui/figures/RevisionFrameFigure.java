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

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.changes.ui.editparts.AbstractComparePart;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author  Riccardo Solmi
 */
public class RevisionFrameFigure extends ContentPaneFigure {
	public static final int CONTENT_MARGIN = 2;
	public static final int MAPPING_SIZE = 32;
	protected EntityFigure leftReviewFigure;
	protected EntityFigure rightReviewFigure;
	protected List<AbstractComparePart.CompareMapper> leftMappers;
	protected List<AbstractComparePart.CompareMapper> rightMappers;

    public RevisionFrameFigure(List<AbstractComparePart.CompareMapper> leftMappers, List<AbstractComparePart.CompareMapper> rightMappers) {
    	super(new RowLayout().withMargin(CONTENT_MARGIN+10).withSpacing(MAPPING_SIZE+2).withMinorAlignment(Alignment.LEADING));
		initContentPanes(6);

		this.leftMappers = leftMappers;
		this.rightMappers = rightMappers;

		leftReviewFigure = new EntityFigure(new OverLayout().withSpacing(16));
		leftReviewFigure.add(createContentPane(1));
		leftReviewFigure.add(createContentPane(0));
		add(leftReviewFigure);

		EntityFigure baseFigure = new EntityFigure(new OverLayout().withSpacing(16));
		baseFigure.add(createContentPane(3));
		baseFigure.add(createContentPane(2));
		add(baseFigure);

		rightReviewFigure = new EntityFigure(new OverLayout().withSpacing(16));
		rightReviewFigure.add(createContentPane(5));
		rightReviewFigure.add(createContentPane(4));
		add(rightReviewFigure);
    }

    public void showLeftReview(boolean value) {
    	leftReviewFigure.setVisible(value);
    }
    public void showRightReview(boolean value) {
    	rightReviewFigure.setVisible(value);
    }

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		boolean hasLeftReview = leftReviewFigure.isVisible();
		boolean hasRightReview = rightReviewFigure.isVisible();
		Rectangle bounds = getBounds();
		Rectangle leftBounds = hasLeftReview ? getContentPane(1).getBounds() : null;
		Rectangle baseBounds = getContentPane(3).getBounds();
		Rectangle rightBounds = hasRightReview ? getContentPane(5).getBounds() : null;

		int x1 = baseBounds.x - 1;
		int x0 = x1 - MAPPING_SIZE;
		int x2 = baseBounds.right() + 1;
		int x3 = x2 + MAPPING_SIZE;

		g.setBackgroundColor(FigureConstants.collapseBackgroundColor);
		g.fillRectangle(bounds.x, bounds.y, bounds.width, leftBounds.y - bounds.y -1);
		if (hasLeftReview)
			g.fillRectangle(x0, bounds.y, MAPPING_SIZE, bounds.height);
		if (hasRightReview)
			g.fillRectangle(x2, bounds.y, MAPPING_SIZE, bounds.height);

		g.setForegroundColor(FigureConstants.collapseColor);
		if (hasLeftReview)
			g.drawRectangle(leftBounds.x-2, leftBounds.y-3, leftBounds.width+2, leftBounds.height+5);
		g.drawRectangle(baseBounds.x-2, baseBounds.y-3, baseBounds.width+2, baseBounds.height+4);
		if (hasRightReview)
			g.drawRectangle(rightBounds.x-2, rightBounds.y-2, rightBounds.width+2, rightBounds.height+3);

		if (hasLeftReview)
			leftMappers.forEach(m -> m.paintMapping(g, x0, x1-1));
		if (hasRightReview)
			rightMappers.forEach(m -> m.paintMapping(g, x2, x3-1));
	}
}
