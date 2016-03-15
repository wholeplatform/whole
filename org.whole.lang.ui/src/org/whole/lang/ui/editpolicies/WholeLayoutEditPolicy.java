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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ReplaceChildCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IFragmentPart;
import org.whole.lang.ui.requests.DnDOverPartRequest;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.requests.PartRequest;

public class WholeLayoutEditPolicy extends LayoutEditPolicy {
	private ICommandFactory commandFactory;

	public WholeLayoutEditPolicy(ICommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child instanceof IFragmentPart)
			return new WholeResizableEditPolicy();
		else
			return new WholeNonResizableEditPolicy();
	}

	protected Command getCreateCommand(CreateRequest request) {
		// TODO incapsulate in command factory
		Object newObject = request.getNewObject();
		if (newObject instanceof IEntity) {
			IEntityPart hostPart = (IEntityPart) getHost();
			// TODO
			// return commandFactory.create(new
			// DnDOverPartRequest(PartRequest.MOVE_ADD_CHILD,
			// hostPart, ((GroupRequest)request).getEditParts()));

			ReplaceChildCommand cmd = new ReplaceChildCommand();
			cmd.setParent(hostPart.getParentModelEntity());
			cmd.setOldChild(hostPart.getModelEntity());
			cmd.setNewChild((IEntity) newObject);
			return cmd;
		}
		return null;
	}

	protected Command getDeleteDependantCommand(Request request) {
		return null;// UnexecutableCommand.INSTANCE;
	}

	protected Command getMoveChildrenCommand(Request request) {
		return UnexecutableCommand.INSTANCE;
	}

	protected Command getAddCommand(Request request) {
		return commandFactory.create(new DnDOverPartRequest(
				PartRequest.MOVE_ADD_CHILD, (IEntityPart) getHost(),
				((GroupRequest) request).getEditParts()));
	}

	protected Command getCloneCommand(ChangeBoundsRequest request) {
		String reqType = request.getType() == WholeDragEditPartsTracker.REQ_SHARE ? PartRequest.SHARE_CHILD
				: PartRequest.CLONE_CHILD;

		return commandFactory.create(new DnDOverPartRequest(reqType,
				(IEntityPart) getHost(), ((GroupRequest) request)
						.getEditParts()));
	}
}
