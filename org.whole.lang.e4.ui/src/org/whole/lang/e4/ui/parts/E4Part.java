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

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
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
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.menu.E4MenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.e4.ui.viewers.IPartFocusListener;
import org.whole.lang.model.IEntity;
import org.whole.lang.status.codebase.StatusTemplate;
import org.whole.lang.ui.editparts.IEntityPart;

@SuppressWarnings("restriction")
public class E4Part {
	protected E4GraphicalViewer viewer;
	protected MPopupMenu contextMenu;
	protected ActionRegistry actionRegistry;
	protected IUIProvider<MMenu> contextMenuProvider;
	protected IResourceChangeListener resourceListener;
	
	@Inject IEclipseContext context;
	@Inject ESelectionService selectionService;
	@Inject EHandlerService handlerService;
	@Inject ECommandService commandService;
	@Inject EMenuService menuService;
	@Inject EModelService modelService;
	@Inject MApplication application;
	@Inject MPart part;
	@Optional @Inject IModelInput modelInput;
	@Inject IWorkspace workspace;

	@PostConstruct
	public void createPartControl(Composite parent) {
		//FIXME workaround due to an eclipse compatibility layer bug
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=386329
		// safely delete the following line of code as soon as the compatibility layer is removed 
		context = context.getParent();
		selectionService = context.get(ESelectionService.class);
		handlerService = context.get(EHandlerService.class);


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
		viewer.addPartFocusListener(new IPartFocusListener() {
			@SuppressWarnings("unchecked")
			public void focusChanged(IEntityPart oldPart, IEntityPart newPart) {
				IBindingManager bm = E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer);
				if (modelInput != null)
					E4Utils.defineResourceBindings(bm, modelInput);
				selectionService.setSelection(bm);
			}
		});
		viewer.setKeyHandler(new E4KeyHandler(context));

		viewer.setContents(modelInput, createDefaultContents());

		context.set(E4GraphicalViewer.class, viewer);
		HandlersBehavior.registerHandlers(handlerService);

		part.getMenus().add(contextMenu = createContextMenu());
		menuService.registerContextMenu(viewer.getControl(), CONTEXT_MENU_ID);

		actionRegistry = createActionRegistry();
		actionRegistry.registerKeyActions(viewer.getKeyHandler());

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

		if (modelInput != null) {
			workspace.addResourceChangeListener(resourceListener = new IResourceChangeListener() {
				public void resourceChanged(IResourceChangeEvent event) {
					if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
						try {
							event.getDelta().accept(new IResourceDeltaVisitor() {
								public boolean visit(IResourceDelta delta) throws CoreException {
									if (delta.getKind() == IResourceDelta.CHANGED && modelInput.getFile().equals(delta.getResource()) &&
											delta.getMarkerDeltas().length == 0) {
										viewer.setContents(modelInput, createDefaultContents());
										return false;
									} else
										return true;
								}
							});
						} catch (CoreException e) {
						}
					}
				}
			});
		}
	}

	protected IEntity createDefaultContents() {
		return new StatusTemplate().create();
	}

	@PersistState
	public void saveState() {
		part.getMenus().clear();
	}

	@Persist
	public void save() {
		if (modelInput != null) {
			workspace.removeResourceChangeListener(resourceListener);
			IFilePersistenceProvider pp = new IFilePersistenceProvider(modelInput.getFile());
			try {
				RootFragment rootFragment = (RootFragment) viewer.getContents().getModel();
				modelInput.getPersistenceKit().writeModel(rootFragment.wGetRoot(), pp);
				viewer.getCommandStack().markSaveLocation();
				part.setDirty(false);
			} catch (Exception e) {
			} finally {
				workspace.addResourceChangeListener(resourceListener);
			}
		}
	}

	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public E4GraphicalViewer getViewer() {
		return viewer;
	}

	protected MPopupMenu createContextMenu() {
		MPopupMenu contextMenu = MenuFactoryImpl.eINSTANCE.createPopupMenu();
		contextMenu.setElementId(CONTEXT_MENU_ID);
		return contextMenu;
	}

	protected ActionRegistry createActionRegistry() {
		return new ActionRegistry(context);
	}
}
