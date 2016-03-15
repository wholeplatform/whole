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
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityAddCommand extends AbstractCommand {
	private static final long serialVersionUID = 1L;
	public final int sourceIndex;
	public final InternalIEntity newValue;

	public EntityAddCommand(int executionTime, IEntity source, int index, IEntity newValue) {
		super(executionTime, source);
		this.sourceIndex = index;
		this.newValue = (InternalIEntity) newValue;
		this.newValue.wSetBindingCommand(this);
	}

    public CommandKind getKind() {
    	return CommandKind.ADD;
    }

	public int getSourceIndex() {
    	return sourceIndex;
    }
    public IEntity getNewEntity() {
    	return newValue;
    }

	public void undo() {
		source.wSetLastCommand(getPrevCommand());
		source.wRemove(sourceIndex);
	}
	public void redo() {
		source.wSetLastCommand(this);
		source.wAdd(sourceIndex, newValue);
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
		builder.append(StringUtils.simpleId(newValue));
	}
	@Override
	protected void appendLocation(StringBuilder builder) {
		super.appendLocation(builder);
		builder.append('[');
		builder.append(sourceIndex);
		builder.append(']');
	}
}
