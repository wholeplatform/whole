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
package org.whole.lang.ui.figures;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;

/**
 * @author Riccardo Solmi
 */
public class PlaceHolderBorder extends AbstractBorder {
	public static final Insets EMPTY_INSETS = new Insets();
	protected boolean isOptional;
	
	public static Border OPTIONAL = new PlaceHolderBorder(true);
	public static Border MANDATORY = new PlaceHolderBorder(false);
	
	protected PlaceHolderBorder(boolean isOptional) {
		this.isOptional = isOptional;
	}

	@Override
	public boolean isOpaque() {
		return true;
	}

	public Color getColor() {
		return isOptional ? FigureConstants.contentLightColor : FigureConstants.errorsColor;
	}

	public Insets getInsets(IFigure figure) {
    	return new Insets(2*insets());
    }
	protected int insets() {
		return isOptional ? 2 : 4;
	}

	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		int i = insets();
		tempRect.setBounds(figure.getBounds());
		tempRect.x += tempRect.width/2 -i;
		tempRect.y += tempRect.height/2 -i;
		tempRect.width = tempRect.height = i*2;

		graphics.setForegroundColor(getColor());
		graphics.drawRectangle(tempRect);
	}
}
