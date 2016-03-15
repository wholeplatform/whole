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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;

/**
 * @author Enrico Persiani
 */
public class DnDCompoundCommand extends Command {
	protected EditPartViewer sourceViewer;
	protected EditPartViewer targetViewer;

	protected CompoundCommand sourceCommand;
	protected CompoundCommand targetCommand;

	public DnDCompoundCommand() {
		this(null);
	}

	public DnDCompoundCommand(String label) {
		super(label);
	}

	public EditPartViewer getSourceViewer() {
		return sourceViewer;
	}

	public EditPartViewer getTargetViewer() {
		return targetViewer;
	}

	public void addSourceCommand(EditPart editPart, Command command) {
		if (sourceViewer == null)
			sourceViewer = editPart.getViewer();
		if (sourceCommand == null)
			sourceCommand = new CompoundCommand();
		sourceCommand.add(command);
	}

	public void addTargetCommand(EditPart editPart, Command command) {
		if (targetViewer == null)
			targetViewer = editPart.getViewer();
		if (targetCommand == null)
			targetCommand = new CompoundCommand();
		targetCommand.add(command);
	}

	@Override
	public boolean canExecute() {
		return (sourceCommand == null || sourceCommand.canExecute()) &&
				(targetCommand == null || targetCommand.canExecute());
	}

	public void executeCompounds() {
		if (sourceViewer == targetViewer && sourceViewer != null) {
			CompoundCommand compound = new CompoundCommand();
			compound.add(sourceCommand);
			compound.add(targetCommand);
			sourceViewer.getEditDomain().getCommandStack().execute(compound);
		} else {
			if (sourceViewer != null)
				sourceViewer.getEditDomain().getCommandStack().execute(sourceCommand);
			if (targetViewer != null)
				targetViewer.getEditDomain().getCommandStack().execute(targetCommand);
		}
	}

	@Override
	public void execute() {
		throw new IllegalStateException("cannot execute directly");
	}
}
