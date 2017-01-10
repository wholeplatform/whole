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
package org.whole.lang.workflows.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class WorkflowFigure extends NodeFigure {
	public WorkflowFigure() {
		initContentPanes(3);
		setLayoutManager(new ColumnLayout()
				.withMinorAlignment(Alignment.CENTER).withSpacing(16));

		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2));
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.relationsColor;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);

		Rectangle startBounds = getContentPane(0).getBounds();
		Rectangle flowBounds = getContentPane(1).getBounds();
		Rectangle endBounds = getContentPane(2).getBounds();

		int xMid = flowBounds.x+flowBounds.width/2;
        graphics.drawLine(xMid, startBounds.y+startBounds.height, xMid, flowBounds.y);
        graphics.drawLine(xMid, flowBounds.y+flowBounds.height, xMid, endBounds.y);
	}
}
