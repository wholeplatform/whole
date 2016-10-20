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

import org.eclipse.gef.commands.Command;
import org.whole.lang.commands.ICommand;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.lifecycle.Status;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.util.AnimableRunnable;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ModelTransactionCommand extends Command {
	private IEntity model;
	private ICommand compoundCommand;
	private boolean executed;
	protected boolean animated = true;

	public ModelTransactionCommand() {
		this(null);
	}
	public ModelTransactionCommand(IEntity model) {
		this(model, null);
	}
	public ModelTransactionCommand(IEntity model, String label) {
		setModel(model);
		setLabel(label);
	}

	public boolean canExecute() {
		return !executed || getModelHistory().getRedoCommand() == compoundCommand;
	}
	public boolean canUndo() {
		return getModelHistory().getUndoCommand() == compoundCommand;
	}

	public void execute() {
		if (executed) {
			if (!animated && AnimableRunnable.isEnabled()) {
				AnimableRunnable.enableAnimation(false);
				getModelHistory().redo();
				AnimableRunnable.enableAnimation(true);
			} else
				getModelHistory().redo();
		} else
			executed = true;
	}
	public void undo() {
		if (!animated && AnimableRunnable.isEnabled()) {
			AnimableRunnable.enableAnimation(false);
			getModelHistory().undo();
			AnimableRunnable.enableAnimation(true);
		} else
			getModelHistory().undo();
	}

	public void setModel(IEntity model) {
		this.model = model;
	}
	protected IEntity getModel() {
		return model;
	}
	protected IHistoryManager getModelHistory() {
		assert model != null;
		return ReflectionFactory.getHistoryManager(model);
	}
	public void begin() {
		getModelHistory().begin();
	}
	public ICommand commit() {
		animated = AnimableRunnable.isEnabled();
		return compoundCommand = getModelHistory().commit();
	}
	public ICommand mergeCommit() {
		animated = AnimableRunnable.isEnabled();
		return compoundCommand = getModelHistory().mergeCommit(compoundCommand);
	}
	public void rollbackIfNeeded() {
		if (!getModelHistory().getStatus().equals(Status.NO_TRANSACTION))	
			getModelHistory().rollback();
	}
}
