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
package org.whole.lang.semantics.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class FunctionApplicationFigure extends ContentPaneFigure {
	protected EntityFigure lf, rf;
	protected boolean asStageDown;

	public FunctionApplicationFigure() {
		super(new RowLayout().withSpacing(2).withMargin(2));
		initContentPanes(4);

		lf = new EntityFigure(
				new OverColumnLayout().withMinorAlignment(Alignment.TRAILING).withSpacing(2));
		lf.add(createContentPane(1));
		lf.add(createContentPane(0));
		add(lf);

		rf = new EntityFigure(new RowLayout().withSpacing(16).withMarginLeft(6).withMarginRight(6));
		rf.add(createContentPane(2));
		rf.add(createContentPane(3));
		add(rf);
	}

	public void showNameAndStage(boolean nameValue, boolean stageValue) {
		lf.setVisible(nameValue | stageValue);
		getContentPane(0).setVisible(nameValue | stageValue);
		getContentPane(1).setVisible(stageValue);
	}
	public void showEnvironments(final boolean value) {
		getContentPane(3).setVisible(value);
	}
	
	public void showAsStageDown(boolean value) {
		if (asStageDown != value) {
			asStageDown = value;
			repaint();
		}
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		if (asStageDown) {
			Rectangle b = getBounds();

			g.setBackgroundColor(FigureConstants.hostLanguageColor);
			g.setForegroundColor(ColorConstants.lightGray);
			g.fillRectangle(b.x, b.y, b.width, b.height);
			g.drawRectangle(b.x, b.y, b.width-1, b.height-1);
		}

		Rectangle lfb = lf.getBounds();
		Rectangle rfb = rf.getBounds();
		int yTop = lf.isVisible() ? Math.min(lfb.y, rfb.y) : rfb.y;
		int yBottom = lf.isVisible() ? Math.max(lfb.bottom(), rfb.bottom()) - 1 : rfb.bottom() - 1;
		int xRight = rfb.right() - 1;
		
		g.setForegroundColor(ColorConstants.black);
		int hsize = 5;
		if (rfb.height > 100) {
			g.setLineWidth(3);
			hsize += 3;
		}

		g.drawLine(rfb.x, yTop, rfb.x+hsize, yTop);
		g.drawLine(rfb.x, yTop, rfb.x, yBottom);
		g.drawLine(rfb.x, yBottom, rfb.x+hsize, yBottom);

		g.drawLine(xRight-hsize, yTop, xRight, yTop);
		g.drawLine(xRight, yTop, xRight, yBottom);
		g.drawLine(xRight-hsize, yBottom, xRight, yBottom);

		int lgap = 2;
		int rgap = 2;
		if (rfb.height > 100) {
			g.setLineWidth(2);
			lgap += 2;
			rgap += 1;
		}

		g.drawLine(rfb.x+lgap, yTop, rfb.x+lgap, yBottom);

		g.drawLine(xRight-rgap, yTop, xRight-rgap, yBottom);
	}
}
