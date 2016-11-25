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

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.whole.lang.commands.ICommand;
import org.whole.lang.commands.NullCommand;
import org.whole.lang.events.CompositeChangeEventHandler;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IPropertyChangeObserver;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.events.MappingChangeEventHandler;
import org.whole.lang.events.PropertyChangeEventHandler;
import org.whole.lang.lifecycle.HistoryManager;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.lifecycle.Status;

/**
 * Responsible for event notification
 * 
 * @author Riccardo Solmi
 */
public class CompoundModel extends CompositeChangeEventHandler implements ICompoundModel, Serializable, IHistoryManager {
	private static final long serialVersionUID = 1L;
    transient private IRequestEventHandler requestEventHandler = IdentityRequestEventHandler.instance;
	transient private IHistoryManager historyManager;
	transient private PropertyChangeEventHandler propertyChangeEventHandler;

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	requestEventHandler = IdentityRequestEventHandler.instance;
		historyManager = this;
    }

	public CompoundModel() {
		super(
				IdentityChangeEventHandler.instance, // placeholder for HistoryManager
				IdentityChangeEventHandler.instance, // placeholder for propertyChangeEventHandler
				new MappingChangeEventHandler.LanguageReactionsChangeEventMapper());
		historyManager = this;
	}

	public boolean equals(IHistoryManager other) {
		if (historyManager != this)
			return historyManager.equals(other);

		if (other instanceof ICompoundModel) {
			ICompoundModel otherModel = (ICompoundModel) other;
			if (otherModel.getHistoryManager() != otherModel)
				return other.equals(this);
		}

		return super.equals(other);
	}

	//assume that subCompoundModel will be gc
	public ICompoundModel merge(ICompoundModel subCompoundModel, boolean mergeHistory) {
		if (subCompoundModel instanceof CompoundModel) {
			CompoundModel compoundModel = (CompoundModel) subCompoundModel;
			
			if (compoundModel.hasPropertyChangeEventHandler())
				getPropertyChangeEventHandler().addAllEventListeners(compoundModel.getPropertyChangeEventHandler().getEventListeners());

			compoundModel.setHistoryManager(getHistoryManager(), mergeHistory);
		}
		return this;
	}

	public IRequestEventHandler getRequestEventHandler() {
	    return requestEventHandler;
	}
    public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler) {
    	return this.requestEventHandler = this.requestEventHandler.addRequestEventHandler(eventHandler);
    }

    public IChangeEventHandler getChangeEventHandler() {
    	return this;
    }

	public IHistoryManager getHistoryManager() {
		return historyManager;
	}
	public void setHistoryManager(IHistoryManager historyManager, boolean mergeHistory) {
		if (this.historyManager.equals(historyManager))
			return;
		
		if (mergeHistory)
			historyManager.mergeHistory(this.historyManager);
		else
			this.historyManager.clearHistory();
		
		setHistoryManager(historyManager);
	}

	protected boolean hasPropertyChangeEventHandler() {
		return propertyChangeEventHandler != null;
	}
	public PropertyChangeEventHandler getPropertyChangeEventHandler() {
    	if (propertyChangeEventHandler == null)
    		setChangeEventHandler(1, propertyChangeEventHandler = new PropertyChangeEventHandler());
		return propertyChangeEventHandler;
	}
	public synchronized void addEventListener(IPropertyChangeObserver l) {
		getPropertyChangeEventHandler().addEventListener(l);
    }
    public synchronized void removeEventListener(IPropertyChangeObserver l) {
		getPropertyChangeEventHandler().removeEventListener(l);
    }
    public void fireNotationEvent(IEntity source, String name, Object data) {
    	getPropertyChangeEventHandler().notifyEvent(source, name, data);
    }

    public boolean isObserved(IEntity entity) {
    	if (hasPropertyChangeEventHandler())
    		for (IPropertyChangeObserver o : getPropertyChangeEventHandler().getEventListeners())
    			if (o.isObserving(entity))
    				return true;

    	return false;
    }

    public boolean isHistoryEvent() {
		if (historyManager != this)
			return historyManager.isHistoryEvent();

		return false;
    }
	public boolean isHistoryEnabled() {
		if (historyManager != this)
			return historyManager.isHistoryEnabled();

		return false;
	}
	public boolean setHistoryEnabled(boolean value) {
		if (historyManager != this)
			return historyManager.setHistoryEnabled(value);

		if (value) {
			initHistoryManager();
			return historyManager.setHistoryEnabled(true);
		} else
			return false;
	}
	protected void initHistoryManager() {
		setHistoryManager(new HistoryManager());
	}
	protected void setHistoryManager(IHistoryManager historyManager) {
		this.historyManager = historyManager;
		setChangeEventHandler(0, (IChangeEventHandler) this.historyManager);
	}

	public int getHistoryCapacity() {
		if (historyManager != this)
			return historyManager.getHistoryCapacity();

		return Integer.MAX_VALUE;
	}
	public void setHistoryCapacity(int size) {
		if (historyManager == this)
			initHistoryManager();
		historyManager.setHistoryCapacity(size);
	}

	public void trimHistory(int size) {
		if (historyManager != this)
			historyManager.trimHistory(size);
	}
	public void clearHistory() {
		if (historyManager != this)
			historyManager.clearHistory();
	}

	public IHistoryManager mergeHistory(IHistoryManager target) {
		if (historyManager != this)
			return historyManager.mergeHistory(target);

		if (target.getUndoSize() > 0)
			setHistoryManager(target);
		return historyManager;
	}

	public int getUndoSize() {
		if (historyManager != this)
			return historyManager.getUndoSize();

		return 0;
	}
	public int getRedoSize() {
		if (historyManager != this)
			return historyManager.getRedoSize();

		return 0;
	}

    public List<ICommand> getUndoCommands() {
		if (historyManager != this)
			return historyManager.getUndoCommands();

		return Collections.emptyList();
	}
    public List<ICommand> getRedoCommands() {
		if (historyManager != this)
			return historyManager.getRedoCommands();

		return Collections.emptyList();
	}

	public ICommand getUndoCommand() {
		if (historyManager != this)
			return historyManager.getUndoCommand();
		else
			return NullCommand.instance;
			
	}
	public ICommand getRedoCommand() {
		if (historyManager != this)
			return historyManager.getRedoCommand();
		else
			return NullCommand.instance;
	}

	public void undo() {
		if (historyManager == this)
			throw new IllegalStateException();

		historyManager.undo();
	}
	public void redo() {
		if (historyManager == this)
			throw new IllegalStateException();

		historyManager.redo();
	}


	public Status getStatus() {
		if (historyManager != this)
			return historyManager.getStatus();

		return Status.NO_TRANSACTION;
	}

	public void begin() {
		if (historyManager == this)
			initHistoryManager();
		historyManager.begin();
	}
	public ICommand commit() {
		if (historyManager == this)
			throw new IllegalStateException();

		return historyManager.commit();
	}
	public ICommand mergeCommit(ICommand command) {
		if (historyManager == this)
			throw new IllegalStateException();

		return historyManager.mergeCommit(command);
	}
	public void rollback() {
		if (historyManager == this)
			throw new IllegalStateException();

		historyManager.rollback();
	}
	public void setRollbackOnly() {
		if (historyManager == this)
			throw new IllegalStateException();

		historyManager.setRollbackOnly();
	}

	@Override
	public String toString() {
		if (historyManager != this)
			return historyManager.toString();

		return "History Manager (enabled=false size=0u0r capacity=*)";
	}
}
