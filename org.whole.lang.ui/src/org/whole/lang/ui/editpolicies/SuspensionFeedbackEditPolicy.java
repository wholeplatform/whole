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
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.whole.lang.operations.IDecorationManager.DecorationKind;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.handles.DebugHandle;
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

	protected DebugHandle handle;
	protected void addSuspensionFeedbak() {
		if (!suspensionKind.isSuspended())
			return;

		IGraphicalEntityPart hostPart = (IGraphicalEntityPart) getHost();

		IFigure layer = getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
		handle = new DebugHandle(hostPart, suspensionKind);
		layer.add(handle);

		switch (suspensionKind) {
		case BREAK:
			hostPart.addDecoration(DecorationKind.ASSIST, "Suspended on a breakpoint");
			break;

		case ERROR:
			hostPart.addDecoration(DecorationKind.ERROR, throwable.getLocalizedMessage());
			break;

		case RECOVERABLE_ERROR:
			hostPart.addDecoration(DecorationKind.WARNING, throwable.getLocalizedMessage());
			break;

		default:
			break;
		}
	}
	protected void removeSuspensionFeedback() {
		if (handle == null)
			return;
		IFigure layer = getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
		layer.remove(handle);
		handle = null;
	}
}
