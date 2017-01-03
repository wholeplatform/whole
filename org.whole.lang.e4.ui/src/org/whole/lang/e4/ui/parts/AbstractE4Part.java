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
package org.whole.lang.e4.ui.parts;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuFactoryImpl;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.actions.E4NavigationKeyHandler;
import org.whole.lang.e4.ui.actions.ILinkViewerListener;
import org.whole.lang.e4.ui.actions.ILinkableSelectionListener;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.input.ModelInput;
import org.whole.lang.e4.ui.menu.JFaceMenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.IUIProvider;
import org.whole.lang.ui.dialogs.LazyConfirmationDialogReloader;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IPartFocusListener;
import org.whole.lang.ui.input.IModelInput;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractE4Part {
	protected IEntityPartViewer viewer;
	protected ActionRegistry actionRegistry;
	protected IUIProvider<IMenuManager> contextMenuProvider;
	protected IResourceChangeListener resourceListener;
	protected ILinkableSelectionListener selectionLinkable;
	protected LazyConfirmationDialogReloader reloader;

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
		restoreState();

		registerHandlers();

		parent.setLayout(new FillLayout());
		viewer = createEntityViewer(parent);

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

			@Override
			@SuppressWarnings("unchecked")
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
			}
		});

		E4KeyHandler keyHandler = new E4KeyHandler(context);
		keyHandler.setParent(new E4NavigationKeyHandler(context));
		context.set(IEntityPartViewer.class, viewer);
		viewer.setKeyHandler(keyHandler);
		viewer.setContents(modelInput, createDefaultContents());		

		actionRegistry = ContextInjectionFactory.make(ActionRegistry.class, context);
		actionRegistry.registerKeyActions(viewer.getKeyHandler());
		context.set(ActionRegistry.class, actionRegistry);

		configureContextMenu();

		if (!E4Utils.isLegacyApplication())
			viewer.getCommandStack().addCommandStackListener(new CommandStackListener() {
				public void commandStackChanged(EventObject event) {
					part.setDirty(viewer.isDirty());
				}
			});

		reloader = new LazyConfirmationDialogReloader(viewer.getControl(), new Runnable() {
			@Override
			public void run() {
				viewer.setContents(modelInput, null);
			}
		});
	}

	protected void registerHandlers() {
		if (E4Utils.isLegacyApplication())
			HandlersBehavior.registerHandlers(handlerService);
	}

	protected abstract IEntityPartViewer createEntityViewer(Composite parent);

	protected void updateSelection(IBindingManager bm) {
		if (modelInput != null)
			E4Utils.defineResourceBindings(bm, modelInput);
		selectionService.setSelection(bm);
		//FIXME workaround selectionService.setSelection(bm); doesn't update the ACTIVE_SELECTION in the active context
		context.set(IServiceConstants.ACTIVE_SELECTION, bm);
	}
	
	protected void configureContextMenu() {
		JFaceMenuBuilder uiBuilder = ContextInjectionFactory.make(JFaceMenuBuilder.class, context);
		contextMenuProvider = new PopupMenuProvider<IContributionItem, IMenuManager>(uiBuilder);

		viewer.setContextMenu(new ContextMenuProvider(viewer) {
			@Override
			public void buildContextMenu(IMenuManager menuManager) {
				try {
					if (!getViewer().getEditDomain().isDisabled())
						contextMenuProvider.populate(menuManager);
				} catch (Exception e) {
					getMenu().setVisible(false);
				}
			}
		});
	}

	@Optional @Inject
	public void setModelInput(final IModelInput modelInput, IWorkspace workspace) {
		clearListeners();
		if (modelInput != null)
			workspace.addResourceChangeListener(resourceListener = new ResourceChangeListener(modelInput));
	}

	@PreDestroy
	public void clearListeners() {
		if (resourceListener != null && this.workspace != null)
			this.workspace.removeResourceChangeListener(resourceListener);

		if (selectionLinkable != null)
			selectionService.removeSelectionListener(selectionLinkable);
	}

	protected IEntity createDefaultContents() {
		return E4Utils.createEmptyStatusContents();
	}

	@PersistState
	public void saveState() {
		part.getMenus().clear();
		if (modelInput != null) {
			part.getPersistedState().put("basePersistenceKitId", modelInput.getBasePersistenceKit().getId());
			part.getPersistedState().put("overridePersistenceKitId", modelInput.getOverridePersistenceKitId());
			part.getPersistedState().put("filePath", modelInput.getLocation());
		}
	}

	protected void restoreState() {
		if (part.getPersistedState().containsKey("basePersistenceKitId")) {
			String basePersistenceKitId = part.getPersistedState().get("basePersistenceKitId");
			IModelInput modelInput = new ModelInput(context, part.getPersistedState().get("filePath"), basePersistenceKitId);
			modelInput.setOverridePersistenceKitId(part.getPersistedState().get("overridePersistenceKitId"));
			updateModelInput(modelInput);
		}
	}

	protected void updateModelInput(IModelInput modelInput) {
		context.set(IModelInput.class, this.modelInput = modelInput);
	}

	@Persist
	public void save() {
		if (modelInput != null) {
			workspace.removeResourceChangeListener(resourceListener);
			IPersistenceProvider pp = modelInput.getPersistenceProvider();
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
		updateSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer, context));
	}
	
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


	@Inject
	@Optional
	protected void syncOutlineSelection(@UIEventTopic(IE4UIConstants.TOPIC_SYNC_OUTLINE_SELECTION) IEntity selectedEntities) {
		if (selectedEntities.wSize()>0 && getViewer().getEditPartRegistry().containsKey(selectedEntities.wGet(0))) {
			List<IEntity> selection = new ArrayList<>();
			for (int i=0, size=selectedEntities.wSize(); i<size; i++)
				selection.add(selectedEntities.wGet(i));
			viewer.selectAndReveal(selection);
		}
	}

	public IEntityPartViewer getViewer() {
		return viewer;
	}

	protected MPopupMenu createContextMenu() {
		MPopupMenu contextMenu = MenuFactoryImpl.eINSTANCE.createPopupMenu();
		contextMenu.setElementId(CONTEXT_MENU_ID);
		return contextMenu;
	}

	public void addLinkViewerListener(ILinkViewerListener listener) { 
		if (this.selectionLinkable != null)
			selectionLinkable.addLinkViewerListener(listener); 
	} 
	public void removeLinkViewerListener(ILinkViewerListener listener) { 
		if (this.selectionLinkable != null)
			selectionLinkable.removeLinkViewerListener(listener); 
	} 

	public void setSelectionLinkable(ILinkableSelectionListener selectionLinkable) {
		if (this.selectionLinkable != null)
			selectionService.removeSelectionListener(this.selectionLinkable);

		this.selectionLinkable = selectionLinkable;

		if (selectionLinkable != null)
			selectionService.addSelectionListener(selectionLinkable);
	}
	public ILinkableSelectionListener getSelectionLinkable() {
		return selectionLinkable;
	}

	protected void reloadContents() {
		context.get(UISynchronize.class).asyncExec(new Runnable() {
			@Override
			public void run() {
				if (viewer.isDirty() && modelInput.getPersistenceProvider() instanceof IFilePersistenceProvider) {
					reloader.schedule(((IFilePersistenceProvider) modelInput.getPersistenceProvider()).getStore());
				} else
					viewer.setContents(modelInput, null);
			}
		});
	}

	public class ResourceChangeListener implements IResourceChangeListener {
		private final IModelInput modelInput;

		public ResourceChangeListener(IModelInput modelInput) {
			this.modelInput = modelInput;
		}

		public void resourceChanged(IResourceChangeEvent event) {
			if (modelInput.getPersistenceProvider() instanceof IFilePersistenceProvider && event.getType() == IResourceChangeEvent.POST_CHANGE) {
				IFile file = ((IFilePersistenceProvider) modelInput.getPersistenceProvider()).getStore();
				IResourceDelta member = event.getDelta().findMember(file.getFullPath());
				if (member == null)
					return;

				if (member.getKind() == IResourceDelta.REMOVED && (member.getFlags() & IResourceDelta.MOVED_TO) != 0) {
					IFile destination = file.getWorkspace().getRoot().getFile(member.getMovedToPath());
					IFilePersistenceProvider pp = new IFilePersistenceProvider(destination);
					ModelInput newModelInput = new ModelInput(context, pp, modelInput.getBasePersistenceKit().getId());
					newModelInput.setOverridePersistenceKitId(modelInput.getOverridePersistenceKitId());
					updateModelInput(newModelInput);
					reloadContents();
				} else if (member.getKind() == IResourceDelta.CHANGED &&  (member.getFlags() & IResourceDelta.CONTENT) != 0) {
					reloadContents();
				}
			}
		}
	}
}
