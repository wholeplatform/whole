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
package org.whole.lang.ui.commands;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ConnectionReconnectCommand extends AbstractConnectionCommand {
	private IEntity newNode;
	private FeatureDescriptor newNodeFeature;
	private IEntity oldNode;
	private FeatureDescriptor oldNodeFeature;
	private boolean sourceCommand;

	public ConnectionReconnectCommand(boolean sourceCommand) {
		this.sourceCommand = sourceCommand;
	}

	public boolean canExecute() {
		if (!canConnect(newNode, newNodeFeature))
			return false;
		oldNode = getConnection().wGet(getConnectionFeature(isSourceCommand() ? "source" : "target"));
		if (oldNode.equals(newNode))
			return false;
		IEntity otherNode = getOtherEndpoint();
		FeatureDescriptor otherFeature = getConnectionConnectedFeature(otherNode);
		if (isSourceCommand())
			return !connectionExists(newNode, newNodeFeature, otherNode, otherFeature);
		else
			return !connectionExists(otherNode, otherFeature, newNode, newNodeFeature);
	}

	protected IEntity getOtherEndpoint() {
		return getConnection().wGet(getConnectionFeature(isSourceCommand() ? "target" : "source"));
	}

	public void execute() {
		oldNodeFeature = getConnectionConnectedFeature(oldNode);
		IEntity connection = getConnection();
		connect(newNode, newNodeFeature, connection);
		connection.wSet(getConnectionFeature(isSourceCommand() ? "source" : "target"), newNode);
		disconnect(oldNode, oldNodeFeature, connection);
	}

	public void undo() {
		IEntity connection = getConnection();
		connect(oldNode, oldNodeFeature, connection);
		connection.wSet(getConnectionFeature(isSourceCommand() ? "source" : "target"), oldNode);
		disconnect(newNode, newNodeFeature, connection);
	}

	public void setNode(IEntity node) {
		this.newNode = node;
	}
	public void setNodeFeature(FeatureDescriptor nodeFeature) {
		this.newNodeFeature = nodeFeature;
	}

	public boolean isSourceCommand() {
		return sourceCommand;
	}
}
