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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.requests.DnDOverCompositeRequest;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.requests.PartRequest;


public class WholeContainerEditPolicy extends ContainerEditPolicy {
	private ICommandFactory commandFactory;

	public WholeContainerEditPolicy(ICommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}
	
	private Command createOrphanCommand(IEntityPart child) {
		IEntityPart hostPart = (IEntityPart) getHost();
		return commandFactory.create(new DnDOverCompositeRequest(PartRequest.MOVE_ORPHAN_CHILD, hostPart,  child, null));
	}

		
	protected Command getOrphanChildrenCommand(GroupRequest req) {
		GroupRequest request = (GroupRequest)req;
		List<?> editParts = request.getEditParts();
		CompoundCommand command = new CompoundCommand();
		for (int i = 0; i < editParts.size(); i++) {
			EditPart child = (EditPart) editParts.get(i);
			command.add(createOrphanCommand((IEntityPart) child));
		}
		return command.unwrap();
	}
}
