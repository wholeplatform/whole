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
package org.whole.lang.e4.ui.dialogs;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
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
import org.whole.lang.e4.ui.actions.E4NavigationKeyHandler;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.menu.JFaceMenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.IUIProvider;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IPartFocusListener;
import org.whole.lang.ui.viewers.IEntityPartViewer;

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

	@Inject
	@Optional
	protected void refreshViewer(@UIEventTopic(IE4UIConstants.TOPIC_REFRESH_VIEWER) IEntity source) {
		if (source == null)
			getViewer().refreshNotation();
		else if (source.wGetModel() == getViewer().getEntityContents().wGetModel())
			getViewer().refreshNotation(source);
	}

	@Inject
	@Optional
	protected void rebuildViewer(@UIEventTopic(IE4UIConstants.TOPIC_REBUILD_VIEWER) IEntity source) {
		if (source == null)
			getViewer().rebuildNotation();
		else if (source.wGetModel() == getViewer().getEntityContents().wGetModel())
			getViewer().rebuildNotation(source);
	}

	@Inject
	@Optional
	protected void rebuildViewerConditional(@UIEventTopic(IE4UIConstants.TOPIC_REBUILD_VIEWER_CONDITIONAL) String resourceUri) {
		if (getViewer().getReferencedResources().contains(resourceUri))
			getViewer().rebuildNotation();
	}

	public IEntityPartViewer getViewer() {
		return viewer;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		if (E4Utils.isLegacyApplication())
			HandlersBehavior.registerHandlers(handlerService);

		IEclipseContext params = EclipseContextFactory.create();
		params.set("parent", parent);
		viewer = ContextInjectionFactory.make(E4GraphicalViewer.class, context, params);
		viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelection(E4Utils.createSelectionBindings(event, context));
			}
		});
		viewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent event) {
			}

			@SuppressWarnings("unchecked")
			@Override
			public void focusGained(FocusEvent event) {
				context.set(IEntityPartViewer.class, viewer);
				context.set(ActionRegistry.class, actionRegistry);
				updateSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer, context));
			}
		});
		viewer.addPartFocusListener(new IPartFocusListener() {
			@SuppressWarnings("unchecked")
			public void focusChanged(IEntityPart oldPart, IEntityPart newPart) {
				updateSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer, context));
				context.activateBranch();
			}
		});

		E4KeyHandler keyHandler = new E4KeyHandler(context);
		keyHandler.setParent(new E4NavigationKeyHandler(context));
		context.set(IEntityPartViewer.class, viewer);
		viewer.setKeyHandler(keyHandler);
		viewer.setEntityContents(createDefaultContents());

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

	@PostConstruct
	@Override
	public int open() {
		return super.open();
	}

	protected void updateSelection(IBindingManager bm) {
		selectionService.setSelection(bm);
		//FIXME workaround selectionService.setSelection(bm); doesn't update the ACTIVE_SELECTION in the active context
		context.set(IServiceConstants.ACTIVE_SELECTION, bm);
	}

	protected IEntity createDefaultContents() {
		return E4Utils.createErrorStatusContents();
	}
}
