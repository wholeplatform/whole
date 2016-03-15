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
package org.whole.lang.ui.notations.map.figures;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.notations.map.borders.FillGradient;
import org.whole.lang.ui.notations.map.borders.IStyledBorder;
import org.whole.lang.ui.notations.map.layouts.ILayoutManagerServer;

/**
 * @author Riccardo Solmi
 */
public interface IStyledFigure extends INodeFigure, ILayoutManagerServer {
	public IStyledBorder getShape();
	public void setShape(IStyledBorder shape);
	public void setShapeInsets(Insets insets);
	public void setShapeFillColor(Color color);
	public void setShapeFillColor2(Color color);
	public void setShapeFillGradient(FillGradient gradient);
	public void setShapeColor(Color color);
	public void setShapeStyle(int style);
	public void setShapeWidth(int width);

	public Font getTextFont();
	public void setTextFont(Font font);

	public Color getLineColor();
	public void setLineColor(Color color);
	public int getLineStyle();
	public void setLineStyle(int style);
	public int getLineWidth();
	public void setLineWidth(int width);
}
