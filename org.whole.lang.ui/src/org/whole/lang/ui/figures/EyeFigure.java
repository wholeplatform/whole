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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Enrico Persiani
 */
public class EyeFigure extends AbstractEntityShapeFigure {
	protected boolean closed;

	public EyeFigure() {
	}

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		return new Dimension(20, 14);
	}
	
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
		revalidate();
		repaint();
	}

	@Override
	protected void fillShape(Graphics graphics) {
		setForegroundColor(closed ? ColorConstants.lightGray : FigureConstants.contentLighterColor);
		Rectangle bounds = getBounds().getCopy().translate(1, 1);
		graphics.fillArc(bounds.setSize(18, 18), 30, 120);
		graphics.fillArc(bounds.translate(0, -8), 205, 130);
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		setBackgroundColor(closed ? ColorConstants.lightGray : FigureConstants.contentLighterColor);
		Rectangle bounds = getBounds().getCopy().translate(1, 1);
		graphics.drawArc(bounds.setSize(17, 17), 30, 120);
		graphics.drawArc(bounds.translate(0, -8), 205, 130);
		graphics.setForegroundColor(ColorConstants.white);
		graphics.setAlpha(200);
		graphics.setLineWidthFloat(1.5f);
		bounds = getBounds().getCopy().translate(6, 2).setSize(7, 7);
		graphics.drawOval(bounds);

	}
}
