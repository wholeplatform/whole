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
package org.whole.lang.ui.editpolicies;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

/**
 * @author Riccardo Solmi
 */
public class FeedbackEditPolicyStrategy {
	public static FeedbackEditPolicyStrategy instance = new FeedbackEditPolicyStrategy();

	protected FeedbackEditPolicyStrategy() {
	}

	public IFigure createFeedbackFigure() {
		Polyline figure = new Polyline();
		figure.setLineWidth(2);
		figure.setForegroundColor(ColorConstants.gray);
		figure.addPoint(new Point(0, 0));
		figure.addPoint(new Point(10, 10));
		return figure;
	}

	public void updateTargetFeedback(GraphicalEditPart host, Point location, boolean isHorizontal, IFigure feedbackFigure) {
		Transposer transposer = new Transposer();
		transposer.setEnabled(!isHorizontal);
		
		Rectangle hostBounds = transposer.t(getAbsoluteBounds(host));
		Rectangle feedbackArea = new Rectangle();

		getFeedbackIndexFor(host, location, isHorizontal, feedbackArea);

		int x;
		if (feedbackArea.x == hostBounds.x) {
			if (feedbackArea.right() == hostBounds.right())
				x = feedbackArea.x + feedbackArea.width/2;
			else
				x = feedbackArea.right() - 2;
		} else if (feedbackArea.right() == hostBounds.right())
			x = feedbackArea.x + 2;
		else
			x = feedbackArea.x + feedbackArea.width/2;

		Point p1 = new Point(x, feedbackArea.y);
		p1 = transposer.t(p1);
		feedbackFigure.translateToRelative(p1);
		
		Point p2 = new Point(x, feedbackArea.bottom());
		p2 = transposer.t(p2);
		feedbackFigure.translateToRelative(p2);

		Polyline feedbackLine = (Polyline) feedbackFigure;
		feedbackLine.setPoint(p1, 0);
		feedbackLine.setPoint(p2, 1);
	}

	protected int getFeedbackIndexFor(EditPart host, Point location, boolean isHorizontal) {
		return getFeedbackIndexFor(host, location, isHorizontal, new Rectangle());
	}
	protected int getFeedbackIndexFor(EditPart host, Point location, boolean isHorizontal, Rectangle feedbackArea) {
		Transposer transposer = new Transposer();
		transposer.setEnabled (!isHorizontal);
		location = transposer.t(location);

		Rectangle hostBounds = transposer.t(getAbsoluteBounds((GraphicalEditPart) host));
		Rectangle prevBounds = Rectangle.SINGLETON;

		List<?> children = host.getChildren();
		if (children.isEmpty() || location == null) {
			feedbackArea.setBounds(hostBounds);
			return -1;
		}

		int candidate = -1;
		int i=0;
		int size=children.size();
		for (; i<size; i++) {
			IFigure figure = ((GraphicalEditPart) children.get(i)).getFigure();
			if (!figure.isVisible())
				continue;
			Rectangle childBounds = transposer.t(getAbsoluteBounds(figure));
			
			if (i == 0 || childBounds.x <= prevBounds.x) {
				if (i > 0 && location.y < feedbackArea.bottom())
					break;

				candidate = -1;

				prevBounds.setLocation(hostBounds.x, Integer.MIN_VALUE);
				prevBounds.setSize(0, 0);
				
				feedbackArea.setLocation(Integer.MIN_VALUE, Integer.MAX_VALUE);
				feedbackArea.setSize(0, 0);
			}

			feedbackArea.y = Math.min(feedbackArea.y, childBounds.y);
			feedbackArea.height += Math.max(0, childBounds.bottom() - feedbackArea.bottom());
			
			if (candidate == -1 && location.x <= childBounds.x + (childBounds.width / 2)) {
				candidate = i;
				
				feedbackArea.x = prevBounds.right();
				feedbackArea.width = Math.max(0, childBounds.x - feedbackArea.x);
			}

			prevBounds = childBounds;
		}
		
		if (candidate == -1) {
			if (i < size)
				candidate = i;

			feedbackArea.x = prevBounds.right();
			feedbackArea.width = Math.max(0, hostBounds.right() - feedbackArea.x);;
		}

		return candidate;
	}

	public static Rectangle getAbsoluteBounds(GraphicalEditPart ep) {
		return getAbsoluteBounds(ep.getFigure());
	}
	public static Rectangle getAbsoluteBounds(IFigure figure) {
		Rectangle bounds = figure.getBounds().getCopy();
		figure.translateToAbsolute(bounds);
		return bounds;
	}
}
