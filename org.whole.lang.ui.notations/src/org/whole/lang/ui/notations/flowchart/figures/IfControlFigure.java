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

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class IfControlFigure extends NodeFigure {
	public static final int gap = 8;

	public IfControlFigure() {
		setLayoutManager(new ColumnLayout()
				.withMinorAlignment(Alignment.CENTER).withSpacing(8));
		initContentPanes(2);

		EntityFigure row2 = new EntityFigure(new RowLayout().withSpacing(11));
		row2.add(createContentPane(1));

		add(createContentPane(0));
		add(row2);
		setBorder(new MarginBorder(0,0,gap,0));
	}

	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopOrBottomMiddleAnchor(this)};
	}

	public IEntityFigure createContentPane(int index) {
		if (index == 0)
			return contentPanes[0] = new ConditionFigure();

		return super.createContentPane(index);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        Rectangle r = getBounds();
        Rectangle rCond = getContentPane(0).getBounds();
        Rectangle rTrue = getContentPane(1).getBounds();
        Rectangle rFalse = getContentPane(2).getBounds();
        
        int xTrueMid = rTrue.x + rTrue.width/2;
        int xFalseMid = rFalse.x + rFalse.width/2;
        int xCondRight = rCond.x + rCond.width;
        int yCondMid = rCond.y + rCond.height/2;
        int yTrueBottom = rTrue.y + rTrue.height;
        int yFalseBottom = rFalse.y + rFalse.height;
        int yBottom = r.y + r.height-1;
        
        // true branch
        g.drawLine(rCond.x, yCondMid, xTrueMid, yCondMid);
        g.drawLine(xTrueMid, yCondMid, xTrueMid, rTrue.y);
		
        // false branch
        g.drawLine(xCondRight, yCondMid, xFalseMid, yCondMid);
        g.drawLine(xFalseMid, yCondMid, xFalseMid, rFalse.y);
        
        // bottom join
        g.drawLine(xTrueMid, yTrueBottom, xTrueMid, yBottom);
        g.drawLine(xFalseMid, yFalseBottom, xFalseMid, yBottom);
        g.drawLine(xTrueMid, yBottom, xFalseMid, yBottom);
        
        
        // branch labels
        g.drawText("T", rCond.x -10, yCondMid -18);
        g.drawText("F", xCondRight +7, yCondMid -18);
	}
}
