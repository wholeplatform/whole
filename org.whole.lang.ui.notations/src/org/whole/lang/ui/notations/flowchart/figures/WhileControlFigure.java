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
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class WhileControlFigure extends NodeFigure {
	public static final int gap = 8;

	public WhileControlFigure() {
		initContentPanes(2);

		setLayoutManager(new ColumnLayout().withMinorAlignment(Alignment.CENTER).withSpacing(4));

		add(createContentPane(0));
		add(createContentPane(1));
		setBorder(new MarginBorder(gap,gap*2,gap*2,gap*2));
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
        
        int xMid = rTrue.x + rTrue.width/2;
        int yCondMid = rCond.y + rCond.height/2;
        int xCondRight = rCond.x + rCond.width;
        int xLoopLine = Math.min(rCond.x, rTrue.x) -gap;
        int xFalseLine = Math.max(xCondRight, rTrue.x + rTrue.width) +gap;
        int yCondBottom = rCond.y + rCond.height-1;
        int yTrueBottom = rTrue.y + rTrue.height;
        int yLoopSource = yTrueBottom +gap;
        int yLoopTarget = r.y;
        int yFalseTarget = r.y+r.height-1;

        //top line
        g.drawLine(xMid, r.y, xMid, rCond.y);
       
        //true line
        g.drawLine(xMid, yCondBottom, xMid, rTrue.y);
        g.drawLine(xMid, yTrueBottom, xMid, yLoopSource);
        
        //loop line
        g.drawLine(xMid, yLoopSource, xLoopLine, yLoopSource);
        g.drawLine(xLoopLine, yLoopSource, xLoopLine, yLoopTarget);
        g.drawLine(xLoopLine, yLoopTarget, xMid, yLoopTarget);

        //false line
        g.drawLine(xCondRight, yCondMid, xFalseLine, yCondMid);
        g.drawLine(xFalseLine, yCondMid, xFalseLine, yFalseTarget);
        g.drawLine(xFalseLine, yFalseTarget, xMid, yFalseTarget);
  
        // branch labels
        g.drawText("F", xCondRight +7, yCondMid -18);
	}
}
