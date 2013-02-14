/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.command;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandParameter;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.whole.lang.model.IEntity;
/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class CommandFactory implements ICommandFactory {
	public CommandFactory() {
	}

	@Override
	public MCommand createMCommand(String elementId, String commandName, MCommandParameter... parameters) {
		MCommand command = MCommandsFactory.INSTANCE.createCommand();
		command.setElementId(elementId);
		command.setCommandName(commandName);
		for (MCommandParameter parameter : parameters)
			command.getParameters().add(parameter);
		return command;
	}

	@Override
	public MCommandParameter createMCommandParameter(String elementId, String label, boolean optional) {
		MCommandParameter parameter = MCommandsFactory.INSTANCE.createCommandParameter();
		parameter.setElementId(elementId);
		parameter.setName(label);
		parameter.setOptional(optional);
		return parameter;
	}

	@Override
	public MCommand createCopyEntityPathCommand() {
		return createMCommand(COPY_ENTITY_PATH_COMMAND_ID, "copy to the clipboard the entity path");
	}

	@Override
	public MCommand createCopyAsImageCommand() {
		return createMCommand(COPY_AS_IMAGE_COMMAND_ID, "copy to the clipboard the entity image representation");
	}

	@Override
	public MCommand createPasteAsCommand() {
		return createMCommand(PASTE_AS_COMMAND_ID, "paste clipboard contents using a specific persistence");
	}

	@Override
	public MCommand createReplaceEntityCommand() {
		MCommandParameter parameter = createMCommandParameter(ED_URI_PARAMETER_ID, "type to instantiate for replacement", false);
		return createMCommand(REPLACE_COMMAND_ID, "Replace with Entity", parameter);
	}

	@Override
	public MCommand createAddEntityCommand() {
		MCommandParameter parameter = createMCommandParameter(ED_URI_PARAMETER_ID, "type to instantiate for addition", false);
		return createMCommand(ADD_COMMAND_ID, "Add child Entity",  parameter);
	}

	@Override
	public MCommand createTransformCommand(IEntity behavior) {
		//TODO
		return null;
	}

	@Override
	public MCommand createReplaceFragmentCommand() {
		MCommandParameter parameter = createMCommandParameter(FRAGMENT_XWL_PARAMETER_ID, "xwl fragment to unparse for replacement", false);
		return createMCommand(REPLACE_FRAGMENT_COMMAND_ID, "Replace with Fragment", parameter);
	}

	@Override
	public MCommand createAddFragmentCommand() {
		MCommandParameter parameter = createMCommandParameter(FRAGMENT_XWL_PARAMETER_ID, "xwl fragment to unparse for addition", false);
		return createMCommand(ADD_FRAGMENT_COMMAND_ID, "Add child Fragment",  parameter);
	}

	@Override
	public MCommand createSelectNotationCommand() {
		MCommandParameter parameter = createMCommandParameter(EDITORKIT_ID_PARAMETER_ID, "editorKit id of the notation to be selected", false);
		return createMCommand(SELECT_NOTATION_COMMAND_ID, "Select Notation", parameter);
	}
	@Override
	public MCommand createImportCommand() {
		return createMCommand(IMPORT_COMMAND_ID, "import fragments into a model");
	}
}
