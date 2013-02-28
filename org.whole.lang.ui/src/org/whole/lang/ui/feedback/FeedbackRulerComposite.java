/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.feedback;

import static org.whole.lang.ui.feedback.FeedbackBarConstants.DEFAULT_FEEDBACK_THICKNESS;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.HORIZONTAL_MODEL;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.HORIZONTAL_THICKNESS;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.HORIZONTAL_VISIBILITY;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.VERTICAL_MODEL;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.VERTICAL_THICKNESS;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.VERTICAL_VISIBILITY;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gef.ui.rulers.RulerComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Enrico Persiani
 */
public class FeedbackRulerComposite extends RulerComposite {
	protected FigureCanvas canvas;
	protected WholeGraphicalViewer viewer;
	protected FeedbackLayoutScheduler feedbackLayoutScheduler;
	protected PropertyChangeListener propertyChangeListener;
	protected boolean horizontalFeedbackVisible, verticalFeedbackVisible;
	protected int horizontalMinThickness, verticalMinThickness;

	public FeedbackRulerComposite(Composite parent, int style) {
		super(parent, style);
		horizontalMinThickness = verticalMinThickness = DEFAULT_FEEDBACK_THICKNESS;
		feedbackLayoutScheduler = new FeedbackLayoutScheduler();
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				disposeResources();
			}
		});
	}

	@Override
	public void setGraphicalViewer(ScrollingGraphicalViewer viewer) {
		this.viewer = (WholeGraphicalViewer) viewer;
		this.canvas = (FigureCanvas) viewer.getControl();

		viewer.addPropertyChangeListener(propertyChangeListener = new FeedbackPropertyChangeListener());
		super.setGraphicalViewer(viewer);

		setFeedbackVisible(SWT.HORIZONTAL, safeGetProperty(HORIZONTAL_VISIBILITY, Boolean.FALSE));
		setFeedbackVisible(SWT.VERTICAL, safeGetProperty(VERTICAL_VISIBILITY, Boolean.FALSE));

		setFeedbackThickness(SWT.HORIZONTAL, safeGetProperty(HORIZONTAL_THICKNESS, DEFAULT_FEEDBACK_THICKNESS));
		setFeedbackThickness(SWT.VERTICAL, safeGetProperty(VERTICAL_THICKNESS, DEFAULT_FEEDBACK_THICKNESS));

		setFeedbackContents(SWT.HORIZONTAL, safeGetProperty(HORIZONTAL_MODEL, CommonsEntityFactory.instance.createResolver()));
		setFeedbackContents(SWT.VERTICAL, safeGetProperty(VERTICAL_MODEL, CommonsEntityFactory.instance.createResolver()));
	}

	protected void disposeResources() {
		if (viewer != null)
			viewer.removePropertyChangeListener(propertyChangeListener);
	}

	protected void setFeedbackVisible(int orientation, boolean visible) {
		switch (orientation) {
		case SWT.HORIZONTAL:
			getHorizontalFeedbackViewer().getControl().setVisible(horizontalFeedbackVisible = visible);
			break;
		case SWT.VERTICAL:
			getVerticalFeedbackViewer().getControl().setVisible(verticalFeedbackVisible = visible);
			break;
		}
		layout(true);
	}
	protected void setFeedbackContents(int orientation, IEntity model) {
		switch (orientation) {
		case SWT.HORIZONTAL:
			getHorizontalFeedbackViewer().setContents(model);
			break;
		case SWT.VERTICAL:
			getVerticalFeedbackViewer().setContents(model);
			break;
		}
		layout(true);
	}
	protected void setFeedbackThickness(int orientation, int minThickness) {
		switch (orientation) {
		case SWT.HORIZONTAL:
			horizontalMinThickness = minThickness;
			break;
		case SWT.VERTICAL:
			verticalMinThickness = minThickness;
			break;
		}
		layout(true);
	}

	protected int getHorizontalFeedbackThickness() {
		return Math.max(horizontalMinThickness, getHorizontalFeedbackViewer().getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
	}
	protected int getVerticalFeedbackThickness() {
		return Math.max(verticalMinThickness, getVerticalFeedbackViewer().getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
	}

	protected WholeGraphicalViewer createRulerContainer(int orientation) {
		IEntity model = CommonsEntityFactory.instance.createResolver();

		WholeGraphicalViewer viewer = new WholeGraphicalViewer(this, model);

		FigureCanvas canvas = (FigureCanvas) viewer.getControl();
		canvas.setScrollBarVisibility(FigureCanvas.NEVER);

		Viewport viewport = canvas.getViewport();
		PropertyChangeListener listener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				layout(true);
			}
		};

		switch (orientation) {
		case SWT.HORIZONTAL:
			viewport.setContentsTracksWidth(true);
			//FIXME the range model is not updated when the root figure is shrinked
			viewport.getVerticalRangeModel().addPropertyChangeListener(listener);
			break;
		case SWT.VERTICAL:
			viewport.setContentsTracksHeight(true);
			//FIXME the range model is not updated when the root figure is shrinked
			viewport.getHorizontalRangeModel().addPropertyChangeListener(listener);
			break;
		}
		return viewer;
	}

	private WholeGraphicalViewer horizontalFeedbackViewer;
	protected WholeGraphicalViewer getHorizontalFeedbackViewer() {
		if (horizontalFeedbackViewer == null)
			horizontalFeedbackViewer = createRulerContainer(SWT.HORIZONTAL);
		return horizontalFeedbackViewer;
	}
	private WholeGraphicalViewer verticalFeedbackViewer;
	protected WholeGraphicalViewer getVerticalFeedbackViewer() {
		if (verticalFeedbackViewer == null)
			verticalFeedbackViewer = createRulerContainer(SWT.VERTICAL);
		return verticalFeedbackViewer;
	}

	protected boolean isFeedbackVisible() {
		return verticalFeedbackVisible || horizontalFeedbackVisible;
	}

	protected void layoutFeedbacks() {
		Rectangle controlBounds = getClientArea();

		if (horizontalFeedbackVisible) {
			getHorizontalFeedbackViewer().getControl().setBounds(controlBounds.x, controlBounds.y + controlBounds.height,
					controlBounds.width, getHorizontalFeedbackThickness());
		}
		if (verticalFeedbackVisible) {
			getVerticalFeedbackViewer().getControl().setBounds(controlBounds.x + controlBounds.width, controlBounds.y,
					getVerticalFeedbackThickness(), controlBounds.height);
		}
	}

	@Override
	public void layout(boolean change) {
		super.layout(change);
		if (isFeedbackVisible() && canvas != null)
			feedbackLayoutScheduler.schedule();
	}

	@Override
	public Rectangle getClientArea() {
		Rectangle clientArea = super.getClientArea();
		
		if (verticalFeedbackVisible)
			clientArea.width -= getVerticalFeedbackThickness();

		if (horizontalFeedbackVisible)
			clientArea.height -= getHorizontalFeedbackThickness();

		return clientArea;
	}

	protected final <T> T safeGetProperty(String propertyName, T defaultValue) {
		return WholeGraphicalViewer.safeGetProperty(viewer, propertyName, defaultValue);
	}

	protected class FeedbackPropertyChangeListener implements PropertyChangeListener {
		public void propertyChange(PropertyChangeEvent event) {
			String propertyName = event.getPropertyName();

			if (VERTICAL_VISIBILITY.equals(propertyName))
				setFeedbackVisible(SWT.VERTICAL, safeGetProperty(VERTICAL_VISIBILITY, Boolean.FALSE));
			else if (HORIZONTAL_VISIBILITY.equals(propertyName))
				setFeedbackVisible(SWT.HORIZONTAL, safeGetProperty(HORIZONTAL_VISIBILITY, Boolean.FALSE));
			else if (VERTICAL_MODEL.equals(propertyName))
				setFeedbackContents(SWT.VERTICAL, safeGetProperty(VERTICAL_MODEL, NullEntity.instance));
			else if (HORIZONTAL_MODEL.equals(propertyName))
				setFeedbackContents(SWT.HORIZONTAL, safeGetProperty(HORIZONTAL_MODEL, NullEntity.instance));
			else if (VERTICAL_THICKNESS.equals(propertyName))
				setFeedbackThickness(SWT.VERTICAL, safeGetProperty(VERTICAL_THICKNESS, DEFAULT_FEEDBACK_THICKNESS));
			else if (HORIZONTAL_THICKNESS.equals(propertyName))
				setFeedbackThickness(SWT.HORIZONTAL, safeGetProperty(HORIZONTAL_THICKNESS, DEFAULT_FEEDBACK_THICKNESS));
		}
	}
	protected class FeedbackLayoutScheduler implements Runnable {
		protected boolean layoutFeedbackScheduled = false;
		
		public synchronized void schedule() {
			if (!layoutFeedbackScheduled) {
				layoutFeedbackScheduled = true;
				Display.getCurrent().asyncExec(this);
			}
		}
		public void run() {
			layoutFeedbacks();
			layoutFeedbackScheduled = false;
		}
	}
}
