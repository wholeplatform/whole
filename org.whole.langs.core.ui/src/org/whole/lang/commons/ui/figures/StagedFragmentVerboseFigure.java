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
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ITabularLayoutClient;

/**
 * @author Riccardo Solmi
 */
public class StagedFragmentVerboseFigure extends ContentPaneFigure {
	public static final int CONTENT_MARGIN = 4;
	private EntityLabel label;
	private int stage;

	public StagedFragmentVerboseFigure(int stage) {
		initContentPanes(1);
		setStage(stage);

		if (stage == +1) {
			setLayoutManager(new ColumnLayout() {
				@Override
				protected int getAscent(int height) {
					return childFigure[1].isVisible() ? childSize[0].height + getSpacingBefore(1) + childSize[1].height/2 : super.getAscent(height);
				}
			});
		} else {
			setLayoutManager(new ColumnLayout() {
				@Override
				protected int getAscent(int height) {
					return childFigure[1].isVisible() ? childSize[0].height + getSpacingBefore(1) + ascent(1) : super.getAscent(height);
				}
			});			
		}
		
		add(label = LabelFactory.createModule());
		label.setBorder(new MarginBorder(1,4,2,4));
		
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

	public String getText() {
		return label.getText();
	}
	public void setText(String text) {
		label.setText(text);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		Rectangle tb = label.getBounds();
		g.setForegroundColor(ColorConstants.lightGray);
		g.drawRectangle(tb.getResized(-1, -1));

		if (getContentPane(0).isVisible()) {
			int oldAlpha = g.getAlpha();
			if (getStage() > 0)
				g.setAlpha(FigureConstants.templateLanguageAlpha);
			else if (getStage() == 0)
				g.setAlpha(FigureConstants.hostLanguageAlpha);

			Rectangle b = getBounds();
			g.setBackgroundColor(getFragmentColor());
			g.setForegroundColor(ColorConstants.lightGray);
			
			Rectangle cb = b.getResized(0, -tb.height).translate(0, tb.height-1);

			g.fillRectangle(cb);
			g.setAlpha(oldAlpha);
			g.drawRectangle(cb.resize(-1, -1));
			
			g.setBackgroundColor(ColorConstants.lightGray);
			final int SZ = CONTENT_MARGIN*2-1;
			if (getStage() >= 0) {
				g.fillPolygon(new int[] {cb.x, cb.y, cb.x+SZ, cb.y, cb.x, cb.y+SZ});
				g.fillPolygon(new int[] {cb.right()-SZ, cb.y, cb.right(), cb.y, cb.right(), cb.y+SZ});
			}
			if (getStage() <= 0) {
				g.fillPolygon(new int[] {cb.x, cb.bottom()-SZ, cb.x+SZ, cb.bottom(), cb.x, cb.bottom()});
				g.fillPolygon(new int[] {cb.right(), cb.bottom()-SZ, cb.right(), cb.bottom(), cb.right()-SZ, cb.bottom()});
			}
		}
	}

	public ITabularLayoutClient getTabularLayoutClient() {
		return ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}
}
