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
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.e4.ui.util.E4Utils;

/**
 * @author Enrico Persiani
 */
public class E4ActionAdapter extends AbstractE4Action {
	protected String commandId;
	protected Map<String, Object> parameters;

	public E4ActionAdapter(IEclipseContext context, String handledMenuId) {
		super(context);
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
			String iconURI = menu.getIconURI();
			if (iconURI != null)
				setImageDescriptor(ImageDescriptor.createFromURL(new URL(iconURI)));
		} catch (Exception e) {
		}
	}
	public E4ActionAdapter(IEclipseContext context, String label, String iconURI, String commandId, Map<String, Object> parameters, int style) {
		super(context, label, style);
		initialize(iconURI, commandId, parameters);
	}
	public E4ActionAdapter(IEclipseContext context, String label, String iconURI, String commandId, Map<String, Object> parameters) {
		super(context, label);
		initialize(iconURI, commandId, parameters);
	}

	protected void initialize(String iconURI, String commandId, Map<String, Object> parameters) {
		setId(this.commandId = commandId);
		this.parameters = parameters;

		try {
			if (iconURI !=  null)
				setImageDescriptor(ImageDescriptor.createFromURL(new URL(iconURI)));
		} catch (Exception e) {
		}
	}

	protected TriggerSequence getTriggerSequence() {
		return getContext().get(EBindingService.class).getBestSequenceFor(getCommand());
	}
	protected ParameterizedCommand getCommand() {
		return getContext().get(ECommandService.class).createCommand(commandId, parameters);
	}

	public void update() {
		setEnabled(getContext().get(EHandlerService.class).canExecute(getCommand()));
	}

	@Override
	public void run() {
		int style = getStyle();
		if ((style == IAction.AS_CHECK_BOX || style == IAction.AS_RADIO_BUTTON) && !isChecked())
			return;

		getContext().get(EHandlerService.class).executeHandler(getCommand());
	}
}
