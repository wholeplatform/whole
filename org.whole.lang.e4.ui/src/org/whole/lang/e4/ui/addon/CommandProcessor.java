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
package org.whole.lang.e4.ui.addon;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.command.CommandFactory;
import org.whole.lang.e4.ui.command.ICommandFactory;

/**
 * @author Enrico Persiani
 */
public class CommandProcessor {
	@Inject
	protected MApplication application;

	@Execute
	public void execute() {
		ICommandFactory commandFactory = new CommandFactory();
		List<MCommand> commands = application.getCommands();

		// clean up previously persisted commands
		for (Iterator<MCommand> iterator = commands.iterator(); iterator.hasNext();)
			if (iterator.next().getElementId().startsWith(IE4UIConstants.COMMAND_NS))
				iterator.remove();

		commands.add(commandFactory.createCopyEntityPathCommand());
		commands.add(commandFactory.createCopyAsImageCommand());
		commands.add(commandFactory.createPasteAsCommand());

		commands.add(commandFactory.createReplaceEntityCommand());
		commands.add(commandFactory.createAddEntityCommand());

		commands.add(commandFactory.createReplaceFragmentCommand());
		commands.add(commandFactory.createAddFragmentCommand());

		commands.add(commandFactory.createReplaceWithDefaultCommand());
		commands.add(commandFactory.createImportCommand());
		commands.add(commandFactory.createSelectNotationCommand());
		commands.add(commandFactory.createActionCallCommand());
		commands.add(commandFactory.createPerformCommand());

		commands.add(commandFactory.createZoomCommand());
		commands.add(commandFactory.createAlignCommand());

		commands.add(commandFactory.createValidateModelCommand());
		commands.add(commandFactory.createNormalizeModelCommand());
		commands.add(commandFactory.createPretyPrintModelCommand());
		commands.add(commandFactory.createInterpretModelCommand());
		commands.add(commandFactory.createGenerateArtifactsModelCommand());
		commands.add(commandFactory.createGenerateJavaModelCommand());
	}
}
