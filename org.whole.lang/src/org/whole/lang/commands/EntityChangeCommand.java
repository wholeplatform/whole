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
package org.whole.lang.commands;

import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityChangeCommand extends AbstractCommand {
	private static final long serialVersionUID = 1L;
	public final FeatureDescriptor fd;
	private IEntity oldValue;
	public final InternalIEntity newValue;

	public EntityChangeCommand(int executionTime, IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
		super(executionTime, source, oldValue == null ? NullCommand.instance : ((InternalIEntity) oldValue).wGetBindingCommand());
		this.fd = fd;
		this.oldValue = oldValue;
		this.newValue = (InternalIEntity) newValue;
		this.newValue.wSetBindingCommand(this);
	}

    public FeatureDescriptor getSourceFeatureDescriptor() {
    	return fd;
    }
    public int getSourceIndex() {
    	return getSource().wIndexOf(fd);
    }

    public IEntity getOldEntity() {
    	return oldValue;
    }
    public void setOldEntity(IEntity entity) {
    	oldValue = entity;
    }
    public IEntity getNewEntity() {
    	return newValue;
    }

	public void undo() {
		source.wSet(fd, oldValue);
	}
	public void redo() {
		source.wSet(fd, newValue);
	}

	@Override
	public void dispose() {
		super.dispose();
		ICommand command = newValue.wGetBindingCommand();
		if (command == this)
			newValue.wSetBindingCommand(NullCommand.instance);

	}

	@Override
	protected void appendChange(StringBuilder builder) {
		builder.append(StringUtils.simpleId(oldValue));
		builder.append(" -> ");
		builder.append(StringUtils.simpleId(newValue));
	}
	@Override
	protected void appendLocation(StringBuilder builder) {
		super.appendLocation(builder);
		builder.append('.');
		builder.append(fd);
	}
}
