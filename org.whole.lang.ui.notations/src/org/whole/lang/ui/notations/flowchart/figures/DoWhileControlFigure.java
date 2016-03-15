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
public class DoWhileControlFigure extends NodeFigure {
	public static final int gap = 8;

	public DoWhileControlFigure() {
		initContentPanes(2);

		setLayoutManager(new ColumnLayout().withMinorAlignment(Alignment.CENTER).withSpacing(4));

		add(createContentPane(0));
		add(createContentPane(1));
		setBorder(new MarginBorder(gap,gap*2,0,gap*2));
	}

	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopOrBottomMiddleAnchor(this)};
	}

	public IEntityFigure createContentPane(int index) {
		if (index == 1)
			return contentPanes[1] = new ConditionFigure();

		return super.createContentPane(index);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        Rectangle r = getBounds();
        Rectangle rTrue = getContentPane(0).getBounds();
        Rectangle rCond = getContentPane(1).getBounds();
        
        int xMid = rTrue.x + rTrue.width/2;
        int yCondMid = rCond.y + rCond.height/2;
        int xLoopLine = Math.min(rCond.x, rTrue.x) -gap;
        int yTrueBottom = rTrue.y + rTrue.height;
        int xLoopSource = rCond.x;
        int yLoopSource = yCondMid;
        int yLoopTarget = r.y;

        //top line
        g.drawLine(xMid, r.y, xMid, rTrue.y);
       
        //true line
        g.drawLine(xMid, yTrueBottom, xMid, rCond.y);
        
        //loop line
        g.drawLine(xLoopSource, yLoopSource, xLoopLine, yLoopSource);
        g.drawLine(xLoopLine, yLoopSource, xLoopLine, yLoopTarget);
        g.drawLine(xLoopLine, yLoopTarget, xMid, yLoopTarget);
        
        // branch labels
        g.drawText("T", rCond.x -10, yCondMid +4);
	}
}
