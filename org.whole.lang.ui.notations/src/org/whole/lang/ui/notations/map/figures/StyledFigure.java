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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.notations.map.borders.FillGradient;
import org.whole.lang.ui.notations.map.borders.IStyledBorder;
import org.whole.lang.ui.notations.map.borders.RoundRectangleStyledBorder;
import org.whole.lang.ui.notations.map.layouts.IStyledLayout;
import org.whole.lang.ui.notations.map.layouts.OutlineDownRightLayout;

/**
 * @author Riccardo Solmi
 */
public class StyledFigure extends AbstractStyledFigure {
	public StyledFigure() {
		this(new OutlineDownRightLayout());
	}
	public StyledFigure(IStyledLayout layout) {
		super(layout);
		getShapeFigure().setBorder(createShape());
	}

	protected IStyledBorder createShape() {
		return new RoundRectangleStyledBorder();
	}
	public IStyledBorder getShape() {
		return (IStyledBorder) getShapeFigure().getBorder();
	}
	public void setShape(IStyledBorder shape) {
		IFigure shapeFigure = getShapeFigure();
		shape.setStyle((IStyledBorder) shapeFigure.getBorder());
		shapeFigure.setBorder(shape);
		invalidateTargetAnchors();
		invalidateTree();
		revalidate();
		repaint();
	}

	public void setShapeInsets(Insets insets) {
		getShape().setInsets(insets);
		invalidateTree();
		revalidate();
		repaint();
	}
	public void setShapeFillColor(Color color) {
		getShape().setFillColor(color);
		revalidate();
		repaint();
	}
	public void setShapeFillColor2(Color color) {
		getShape().setFillColor2(color);
		revalidate();
		repaint();
	}
	public void setShapeFillGradient(FillGradient gradient) {
		getShape().setFillGradient(gradient);
		revalidate();
		repaint();
	}
	public void setShapeColor(Color color) {
		getShape().setLineColor(color);
		revalidate();
		repaint();
	}
	public void setShapeStyle(int style) {
		getShape().setLineStyle(style);
		revalidate();
		repaint();
	}
	public void setShapeWidth(int width) {
		getShape().setLineWidth(width);
		invalidateTree();
		revalidate();
		repaint();
	}
}
