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
package org.whole.lang.ui.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editpolicies.TextualDirectEditEditPolicy;
import org.whole.lang.ui.editpolicies.TextualHilightEditPolicy;
import org.whole.lang.ui.figures.ITextualFigure;
import org.whole.lang.ui.tools.TextualDragTracker;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.ui.util.CaretUtils;
import org.whole.lang.util.DataTypeUtils;

/**
 * NB apply changes also on AbstractTextualFreeformNodePart
 * 
 * @author Riccardo Solmi, Enrico Persiani
 */
public abstract class AbstractTextualEntityPart extends AbstractPart implements ITextualEntityPart {
	protected int selectionStart;
	protected int selectionEnd;

	public AbstractTextualEntityPart() {
		clearSelectionRange();
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new TextualHilightEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new TextualDirectEditEditPolicy(getCommandFactory()));
	}

	@Override
	public DragTracker getDragTracker(Request request) {
		EditPartViewer viewer = getViewer();
		return viewer != null && Tools.TEXTUAL.isActive(viewer) ? 
				new TextualDragTracker() : super.getDragTracker(request);
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent event) {
		refreshVisuals();
		int caretPositions = getCaretPositions();
		if (getCaretPosition() > caretPositions)
			CaretUtils.updateCaret(this, getViewer(), caretPositions, caretPositions, null, true);
	}
	@Override
	protected void refreshVisuals() {
		getTextualFigure().setText(DataTypeUtils.getAsPresentationString(getModelTextEntity()));
	}
	public IEntity getModelTextEntity() {
		return getModelEntity();
	}

	public void updateCaret(Point location) {
		getTextualFigure().updateCaret(location);
	}

	public ITextualFigure getTextualFigure() {
		return (ITextualFigure) getFigure();
	}

	public int getCaretPositions() {
		return getTextualFigure().getCaretPositions();
	}

	public int getCaretPosition() {
		return getTextualFigure().getCaretPosition();
	}

	public void setCaretPosition(int position) {
		getTextualFigure().setCaretPosition(position);
		getTextualFigure().revealCaret();
	}

	@Override
	public void setSelected(int value) {
		super.setSelected(value);
		if (value == SELECTED_NONE)
			clearSelectionRange();
	}
	public void clearSelectionRange() {
		setSelectionRange(-1, -1);
	}
	public void setSelectionRange(int start, int end) {
		this.selectionStart = start;
		this.selectionEnd = end;
		getTextualFigure().setSelectionRange(start, end);
	}
	public boolean hasSelectionRange() {
		return this.selectionStart != -1 && this.selectionEnd != this.selectionStart;
	}
	public int getSelectionStart() {
		return selectionStart;
	}
	public int getSelectionEnd() {
		return selectionEnd;
	}

	@Override
	protected void performDirectEdit(LocationRequest request) {
		if (Tools.TEXTUAL.ensureActive(getViewer())) {
			setCaretVisible(true);
			getViewer().deselectAll();
			Point location = request.getLocation();
			if (location != null)
				CaretUtils.updateCaret(this, getViewer(), -1, -1, location, true);
			else
				CaretUtils.updateCaret(this, getViewer(), 0, getCaretPositions(), location, true);

			getDragTracker(request).mouseDoubleClick(createDoubleClickEvent(request), getViewer());
		}
	}

	private MouseEvent createDoubleClickEvent(LocationRequest request) {
		Point location = request.getLocation();
		location = location != null ? new Point(location) : new Point();
		Event event = new Event();
		event.widget = getViewer().getControl();
		event.display = event.widget.getDisplay();
		event.button = 1;
		event.x = location.x;
		event.y = location.y;
		event.stateMask = SWT.NONE;
		event.doit = true;
		return new MouseEvent(event);
	}

	public void setCaretVisible(boolean visible) {
		if (visible) {
			getTextualFigure().activateCaret(CaretUtils.getCaret(getViewer()));
			setCaretPosition(getCaretPosition());
		} else
			getTextualFigure().deactivateCaret();
	}
}
