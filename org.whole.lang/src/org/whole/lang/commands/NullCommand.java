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

import java.io.ObjectStreamException;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class NullCommand implements ICommand {
	private static final long serialVersionUID = 1L;
	public static final NullCommand instance = new NullCommand();
	protected NullCommand() {}
    public Object readResolve() throws ObjectStreamException {
    	return NullCommand.instance;
    }

    public CommandKind getKind() {
    	return CommandKind.NULL;
    }

    public int getExecutionTime() {
    	return Integer.MIN_VALUE;
    }
    public void setExecutionTime(int executionTime) {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);    	
    }
    public ICommand getPrevCommand() {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public void setPrevCommand(ICommand command) {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
	public ICommand getCommand(int contextTime) {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);		
	}

    public IEntity getSource() {
    	//TODO return NullEntity for getting specific scope related exceptions
    	return null;
    }
    public FeatureDescriptor getSourceFeatureDescriptor() {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public int getSourceIndex() {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public IEntity getOldEntity() {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public void setOldEntity(IEntity entity) {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public IEntity getNewEntity() {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public Object getOldObject() {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public void setOldObject(Object object) {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }
    public Object getNewObject() {
    	throw new IllegalStateException(WholeMessages.command_illegal_method);
    }

	public void undo() {
		throw new IllegalStateException(WholeMessages.command_illegal_method);
	}
	public void redo() {
	}

	public void dispose() {
	}

	public String toString() {
		return "null";
	}
	public void toString(StringBuilder builder) {
		builder.append(toString());
	}
}
