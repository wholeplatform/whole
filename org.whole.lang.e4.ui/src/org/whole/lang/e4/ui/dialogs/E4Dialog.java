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
package org.whole.lang.e4.ui.dialogs;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.bindings.EBindingService;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IUIProvider;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.menu.JFaceMenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.status.codebase.StatusTemplate;
import org.whole.lang.ui.actions.IUpdatableAction;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E4Dialog extends Dialog {
	protected E4GraphicalViewer viewer;
	protected ActionRegistry actionRegistry;
	protected IUIProvider<IMenuManager> contextMenuProvider;

	@Inject
	public E4Dialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		super(shell);
	}

	@Inject IEclipseContext context;
	@Inject ESelectionService selectionService;
	@Inject EHandlerService handlerService;
	@Inject ECommandService commandService;
	@Inject EModelService modelService;
	@Inject MApplication application;
	@Inject EBindingService bindingService;

	@Override
	protected Control createDialogArea(Composite parent) {
		//FIXME workaround due to an eclipse compatibility layer bug
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=386329
		// safely delete the following line of code as soon as the compatibility layer is removed 
		context = context.getParent();
		selectionService = context.get(ESelectionService.class);
		handlerService = context.get(EHandlerService.class);
		bindingService = context.get(EBindingService.class);

		viewer = new E4GraphicalViewer(parent);
		viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				selectionService.setSelection(E4Utils.createSelectionBindings(event));
			}
		});
		viewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@SuppressWarnings("unchecked")
			@Override
			public void focusGained(FocusEvent e) {
				context.set(E4GraphicalViewer.class, viewer);
				IBindingManager bm = E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer);
				selectionService.setSelection(bm);
			}
		});

		viewer.setKeyHandler(new E4KeyHandler(context));
		viewer.setEntityContents(createDefaultContents());

		context.set(E4GraphicalViewer.class, viewer);

		actionRegistry = createActionRegistry();
		HandlersBehavior.registerHandlers(handlerService);

		contextMenuProvider = new PopupMenuProvider<IContributionItem, IMenuManager>(new JFaceMenuBuilder(context, actionRegistry));

		viewer.setContextMenu(new ContextMenuProvider(viewer) {
			@Override
			public void buildContextMenu(IMenuManager menuManager) {
				contextMenuProvider.populate(menuManager);
			}
		});
		return parent;
	}

	protected IEntity createDefaultContents() {
		return new StatusTemplate().create();
	}

	protected ActionRegistry createActionRegistry() {
		ActionRegistry actionRegistry = new ActionRegistry(context, getShell());

		IUpdatableAction undoAction = actionRegistry.getAction(EDIT_UNDO);
		ParameterizedCommand command = commandService.createCommand(EDIT_UNDO, null);
		viewer.getKeyHandler().put((KeySequence) bindingService.getBestSequenceFor(command), true, undoAction);

		IUpdatableAction redoAction = actionRegistry.getAction(EDIT_REDO);
		command = commandService.createCommand(EDIT_REDO, null);
		viewer.getKeyHandler().put((KeySequence) bindingService.getBestSequenceFor(command), true, redoAction);

		IUpdatableAction deleteAction = actionRegistry.getAction(EDIT_DELETE);
		command = commandService.createCommand(EDIT_DELETE, null);
		viewer.getKeyHandler().put((KeySequence) bindingService.getBestSequenceFor(command), true, deleteAction);

		return actionRegistry;
	}
}
