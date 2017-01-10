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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.figures.PaintFigureHelper;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class GuardedActivityFigure extends NodeFigure {
	public static final int gap = 4;
	protected IFigure row0;

	public GuardedActivityFigure() {
		this(null);
	}
	public GuardedActivityFigure(Image labelImage) {
		initContentPanes(2);

		setLayoutManager(new ColumnLayout()
		.withMinorAlignment(Alignment.CENTER).withSpacing(gap*2)
		.withMargin(gap, 4, 4, 4));

		if (labelImage == null)
			row0 = createContentPane(0);
		else {
			row0 = new EntityFigure(new RowLayout().withMinorAlignment(Alignment.CENTER).withSpacing(2));
			((EntityFigure)row0).addLabel(labelImage);
			row0.add(createContentPane(0));			
		}

		add(row0);
		add(createContentPane(1));
	}

	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopOrBottomMiddleAnchor(this)};
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension d = super.getPreferredSize(wHint, hHint);
		d.width = Math.max(d.width, 41);
		return d;
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.relationsColor;
	}

	@Override
	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        Rectangle bounds = getBounds();
        Rectangle rGuardContent = row0.getBounds();
        Rectangle rActivity = getContentPane(1).getBounds();

        Rectangle rGuard = Rectangle.SINGLETON;
        rGuard.setLocation(bounds.x, bounds.y);
        rGuard.setSize(bounds.width, gap*2 + rGuardContent.height);

        int yGuardBottom = rGuard.y + rGuard.height;
        int xMid = rActivity.x + rActivity.width/2;
        int yActivityBottom = rActivity.y + rActivity.height-1;
        int yBottom = bounds.y + bounds.height-1;
        
        g.drawLine(xMid, yGuardBottom, xMid, rActivity.y);
        g.drawLine(xMid, yActivityBottom, xMid, yBottom);

        PaintFigureHelper.drawFilledRectangle(g, rGuard,
        		ColorConstants.black, FigureConstants.lightGray);
	}
}
