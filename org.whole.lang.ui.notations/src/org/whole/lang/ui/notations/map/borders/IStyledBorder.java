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
package org.whole.lang.ui.notations.map.borders;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;

/**
 * @author Riccardo Solmi
 */
public interface IStyledBorder extends Border {
	public void setStyle(IStyledBorder styledBorder);

	public Insets getInsets();
	public void setInsets(Insets insets);

	public Color getFillColor();
	public void setFillColor(Color color);
	public Color getFillColor2();
	public void setFillColor2(Color color);

	public FillGradient getFillGradient();
	public void setFillGradient(FillGradient gradient);

	public Color getLineColor();
	public void setLineColor(Color color);

	public int getLineStyle();
	public void setLineStyle(int style);

	public int getLineWidth();
	public void setLineWidth(int width);
}