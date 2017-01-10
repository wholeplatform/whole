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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editpolicies.WholeNonResizableEditPolicy.FeedbackImageFigure;
import org.whole.lang.ui.figures.FigureConstants;

/**
 * @author Riccardo Solmi
 */
public class WholeResizableEditPolicy extends ResizableEditPolicy {
	protected List<?> createSelectionHandles() {
		final GraphicalEditPart host = (GraphicalEditPart) getHost();
		final int directions = getResizeDirections() != -1 ? getResizeDirections() :
				PositionConstants.EAST + PositionConstants.SOUTH +
				PositionConstants.WEST + PositionConstants.NORTH;

		final MoveHandle moveHandle = new MoveHandle(host) {
			@Override
			protected void initialize() {
				setOpaque(false);
				setBorder(new LineBorder(ColorConstants.gray, 1));
				setCursor(Cursors.SIZEALL);
			}

		};

		final List<Handle> handles = new ArrayList<Handle>(9);
	 	handles.add(moveHandle);
		handles.add(createHandle(host, PositionConstants.EAST,
					(directions & PositionConstants.EAST) != 0));
		handles.add(createHandle(host, PositionConstants.SOUTH_EAST,
				(directions & PositionConstants.SOUTH_EAST) != 0));
		handles.add(createHandle(host, PositionConstants.SOUTH,
				(directions & PositionConstants.SOUTH) != 0));
		handles.add(createHandle(host, PositionConstants.SOUTH_WEST,
				(directions & PositionConstants.SOUTH_WEST) != 0));
		handles.add(createHandle(host, PositionConstants.WEST,
				(directions & PositionConstants.WEST) != 0));
		handles.add(createHandle(host, PositionConstants.NORTH_WEST,
				(directions & PositionConstants.NORTH_WEST) != 0));
		handles.add(createHandle(host, PositionConstants.NORTH,
				(directions & PositionConstants.NORTH) != 0));
		handles.add(createHandle(host, PositionConstants.NORTH_EAST,
				(directions & PositionConstants.NORTH_EAST) != 0));
	 	return handles;
	}
	
	public Handle createHandle(GraphicalEditPart owner, int direction, final boolean isResizable) {
		return new ResizeHandle(owner, direction) {
			protected Color getBorderColor() {
				return (isResizable)
					? ColorConstants.black
					: ColorConstants.lightGray;
			}
			protected Color getFillColor() {
				return (isPrimary())
					? FigureConstants.lightBlueColor
					: ColorConstants.white;
			}

		};
	}

	protected IFigure targetFeedback;
	@Override
	public void showTargetFeedback(Request request) {
		if (request.getType().equals(RequestConstants.REQ_MOVE)	||
				request.getType().equals(RequestConstants.REQ_CLONE) ||
				request.getType().equals(RequestConstants.REQ_ADD))
		if (targetFeedback == null) {
			targetFeedback = new AbstractHandle(
					(GraphicalEditPart)getHost(),
					new Locator() {
						public void relocate(IFigure target) {
							IFigure figure = getHostFigure();
							Rectangle r;
							if (figure instanceof HandleBounds)
								r = ((HandleBounds)figure).getHandleBounds().getCopy();
							else
								r = getHostFigure().getBounds().getResized(-1, -1);
							getHostFigure().translateToAbsolute(r);
							target.translateToRelative(r);
							target.setBounds(r.expand(5, 5).resize(1, 1));
						}
					})
					{
						{
							setBorder(new LineBorder(ColorConstants.lightGray, 1));
						}
						protected DragTracker createDragTracker() {
							return null;
						}
					};
			addFeedback(targetFeedback);
		}
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if (targetFeedback != null)
			removeFeedback(targetFeedback);
		targetFeedback = null;
	}

	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		IFigure figure = new FeedbackImageFigure(WholeNonResizableEditPolicy.createFeedbackImage((IGraphicalEntityPart) getHost(), FeedbackImageFigure.ALPHA, true, FitToScreenStrategy.instance())) {
			@Override
			protected void paintFigure(Graphics graphics) {
				Rectangle area = getClientArea();
				org.eclipse.swt.graphics.Rectangle imageBounds = getImage().getBounds();
//				graphics.drawImage(getImage(), area.x + ix, area.y + iy);
				graphics.drawImage(getImage(),
						0,0, imageBounds.width, imageBounds.height,
						area.x , area.y,
						Math.max(0, area.width),
						Math.max(0, area.height));
			}

		};
		figure.setBounds(getInitialFeedbackBounds());
		addFeedback(figure);
		return figure;
	}
	@Override
	protected void removeFeedback(IFigure figure) {
		super.removeFeedback(figure);
		if (figure instanceof ImageFigure)
			((ImageFigure) figure).getImage().dispose();
	};
	
	protected IFigure getFeedbackLayer() {
		return getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
	}
	protected Rectangle getInitialFeedbackBounds() {
		return getHostFigure().getBounds();
	}
}
