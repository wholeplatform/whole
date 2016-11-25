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
package org.whole.lang.model;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.whole.lang.commands.ICommand;
import org.whole.lang.commands.NullCommand;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IPropertyChangeObserver;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.lifecycle.Status;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class NullCompoundModel implements ICompoundModel, Serializable, IHistoryManager {
	private static final long serialVersionUID = 1L;
	public static final NullCompoundModel instance = new NullCompoundModel();
	public NullCompoundModel() {
	}
    public Object readResolve() throws ObjectStreamException {
    	return NullCompoundModel.instance;
    }

    public Object clone() {
        return this;
	}

    public boolean equals(IHistoryManager other) {
		return this == other || other instanceof ICompoundModel ? other.equals(this) : false;
    }

    public ICompoundModel merge(ICompoundModel compoundModel, boolean mergeHistory) {
    	return compoundModel;
    }

	public IRequestEventHandler getRequestEventHandler() {
		return IdentityRequestEventHandler.instance;
	}
	public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler) {
		throw new IllegalStateException(WholeMessages.null_model);
	}
    public IChangeEventHandler getChangeEventHandler() {
    	return IdentityChangeEventHandler.instance;
    }
	public IChangeEventHandler addChangeEventHandler(IChangeEventHandler eventHandler) {
		throw new IllegalStateException(WholeMessages.null_model);
	}

	public IHistoryManager getHistoryManager() {
    	return this;
    }
	public void setHistoryManager(IHistoryManager historyManager, boolean mergeHistory) {
		throw new IllegalStateException(WholeMessages.null_model);		
	}

	public IChangeEventHandler getPropertyChangeEventHandler() {
		throw new IllegalStateException(WholeMessages.null_model);
    }
	public void fireNotationEvent(IEntity source, String name, Object data) {
		throw new IllegalStateException(WholeMessages.null_model);
    }

    public void addEventListener(IPropertyChangeObserver l) {
		throw new IllegalStateException(WholeMessages.null_model);
    }
    public void removeEventListener(IPropertyChangeObserver l) {
		throw new IllegalStateException(WholeMessages.null_model);
    }

    public boolean isObserved(IEntity entity) {
    	return false;
    }

    public boolean isHistoryEvent() {
    	return false;
    }
	public boolean isHistoryEnabled() {
		return false;
	}
	public boolean setHistoryEnabled(boolean value) {
		if (value)
			throw new IllegalStateException();
		return false;
	}

	public int getHistoryCapacity() {
		return 0;
	}
	public void setHistoryCapacity(int size) {
		throw new IllegalStateException();
	}

	public void trimHistory(int size) {
	}
	public void clearHistory() {
	}

	public IHistoryManager mergeHistory(IHistoryManager target) {
		throw new IllegalStateException();
	}

	public ICommand getUndoCommand() {
		return NullCommand.instance;
			
	}
	public ICommand getRedoCommand() {
		return NullCommand.instance;
	}

	public int getUndoSize() {
		return 0;
	}
	public int getRedoSize() {
		return 0;
	}

    public List<ICommand> getUndoCommands() {
		return Collections.emptyList();
	}
    public List<ICommand> getRedoCommands() {
		return Collections.emptyList();
	}

	public void undo() {
		throw new IllegalStateException();
	}
	public void redo() {
		throw new IllegalStateException();
	}


	public Status getStatus() {
		return Status.NO_TRANSACTION;
	}

	public void begin() {
		throw new IllegalStateException();
	}
	public ICommand commit() {
		throw new IllegalStateException();
	}
	public ICommand mergeCommit(ICommand command) {
		throw new IllegalStateException();		
	}
	public void rollback() {
		throw new IllegalStateException();
	}
	public void setRollbackOnly() {
		throw new IllegalStateException();
	}

	@Override
	public String toString() {
		return "Null History Manager (enabled=false size=0u0r capacity=0)";
	}
}
