/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.steppers.ui.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.steppers.ui.layouts.ChooseLayout;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;

/**
 *  @author Riccardo Solmi
 */
public class ChooseFigure extends NodeFigure {
    public ChooseFigure() {
        initContentPanes(2);
        setLayoutManager(new ChooseLayout());
        add(createContentPane(0));
        add(createContentPane(1));
    }

    @Override
    protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				new AbstractConnectionAnchor(this) {
					public Point getLocation(Point reference) {
						Point tp = getContentPaneTargetPoint(1, 0, (r) -> r.getTop());
						Point p = new Point(getContentPane(0).getBounds().x-2, tp.y);
				        getOwner().translateToAbsolute(p);
						return p;
					}
					public Point getReferencePoint() {
						return getLocation(null);
					}
				},
			};
    }

	@Override
	public void paintClientArea(Graphics g) {
		super.paintClientArea(g);
		paintConnections(g);
		g.restoreState();
	}

	protected void paintConnections(Graphics g) {
		g.setForegroundColor(FigureConstants.relationsColor);

		Point tp = getContentPaneTargetPoint(1, 0, (r) -> r.getTop());
        g.drawLine(getContentPane(0).getBounds().x-2, tp.y, tp.x, tp.y);
	}
}
