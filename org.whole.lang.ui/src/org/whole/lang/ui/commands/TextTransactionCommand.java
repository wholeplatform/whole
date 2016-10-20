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

/**
 * @author Enrico Persiani
 */
public class TextTransactionCommand extends ModelTransactionCommand {
	protected ITextCommand textCommand;

	public TextTransactionCommand() {
		this(null);
	}

	public TextTransactionCommand(String label) {
		setLabel(label);
	}

	public boolean canMerge(ITextCommand command) {
		return isFirstMerge() ||  (canUndo() && textCommand.sameType(command));
	}

	protected boolean isFirstMerge() {
		return textCommand == null;
	}

	public void merge(ITextCommand command) {
		try {
			begin();
			command.execute();

			if (isFirstMerge()) {
				commit();
				setLabel((textCommand = command).getLabel());
			} else {
				mergeCommit();
				textCommand.merge(command);
			}
			animated = false;
		} catch (Exception e) {
			command.restoreInitialSelection();
			rollbackIfNeeded();
		}
	}

	public void undo() {
		super.undo();
		textCommand.restoreInitialSelection();
	}
	public void redo() {
		super.redo();
		textCommand.restoreFinalSelection();
	}
}
