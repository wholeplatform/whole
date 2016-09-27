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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.whole.lang.ui.handles.DebugLabeledHandle;
import org.whole.lang.ui.util.SuspensionKind;

/**
 * @author Enrico Persiani
 */
public class SuspensionFeedbackEditPolicy extends AbstractEditPolicy {
	public static final String SUSPENSION_FEEDBACK_ROLE = "Suspension Feedback";
	
	protected SuspensionKind suspensionKind;
	protected Throwable throwable;
	
	public SuspensionFeedbackEditPolicy(SuspensionKind suspensionKind, Throwable throwable) {
		this.suspensionKind = suspensionKind;
		this.throwable = throwable;
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

	protected DebugLabeledHandle handle;
	protected void addSuspensionFeedbak() {
		if (!suspensionKind.isSuspended())
			return;

		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		String message = throwable != null ? throwable.getLocalizedMessage() : suspensionKind.name().toLowerCase();
		handle = new DebugLabeledHandle(message, (GraphicalEditPart) getHost(), suspensionKind);
		layer.add(handle);
	}
	protected void removeSuspensionFeedback() {
		if (handle == null)
			return;
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		layer.remove(handle);
		handle = null;
		getHost().removeEditPolicy(SUSPENSION_FEEDBACK_ROLE);
	}
}
