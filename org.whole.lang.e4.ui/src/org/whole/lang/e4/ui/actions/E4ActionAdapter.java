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
package org.whole.lang.e4.ui.actions;

import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.bindings.EBindingService;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.e4.ui.util.E4Utils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E4ActionAdapter extends Action implements IUpdatableAction {
	protected IEclipseContext context;
	protected String commandId;
	protected Map<String, String> parameters;

	public E4ActionAdapter(IEclipseContext context, String handledMenuId) {
		this.context = context;
		this.parameters = Collections.emptyMap();
		
		MHandledMenuItem menu =  E4Utils.findMenu(handledMenuId, context.get(EModelService.class), context.get(MApplication.class), MHandledMenuItem.class);
		setId(this.commandId = menu.getCommand().getElementId());
		
		String label = menu.getLocalizedLabel();
		TriggerSequence sequence = getTriggerSequence();
		if (sequence != null)
			setText(label+'\t'+sequence.format());
		else
			setText(label);
		
		try {
			setImageDescriptor(ImageDescriptor.createFromURL(new URL(menu.getIconURI())));
		} catch (Exception e) {
		}
	}
	public E4ActionAdapter(IEclipseContext context, String label, String iconURI, String commandId, Map<String, String> parameters, int style) {
		super(label, style);
		initialize(context, iconURI, commandId, parameters);
	}
	public E4ActionAdapter(IEclipseContext context, String label, String iconURI, String commandId, Map<String, String> parameters) {
		super(label);
		initialize(context, iconURI, commandId, parameters);
	}

	protected void initialize(IEclipseContext context, String iconURI, String commandId, Map<String, String> parameters) {
		this.context = context;
		setId(this.commandId = commandId);
		this.parameters = parameters;

		try {
			if (iconURI !=  null)
				setImageDescriptor(ImageDescriptor.createFromURL(new URL(iconURI)));
		} catch (Exception e) {
		}
	}

	protected TriggerSequence getTriggerSequence() {
		return context.get(EBindingService.class).getBestSequenceFor(getCommand());
	}
	protected ParameterizedCommand getCommand() {
		return context.get(ECommandService.class).createCommand(commandId, parameters);
	}

	public void update() {
		ParameterizedCommand command = getCommand();
		if (command == null)
			System.out.println("CommandId: " + commandId);
		setEnabled(context.get(EHandlerService.class).canExecute(command));
	}

	@Override
	public void run() {
		int style = getStyle();
		if ((style == IAction.AS_CHECK_BOX || style == IAction.AS_RADIO_BUTTON) && !isChecked())
			return;

		context.get(EHandlerService.class).executeHandler(getCommand());
	}
}
