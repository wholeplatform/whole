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
package org.whole.lang.lifecycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.whole.lang.commands.BooleanChangeCommand;
import org.whole.lang.commands.ByteChangeCommand;
import org.whole.lang.commands.CharChangeCommand;
import org.whole.lang.commands.CommandKind;
import org.whole.lang.commands.CompoundCommand;
import org.whole.lang.commands.DateChangeCommand;
import org.whole.lang.commands.DoubleChangeCommand;
import org.whole.lang.commands.EntityAddCommand;
import org.whole.lang.commands.EntityChangeCommand;
import org.whole.lang.commands.EntityRemoveCommand;
import org.whole.lang.commands.EntitySetCommand;
import org.whole.lang.commands.EnumValueChangeCommand;
import org.whole.lang.commands.FloatChangeCommand;
import org.whole.lang.commands.ICommand;
import org.whole.lang.commands.IntChangeCommand;
import org.whole.lang.commands.LongChangeCommand;
import org.whole.lang.commands.NullCommand;
import org.whole.lang.commands.ObjectChangeCommand;
import org.whole.lang.commands.ShortChangeCommand;
import org.whole.lang.commands.StringChangeCommand;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class HistoryManager extends IdentityChangeEventHandler implements IHistoryManager {
	private static final long serialVersionUID = 1L;

	public HistoryManager() {
		transactionBegin[0] = -1;
		transactionStatus[0] = Status.NO_TRANSACTION;
	}

	private static final int initial_history_capacity = 1024;
	private List<ICommand> history = new ArrayList<ICommand>(initial_history_capacity);
	private int firstExecutedIndex = 0;
	private int lastExecutedIndex = -1;
	
	private static final int initial_nesting_capacity = 2;
	private int[] transactionBegin = new int[initial_nesting_capacity];
	private Status[] transactionStatus = new Status[initial_nesting_capacity];
	private int transactionLevel;

    protected void ensureNestingCapacity(int minCapacity) {
		int oldCapacity = transactionBegin.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;

			int[] oldData = transactionBegin;
			transactionBegin = new int[newCapacity];
			System.arraycopy(oldData, 0, transactionBegin, 0, transactionLevel+1);
			Status[] oldStatus = transactionStatus;
			transactionStatus = new Status[newCapacity];
			System.arraycopy(oldStatus, 0, transactionStatus, 0, transactionLevel+1);
		}
	}

	public Status getStatus() {
		return transactionStatus[transactionLevel];
	}
	private void setStatus(Status status) {
		transactionStatus[transactionLevel] = status;
	}

	public void begin() {
		ensureNestingCapacity(++transactionLevel +1);
		transactionBegin[transactionLevel] = lastExecutedIndex+1;
		setStatus(Status.ACTIVE);
	}

	public ICommand commit() {
		if (getStatus() == Status.MARKED_ROLLBACK) {
			rollback();
			throw new RollbackException();
		} else if (getStatus() == Status.NO_TRANSACTION)
			throw new IllegalStateException();
		else
			return compound(transactionBegin[transactionLevel--]);
	}
	public ICommand mergeCommit(ICommand command) {
		if (getStatus() == Status.MARKED_ROLLBACK) {
			rollback();
			throw new RollbackException();
		} else if (getStatus() == Status.NO_TRANSACTION)
			throw new IllegalStateException();
		else {
			int index = transactionBegin[transactionLevel--];
			if (index>0 && history.get(index-1) == command)
				//TODO append to command
				return compound(index-1);
			else
				return compound(index);
		}
	}
	protected CompoundCommand compound(int beginIndex) {
		CompoundCommand command = null;
		int size = lastExecutedIndex+1 - beginIndex;
		if (size > 0) {
			List<ICommand> subList = history.subList(beginIndex, lastExecutedIndex+1);
			command = new CompoundCommand(nextExecutionTime(),
					reduce(subList).toArray(new ICommand[0]));
			subList.clear();
			addCommand(command);
		}
		return command;
	}

	//TODO called by model to delta Stream if changes.size > model.size
	protected List<ICommand> reduce(List<ICommand> commands) {
		if (commands.isEmpty())
			return commands;

		List<ICommand> list = new ArrayList<ICommand>();

		for (int i=0, size=commands.size(); i<size; i++) {
			ICommand command = commands.get(i);
			if (CommandKind.COMPOUND == command.getKind()) {
				for (ICommand child : ((CompoundCommand) command).commands)
					list.add(child);
			} else
				list.add(command);
		}

		int index = list.size()-1;
		while (index > 0) {
			ICommand lastCommand = list.get(index--);
			if (CommandKind.CHANGE == lastCommand.getKind()) {
				IEntity lastSource = lastCommand.getSource();
				FeatureDescriptor lastSourceFD = lastCommand.getSourceFeatureDescriptor();
				
				int firstIndex = index;
				while (firstIndex >= 0) {
					ICommand firstCommand = list.get(firstIndex);
					if (CommandKind.CHANGE != firstCommand.getKind() ||
							firstCommand.getSource() != lastSource ||
							firstCommand.getSourceFeatureDescriptor() != lastSourceFD)
						break;
					else
						firstIndex--;
				}
				if (firstIndex < index) {
					if (lastSourceFD == null)
						lastCommand.setOldObject(list.get(firstIndex+1).getOldObject());
					else
						lastCommand.setOldEntity(list.get(firstIndex+1).getOldEntity());

					for (int i=firstIndex+1; i<=index; i++)
						list.remove(firstIndex+1).dispose();

					index = firstIndex;
				}
			}
		}
		return list;
		// iterate over model tree to exclude overridden commands
		// for each command discard overridden prevCommands
	}

	public void rollback() {
		if (getStatus() == Status.NO_TRANSACTION)
			throw new IllegalStateException();

		discard(transactionBegin[transactionLevel--]);
	}
	protected void discard(int beginIndex) {
		disposeRedoCommands();
		boolean isEnabled = setHistoryEnabled(false);
		setHistoryEvent(true);
		while (lastExecutedIndex >= beginIndex) {
			ICommand command = history.remove(lastExecutedIndex--);
			command.undo();
			command.dispose();
		}
		setHistoryEvent(false);
		setHistoryEnabled(isEnabled, true);
	}

	public void setRollbackOnly() {
		if (getStatus() == Status.NO_TRANSACTION)
			throw new IllegalStateException();

		setStatus(Status.MARKED_ROLLBACK);
	}

	private boolean historyEvent = false;
	public boolean isHistoryEvent() {
		return historyEvent;
	}
	public boolean setHistoryEvent(boolean value) {
		return historyEvent = value;
	}

	private boolean historyEnabled = false;
	public boolean isHistoryEnabled() {
		return historyEnabled;
	}
	public boolean setHistoryEnabled(boolean value) {
		return setHistoryEnabled(value, false);
	}
	public boolean setHistoryEnabled(boolean value, boolean keepHistory) {
		boolean oldValue = historyEnabled;
		historyEnabled = value;
		if (!oldValue && historyEnabled && !keepHistory)
			clearHistory();
		return oldValue;
	}

	private int historyCapacity = Integer.MAX_VALUE;
	public int getHistoryCapacity() {
		return historyCapacity;
	}
	// capacity <= 0 means unlimited
	public void setHistoryCapacity(int capacity) {
		if (capacity <= 0)
			capacity = Integer.MAX_VALUE;

		safeTrimHistory(capacity);
		historyCapacity = capacity;
	}
	public void safeTrimHistory(int size) {
		int trimSize = getUndoSize() - size;
		if (trimSize <= 0)
			return;
		if (getStatus() != Status.NO_TRANSACTION && transactionBegin[0] < firstExecutedIndex+trimSize)
			trimSize = transactionBegin[0] - firstExecutedIndex;

		for (int i=0; i<trimSize; i++)
			history.set(firstExecutedIndex++, null).dispose();

	}
	public void trimHistory(int size) {
		int trimSize = getUndoSize() - size;
		if (getStatus() != Status.NO_TRANSACTION && transactionBegin[0] < firstExecutedIndex+trimSize)
			throw new IllegalStateException();

		for (int i=0; i<trimSize; i++)
			history.set(firstExecutedIndex++, null).dispose();

	}
	public void clearHistory() {
		trimHistory(0);
		compactHistory();
	}

	protected void ensureHistoryCapacity() {
		safeTrimHistory(getHistoryCapacity()-1);
		if (firstExecutedIndex >= initial_history_capacity)
			compactHistory();
	}
	protected void compactHistory() {
		if (firstExecutedIndex > 0) {
			history.subList(0, firstExecutedIndex).clear();
			lastExecutedIndex -= firstExecutedIndex;
			for (int i=1; i<=transactionLevel; i++)
				transactionBegin[i] -= firstExecutedIndex;
			firstExecutedIndex = 0;
		}		
	}

	public boolean equals(IHistoryManager other) {
		return other instanceof ICompoundModel ? other.equals(this) : super.equals(other);
	}

	//assume that subHistory will be replaced by the returned one
	public IHistoryManager mergeHistory(IHistoryManager subHistory) {
		int size = subHistory.getUndoSize();
		if (size > 0 && !subHistory.equals(this)) {
			ICommand[] changes = subHistory.getUndoCommands().toArray(new ICommand[size]);
			ICommand command = new CompoundCommand(nextExecutionTime(), changes);
			addCommand(command);
		}
		return this;
	}

	public int getUndoSize() {
		return lastExecutedIndex -firstExecutedIndex +1;
	}
	public int getRedoSize() {
		return history.size() -lastExecutedIndex -1;
	}

	public List<ICommand> getUndoCommands() {
		if (getUndoSize() > 0)
			return Collections.unmodifiableList(
					history.subList(firstExecutedIndex, lastExecutedIndex+1));
		else
			return Collections.emptyList();
	}
	public List<ICommand> getRedoCommands() {
		if (getRedoSize() > 0)
			return Collections.unmodifiableList(
					history.subList(lastExecutedIndex+1, history.size()));
		else
			return Collections.emptyList();
	}

	public ICommand getUndoCommand() {
		if (getUndoSize() < 1)
			return NullCommand.instance;
		else
			return history.get(lastExecutedIndex);
	}
	public ICommand getRedoCommand() {
		if (getRedoSize() < 1)
			return NullCommand.instance;
		else
			return history.get(lastExecutedIndex+1);
	}

	public void undo() {
		if (getUndoSize() < 1)
			throw new IllegalStateException();

		boolean isEnabled = setHistoryEnabled(false);
		setHistoryEvent(true);
		history.get(lastExecutedIndex--).undo();
		setHistoryEvent(false);
		setHistoryEnabled(isEnabled, true);
	}
	public void redo() {
		if (getRedoSize() < 1)
			throw new IllegalStateException();
		
		boolean isEnabled = setHistoryEnabled(false);
		setHistoryEvent(true);
		history.get(++lastExecutedIndex).redo();
		setHistoryEvent(false);
		setHistoryEnabled(isEnabled, true);
	}

	protected void addCommand(ICommand command) {
		disposeRedoCommands();
		ensureHistoryCapacity();
		lastExecutedIndex = history.size();
		history.add(command);
	}

	private int executionTime;
	protected int nextExecutionTime() {
		if (executionTime == Integer.MAX_VALUE) {
			executionTime = 0;
			for (int i=firstExecutedIndex; i<lastExecutedIndex; i++)
				history.get(i).setExecutionTime(executionTime++);
		}
		return executionTime++;
	}

	protected void disposeRedoCommands() {
		for (int i=history.size()-1; i>lastExecutedIndex; i--)
			history.remove(i).dispose();
	}


	public void notifyAdded(IEntity source, FeatureDescriptor fd, int index, IEntity newValue) {
		if (isHistoryEnabled())
     		addCommand(new EntityAddCommand(nextExecutionTime(), source, index, newValue));
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue) {
    	if (isHistoryEnabled())
     		addCommand(new EntityRemoveCommand(nextExecutionTime(), source, index, oldValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue, IEntity newValue) {
    	if (isHistoryEnabled())
     		addCommand(new EntitySetCommand(nextExecutionTime(), source, index, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
     	if (isHistoryEnabled())
     		addCommand(new EntityChangeCommand(nextExecutionTime(), source, fd, oldValue, newValue));
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, boolean oldValue, boolean newValue) {
     	if (isHistoryEnabled())
     		addCommand(new BooleanChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, byte oldValue, byte newValue) {
     	if (isHistoryEnabled())
     		addCommand(new ByteChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, char oldValue, char newValue) {
     	if (isHistoryEnabled())
     		addCommand(new CharChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, double oldValue, double newValue) {
     	if (isHistoryEnabled())
     		addCommand(new DoubleChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, float oldValue, float newValue) {
     	if (isHistoryEnabled())
     		addCommand(new FloatChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, int oldValue, int newValue) {
     	if (isHistoryEnabled())
     		addCommand(new IntChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, long oldValue, long newValue) {
     	if (isHistoryEnabled())
     		addCommand(new LongChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, short oldValue, short newValue) {
     	if (isHistoryEnabled())
     		addCommand(new ShortChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, String oldValue, String newValue) {
     	if (isHistoryEnabled())
     		addCommand(new StringChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, Date oldValue, Date newValue) {
     	if (isHistoryEnabled())
     		addCommand(new DateChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, EnumValue oldValue, EnumValue newValue) {
     	if (isHistoryEnabled())
     		addCommand(new EnumValueChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, Object oldValue, Object newValue) {
     	if (isHistoryEnabled())
     		addCommand(new ObjectChangeCommand(nextExecutionTime(), source, oldValue, newValue));
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("History Manager (enabled=");
		builder.append(isHistoryEnabled());
		builder.append(" size=");
		builder.append(getUndoSize());
		builder.append('u');
		builder.append(getRedoSize());
		builder.append('r');
		builder.append(" capacity=");
		builder.append(getHistoryCapacity() == Integer.MAX_VALUE ? "*" : getHistoryCapacity());
		builder.append(")\n[");
		for (ICommand command : getUndoCommands()) {
			builder.append("\n");
			builder.append(command.toString());
		}
		builder.append("\n--");
		for (ICommand command : getRedoCommands()) {
			builder.append("\n");
			builder.append(command.toString());
		}
		builder.append("\n]");

		return builder.toString();
	}
}
