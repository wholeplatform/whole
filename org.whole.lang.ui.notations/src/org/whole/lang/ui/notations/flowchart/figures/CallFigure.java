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
package org.whole.lang.ui.notations.flowchart.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.PaintFigureHelper;
import org.whole.lang.ui.figures.TextualNodeFigure;
import org.whole.lang.ui.notations.NotationImages;

/**
 * @author Riccardo Solmi
 */
public class CallFigure extends TextualNodeFigure {
	public CallFigure() {
		label.setIcon(NotationImages.CALL16);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        PaintFigureHelper.drawFilledRoundRectangle(g, getBounds(),
        		ColorConstants.darkGray, ColorConstants.lightGray);
	}
}
