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
package org.whole.lang.ui.dnd;

import static org.eclipse.gef.RequestConstants.REQ_CLONE;
import static org.eclipse.gef.RequestConstants.REQ_MOVE;
import static org.eclipse.gef.RequestConstants.REQ_ORPHAN;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.whole.lang.ui.commands.DnDCompoundCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class EditPartTransferDropTargetListener extends AbstractTransferDropTargetListener {

	public EditPartTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer, EditPartsTransfer.instance());
		setEnablementDeterminedByCommand(true);
	}

	@Override
	protected void handleDrop() {
		updateTargetRequest();
		updateTargetEditPart();

		if (getTargetEditPart() != null) {
			Command command = getCommand();
			if (command != null && command.canExecute())
				((DnDCompoundCommand) command).executeCompounds();
			else
				getCurrentEvent().detail = DND.DROP_NONE;
		} else
			getCurrentEvent().detail = DND.DROP_NONE;

		if (getCurrentEvent().detail != DND.DROP_NONE) {
			getViewer().setSelection(StructuredSelection.EMPTY);
			getViewer().getControl().setFocus();
		}
	}

	@Override
	protected void handleDragOver() {
		getCurrentEvent().feedback = DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
		super.handleDragOver();
	}


	@SuppressWarnings("unchecked")
	protected boolean isMoving() {
		DropTargetEvent event = getCurrentEvent();
		EditPart targetEditPart = getTargetEditPart();
		if (event.detail != DND.DROP_MOVE || targetEditPart == null)
			return false;

		ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
		for (EditPart editPart : ((List<EditPart>) request.getEditParts()))
			if (!targetEditPart.equals(editPart.getParent()))
				return false;
		return true;
	}

	protected boolean isCloning() {
		DropTargetEvent event = getCurrentEvent();
		return event.detail == DND.DROP_COPY;
	}

	@SuppressWarnings("unchecked")
	protected Command getCommand() {
		EditPart targetEditPart = getTargetEditPart();
		if (targetEditPart == null)
			return UnexecutableCommand.INSTANCE;

		ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
		DnDCompoundCommand command = new DnDCompoundCommand();
		boolean cloning = isCloning();
		boolean moving = isMoving();

		if (cloning)
			request.setType(REQ_CLONE);
		else if (moving)
			request.setType(REQ_MOVE);
		else
			request.setType(REQ_ORPHAN);

		// create REQ_MOVE and REQ_ORPHAN requests
		if (!cloning)
			for (EditPart editPart : ((List<EditPart>) request.getEditParts()))
				command.addSourceCommand(editPart, editPart.getCommand(request));

		// create REQ_CLONE request
		if (!moving) {
			request.setType(REQ_CLONE);
			command.addTargetCommand(targetEditPart, targetEditPart.getCommand(request));
		}

		return command;
	}

	@Override
	protected Request createTargetRequest() {
		return new ChangeBoundsRequest();
	}

	@Override
	protected void updateTargetRequest() {
		DropTargetEvent event = getCurrentEvent();
		ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
		request.setType(REQ_CLONE);
		request.setEditParts(event.data == null ? Collections.emptyList() : (List<?>) event.data);
		request.getExtendedData().clear();
		request.setLocation(getDropLocation());
	}

	@Override
	public boolean isEnabled(DropTargetEvent event) {
		// this is an hack to allow drop enablement calculations
		// see the selected entities before the final drop event
		for (int i = 0; i < event.dataTypes.length; i++)
			if (getTransfer().isSupportedType(event.dataTypes[i]))
				event.data = EditPartsTransfer.instance().getObject();
		if (event.data != null && !((List<?>) event.data).isEmpty()) {
			IEntityPartViewer sourceViewer = ((IEntityPart) ((List<?>) event.data).get(0)).getViewer();
			if (sourceViewer == getViewer())
				return false;
			else if (Boolean.TRUE.equals(sourceViewer.getProperty(EditPartsTransfer.PROPERTY_FORCE_DND_COPY)))
				event.detail = DND.DROP_COPY;
		}

		return super.isEnabled(event);
	}
}
