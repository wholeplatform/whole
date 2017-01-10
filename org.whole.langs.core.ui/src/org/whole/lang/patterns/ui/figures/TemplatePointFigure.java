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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class TemplatePointFigure extends ContentPaneFigure {
	public static final int CONTENT_MARGIN = 4;
	public TemplatePointFigure() {
		initContentPanes(1);
		setLayoutManager(new MonoLayout());

		add(createContentPane(0, new MarginBorder(
				CONTENT_MARGIN+2, CONTENT_MARGIN, CONTENT_MARGIN, CONTENT_MARGIN)));
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		int oldAlpha = g.getAlpha();
		g.setAlpha(FigureConstants.templateLanguageAlpha);

		Rectangle cb = getBounds();
		g.setBackgroundColor(FigureConstants.templateLanguageColor);
		g.setForegroundColor(ColorConstants.lightGray);

		g.fillRectangle(cb);
		g.setAlpha(oldAlpha);
		g.drawRectangle(cb.getResized(-1, -1));

//		g.setBackgroundColor(ColorConstants.lightGray);
//		final int SZ = CONTENT_MARGIN*2-1;
//		g.setLineWidth(3);
//		g.drawLine(cb.x, cb.y+1, cb.right(), cb.y+1);
//		g.fillPolygon(new int[] {cb.x, cb.y+2, cb.x+SZ, cb.y+2, cb.x, cb.y+2+SZ});
//		g.fillPolygon(new int[] {cb.right()-SZ, cb.y+2, cb.right(), cb.y+2, cb.right(), cb.y+2+SZ});
	}

	public ITabularLayoutClient getTabularLayoutClient() {
		return ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}
}
