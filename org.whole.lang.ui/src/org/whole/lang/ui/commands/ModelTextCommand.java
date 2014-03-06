/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.commands.ICommand;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.util.CaretUpdater;

/**
 * @author Enrico Persiani
 */
public class ModelTextCommand extends ModelTransactionCommand {
	private EditPartViewer viewer;
	private CaretUpdater initialSelection;
	private CaretUpdater finalSelection;
	private IEntity newSelectedEntity;
	private int newSelectionStart;
	private int newSelectionEnd;

	@Override
	public void undo() {
		initialSelection.sheduleAsyncUpdate();
		super.undo();
	}

	@Override
	public void redo() {
		finalSelection.sheduleAsyncUpdate();
		super.redo();
	}

	public void setViewer(EditPartViewer viewer) {
		this.viewer = viewer;
	}

	public void setNewSelectedEntity(IEntity newSelectedEntity) {
		this.newSelectedEntity = newSelectedEntity;
	}

	public void setNewSelectionStart(int newSelectedEntityPosition) {
		this.newSelectionStart = newSelectedEntityPosition;
	}

	public void setNewSelectionEnd(int newSelectionEnd) {
		this.newSelectionEnd = newSelectionEnd;
	}	

	public void setNewPosition(int newPosition) {
		this.newSelectionStart = this.newSelectionEnd = newPosition;
	}

	@Override
	public void begin() {
		initialSelection = CaretUpdater.record(viewer);
		super.begin();
	}
	@Override
	public ICommand commit() {
		ICommand command = super.commit();
		finalSelection = CaretUpdater.createCU(viewer, newSelectedEntity, newSelectionStart, newSelectionEnd);
		return command;
	}
}
