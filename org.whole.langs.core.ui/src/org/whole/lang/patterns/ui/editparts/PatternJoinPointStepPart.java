/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.patterns.ui.editparts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.editparts.AbstractPart;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;

/**
 *  @author  Riccardo Solmi
 */
public class PatternJoinPointStepPart extends AbstractPart {

    protected IFigure createFigure() {
		EntityLabel label = new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.keywordsColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.keywordsFont;
			}
			@Override
			protected void paintFigure(Graphics g) {
		        super.paintFigure(g);

		    	int oldAlpha = g.getAlpha();
				g.setAlpha(100);
		    	g.setBackgroundColor(FigureConstants.relationsColor);
		        g.fillRoundRectangle(getBounds(), 8, 6);
		        g.setAlpha(oldAlpha);
			}
		};
		label.setBorder(new MarginBorder(0,2,0,2));
		label.setText("applicationPoint");
		return label;
    }
}
