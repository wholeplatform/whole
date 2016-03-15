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

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.requests.DnDOverCompositeRequest;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.requests.PartRequest;


public class WholeTreeLayoutEditPolicy extends FlowLayoutEditPolicy {
	private ICommandFactory commandFactory;

	public WholeTreeLayoutEditPolicy(ICommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new WholeNonResizableEditPolicy();
	}

	protected Command createAddCommand(EditPart child, EditPart after) {
		return commandFactory.create(new DnDOverCompositeRequest(PartRequest.MOVE_ADD_CHILD,
				(IEntityPart)getHost(), (IEntityPart)child, (IEntityPart)after));
	}

	protected Command createMoveChildCommand(EditPart child, EditPart after) {
		return commandFactory.create(new DnDOverCompositeRequest(PartRequest.MOVE_CHILD,
				(IEntityPart)getHost(), (IEntityPart)child, (IEntityPart)after));
	}

	protected Command getCreateCommand(CreateRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	protected Command getDeleteDependantCommand(Request request) {
		return UnexecutableCommand.INSTANCE;
	}

	private Command createCloneChildCommand(String reqType, EditPart child, EditPart after) {
		return commandFactory.create(new DnDOverCompositeRequest(reqType,
				(IEntityPart)getHost(), (IEntityPart)child, (IEntityPart)after));
	}

	protected Command getCloneCommand(ChangeBoundsRequest request) {
		String reqType = request.getType() == WholeDragEditPartsTracker.REQ_SHARE ? PartRequest.SHARE_CHILD : PartRequest.CLONE_CHILD;

		CompoundCommand command = new CompoundCommand();
		List editParts = ((ChangeBoundsRequest)request).getEditParts();
		
		EditPart insertionReference = getInsertionReference(request);
		for (int i = 0; i < editParts.size(); i++) {
			EditPart child = (EditPart)editParts.get(i);
			command.add(createCloneChildCommand(reqType, child, insertionReference));
		}
		return command.unwrap();
	}
	
	protected boolean isHorizontal() {
		IFigure figure = ((GraphicalEditPart)getHost()).getContentPane();
		return false;//FIXME ((TreeLayout)figure.getLayoutManager()).isHorizontal();
	}

}
