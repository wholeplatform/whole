/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
	public static Border OPTIONAL = new CompositePlaceHolderBorder(true);
	public static Border MANDATORY = new CompositePlaceHolderBorder(false);
	
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

	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		if (showBorder(figure))
			super.paint(figure, graphics, insets);
	}

	protected boolean showBorder(IFigure figure) {
		int size = figure.getChildren().size();
		return size == 0 ||
				(size == 1 && figure.getLayoutManager() instanceof TableLayout && ((TableLayout) figure.getLayoutManager()).hasHeaderRow());
	}
}
