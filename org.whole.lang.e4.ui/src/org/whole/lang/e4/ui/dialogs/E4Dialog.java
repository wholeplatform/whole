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

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
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
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.e4.ui.viewers.IPartFocusListener;
import org.whole.lang.model.IEntity;
import org.whole.lang.status.codebase.ErrorStatusTemplate;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
public class E4Dialog extends Dialog {
	protected IEntityPartViewer viewer;
	protected ActionRegistry actionRegistry;
	protected IUIProvider<IMenuManager> contextMenuProvider;

	@Inject
	public E4Dialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		super(shell);
	}

	@Inject	protected IEclipseContext context;
	@Inject protected ESelectionService selectionService;
	@Inject	protected EHandlerService handlerService;
	@Inject	protected EModelService modelService;
	@Inject	protected MApplication application;

	@Override
	protected Control createDialogArea(Composite parent) {
		HandlersBehavior.registerHandlers(handlerService);

		viewer = new E4GraphicalViewer(parent);
		viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelection(E4Utils.createSelectionBindings(event));
			}
		});
		viewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent event) {
				context.remove(IEntityPartViewer.class);
				context.remove(ActionRegistry.class);
			}

			@SuppressWarnings("unchecked")
			@Override
			public void focusGained(FocusEvent event) {
				context.set(IEntityPartViewer.class, viewer);
				context.set(ActionRegistry.class, actionRegistry);
				updateSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer));
			}
		});
		viewer.addPartFocusListener(new IPartFocusListener() {
			@SuppressWarnings("unchecked")
			public void focusChanged(IEntityPart oldPart, IEntityPart newPart) {
				updateSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer));
			}
		});

		viewer.setKeyHandler(new E4KeyHandler(context));
		viewer.setEntityContents(createDefaultContents());
		context.set(IEntityPartViewer.class, viewer);

		actionRegistry = ContextInjectionFactory.make(ActionRegistry.class, context);
		actionRegistry.registerWorkbenchActions();
		context.set(ActionRegistry.class, actionRegistry);

		JFaceMenuBuilder uiBuilder = ContextInjectionFactory.make(JFaceMenuBuilder.class, context);
		contextMenuProvider = new PopupMenuProvider<IContributionItem, IMenuManager>(uiBuilder);

		viewer.setContextMenu(new ContextMenuProvider(viewer) {
			@Override
			public void buildContextMenu(IMenuManager menuManager) {
				contextMenuProvider.populate(menuManager);
			}
		});
		return parent;
	}

	protected void updateSelection(IBindingManager bm) {
		selectionService.setSelection(bm);
	}

	protected IEntity createDefaultContents() {
		return new ErrorStatusTemplate().create();
	}
}
