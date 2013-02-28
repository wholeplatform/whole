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
package org.whole.lang.e4.ui.parts;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.lang.reflect.Field;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuFactoryImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.e4.ui.api.IUIProvider;
import org.whole.lang.e4.ui.command.CommandFactory;
import org.whole.lang.e4.ui.command.ICommandFactory;
import org.whole.lang.e4.ui.menu.E4MenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.reflect.QueriesTemplateManager;
import org.whole.lang.reflect.ReflectionFactory;

@SuppressWarnings("restriction")
public class E4Part {
	protected E4GraphicalViewer viewer;
	protected ICommandFactory commandFactory;
	protected MPopupMenu contextMenu;
	protected ActionRegistry actionRegistry;
	protected IUIProvider<MMenu> contextMenuProvider;

	public E4Part() {
	}

	@Inject IEclipseContext context;
	@Inject ESelectionService selectionService;
	@Inject EHandlerService handlerService;
	@Inject ECommandService commandService;
	@Inject EMenuService menuService;
	@Inject EModelService modelService;
	@Inject MApplication application;
	@Inject MPart part;
	@Optional @Inject IModelInput modelInput;

	private void fixService(Class<?> serviceClass, Object service) {
		try {
			Field contextField = serviceClass.getDeclaredField("context");
			contextField.setAccessible(true);
			contextField.set(service, context);
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	private void fixInjections() {
		context = context.getParent();

		fixService(selectionService.getClass(), selectionService);
		fixService(handlerService.getClass(), handlerService);
	}

	public E4GraphicalViewer getViewer() {
		return viewer;
	}

	@PostConstruct
	public void createPartControl(Composite parent) {
		//FIXME workaround due to an eclipse compatibility layer bug
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=386329
		// safely delete the following line of code as soon as the compatibility layer is removed 
		fixInjections();

		IEntity entity = QueriesTemplateManager.instance().create("FileArtifact generator");

		// use model input if has been injected
		if (modelInput != null) {
			IFilePersistenceProvider pp = new IFilePersistenceProvider(modelInput.getFile());
			try {
				entity = modelInput.getPersistenceKit().readModel(pp);
			} catch (Exception e) {
			}
		}

		parent.setLayout(new FillLayout());
		viewer = new E4GraphicalViewer(parent);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IBindingManager bm = E4Utils.createSelectionBindings(event);
				if (modelInput != null)
					E4Utils.defineResourceBindings(bm, modelInput);
				selectionService.setSelection(bm);
			}
		});
		viewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				context.remove(E4GraphicalViewer.class);
			}

			@Override
			public void focusGained(FocusEvent e) {
				context.set(E4GraphicalViewer.class, viewer);
			}
		});
		viewer.setKeyHandler(new E4KeyHandler());
		viewer.setContents(entity);
		viewer.setInteractive(entity, true, true, true);
		viewer.flush();

		ReflectionFactory.getHistoryManager(entity).setHistoryEnabled(true);
		context.set(E4GraphicalViewer.class, viewer);

		E4Utils.registerCommands(handlerService, application, commandFactory = new CommandFactory());

		part.getMenus().add(contextMenu = createContextMenu());
		menuService.registerContextMenu(viewer.getControl(), CONTEXT_MENU_ID);

		actionRegistry = createActionRegistry();
		contextMenuProvider = new PopupMenuProvider<MMenuElement, MMenu>(new E4MenuBuilder(context, actionRegistry));
		contextMenuProvider.populate(contextMenu);

		viewer.getControl().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent event) {
				if (event.button == 3) {
					//FIXME workaround for an Eclipse bug that doesn't rebuild correctly the menu
					E4Utils.forceRender(context, contextMenu);
					viewer.getControl().removeMouseListener(this);
				}
			}
		});
	}

	@PersistState
	public void saveState() {
		part.getMenus().clear();
	}

	@Persist
	public void save() {
		if (modelInput != null) {
			IFilePersistenceProvider pp = new IFilePersistenceProvider(modelInput.getFile());
			try {
				RootFragment rootFragment = (RootFragment) viewer.getContents().getModel();
				modelInput.getPersistenceKit().writeModel(rootFragment.wGetRoot(), pp);
				viewer.getCommandStack().markSaveLocation();
				part.setDirty(false);
			} catch (Exception e) {
			}
		}
	}

	protected MPopupMenu createContextMenu() {
		MPopupMenu contextMenu = MenuFactoryImpl.eINSTANCE.createPopupMenu();
		contextMenu.setElementId(CONTEXT_MENU_ID);
		return contextMenu;
	}

	protected ActionRegistry createActionRegistry() {
		return new ActionRegistry(context);
	}
	
	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
