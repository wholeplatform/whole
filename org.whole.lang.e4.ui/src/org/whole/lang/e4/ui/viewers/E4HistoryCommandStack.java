/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.viewers;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.commands.ILegacyCommand;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.commands.TextTransactionCommand;

/**
 * @author Enrico Persiani
 */
public class E4HistoryCommandStack extends CommandStack {
	protected E4GraphicalViewer viewer;

	public E4HistoryCommandStack(E4GraphicalViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void flush() {
		super.flush();
		getHistoryManager().clearHistory();
	}

	public void execute(Command command) {
		ModelTransactionCommand mtCommand;
		if (isLegacyCommand(command) && command.canExecute())
			mtCommand = toModelTransactionCommand(command);
		else if (!(command instanceof ModelTransactionCommand)) {
			super.execute(command);
			return;
		} else
			mtCommand = (ModelTransactionCommand) command;

		if (mtCommand.canUndo())
			super.execute(mtCommand);
	}

	protected IHistoryManager getHistoryManager() {
		return ReflectionFactory.getHistoryManager(getModel());
	}
	protected IEntity getModel() {
		return viewer.getEntityContents();
	}
	protected boolean isLegacyCommand(Command command) {
		if (command instanceof TextTransactionCommand)
			return false;
		if (command instanceof ILegacyCommand)
			return true;
		else if (command instanceof CompoundCommand) {
			CompoundCommand compoundCommand = (CompoundCommand) command;
			for (Object child : compoundCommand.getChildren())
				if (!isLegacyCommand((Command) child))
					return false;
			return true;
		}
		return false;
	}
	protected ModelTransactionCommand toModelTransactionCommand(Command command) {
		ModelTransactionCommand mtCommand = new ModelTransactionCommand();
		
		try {
			mtCommand.setModel(getModel());
			mtCommand.setLabel(command.getLabel());
			mtCommand.begin();
			command.execute();
			mtCommand.commit();
			return mtCommand;
		} catch (Exception e) {
			mtCommand.rollback();
		}

		return mtCommand;
	}
}
