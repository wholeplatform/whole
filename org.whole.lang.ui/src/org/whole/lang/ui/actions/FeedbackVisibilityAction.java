/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.actions;

import static org.whole.lang.ui.feedback.FeedbackBarConstants.BOTH;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.HORIZONTAL;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.HORIZONTAL_VISIBILITY;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.NONE;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.VERTICAL;
import static org.whole.lang.ui.feedback.FeedbackBarConstants.VERTICAL_VISIBILITY;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Enrico Persiani
 */
public class FeedbackVisibilityAction extends Action {
	protected GraphicalViewer viewer;
	protected boolean verticalVisible;
	protected boolean horizontalVisible;

	public FeedbackVisibilityAction(String text, String id, GraphicalViewer viewer, boolean verticalVisible, boolean horizontalVisible) {
		super(text, IAction.AS_RADIO_BUTTON);
		this.viewer = viewer;
		this.verticalVisible = verticalVisible;
		this.horizontalVisible = horizontalVisible;

		setChecked(verticalVisible == safeGetProperty(VERTICAL_VISIBILITY) &&
				horizontalVisible == safeGetProperty(HORIZONTAL_VISIBILITY));
		setId(id);
	}

	@Override
	public void run() {
		viewer.setProperty(VERTICAL_VISIBILITY, verticalVisible);
		viewer.setProperty(HORIZONTAL_VISIBILITY, horizontalVisible);
	}

	protected  boolean safeGetProperty(String propertyName) {
		return WholeGraphicalViewer.safeGetProperty(viewer, propertyName, Boolean.FALSE);
	}

	public static class Both extends FeedbackVisibilityAction {
		public Both(GraphicalViewer viewer) {
			super("Both", BOTH, viewer, true, true);
		}
	}
	public static class Vertical extends FeedbackVisibilityAction {
		public Vertical(GraphicalViewer viewer) {
			super("Vertical", VERTICAL, viewer, true, false);
		}
	}
	public static class Horizontal extends FeedbackVisibilityAction {
		public Horizontal(GraphicalViewer viewer) {
			super("Horizontal", HORIZONTAL, viewer, false, true);
		}
	}
	public static class None extends FeedbackVisibilityAction {
		public None(GraphicalViewer viewer) {
			super("None", NONE, viewer, false, false);
		}
	}
}
