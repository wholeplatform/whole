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

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.util.CaretUpdater;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractTextCommand extends Command implements ITextCommand, ILegacyCommand {
	protected final TextCommandTypes type;
	protected EditPartViewer viewer;
	protected Range initialRange;
	protected Range finalRange;

	protected IEntity entity;
	protected Object newValue;

	public AbstractTextCommand(TextCommandTypes type) {
		this.type = type;
		setLabel("Typing");
	}

	public void setEntity(IEntity entity) {
		this.entity = entity;
	}
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}

	public boolean sameType(ITextCommand command) {
		AbstractTextCommand textCommand = (AbstractTextCommand) command;
		return type == textCommand.type;
	}

	@SuppressWarnings("unchecked")
	public ITextualEntityPart getSourcePart() {
		return (ITextualEntityPart) ModelObserver.getObserver(entity, getViewer().getEditPartRegistry());
	}

	public EditPartViewer getViewer() {
		return viewer;
	}
	public void setViewer(EditPartViewer viewer) {
		this.viewer = viewer;
	}

	public void merge(ITextCommand command) {
		AbstractTextCommand textCommand = (AbstractTextCommand) command;
		newValue = textCommand.newValue;
		initialRange.merge(textCommand.initialRange);
		finalRange.merge(textCommand.finalRange);
	}

	private CaretUpdater initialSelection;
	private CaretUpdater getInitialSelection() {
		if (initialSelection == null) {
			initialSelection = CaretUpdater.createCU(getViewer(), entity, initialRange.start, initialRange.end);
		}
		return initialSelection;
	}

	private CaretUpdater finalSelection;
	private CaretUpdater getFinalSelection() {
		if (finalSelection == null) {
			finalSelection = CaretUpdater.createCU(getViewer(), entity, finalRange.start, finalRange.end);
		}
		return finalSelection;
	}

	public void restoreInitialSelection() {
		getInitialSelection().sheduleSyncUpdate();
	}
	public void restoreFinalSelection() {
		getFinalSelection().sheduleSyncUpdate();
	}

	public void execute() {
		entity.wSetValue(newValue);
	}
	public abstract boolean canExecute();

	public boolean canUndo() {
		return false;
	}
	public void undo() {
		throw new IllegalStateException();
	}
	public void redo() {
		throw new IllegalStateException();
	}
}
