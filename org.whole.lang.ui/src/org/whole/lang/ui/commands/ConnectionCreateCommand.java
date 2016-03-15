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
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ConnectionCreateCommand extends AbstractConnectionCommand {
	private IEntity source;
	private FeatureDescriptor sourceFeature;
	private IEntity target;
	private FeatureDescriptor targetFeature;

	public boolean canExecute() {
		if (!canConnect(source, sourceFeature))
			return false;
		if (target != null && targetFeature != null && !canConnect(target, targetFeature))
			return false;
		if (source.equals(target))
			return false;
		return !connectionExists(source, sourceFeature, target, targetFeature);
	}

	public void execute() {
		IEntity connection = getConnection();
		IEntity transitionParent = EntityUtils.getCompoundRoot(source).wGet(1);//FIXME get transitions from presentation aspect
		connect(source, sourceFeature, connection);
		//FIXME should use presentation aspects
		connection.wSet(getConnectionFeature("source"), source);
		connection.wSet(getConnectionFeature("target"), target);
		connect(target, targetFeature, connection);
		transitionParent.wAdd(connection);
	}

	public void undo() {
		IEntity connection = getConnection();
		IEntity transitionParent = EntityUtils.getCompoundRoot(source).wGet(1);
		disconnect(source, sourceFeature, getConnection());
		disconnect(target, targetFeature, getConnection());
		transitionParent.wRemove(connection);
	}

	public void setSource(IEntity source) {
		this.source = source;
	}
	public void setSourceFeature(FeatureDescriptor sourceFeature) {
		this.sourceFeature = sourceFeature;
	}

	public void setTarget(IEntity target) {
		this.target = target;
	}
	public void setTargetFeature(FeatureDescriptor targetFeature) {
		this.targetFeature = targetFeature;
	}
}
