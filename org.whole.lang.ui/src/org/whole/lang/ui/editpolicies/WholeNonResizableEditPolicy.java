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
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.figures.FigureConstants;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeNonResizableEditPolicy extends NonResizableEditPolicy {

	@Override
	protected List<?> createSelectionHandles() {
		final GraphicalEditPart host = (GraphicalEditPart) getHost();
		final DragTracker tracker = new SelectEditPartTracker(host);
		final Cursor cursor = SharedCursors.ARROW;

		final MoveHandle moveHandle = new MoveHandle(host) {
			@Override
			protected void initialize() {
				setOpaque(false);
				setBorder(new LineBorder(ColorConstants.gray, 1));
				setCursor(cursor);
				setDragTracker(tracker);
			}
		};

	 	final List<Handle> handles = new ArrayList<Handle>(5);
	 	handles.add(moveHandle);
	 	if (isDragAllowed()) {
			handles.add(createHandle(host, PositionConstants.SOUTH_EAST, tracker, cursor));
			handles.add(createHandle(host, PositionConstants.SOUTH_WEST, tracker, cursor));
			handles.add(createHandle(host, PositionConstants.NORTH_WEST, tracker, cursor));
			handles.add(createHandle(host, PositionConstants.NORTH_EAST, tracker, cursor));	 		
	 	}
		return handles;
	}

	public Handle createHandle(GraphicalEditPart owner, int direction, DragTracker tracker, Cursor cursor) {
		ResizeHandle handle = new ResizeHandle(owner, direction) {
			protected Color getBorderColor() {
				return ColorConstants.black;
			}
			protected Color getFillColor() {
				return (isPrimary())
					? FigureConstants.lightBlueColor
					: ColorConstants.white;
			}
			public void paintFigure(Graphics g) {
				Rectangle r = getBounds();
				r.shrink(1, 1);
				try {
					g.setBackgroundColor(getFillColor());
					g.fillOval(r.x, r.y, r.width, r.height);
					g.setForegroundColor(getBorderColor()); 
					g.drawOval(r.x, r.y, r.width, r.height);
				} finally {
					r.expand(1, 1);
				}
			}

		};
		handle.setCursor(cursor);
		handle.setDragTracker(tracker);
		return handle;
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

	public static class FeedbackImageFigure extends ImageFigure {
		public static final Dimension DIMENSION = new Dimension(500, 500);
		public static final int ALPHA = 160;

		protected int ix, iy;

		public FeedbackImageFigure(Image image) {
			super(image);
		}

		public void setImageLocation(int x, int y) {
			ix = x;
			iy = y;
		}

		@Override
		protected void paintFigure(Graphics graphics) {
			Rectangle area = getClientArea();
			graphics.drawImage(getImage(), area.x + ix, area.y + iy);
		}
	}
	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		IFigure figure = new FeedbackImageFigure(createFeedbackImage((IGraphicalEntityPart) getHost(), FeedbackImageFigure.ALPHA, true, FitToScreenStrategy.instance()));
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
	
	public static Image createFeedbackImage(IGraphicalEntityPart part, int alpha, boolean withBorder, IConstraintDimensionStrategy strategy) {
		IFigure figure = part.getFigure();
		Rectangle figureBounds = figure.getBounds();
		Control figureCanvas = part.getViewer().getControl();				
		double scale = ((ScalableRootEditPart) part.getViewer().getRootEditPart()).getZoomManager().getZoom();

		// calculate feedback maximum dimension
		Dimension dimension = strategy.constraintDimensions(new Dimension((int) Math.round(figureBounds.width*scale),
				(int) Math.round(figureBounds.height*scale)));

		if (dimension == null)
			return null;

		Image img = new Image(null, dimension.width, dimension.height);
		img.setBackground(ColorConstants.white);
		GC imageGC = new GC(img);

		Graphics imgGraphics = new SWTGraphics(imageGC);
		imgGraphics.scale(scale);
		imgGraphics.translate(-figureBounds.x, -figureBounds.y);
		figure.paint(imgGraphics);

		// draw dashed border
		if (withBorder) {
			imgGraphics.translate(figureBounds.x, figureBounds.y);
			imgGraphics.scale(1.0/scale);
			imgGraphics.setForegroundColor(ColorConstants.white);
			imgGraphics.drawRectangle(0, 0, dimension.width-1, dimension.height-1);
			imgGraphics.setLineStyle(SWT.LINE_DASH);
			imgGraphics.setLineDash(new int[] {4,3});
			imgGraphics.setForegroundColor(ColorConstants.black);
			imgGraphics.drawRectangle(0, 0, dimension.width-1, dimension.height-1);
		}

		ImageData data = img.getImageData();

		// alpha only
		for (int x=0 ; x<data.width; x++)
			for (int y=0 ; y<data.height; y++)
				data.setAlpha(x, y, alpha);

		Image feedbackImage = new Image(figureCanvas.getDisplay(), data);

		imageGC.dispose();
		img.dispose();

		return feedbackImage;
	}

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		final FeedbackImageFigure feedback = (FeedbackImageFigure) getDragSourceFeedbackFigure();
		
		final PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
//		rect.resize(request.getSizeDelta());

		FigureCanvas figureCanvas = (FigureCanvas) getHost().getViewer().getControl();
		Rectangle viewportArea = figureCanvas.getViewport().getBounds();
		
		int dx = Math.min(rect.x - viewportArea.x, 0);
		int dy = Math.min(rect.y - viewportArea.y, 0);
		rect.intersect(viewportArea);

		feedback.setImageLocation(dx, dy);

		feedback.translateToRelative(rect);

		Display.getCurrent().asyncExec(new Runnable() {
			public void run() {
				feedback.setBounds(rect);
			}
		});
	}
}
