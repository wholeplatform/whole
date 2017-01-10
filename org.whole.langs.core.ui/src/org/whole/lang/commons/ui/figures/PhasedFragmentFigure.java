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
package org.whole.lang.commons.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ITabularLayoutClient;

/**
 * @author Riccardo Solmi
 */
public class PhasedFragmentFigure extends ContentPaneFigure {
	public static final int CONTENT_MARGIN = 4;
	private int stage;

	public PhasedFragmentFigure(int stage) {
		initContentPanes(2);
		setStage(stage);

		setLayoutManager(new ColumnLayout() {
			@Override
			protected int getAscent(int height) {
				return childFigure[0].isVisible() ? childSize[0].height + getSpacingBefore(1) + ascent(1) : ascent(1);
			}
		});

		add(createContentPane(1, new MarginBorder(1,4,2,4)));
		add(createContentPane(0, new MarginBorder(CONTENT_MARGIN)));
	}

	protected Color getFragmentColor() {
		return getStage() == +1 ? FigureConstants.templateLanguageColor : FigureConstants.hostLanguageColor;
	}

	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}

	public void showPhase(boolean value) {
		getContentPane(1).setVisible(value);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		Rectangle b = getBounds();
		Rectangle cb;
		if (getContentPane(1).isVisible()) {
			Rectangle tb = getContentPane(1).getBounds();
			g.setForegroundColor(ColorConstants.lightGray);
			g.drawRectangle(tb.getResized(-1, -1));
			
			cb = b.getResized(0, -tb.height+1).translate(0, tb.height-1);
		} else
			cb = b.getCopy();

		int oldAlpha = g.getAlpha();
		if (getStage() > 0)
			g.setAlpha(FigureConstants.templateLanguageAlpha);
		else if (getStage() == 0)
			g.setAlpha(FigureConstants.hostLanguageAlpha);

		g.setBackgroundColor(getFragmentColor());
		g.setForegroundColor(ColorConstants.lightGray);
		g.fillRectangle(cb);
		g.setAlpha(oldAlpha);
		g.drawRectangle(cb.resize(-1, -1));
	}

	public ITabularLayoutClient getTabularLayoutClient() {
		return ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}
}
