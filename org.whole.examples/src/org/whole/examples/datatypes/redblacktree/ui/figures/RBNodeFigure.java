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
package org.whole.examples.datatypes.redblacktree.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.BinaryTreeLayout;

/**
 * @author Riccardo Solmi
 */
public class RBNodeFigure extends NodeFigure {
	private boolean isBlack;

	public RBNodeFigure() {
		initContentPanes(3);

		setLayoutManager(new BinaryTreeLayout());
		add(createContentPane(0, new MarginBorder(4,6,4,6)));
		add(createContentPane(1));
		add(createContentPane(2));
	}

	public void setBlackColor(boolean value) {
		isBlack = value;
	}

	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createBottomMiddleAnchor(getContentPane(0)),
				AnchorFactory.createBottomMiddleAnchor(getContentPane(0))
		};
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopMiddleAnchor(getContentPane(0))
		};
	}

	protected void paintFigure(Graphics graphics) {
		Rectangle nodeBounds = getContentPane(0).getBounds();

		graphics.setBackgroundColor(isBlack ? ColorConstants.black : ColorConstants.red);
		graphics.fillOval(nodeBounds.x, nodeBounds.y, nodeBounds.width, nodeBounds.height);
		graphics.setForegroundColor(ColorConstants.black);
		graphics.drawOval(nodeBounds.x, nodeBounds.y, nodeBounds.width-1, nodeBounds.height-1);
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	protected void paintConnections(Graphics graphics) {
		graphics.setForegroundColor(ColorConstants.black);
		ConnectionAnchor[] srcAnchors = getSourceAnchors();
		for (int i = 0; i < srcAnchors.length; i++) {
			IFigure contentPane = getContentPane(i+1);
			IFigure targetFigure = (IFigure) contentPane.getChildren().get(0);
			Point sourceLocation = srcAnchors[i].getLocation(null);
			Point targetLocation = null;
			if (targetFigure instanceof INodeFigure)
				targetLocation = ((INodeFigure) targetFigure).getTargetAnchor(0).getLocation(null);
			else {
				targetLocation = targetFigure.getBounds().getTop();
				targetFigure.translateToAbsolute(targetLocation);
			}
			translateToRelative(targetLocation);
			translateToRelative(sourceLocation);
			
			graphics.drawLine(sourceLocation, targetLocation);
		}
	}
}
