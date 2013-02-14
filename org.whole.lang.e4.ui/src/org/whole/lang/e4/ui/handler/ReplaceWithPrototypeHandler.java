/**
 * Copyright 2004-2011 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.handler;

import java.util.List;

import javax.inject.Named;

import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandParameter;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings({"restriction", "unchecked"})
public class ReplaceWithPrototypeHandler {
	public static final String COMMAND_ID = "whole.command.replaceWithPrototype";
	public static final String COMMAND_PARAMETER_ID = "whole.command.replaceWithPrototype.parameter.prototype";

	public ReplaceWithPrototypeHandler(EHandlerService handlerService, MApplication application) {
		MCommand command = E4Utils.findCommand(COMMAND_ID, application);
		// lazily register the command
		if (command == null) {
			MCommandParameter parameter = MCommandsFactory.INSTANCE.createCommandParameter();
			parameter.setName("The Prototype to Replace with");
			parameter.setOptional(false);
			parameter.setElementId(COMMAND_PARAMETER_ID);
			command = MCommandsFactory.INSTANCE.createCommand();
			command.setElementId(COMMAND_ID);
			command.setCommandName(COMMAND_ID);   
			command.getParameters().add(parameter);
			application.getCommands().add(command);
		}
		handlerService.activateHandler(COMMAND_ID, this);		
	}

	@Execute
	public void execute(@Named(COMMAND_PARAMETER_ID) String prototypeString, ESelectionService selectionService) throws Exception {
		Object selection = selectionService.getSelection();
		List<IEntityPart> selectedEntityParts = ((IStructuredSelection) selection).toList();
		IEntity selectedEntity = selectedEntityParts.get(0).getModelEntity();
		IEntity parent = selectedEntity.wGetParent();
		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(selectedEntity);
		IEntity prototype = ReflectionFactory.getDefaultPersistenceKit().readModel(new StringPersistenceProvider(prototypeString));
		IEntity adapter = CommonsEntityAdapterFactory.createSameStageFragment(ed, prototype);
		parent.wSet(selectedEntity, adapter);
	}
}
