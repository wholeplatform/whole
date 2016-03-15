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

import java.util.Formatter;

import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractCommand extends NullCommand {
	public int executionTime;
	public ICommand prevCommand;
	public final InternalIEntity source;

    protected AbstractCommand(int executionTime, IEntity source) {
		this.executionTime = executionTime;
		this.source = (InternalIEntity) source;
		this.prevCommand = this.source.wSetLastCommand(this);
    }
    protected AbstractCommand(int executionTime, IEntity source, ICommand prevCommand) {
    	this.executionTime = executionTime;
		this.source = (InternalIEntity) source;
		this.prevCommand = prevCommand;
    }

    public CommandKind getKind() {
    	return CommandKind.CHANGE;
    }
    public final int getExecutionTime() {
    	return executionTime;
    }
    public void setExecutionTime(int executionTime) {
    	this.executionTime = executionTime;
    }
    public final ICommand getPrevCommand() {
    	return prevCommand;
    }
    public void setPrevCommand(ICommand command) {
    	prevCommand = command;
    }
	public final ICommand getCommand(int contextTime) {
		ICommand command = this;
		while (contextTime < command.getExecutionTime())
			command = command.getPrevCommand();
		return command;
	}

    public final IEntity getSource() {
    	return source;
    }

    public FeatureDescriptor getSourceFeatureDescriptor() {
    	return null;
    }
    public int getSourceIndex() {
    	return -1;
    }


	public void dispose() {
		ICommand command = source.wGetLastCommand();
		if (command == this)
			source.wSetLastCommand(getPrevCommand());
		else
			while (command != NullCommand.instance) {
				ICommand prevCommand = command.getPrevCommand();
				if (prevCommand == this) {
					command.setPrevCommand(getPrevCommand());
					break;
				}
				command = prevCommand;
			}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		toString(builder);
		return builder.toString();
	}
	public void toString(StringBuilder builder) {
		builder.append("at ");
		new Formatter(builder).format("%8x %8s ", getExecutionTime(), getKind());
		appendChange(builder);
		builder.append(" in ");
		appendLocation(builder);
	}
	protected abstract void appendChange(StringBuilder builder);
	protected void appendLocation(StringBuilder builder) {
		builder.append(StringUtils.simpleId(source));
	}
}
