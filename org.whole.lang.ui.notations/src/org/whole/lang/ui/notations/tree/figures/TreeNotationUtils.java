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
package org.whole.lang.ui.notations.tree.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Toggle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class TreeNotationUtils {
	public static EntityFigure createTitleFigure(String title, Toggle toggle) {
		EntityFigure titleFigure = new EntityFigure(new RowLayout().withSpacing(4).withMargin(2, 4, 2, 12));
		if (toggle != null)
			titleFigure.add(toggle);
		
		titleFigure.addDeclaration(title);
		return titleFigure;
	}

	public static EntityFigure createTitleFigureWithAlpha(String title, Toggle toggle) {
		EntityFigure titleFigure = new EntityFigure(new RowLayout().withSpacing(4).withMargin(2, 4, 2, 12));
		if (toggle != null)
			titleFigure.add(toggle);
		
		EntityLabel label = new EntityLabel() {
			public Color getLocalForegroundColor() {
				return FigureConstants.declarationsColor;
			}	
			public Font getLocalFont() {
				return FigureConstants.declarationsFont;
			}
			@Override
			protected void paintFigure(Graphics g) {
				int oldAlpha = g.getAlpha();
				g.setAlpha(60);
				
				super.paintFigure(g);

				g.setAlpha(oldAlpha);

			}
		};
		label.setText(title);
		titleFigure.add(label);
		return titleFigure;
	}

}
