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
package org.whole.lang.tests.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.tests.model.OutcomeEnum;
import org.whole.lang.ui.figures.AbstractEntityShapeFigure;
import org.whole.lang.ui.figures.FigureConstants;

/**
 * @author Enrico Persiani
 */
public class OutcomeFigure extends AbstractEntityShapeFigure {
	protected OutcomeEnum.Value outcome;

	public OutcomeFigure() {
		this(OutcomeEnum.SUCCESS);
	}
	public OutcomeFigure(OutcomeEnum.Value outcome) {
		update(outcome);
	}
	
	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		return new Dimension(10, 10);
	}

	protected Color getColor(boolean darker) {
		switch (outcome.getOrdinal()) {
		case OutcomeEnum.SUCCESS_ord:
			return darker ? ColorConstants.darkGreen : ColorConstants.green;
		case OutcomeEnum.FAILURE_ord:
			return darker ? FigureConstants.darkOrange : ColorConstants.orange;
		case OutcomeEnum.ERROR_ord:
			return darker ? FigureConstants.darkRed : ColorConstants.red;
		default:
			throw new IllegalArgumentException("unsupported outcome");
		}
	}

	public void update(OutcomeEnum.Value outcome) {
		this.outcome = outcome;

		setBackgroundColor(getColor(false));
		setForegroundColor(getColor(true));

		repaint();
	}

	@Override
	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.translate(getLocation());
		int width = getBounds().width;
		int height = getBounds().height;
		graphics.fillOval(0, 0, width, height);
		graphics.popState();
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		graphics.pushState();
		graphics.translate(getLocation());
		int width = getBounds().width;
		int height = getBounds().height;
		graphics.drawOval(0, 0, width-1, height-1);
		graphics.popState();
	}
}
