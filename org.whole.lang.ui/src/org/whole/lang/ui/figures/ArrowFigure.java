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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.figures.ArrowFactory.ArrowKind;
import org.whole.lang.ui.figures.ArrowFactory.Direction;
import org.whole.lang.ui.layout.AbstractEntityLayout;
import org.whole.lang.ui.util.IUIConstants;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Riccardo Solmi
 */
public class ArrowFigure extends EntityFigure {
	protected final Shape decorationLeft, decorationRight;
	protected final String colorName;

	public ArrowFigure(float autoresizeWeight, ArrowKind arrowLeft, ArrowKind arrowRight) {
		this(autoresizeWeight, arrowLeft, arrowRight, PreferenceConstants.CONTENT_CATEGORY, true);
	}

	public ArrowFigure(float autoresizeWeight, ArrowKind arrowLeft, ArrowKind arrowRight, String color, boolean filled) {
		this(autoresizeWeight,
				ArrowFactory.createArrow(Direction.WEST, arrowLeft, filled),
				ArrowFactory.createArrow(Direction.EAST, arrowRight, filled),				
				color);
	}

	public ArrowFigure(float autoresizeWeight, Shape decorationLeft, Shape decorationRight, String colorName) {
		super(new ArrowLayout().withAutoresizeWeight(autoresizeWeight));
		this.decorationLeft = decorationLeft;
		this.decorationRight = decorationRight;
		this.colorName = colorName;
	}

	public Color getLocalForegroundColor() {
		return UIUtils.createColor(IUIConstants.BUNDLE_ID, colorName);
	}
	public Color getLocalBackgroundColor() {
		return UIUtils.createColor(IUIConstants.BUNDLE_ID, colorName);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
        Rectangle bounds = getBounds();

    	decorationLeft.setLocation(bounds.getLeft().getTranslated(0,-1));
    	decorationLeft.paint(g);
    	
    	//FIXME endpoints
    	g.drawLine(bounds.x+6, bounds.getCenter().y-1, bounds.right()-6-1, bounds.getCenter().y-1);
    	
    	decorationRight.setLocation(bounds.getRight().getTranslated(-1,-1));
    	decorationRight.paint(g);
	}

	public static class ArrowLayout extends AbstractEntityLayout {
		protected void setAscentDescentWidth(int wHint, int hHint) {
			figAscent = 4;
			figDescent = 6;
			figWidth = 16;
		}
	
		protected void setLocation(Rectangle area, int[] x, int[] y) {
		}
	}
}
