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

import org.eclipse.draw2d.AbstractBackground;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractStyledBorder extends AbstractBackground implements IStyledBorder {
	public static final Insets DEFAULT_INSETS = new Insets(1,4,1,4);
	private Insets insets = DEFAULT_INSETS;
	private Color fillColor = ColorConstants.white;
	private Color fillColor2;
	private FillGradient fillGradient = FillGradient.NONE;
	private Color lineColor = ColorConstants.black;
	private int lineStyle = SWT.LINE_SOLID;
	private int lineWidth = 1;

	protected AbstractStyledBorder() {
	}
	public AbstractStyledBorder(IStyledBorder styledBorder) {
		setStyle(styledBorder);
	}
	public AbstractStyledBorder(Color lineColor, int lineStyle, int lineWidth) {
		this.lineColor = lineColor;
		this.lineStyle = lineStyle;
		this.lineWidth = lineWidth;
	}

	public void setStyle(IStyledBorder styledBorder) {
		this.insets = styledBorder.getInsets();
		this.fillColor = styledBorder.getFillColor();
		this.fillColor2 = styledBorder.getFillColor2();
		this.fillGradient = styledBorder.getFillGradient();
		this.lineColor = styledBorder.getLineColor();
		this.lineStyle = styledBorder.getLineStyle();
		this.lineWidth = styledBorder.getLineWidth();
	}

	public boolean isOpaque() {
		return true;
	}

	public Insets getInsets(IFigure figure) {
		Insets insets = getInsets();
		int lw = getLineWidth();
		return new Insets(lw).add(insets);
	}
	public Insets getInsets() {
		return insets;
	}
	public void setInsets(Insets insets) {
		this.insets = insets;
	}
	public void setInsets(int i) {
		setInsets(new Insets(i));
	}

	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	public Color getFillColor2() {
		return fillColor2;
	}
	public void setFillColor2(Color fillColor) {
		this.fillColor2 = fillColor;
	}
	protected Color safeGetFillColor2() {
		return fillColor2 != null ? fillColor2 : getLineColor();
	}

	public FillGradient getFillGradient() {
		return fillGradient;
	}
	public void setFillGradient(FillGradient fillGradient) {
		this.fillGradient = fillGradient;
	}

	public Color getLineColor() {
		return lineColor;
	}
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public int getLineStyle() {
		return lineStyle;
	}
	public void setLineStyle(int lineStyle) {
		this.lineStyle = lineStyle;
	}

	public int getLineWidth() {
		return lineWidth;
	}
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}
}