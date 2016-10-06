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

import java.util.List;

import org.whole.lang.commands.ICommand;

/**
 * @author Riccardo Solmi
 */
public interface IHistoryManager extends ITransaction {
	public boolean equals(IHistoryManager other);
	public IHistoryManager mergeHistory(IHistoryManager target); 

	public boolean isHistoryEvent();
	public boolean isHistoryEnabled();
	public boolean setHistoryEnabled(boolean value);

	public int getHistoryCapacity();
	public void setHistoryCapacity(int size);
	public void trimHistory(int size);
	public void clearHistory();

	public int getUndoSize();
	public ICommand getUndoCommand();
	public List<ICommand> getUndoCommands();
	public void undo();

	public int getRedoSize();
	public ICommand getRedoCommand();
	public List<ICommand> getRedoCommands();
	public void redo();
}
