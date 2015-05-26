/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.ui.handles.DisabledLabeledHandle;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class DisabledFeedbackEditPolicy extends AbstractEditPolicy {
	public static final String DISABLED_FEEDBACK_ROLE = "Disabled Feedback";
	
	public DisabledFeedbackEditPolicy() {
	}

	public void activate() {
		addSuspensionFeedbak();
	}

	public void deactivate() {
		removeSuspensionFeedback();
	}

	protected IFigure getLayer(Object layer) {
		return LayerManager.Helper.find(getHost()).getLayer(layer);
	}

	protected DisabledLabeledHandle handle;
	protected void addSuspensionFeedbak() {
		removeSuspensionFeedback();

		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		handle = new DisabledLabeledHandle("long running operation in progress...", (GraphicalEditPart) getHost());
		layer.add(handle);
	}
	protected void removeSuspensionFeedback() {
		if (handle == null)
			return;
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		layer.remove(handle);
		handle = null;
	}

	public static void markDisabled(boolean disabled, IEntityPartViewer viewer) {
		RootEditPart rootEditPart = viewer.getRootEditPart();

		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				if (disabled)
					rootEditPart.installEditPolicy(DisabledFeedbackEditPolicy.DISABLED_FEEDBACK_ROLE, new DisabledFeedbackEditPolicy());
				else
					rootEditPart.removeEditPolicy(DisabledFeedbackEditPolicy.DISABLED_FEEDBACK_ROLE);
			}
		});
	}
	public static boolean isDisabled(IEntityPartViewer viewer) {
		RootEditPart rootEditPart = viewer.getRootEditPart();
		return rootEditPart.getEditPolicy(DisabledFeedbackEditPolicy.DISABLED_FEEDBACK_ROLE) != null;
	}
}
