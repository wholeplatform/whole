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
package org.whole.lang.ui.notations.flowchart.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class EndEventFigure extends NodeFigure {
	public EndEventFigure(Image eventImage) {
		setLayoutManager(new MonoLayout().withMargin(5).withMinorAlignment(Alignment.CENTER).withMajorAlignment(Alignment.CENTER));
		addLabel(eventImage);
	}
	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createEllipseAnchor(this)};
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        Rectangle bounds = getBounds();

        int size = 27-1;
		int delta = 1;
        g.setLineWidth(4);
        g.setForegroundColor(ColorConstants.lightGray);
		g.drawOval(bounds.x+delta, bounds.y+delta, size-delta*2, size-delta*2);
	}
}
