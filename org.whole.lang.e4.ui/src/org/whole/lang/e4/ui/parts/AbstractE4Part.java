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
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuFactoryImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IContextProvider;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.e4.ui.api.IUIProvider;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.menu.JFaceMenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.e4.ui.viewers.IPartFocusListener;
import org.whole.lang.model.IEntity;
import org.whole.lang.status.codebase.EmptyStatusTemplate;
import org.whole.lang.ui.editparts.IEntityPart;

@SuppressWarnings("restriction")
public abstract class AbstractE4Part implements IContextProvider {
	protected IEntityPartViewer viewer;
	protected IMenuManager contextMenu;
	protected ActionRegistry actionRegistry;
	protected IUIProvider<IMenuManager> contextMenuProvider;
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

	public IEclipseContext getContext() {
		return context;
	}
	public ActionRegistry getActionRegistry() {
		return actionRegistry;
	}

	@PostConstruct
	public void createPartControl(Composite parent) {
		//FIXME workaround due to an eclipse compatibility layer bug
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=386329
		// safely delete the following line of code as soon as the compatibility layer is removed 
		context = context.getParent();
		selectionService = context.get(ESelectionService.class);
		handlerService = context.get(EHandlerService.class);
		
		restoreState();

		parent.setLayout(new FillLayout());
		viewer = createEntityViewer(parent);
		viewer.setKeyHandler(new E4KeyHandler(context));

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				setSelection(E4Utils.createSelectionBindings(event));
			}
		});
		viewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				context.remove(IEntityPartViewer.class);
			}

			@Override
			@SuppressWarnings("unchecked")
			public void focusGained(FocusEvent e) {
				context.set(IEntityPartViewer.class, viewer);
				setSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer));
			}
		});
		viewer.addPartFocusListener(new IPartFocusListener() {
			@SuppressWarnings("unchecked")
			public void focusChanged(IEntityPart oldPart, IEntityPart newPart) {
				setSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer));
			}
		});

		viewer.setContents(modelInput, createDefaultContents());
		
		context.set(IEntityPartViewer.class, viewer);
		HandlersBehavior.registerHandlers(handlerService);

		contextMenu = new MenuManager("Whole Context Menu", CONTEXT_MENU_ID);

		actionRegistry = createActionRegistry();
		actionRegistry.registerKeyActions(viewer.getKeyHandler());

		contextMenuProvider = new PopupMenuProvider<IContributionItem, IMenuManager>(new JFaceMenuBuilder(this));
		contextMenuProvider.populate(contextMenu);

		viewer.setContextMenu(new ContextMenuProvider(viewer) {
			@Override
			public void buildContextMenu(IMenuManager menuManager) {
				contextMenuProvider.populate(menuManager);
			}
		});
	}

	protected abstract IEntityPartViewer createEntityViewer(Composite parent);

	protected void setSelection(IBindingManager bm) {
		if (modelInput != null)
			E4Utils.defineResourceBindings(bm, modelInput);
		selectionService.setSelection(bm);
	}

	@Inject
	public void setModelInput(final IModelInput modelInput, IWorkspace workspace) {
		clearListeners();
		if (modelInput != null) {
			workspace.addResourceChangeListener(resourceListener = new IResourceChangeListener() {
				public void resourceChanged(IResourceChangeEvent event) {
					if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
						try {
							event.getDelta().accept(new IResourceDeltaVisitor() {
								public boolean visit(IResourceDelta delta) throws CoreException {
									if (delta.getKind() == IResourceDelta.CHANGED && modelInput.getFile().equals(delta.getResource()) &&
											delta.getMarkerDeltas().length == 0) {
										viewer.setContents(modelInput, null);
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

	@PreDestroy
	public void clearListeners() {
		if (resourceListener != null && this.workspace != null)
			this.workspace.removeResourceChangeListener(resourceListener);
	}

	protected IEntity createDefaultContents() {
		return new EmptyStatusTemplate().create();
	}

	@PersistState
	public void saveState() {
		part.getMenus().clear();
		if (modelInput != null) {
			part.getPersistedState().put("basePersistenceKitId", modelInput.getBasePersistenceKit().getId());
			part.getPersistedState().put("filePath", modelInput.getFile().getFullPath().toPortableString());
		}
	}
	
	protected void restoreState() {
		if (part.getPersistedState().containsKey("basePersistenceKitId")) {
			String basePersistenceKitId = part.getPersistedState().get("basePersistenceKitId");
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromPortableString(part.getPersistedState().get("filePath")));
			context.set(IModelInput.class, modelInput = new ModelInput(file, basePersistenceKitId));
		}
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

	@SuppressWarnings("unchecked")
	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
		setSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer));
	}

	public IEntityPartViewer getViewer() {
		return viewer;
	}

	protected MPopupMenu createContextMenu() {
		MPopupMenu contextMenu = MenuFactoryImpl.eINSTANCE.createPopupMenu();
		contextMenu.setElementId(CONTEXT_MENU_ID);
		return contextMenu;
	}

	protected ActionRegistry createActionRegistry() {
		return new ActionRegistry(context, viewer.getControl());
	}
}
