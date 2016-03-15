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

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class CompositePlaceHolderBorder extends PlaceHolderBorder {
	public static Border OPTIONAL_HORIZONTAL = new CompositePlaceHolderBorder(true) {
		public boolean isHorizontal(IFigure figure) {
			return true;
		}
	};
	public static Border OPTIONAL_VERTICAL = new CompositePlaceHolderBorder(true) {
		public boolean isHorizontal(IFigure figure) {
			return false;
		}
	};
	public static Border OPTIONAL_COMPOSITE = new CompositePlaceHolderBorder(true) {
		public boolean isHorizontal(IFigure figure) {
			return ((CompositeFigure) figure).isHorizontal();
		}
	};
	public static Border MANDATORY_HORIZONTAL = new CompositePlaceHolderBorder(false) {
		public boolean isHorizontal(IFigure figure) {
			return true;
		}
	};
	public static Border MANDATORY_VERTICAL = new CompositePlaceHolderBorder(false) {
		public boolean isHorizontal(IFigure figure) {
			return false;
		}
	};
	public static Border MANDATORY_COMPOSITE = new CompositePlaceHolderBorder(false) {
		public boolean isHorizontal(IFigure figure) {
			return ((CompositeFigure) figure).isHorizontal();
		}
	};

	protected CompositePlaceHolderBorder(boolean isOptional) {
		super(isOptional);
	}

	@Override
	public Insets getInsets(IFigure figure) {
		if (showBorder(figure))
			return super.getInsets(figure);
		else
			return EMPTY_INSETS;
	}
	
	public boolean isHorizontal(IFigure figure) {
		return false;
	}


	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		if (showBorder(figure)) {
			int i = insets();
			tempRect.setBounds(figure.getBounds());
			tempRect.x += tempRect.width/2 -i;
			tempRect.y += tempRect.height/2 -i;
			tempRect.width = tempRect.height = i*2;

			graphics.setForegroundColor(getColor());
			if (isHorizontal(figure)) {
				graphics.drawLine(tempRect.x, tempRect.y, tempRect.x+1, tempRect.y);
				graphics.drawLine(tempRect.x, tempRect.y, tempRect.x, tempRect.bottom());
				graphics.drawLine(tempRect.x, tempRect.bottom(), tempRect.x+1, tempRect.bottom());
	
				graphics.drawLine(tempRect.right(), tempRect.y, tempRect.right()-1, tempRect.y);
				graphics.drawLine(tempRect.right(), tempRect.y, tempRect.right(), tempRect.bottom());
				graphics.drawLine(tempRect.right(), tempRect.bottom(), tempRect.right()-1, tempRect.bottom());
			} else {
				graphics.drawLine(tempRect.x, tempRect.y, tempRect.x, tempRect.y+1);
				graphics.drawLine(tempRect.x, tempRect.y, tempRect.right(), tempRect.y);
				graphics.drawLine(tempRect.right(), tempRect.y, tempRect.right(), tempRect.y+1);
	
				graphics.drawLine(tempRect.x, tempRect.bottom(), tempRect.x, tempRect.bottom()-1);
				graphics.drawLine(tempRect.x, tempRect.bottom(), tempRect.right(), tempRect.bottom());
				graphics.drawLine(tempRect.right(), tempRect.bottom(), tempRect.right(), tempRect.bottom()-1);
			}
		}
	}

	protected boolean showBorder(IFigure figure) {
		int size = figure.getChildren().size();
		return size == 0 ||
				(size == 1 && figure.getLayoutManager() instanceof TableLayout && ((TableLayout) figure.getLayoutManager()).hasHeaderRow());
	}
}
