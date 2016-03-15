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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.LocationRequest;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.layout.IEntityLayout;

public class WholeFlowHilightEditPolicy extends WholeHilightEditPolicy {
	private void clearHilightPosition() {
		if (getHost() instanceof IHilightable)
			((IHilightable) getHost()).setHilightPosition(-1);
	}

	private void updateHilightPosition(Request request) {
		if (getHost() instanceof IHilightable) {
			int index = toModelIndex(getFeedbackIndexFor(request));
			((IHilightable) getHost()).setHilightPosition(index);
		}
	}

	protected int toModelIndex(int index) {
		if (isModelChildrenReversed()) {
			if (index == -1)
				index = 0;
			else
				index = getHost().getChildren().size() -index;
		} else if (index == -1)
				index = getHost().getChildren().size();
		return index;
	}
	protected int getFeedbackIndexFor(Request request) {
		return FeedbackEditPolicyStrategy.instance.getFeedbackIndexFor(
				(GraphicalEditPart) getHost(),
				getLocationFromRequest(request),
				isHorizontal());
	}

	protected Point getLocationFromRequest(Request request) {
		if (request instanceof LocationRequest)
			return ((LocationRequest) request).getLocation();
		else
			return null;
	}

	protected boolean isHorizontal() {
		IFigure figure = ((GraphicalEditPart) getHost()).getContentPane();
		return ((IEntityLayout) figure.getLayoutManager()).isHorizontal();
	}

	protected boolean isModelChildrenReversed() {
		return ((IEntityPart) getHost()).isModelChildrenReversed();
	}

	public void showTargetFeedback(Request request) {
		if (!request.getType().equals(REQ_SELECTION))
			return;

		if (!((GraphicalEditPart) getHost()).getContentPane().isVisible())
			return;
		
		Point location = getLocationFromRequest(request);
		if (location == null)
			return;

		FeedbackEditPolicyStrategy.instance.updateTargetFeedback(
				(GraphicalEditPart) getHost(), location, isHorizontal(), getFeedbackFigure());

		updateHilightPosition(request);
	}

	private IFigure feedbackFigure;
	protected IFigure getFeedbackFigure() {
		if (feedbackFigure == null)
			addFeedback(
					feedbackFigure = FeedbackEditPolicyStrategy.instance.createFeedbackFigure());
		return feedbackFigure;
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if(!REQ_SELECTION.equals(request.getType()))
			return;

		if (feedbackFigure != null) {
			removeFeedback(feedbackFigure);
			feedbackFigure = null;
		}
	}
	
	@Override
	public void deactivate() {
		if (feedbackFigure != null)
			removeFeedback(feedbackFigure);
		
		clearHilightPosition();
		super.deactivate();
	}
}
