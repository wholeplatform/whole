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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class VariabilityNameFigure extends ContentPaneFigure {
	public VariabilityNameFigure() {
		super(new MonoLayout());
		initContentPanes(1);

		EntityLabel label = LabelFactory.createIdentifier();
		label.setBorder(new MarginBorder(0,2,0,2));
		add(createContentPane(0, label));
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

    	int oldAlpha = g.getAlpha();
		g.setAlpha(100);
		g.setForegroundColor(FigureConstants.relationsColor);
    	g.setBackgroundColor(ColorConstants.orange);
        g.fillRoundRectangle(getContentPane(0).getBounds(), 8, 6);
        g.drawRoundRectangle(getContentPane(0).getBounds().getResized(-1, -1), 8, 6);
        g.setAlpha(oldAlpha);
	}
}
