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
package org.whole.lang.ui.notations.tree.figures;

import org.eclipse.draw2d.AbstractLabeledBorder;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.FigureConstants;

public class RoundedTitleTabBorder extends AbstractLabeledBorder {
	private static final int LINE_WIDTH = 1;
	public static final Insets NO_SHRINK = new Insets(0);
	public static enum Style {DASHED, SOLID, SOLID_BORDER};

	protected Insets shrink;
	protected Style style;
	protected Color borderColor;
	public static Color TAB_TEXT_COLOR = ColorConstants.black;
	public static Color BORDER_COLOR = FigureConstants.blueColor;

	public RoundedTitleTabBorder(String s) {
		this(s, NO_SHRINK, Style.SOLID);
	}
	public RoundedTitleTabBorder(String s, Insets shrink, Style style) {
		this(s, shrink, style, RoundedTitleTabBorder.TAB_TEXT_COLOR, RoundedTitleTabBorder.BORDER_COLOR);
	}	
	public RoundedTitleTabBorder(String s, Insets shrink, Style style, Color labelColor, Color borderColor) {
		super(s);
		setShrink(shrink);
		setTextColor(labelColor);
		setBorderColor(borderColor);
		setFont(FigureConstants.declarationsFont);
		this.style = style;
	}

	@Override
	protected Insets calculateInsets(IFigure figure) {
		Insets insets = new Insets(LINE_WIDTH);
		Dimension textExtents = getTextExtents(figure);
		insets.top += textExtents.height;
		return insets;
	}

	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		Dimension textExtents = getTextExtents(figure);
		int labelHeight = textExtents.height;
		int labelHalfHeight = labelHeight / 2 + 1;

		tempRect.setBounds(getPaintRectangle(figure, insets));
		tempRect.resize(-1, -labelHeight -1);
		tempRect.translate(getShrink().left, labelHeight + getShrink().top);
		tempRect.resize(-getShrink().left -getShrink().right, -getShrink().top -getShrink().bottom);
		graphics.setLineWidth(1);
		if (Style.DASHED.equals(style)) {
			graphics.setLineStyle(SWT.LINE_CUSTOM);
			graphics.setLineDash(new int[] {4,2});
		}
		if (getBorderColor() != null)
			graphics.setForegroundColor(getBorderColor());
		graphics.setBackgroundColor(ColorConstants.lightGray);

		int oldAlpha = graphics.getAlpha();
		if (Style.DASHED.equals(style))
			graphics.setAlpha(60);

		// part of the round border outside the tab
		int titleWidth = textExtents.width + labelHeight +1;
		Rectangle rect = tempRect.getResized(-titleWidth, 0);
		graphics.setClip(rect.translate(titleWidth, 0).expand(LINE_WIDTH, LINE_WIDTH));
		graphics.drawRoundRectangle(tempRect, 8, 8);
		
		// part of the round border under the tab
		rect = tempRect.getCopy();
		rect.width = titleWidth;
		rect.height = 8;
		graphics.setClip(rect);
		graphics.drawRectangle(tempRect);
		rect.height = tempRect.height-8;
		graphics.setClip(rect.translate(0, 8).expand(LINE_WIDTH, LINE_WIDTH));
		graphics.drawRoundRectangle(tempRect, 8, 8);

		if (Style.DASHED.equals(style)) {
			graphics.setLineStyle(SWT.LINE_SOLID);
			graphics.setLineDash((int[]) null);
		}

		// draw tab
		tempRect.setBounds(getPaintRectangle(figure, insets));
		tempRect.setSize(textExtents);
		tempRect.resize(labelHeight + getShrink().top, 1);//FIXME order ? 1,
		tempRect.translate(getShrink().left, 0);
		graphics.setForegroundColor(borderColor);
		graphics.setBackgroundColor(borderColor);
		graphics.setClip(tempRect);
		graphics.drawRoundRectangle(tempRect.getResized(-1,+4), 8, 8);
		int oldAlpha1 = graphics.getAlpha();
		graphics.setAlpha(60);
		graphics.fillRoundRectangle(tempRect.getResized(0,+4), 8, 8);
		graphics.setAlpha(oldAlpha1);

		// draw label
		graphics.setFont(getFont(figure));
		graphics.setForegroundColor(getTextColor());
		graphics.drawString(getLabel(), tempRect.x + labelHalfHeight, tempRect.y);

		if (Style.DASHED.equals(style))
			graphics.setAlpha(oldAlpha);
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Insets getShrink() {
		return shrink;
	}

	public void setShrink(Insets shrink) {
		this.shrink = shrink;
	}

	@Override
	public Dimension getPreferredSize(IFigure fig) {
		Dimension size = super.getPreferredSize(fig);
		size.width += size.height;
		return size;
	}
}
