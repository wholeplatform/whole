/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.ui.handles.LabeledHandle;

/**
 * @author Enrico Persiani
 */
public class TextFeedbackEditPolicy extends AbstractEditPolicy {
	public static final String TEXT_FEEDBACK_ROLE = "Text Feedback";
	public static final int DEFAULT_DELAY = 3000;

	protected String text;
	protected int delay;
	protected Color color;
	
	public TextFeedbackEditPolicy(String text) {
		this(text, DEFAULT_DELAY);
	}
	public TextFeedbackEditPolicy(String text, int delay) {
		this(text, delay, ColorConstants.black);
	}
	public TextFeedbackEditPolicy(String text, int delay, Color color) {
		this.text = text;
		this.delay = delay;
		this.color = color;
	}

	public void activate() {
		addTextFeedbak();
	}

	public void deactivate() {
		removeTextFeedback();
	}

	protected IFigure getLayer(Object layer) {
		return LayerManager.Helper.find(getHost()).getLayer(layer);
	}

	protected LabeledHandle handle;
	protected void addTextFeedbak() {
		IFigure layer = getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
		GraphicalEditPart hostPart = (GraphicalEditPart) getHost();
		handle = new LabeledHandle(text, hostPart);
		layer.add(handle);
		Display.getCurrent().timerExec(delay, () -> hostPart.removeEditPolicy(TEXT_FEEDBACK_ROLE));
	}
	protected void removeTextFeedback() {
		if (handle == null)
			return;
		IFigure layer = getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
		layer.remove(handle);
		handle = null;
	}
}
