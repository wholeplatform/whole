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
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.changes.ui.editparts.AbstractComparePart;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author  Riccardo Solmi
 */
public class SideBySideCompareFigure extends ContentPaneFigure {
	public static final int CONTENT_MARGIN = 2;
	public static final int MAPPING_SIZE = 32;
	protected EntityFigure baseFigure;
	protected AbstractComparePart.CompareMapper leftMapper;
	protected AbstractComparePart.CompareMapper rightMapper;

    public SideBySideCompareFigure(AbstractComparePart.CompareMapper leftMapper, AbstractComparePart.CompareMapper rightMapper) {
    	super(new RowLayout().withMargin(CONTENT_MARGIN).withSpacing(MAPPING_SIZE+2).withMinorAlignment(Alignment.LEADING));
		initContentPanes(3);

		this.leftMapper = leftMapper;
		this.rightMapper = rightMapper;

		EntityFigure leftFigure = new EntityFigure(new OverLayout());
		leftFigure.add(createContentPane(1));
		EntityLabel header = LabelFactory.createIdentifier("REVISION 0");
		header.setBorder(new MarginBorder(8, 2, 4, 6));
		leftFigure.add(header);
		add(leftFigure);

		baseFigure = new EntityFigure(new OverLayout());
		baseFigure.add(createContentPane(0));
		header = LabelFactory.createIdentifier("BASE REVISION");
		header.setBorder(new MarginBorder(8, 2, 4, 6));
		baseFigure.add(header);
		add(baseFigure);

		EntityFigure rightFigure = new EntityFigure(new OverLayout());
		rightFigure.add(createContentPane(2));
		header = LabelFactory.createIdentifier("REVISION 1");
		header.setBorder(new MarginBorder(8, 2, 4, 6));
		rightFigure.add(header);
		add(rightFigure);
    }

    public void showBaseRevision(boolean value) {
    	baseFigure.setVisible(value);
    }

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		boolean isThreeWay = baseFigure.isVisible();
		Rectangle bounds = getBounds();
		Rectangle leftBounds = getContentPane(1).getBounds();
		Rectangle baseBounds = isThreeWay ? getContentPane(0).getBounds() : null;
		Rectangle rightBounds = getContentPane(2).getBounds();

		int x0 = leftBounds.right() +1;
		int x1 = x0 + MAPPING_SIZE;
		int x3 = rightBounds.x -1;
		int x2 = x3 - MAPPING_SIZE;

		g.setBackgroundColor(FigureConstants.collapseBackgroundColor);
		g.fillRectangle(bounds.x, bounds.y, bounds.width, leftBounds.y - bounds.y -1);
		g.fillRectangle(x0, bounds.y, MAPPING_SIZE, bounds.height);
		if (isThreeWay)
			g.fillRectangle(x2, bounds.y, MAPPING_SIZE, bounds.height);

		g.setForegroundColor(FigureConstants.collapseColor);
		g.drawRectangle(leftBounds.x-2, leftBounds.y-3, leftBounds.width+2, leftBounds.height+5);
		if (isThreeWay)
			g.drawRectangle(baseBounds.x-2, baseBounds.y-3, baseBounds.width+2, baseBounds.height+4);
		g.drawRectangle(rightBounds.x-2, rightBounds.y-2, rightBounds.width+2, rightBounds.height+3);

		leftMapper.paintMapping(g, x0, x1-1);
		if (isThreeWay)
			rightMapper.paintMapping(g, x2, x3-1);
	}
}
