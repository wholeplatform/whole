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

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.commands.ConnectionCreateCommand;
import org.whole.lang.ui.commands.ConnectionReconnectCommand;
import org.whole.lang.ui.editparts.INodeEntityPart;


/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeNodeEditPolicy extends GraphicalNodeEditPolicy {
	protected INodeEntityPart getNodeEditPart() {
		return (INodeEntityPart) getHost();
	}
	protected IEntity getNode() {
		return (IEntity) getHost().getModel();
	}

	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		FeatureDescriptor fd = getNodeEditPart().getTargetConnectionFeature(request);
		if (fd == null)
			return UnexecutableCommand.INSTANCE;
		ConnectionCreateCommand cmd = (ConnectionCreateCommand) request.getStartCommand();
		if (cmd == null)
			return UnexecutableCommand.INSTANCE;
		cmd.setConnection((IEntity) request.getNewObject());
		cmd.setTarget(getNode());
		cmd.setTargetFeature(fd);
		return cmd;
	}

	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		FeatureDescriptor fd = getNodeEditPart().getSourceConnectionFeature(request);
		if (fd == null)
			return UnexecutableCommand.INSTANCE;
		ConnectionCreateCommand cmd = new ConnectionCreateCommand();
		cmd.setSource(getNode());
		cmd.setSourceFeature(fd);
		request.setStartCommand(cmd);
		return cmd;
	}

	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		FeatureDescriptor fd = getNodeEditPart().getTargetConnectionFeature(request);
		if (fd == null)
			return UnexecutableCommand.INSTANCE;
		ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(false);
		cmd.setConnection((IEntity) request.getConnectionEditPart().getModel());
		cmd.setNode(getNode());
		cmd.setNodeFeature(fd);
		return cmd;
	}

	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		FeatureDescriptor fd = getNodeEditPart().getSourceConnectionFeature(request);
		if (fd == null)
			return UnexecutableCommand.INSTANCE;
		ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(true);
		cmd.setConnection((IEntity) request.getConnectionEditPart().getModel());
		cmd.setNode(getNode());
		cmd.setNodeFeature(fd);
		return cmd;
	}
}
