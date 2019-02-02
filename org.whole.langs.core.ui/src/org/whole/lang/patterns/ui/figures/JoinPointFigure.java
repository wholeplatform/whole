/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.PipeBracketsBorder;
import org.whole.lang.ui.layout.OverLayout;

/**
 * @author Riccardo Solmi
 */
public class JoinPointFigure extends ContentPaneFigure {
	public JoinPointFigure() {
		initContentPanes(2);
		setLayoutManager(new OverLayout().withMarginTop(1));

		add(createContentPane(1, new PipeBracketsBorder(3) {
			@Override
			protected void setBracketsStyle(Graphics g) {
				g.setForegroundColor(FigureConstants.relationsColor);
				g.setLineWidth(1);
				g.setLineStyle(SWT.LINE_CUSTOM);
				g.setLineDash(new int[] {1,2});
			}
		}));
		add(createContentPane(0, new MarginBorder(0,2,0,2)));
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

    	int oldAlpha = g.getAlpha();
		g.setAlpha(100);
    	g.setBackgroundColor(FigureConstants.relationsColor);
        g.fillRoundRectangle(getContentPane(0).getBounds(), 4, 6);
        g.setAlpha(oldAlpha);
	}
}
