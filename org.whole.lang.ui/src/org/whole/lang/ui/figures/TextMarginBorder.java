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
package org.whole.lang.ui.figures;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;

/**
 * @author Enrico Persiani
 */
public class TextMarginBorder extends AbstractBorder {
	private static final Insets EMPTY = new Insets();
	private static final Insets NON_EMPTY = new Insets(0,3,0,3);

	public static final Border instance = new TextMarginBorder();

	protected TextMarginBorder() {
	}
	
	public Insets getInsets(IFigure figure) {
		return ((ITextFigure) figure).getText().length() > 0 ? EMPTY : NON_EMPTY;
	}

	public void paint(IFigure figure, Graphics graphics, Insets insets) {
	}
}
