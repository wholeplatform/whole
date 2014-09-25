/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class GoalStepFigure extends ContentPaneFigure {
	public GoalStepFigure() {
		super(new MonoLayout());
		initContentPanes(1);

		EntityLabel label = LabelFactory.createIdentifier();//Declaration();
		label.setBorder(new MarginBorder(2,2,0,2));//1,3,1,3));
		add(createContentPane(0, label));
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

        Rectangle goalBounds = getContentPane(0).getBounds();

//    	int oldAlpha = g.getAlpha();
//		g.setAlpha(100);
//    	g.setBackgroundColor(FigurePrefs.relationsColor);
//		g.fillRoundRectangle(goalBounds, 8, 6);
//        g.setAlpha(oldAlpha);

        final int bw = 5;
//        final int xCenter = goalBounds.x + goalBounds.width / 2;
        g.setForegroundColor(FigurePrefs.relationsColor);
//        g.drawLine(xCenter-bw, goalBounds.y, xCenter+bw, goalBounds.y);
//        g.drawLine(xCenter-bw, goalBounds.bottom()-1, xCenter+bw, goalBounds.bottom()-1);
//        g.setLineWidth(2);
//        g.drawLine(xCenter, goalBounds.y, xCenter, goalBounds.y+2);
//        g.drawLine(xCenter, goalBounds.bottom()-1, xCenter, goalBounds.bottom()-1-2);
//        g.setLineWidth(1);
        
        g.setClip(new Rectangle(goalBounds.x, goalBounds.y, bw, goalBounds.height));
        g.drawRoundRectangle(goalBounds.getResized(-1, -1), 8, 6);
        g.setClip(new Rectangle(goalBounds.right()-bw, goalBounds.y, bw, goalBounds.height));
        g.drawRoundRectangle(goalBounds.getResized(-1, -1), 8, 6);
	}
}
