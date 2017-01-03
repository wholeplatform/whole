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
package org.whole.lang.e4.ui.command;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandParameter;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
/**
 * @author Enrico Persiani
 */
public class CommandFactory implements ICommandFactory {
	public CommandFactory() {
	}

	protected MCommand createMCommand(String elementId, String commandName, MCommandParameter... parameters) {
		MCommand command = MCommandsFactory.INSTANCE.createCommand();
		command.setElementId(elementId);
		command.setCommandName(commandName);
		for (MCommandParameter parameter : parameters)
			command.getParameters().add(parameter);
		return command;
	}

	protected MCommandParameter createMCommandParameter(String elementId, String label, boolean optional) {
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
		MCommandParameter edUri = createMCommandParameter(ED_URI_PARAMETER_ID, "type to instantiate for replacement", false);
		MCommandParameter fdUri = createMCommandParameter(FD_URI_PARAMETER_ID, "feature to replace with", true);
		return createMCommand(REPLACE_COMMAND_ID, "Replace with Entity", edUri, fdUri);
	}

	@Override
	public MCommand createAddEntityCommand() {
		MCommandParameter edUri = createMCommandParameter(ED_URI_PARAMETER_ID, "type to instantiate for addition", false);
		MCommandParameter fdUri = createMCommandParameter(FD_URI_PARAMETER_ID, "feature to insert into", true);
		return createMCommand(ADD_COMMAND_ID, "Add child Entity",  edUri, fdUri);
	}

	@Override
	public MCommand createReplaceFragmentCommand() {
		MCommandParameter fragment = createMCommandParameter(FRAGMENT_XWL_PARAMETER_ID, "xwl fragment to unparse for replacement", false);
		MCommandParameter predicate = createMCommandParameter(PREDICATE_XWL_PARAMETER_ID, "xwl fragment to unparse for predicate", false);
		return createMCommand(REPLACE_FRAGMENT_COMMAND_ID, "Replace with Fragment", fragment, predicate);
	}

	@Override
	public MCommand createAddFragmentCommand() {
		MCommandParameter fragment = createMCommandParameter(FRAGMENT_XWL_PARAMETER_ID, "xwl fragment to unparse for addition", false);
		MCommandParameter predicate = createMCommandParameter(PREDICATE_XWL_PARAMETER_ID, "xwl fragment to unparse for predicate", false);
		return createMCommand(ADD_FRAGMENT_COMMAND_ID, "Add child Fragment",  fragment, predicate);
	}

	@Override
	public MCommand createPerformCommand() {
		MCommandParameter behavior = createMCommandParameter(BEHAVIOR_XWL_PARAMETER_ID, "xwl fragment to unparse for executing behavior", false);
		MCommandParameter predicate = createMCommandParameter(PREDICATE_XWL_PARAMETER_ID, "xwl fragment to unparse for predicate", false);
		MCommandParameter description = createMCommandParameter(DESCRIPTION_PARAMETER_ID, "behavior description", true);
		return createMCommand(PERFORM_COMMAND_ID, "Perform", behavior, predicate, description);
	}

	@Override
	public MCommand createReplaceWithDefaultCommand() {
		return createMCommand(REPLACE_WITH_DEFAULT_COMMAND_ID, "replace with default");
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
	
	@Override
	public MCommand createActionCallCommand() {
		MCommandParameter functionUri = createMCommandParameter(FUNCTION_URI_PARAMETER_ID, "function uri to unparse to apply transformation", false);
		MCommandParameter predicate = createMCommandParameter(PREDICATE_XWL_PARAMETER_ID, "xwl fragment to unparse for predicate", false);
		MCommandParameter analyzing = createMCommandParameter(ANALYSING_PARAMETER_ID, "enables results view update", true);
		MCommandParameter description = createMCommandParameter(DESCRIPTION_PARAMETER_ID, "action description", true);
		return createMCommand(ACTION_CALL_COMMAND_ID, "action call", functionUri, predicate, analyzing, description);
	}

	@Override
	public MCommand createZoomCommand() {
		MCommandParameter description = createMCommandParameter(PERCENTAGE_PARAMETER_ID, "zoom percentage", false);
		return createMCommand(ZOOM_COMMAND_ID, "zoom", description);
	}

	@Override
	public MCommand createAlignCommand() {
		MCommandParameter description = createMCommandParameter(DIRECTION_PARAMETER_ID, "align direction", false);
		return createMCommand(ALIGN_COMMAND_ID, "zoom", description);
	}

	@Override
	public MCommand createValidateModelCommand() {
		return createMCommand(VALIDATE_MODEL_COMMAND_ID, "validate model");
	}

	@Override
	public MCommand createNormalizeModelCommand() {
		return createMCommand(NORMALIZE_MODEL_COMMAND_ID, "normalize model");
	}

	@Override
	public MCommand createPretyPrintModelCommand() {
		return createMCommand(PRETTYPRINT_MODEL_COMMAND_ID, "pretty print model");
	}

	@Override
	public MCommand createInterpretModelCommand() {
		return createMCommand(INTERPRET_MODEL_COMMAND_ID, "interpret model");
	}

	@Override
	public MCommand createGenerateArtifactsModelCommand() {
		return createMCommand(GENERATEARTIFACTS_COMMAND_ID, "generate artifacts model");
	}

	@Override
	public MCommand createGenerateJavaModelCommand() {
		return createMCommand(GENERATEJAVA_COMMAND_ID, "generate java model");
	}
}
