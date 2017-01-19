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
package org.whole.lang.math.ui.figures;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ParenthesizedStringSeparatedCompositeRowFigure;

/**
 * @author Riccardo Solmi
 */
public class ParenthesizedMathCompositeRowFigure extends ParenthesizedStringSeparatedCompositeRowFigure {
	public ParenthesizedMathCompositeRowFigure(String separator) {
		this(separator, 15);
	}
	public ParenthesizedMathCompositeRowFigure(String separator, int spacing) {
		super(separator, spacing);
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.contentColor;
	}
	@Override
	protected Font getLocalFont() {
		return FigureConstants.symbolFontRegular;
	}
	@Override
	protected int getSeparatorAscent() {
		return super.getSeparatorAscent()+1;
	}
}
