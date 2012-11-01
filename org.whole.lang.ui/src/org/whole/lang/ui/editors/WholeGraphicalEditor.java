/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.editors;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gef.tools.PanningSelectionTool;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleRulerVisibilityAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gef.ui.parts.SelectionSynchronizer;
import org.eclipse.gef.ui.rulers.RulerComposite;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.GestureEvent;
import org.eclipse.swt.events.GestureListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.impl.RootFragmentImpl;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistryListener;
import org.whole.lang.ui.ProblemsImageDecorator;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.actions.FeedbackVisibilityAction;
import org.whole.lang.ui.actions.GlobalActionProxy;
import org.whole.lang.ui.actions.GlobalActionRegistry;
import org.whole.lang.ui.actions.RevertToSavedAction;
import org.whole.lang.ui.actions.WholeActionFactory;
import org.whole.lang.ui.dialogs.SaveAsModelDialog;
import org.whole.lang.ui.dnd.PaletteTransferDropListener;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.feedback.FeedbackRulerComposite;
import org.whole.lang.ui.palette.WholePaletteCustomizer;
import org.whole.lang.ui.palette.WholePaletteFactory;
import org.whole.lang.ui.ruler.WholeRuler;
import org.whole.lang.ui.ruler.WholeRulerProvider;
import org.whole.lang.ui.templates.IUITemplate;
import org.whole.lang.ui.util.MarkerUtils;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.ui.views.WholeEditDomain;
import org.whole.lang.ui.views.WholeGraphicalViewer;
import org.whole.lang.ui.views.properties.tabbed.WholeTabbedPropertySheetPage;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeGraphicalEditor extends GraphicalEditorWithFlyoutPalette implements ITabbedPropertySheetPageContributor, IGotoMarker {
	private KeyHandler sharedKeyHandler;
	private boolean savePreviouslyNeeded = false;

	private WholeActionFactory actionFactory = new WholeActionFactory();

	private ProblemsImageDecorator problemsImageDecorator = new ProblemsImageDecorator();

	public WholeGraphicalEditor() {
		WholeEditDomain editDomain = new WholeEditDomain(this);
		editDomain.setActiveTool(new PanningSelectionTool());
		setEditDomain(editDomain);
	}

	private RulerComposite rulerComposite;
	protected Control getGraphicalControl() {
		return rulerComposite;
	}
	protected void createGraphicalViewer(Composite parent) {
		rulerComposite = new FeedbackRulerComposite(parent, SWT.NONE);

		final WholeGraphicalViewer viewer = new WholeGraphicalViewer(rulerComposite, getEditDomain(), this, getActionRegistry());
		setGraphicalViewer(viewer);
		configureGraphicalViewer();
		hookGraphicalViewer();
		initializeGraphicalViewer();

		rulerComposite.setGraphicalViewer((ScrollingGraphicalViewer) getGraphicalViewer());
		
		viewer.getControl().addGestureListener(createGestureListener(viewer));
		
		//TODO test only
		getResourceRegistryListener();
	}

	protected double initialZoomLevel;
	protected GestureListener createGestureListener(
			final WholeGraphicalViewer viewer) {
		return new GestureListener() {
			
			public void gesture(GestureEvent e) {
				final ScalableRootEditPart root = (ScalableRootEditPart) viewer.getRootEditPart();
				final ZoomManager zoomManager = root.getZoomManager();

				switch (e.detail) {
				case SWT.GESTURE_BEGIN:
					initialZoomLevel = zoomManager.getZoom();
					break;
				case SWT.GESTURE_MAGNIFY:
					double targetZoomLevel = initialZoomLevel * e.magnification;

					if (Math.abs((Math.rint(targetZoomLevel) - targetZoomLevel)) < 0.03d)
						targetZoomLevel = Math.rint(targetZoomLevel);
					else if (Math.abs((Math.rint(targetZoomLevel + .5d) - targetZoomLevel - .5d)) < 0.03d)
						targetZoomLevel = Math.rint(targetZoomLevel + .5d) - .5d;

					zoomManager.setZoom(targetZoomLevel);
					zoomManager.getViewport().getUpdateManager().performUpdate();
					break;
				}
			}
		};
	}

	private Set<String> referencedResources = new HashSet<String>();
	public Set<String> getReferencedResources() {
		return referencedResources;
	}

	private IResourceRegistryListener<ILanguageKit> resourceRegistryListener;
	public IResourceRegistryListener<ILanguageKit> getResourceRegistryListener() {
		if (resourceRegistryListener == null) {
			ReflectionFactory.getLanguageKitRegistry().addResourceRegistryListener(
					resourceRegistryListener = createResourceRegistryListener());
		}
		return resourceRegistryListener;
	}
	protected IResourceRegistryListener<ILanguageKit> createResourceRegistryListener() {
		return new IResourceRegistryListener<ILanguageKit>() {
			public void notifyAdded(ILanguageKit resource) {
				rebuildNotationIfNeeded(resource);
			}
			public void notifyRemoved(ILanguageKit resource) {
				rebuildNotationIfNeeded(resource);
			}
			public void notifyChanged(ILanguageKit oldResource, ILanguageKit newResource) {
				rebuildNotationIfNeeded(newResource);
			}
			protected void rebuildNotationIfNeeded(final ILanguageKit resource) {
				if (getReferencedResources().contains(resource.getURI()))
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						public void run() {
							((WholeGraphicalViewer) getGraphicalViewer()).rebuildNotation();
						}
					});
			}
		};
	}
	protected void disposeLanguageKitRegistryListener() {
		if (resourceRegistryListener != null)
			ReflectionFactory.getLanguageKitRegistry().removeResourceRegistryListener(resourceRegistryListener);
	}

	private StatusPageHandler statusPageHandler;
	private IStatus status;
	protected IStatus getStatus() {
		return status;
	}
	protected void setStatus(IStatus status) {
		this.status = status;
		if (statusPageHandler != null)
			statusPageHandler.setStatus(status);
	}
	@Override
	public void createPartControl(Composite parent) {
		statusPageHandler = new StatusPageHandler(parent, new Runnable() {
			public void run()  {
				IEntity model = readModel(getEditorInput());
				if (getStatus().isOK()) {
					getGraphicalViewer().setContents(model);
					ReflectionFactory.getHistoryManager(model).setHistoryEnabled(true);

					getSite().getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							ContentOutline part = (ContentOutline) WholeUIPlugin.findView("org.eclipse.ui.views.ContentOutline");
							if (part != null)
								part.partActivated(WholeGraphicalEditor.this);
						}
					});
				}
			}
		});
		super.createPartControl(statusPageHandler.getEditorContainer());
		statusPageHandler.setStatus(getStatus());
	}

	public String getContributorId() {
		return WholeGraphicalEditor.class.getName();//getSite().getId();
	}

	public void commandStackChanged(EventObject event) {
		if (isDirty()) {
			if (!savePreviouslyNeeded()) {
				setSavePreviouslyNeeded(true);
				firePropertyChange(IEditorPart.PROP_DIRTY);
			}
		} else {
			setSavePreviouslyNeeded(false);
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		super.commandStackChanged(event);
	}

	@SuppressWarnings("unchecked")
	protected void createActions() {
		super.createActions();

		ActionRegistry registry = getActionRegistry();

		RevertToSavedAction action = new RevertToSavedAction(this);
		getPropertyActions().add(action.getId());
		registry.registerAction(action);

		for(IConfigurationElement element : GlobalActionRegistry.getGlobalActionConfigurations()) {
			GlobalActionProxy proxy = GlobalActionRegistry.createGlobalActionProxy(this, element);
			if (proxy != null) {
				registry.registerAction(proxy);
				getSelectionActions().add(proxy.getId());
			}
		}

		WholeActionFactory.addSelectionActions(
				(IWorkbenchPart) this, actionFactory, registry, getSelectionActions());
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == IContentOutlinePage.class)
			return getOutlinePage();
		if (type == ZoomManager.class)
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (type == IPropertySheetPage.class)
			return new WholeTabbedPropertySheetPage(this);
		if (type == IGotoMarker.class)
			return this;
		return super.getAdapter(type);
	}

	@Override
	protected WholeEditDomain getEditDomain() {
		return (WholeEditDomain) super.getEditDomain();
	}

	protected SelectionSynchronizer synchronizer;
	protected SelectionSynchronizer getSelectionSynchronizer() {
		if (synchronizer == null) {
			synchronizer = new SelectionSynchronizer() {
				@Override
				protected EditPart convert(EditPartViewer viewer, EditPart part) {
					EditPart mappedPart = super.convert(viewer, part);
					if (mappedPart instanceof GraphicalEditPart &&!((GraphicalEditPart)mappedPart).getFigure().isShowing())
						mappedPart = null;
					return mappedPart;
				}
			};
		}
		return synchronizer;
	}

	private WholeOutlinePage outlinePage;
	protected boolean hasOutlinePage() {
		return outlinePage != null && outlinePage.isValid(); //FIXME remove lazy construction & isValid workaround???
	}
	protected WholeOutlinePage getOutlinePage() {
		if (getStatus().isOK() && outlinePage == null)
			outlinePage = new WholeOutlinePage((WholeGraphicalViewer) getGraphicalViewer(), getSelectionSynchronizer());
		return outlinePage;
	}

	public static void incrementalZoom(final ZoomManager zoomManager, final double targetZoomLevel, final double zoomIncrement) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				double zoom = zoomManager.getZoom();
				while (zoomIncrement > 0 ? zoom < targetZoomLevel : zoom > targetZoomLevel) {
					zoom += zoomIncrement;
					if (zoomIncrement > 0 ? zoom > targetZoomLevel : zoom < targetZoomLevel)
						zoom = targetZoomLevel;
					zoomManager.setZoom(zoom);
					zoomManager.getViewport().getUpdateManager().runWithUpdate(this);
					zoomManager.getViewport().getUpdateManager().performUpdate();
				}
			}
		});
	}

	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		ScrollingGraphicalViewer viewer = (ScrollingGraphicalViewer) getGraphicalViewer();
		//		ScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();
		//		viewer.setRootEditPart(root);
		ScalableRootEditPart root = (ScalableRootEditPart) viewer.getRootEditPart();

		// createZoomActions
		List<String> zoomLevels = new ArrayList<String>(3);
		zoomLevels.add(ZoomManager.FIT_ALL);
		zoomLevels.add(ZoomManager.FIT_WIDTH);
		zoomLevels.add(ZoomManager.FIT_HEIGHT);
		ZoomManager zoomManager = root.getZoomManager();
		zoomManager.setZoomLevelContributions(zoomLevels);
		zoomManager.setZoomAnimationStyle(ZoomManager.ANIMATE_ZOOM_IN_OUT);

		IAction zoomInAction = new ZoomInAction(zoomManager) {
			@Override
			public void run() {
				final ZoomManager zoomManager = this.zoomManager;
				final double targetZoomLevel = zoomManager.getNextZoomLevel();
				final double zoomIncrement = (targetZoomLevel - zoomManager.getZoom()) / 6;
				incrementalZoom(zoomManager, targetZoomLevel, zoomIncrement);
			}

		};
		IAction zoomOutAction = new ZoomOutAction(zoomManager) {
			@Override
			public void run() {
				final ZoomManager zoomManager = this.zoomManager;
				final double targetZoomLevel = zoomManager.getPreviousZoomLevel();
				final double zoomIncrement = (targetZoomLevel - zoomManager.getZoom()) / 6;
				incrementalZoom(zoomManager, targetZoomLevel, zoomIncrement);
			}
		};
		getActionRegistry().registerAction(zoomInAction);
		getActionRegistry().registerAction(zoomOutAction);

		IHandlerService service = (IHandlerService) getEditorSite().getService(IHandlerService.class);
		service.activateHandler(zoomInAction.getActionDefinitionId(), new ActionHandler(zoomInAction));
		service.activateHandler(zoomOutAction.getActionDefinitionId(), new ActionHandler(zoomOutAction));

		//TODO load properties
//		viewer.setProperty(FeedbackConstants.VERTICAL_VISIBILITY, Boolean.TRUE);
//		viewer.setProperty(FeedbackConstants.HORIZONTAL_VISIBILITY, Boolean.TRUE);
//		viewer.setProperty(FeedbackConstants.VERTICAL_MODEL, CommonsEntityFactory.instance.createQuantifier());
//		viewer.setProperty(FeedbackConstants.HORIZONTAL_MODEL, CommonsEntityFactory.instance.createQuantifier());

		viewer.setProperty(RulerProvider.PROPERTY_VERTICAL_RULER, 
				new WholeRulerProvider(new WholeRuler(false)));
		viewer.setProperty(RulerProvider.PROPERTY_HORIZONTAL_RULER, 
				new WholeRulerProvider(new WholeRuler(true)));
		viewer.setProperty(RulerProvider.PROPERTY_RULER_VISIBILITY, Boolean.FALSE);
		viewer.setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, Boolean.TRUE);
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, Boolean.FALSE);
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, Boolean.FALSE);

		getActionRegistry().registerAction(new ToggleRulerVisibilityAction(viewer));
		getActionRegistry().registerAction(new ToggleSnapToGeometryAction(viewer));
		getActionRegistry().registerAction(new ToggleGridAction(viewer));
		
		getActionRegistry().registerAction(new FeedbackVisibilityAction.Both(viewer));
		getActionRegistry().registerAction(new FeedbackVisibilityAction.Vertical(viewer));
		getActionRegistry().registerAction(new FeedbackVisibilityAction.Horizontal(viewer));
		getActionRegistry().registerAction(new FeedbackVisibilityAction.None(viewer));
		
		getSite().registerContextMenu(viewer.getContextMenu(), viewer);
	}

	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();

		if (modelToSet != null) {
			viewer.setContents(modelToSet);
			modelToSet = null;
		} else
			assert viewer.getContents() != null;

		viewer.addDropTargetListener(new PaletteTransferDropListener(viewer));
	}

	protected FigureCanvas getEditor() {
		return (FigureCanvas) getGraphicalViewer().getControl();
	}

	protected void setSite(IWorkbenchPartSite site){
		super.setSite(site);
		getSite().getWorkbenchWindow().getPartService().addPartListener(partListener);
	}

	public void dispose() {
		disposeLanguageKitRegistryListener();

		IWorkbenchPartSite partSite = getSite();
		if (partSite != null)
			partSite.getWorkbenchWindow().getPartService().removePartListener(partListener);
		partListener = null;
		if (getEditorInput() instanceof IFileEditorInput)
			((IFileEditorInput) getEditorInput()).getFile().getWorkspace().removeResourceChangeListener(resourceListener);
		super.dispose();
	}

	protected KeyHandler getCommonKeyHandler() {
		if (sharedKeyHandler == null) {
			sharedKeyHandler = new KeyHandler();
			sharedKeyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));
		}
		return sharedKeyHandler;
	}

	public boolean isDirty() {
		return isSaveOnCloseNeeded();
	}

	public boolean isSaveAsAllowed() {
		return true;
	}

	public boolean isSaveOnCloseNeeded() {
		return getCommandStack().isDirty();
	}

	private boolean savePreviouslyNeeded() {
		return savePreviouslyNeeded;
	}

	private void setSavePreviouslyNeeded(boolean value) {
		savePreviouslyNeeded = value;
	}

	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		setPartName(input.getName());
	}

	public void doRevertToSaved() {
		try {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			workbench.getActiveWorkbenchWindow().run(true, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					workbench.getDisplay().syncExec(new Runnable() {
						public void run() {
							setInput(getEditorInput());
							getCommandStack().flush();
						}
					});
				}
			});
		} catch (Exception e) {
		}
	}

	private IEntity modelToSet;
	protected void setInput(IEditorInput input) {
		superSetInput(input);

		IEntity newModel = new RootFragmentImpl(readModel(input));

		IEntity oldModelRoot = getRootEntity();
		if (oldModelRoot != null)
			((InternalIEntity) newModel).wSetModel(oldModelRoot.wGetModel());

		//TODO uncomment when the GEF command stack will be replaced
		//		IHistoryManager historyManager = ReflectionFactory.getHistoryManager(newModel);
		//		historyManager.clearHistory();
		//		historyManager.setHistoryCapacity(1024);
		//		historyManager.setHistoryEnabled(true);

		if (!editorSaving) {
			ReflectionFactory.getHistoryManager(newModel).setHistoryEnabled(true);
			if (getGraphicalViewer() != null) {
				getGraphicalViewer().setContents(newModel);
				if (hasOutlinePage())
					getOutlinePage().setContents(newModel);
			} else
				modelToSet = newModel;
		}

	}
	protected void superSetInput(IEditorInput input) {
		IEditorInput editorInput = getEditorInput();
		if (editorInput != null && editorInput instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) editorInput).getFile();
			file.getWorkspace().removeResourceChangeListener(resourceListener);
		}

		super.setInput(input);

		if (input instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) input).getFile();
			file.getWorkspace().addResourceChangeListener(resourceListener);
			setPartName(file.getName());
		}
	}

	public void doSave(IProgressMonitor monitor) {
		try {
			editorSaving = true;
			IEditorInput editorInput = getEditorInput();
			IFile file = ResourceUtils.getFile(editorInput);

			writeModel(getRootEntity(), file, getPersistenceKit());

			getCommandStack().markSaveLocation();
		} 
		catch (Exception e) {
			WholeUIPlugin.log(e);
			MessageDialog.openError(getSite().getShell(), "Write Model errors", StringUtils.errorMessage(e));
		} finally {
			editorSaving = false;
		}
	}

	public void doSaveAs() {
		performSaveAs();
	}

	protected boolean performSaveAs() {
		final IEntity rootEntity = getRootEntity();
		SaveAsModelDialog dialog = new SaveAsModelDialog(
				getSite().getWorkbenchWindow().getShell(),
				rootEntity.wGetLanguageKit(),
				getPersistenceKit());
		IEditorInput editorInput = getEditorInput();
		dialog.setOriginalFile(((IFileEditorInput) editorInput).getFile());
		dialog.open();

		IPath path = dialog.getResult();
		if (path == null)
			return false;

		final IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		setPersistenceKit(persistenceKit);

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IFile file = workspace.getRoot().getFile(path);

		try {
			writeModel(rootEntity, file, persistenceKit);

			IDE.setDefaultEditor(file, ReflectionFactory.getEditorIdFromPersistenceKit(persistenceKit));
		} catch (Exception e) {
			WholeUIPlugin.log(e);
			MessageDialog.openError(getSite().getShell(), "Write Model errors", StringUtils.errorMessage(e));
		}

		try {
			superSetInput(new FileEditorInput(file));
			getCommandStack().markSaveLocation();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		return true;
	}

	protected void closeEditor(boolean save) {
		getSite().getPage().closeEditor(this, save);
	}

	private ResourceTracker resourceListener = new ResourceTracker();
	private boolean editorSaving = false;
	private IPartListener partListener = new IPartListener() {
		// If an open, unsaved file was deleted, query the user to either do a "Save As"
		// or close the editor.
		public void partActivated(IWorkbenchPart part) {
			if (part != WholeGraphicalEditor.this)
				return;
			if (getEditorInput() instanceof IFileEditorInput &&
					!((IFileEditorInput) getEditorInput()).getFile().exists()) {
				Shell shell = getSite().getShell();
				String title = "File Deleted";
				String message = "The file has been deleted from the file system.  Do you want to save your changes or close the editor without saving?";
				String[] buttons = { "Save", "Close" };
				MessageDialog dialog = new MessageDialog(shell, title, null, message, MessageDialog.QUESTION, buttons, 0);			
				if (dialog.open() == 0) {
					if (!performSaveAs())
						partActivated(part);
				} 
				else {
					closeEditor(false);
				}
			}
		}
		public void partBroughtToTop(IWorkbenchPart part) {}
		public void partClosed(IWorkbenchPart part) {}
		public void partDeactivated(IWorkbenchPart part) {}
		public void partOpened(IWorkbenchPart part) {}
	};

	class ResourceTracker implements IResourceChangeListener, IResourceDeltaVisitor {
		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				if (delta != null)
					delta.accept(this);
			} 
			catch (CoreException exception) {
				// What should be done here?
			}
		}	
		public boolean visit(IResourceDelta delta) { 
			if (delta == null || (getEditorInput() instanceof IFileEditorInput
					&& !delta.getResource().equals(((IFileEditorInput) getEditorInput()).getFile())))
				return true;

			if (delta.getKind() == IResourceDelta.REMOVED) {
				Display display = getSite().getShell().getDisplay();
				if ((IResourceDelta.MOVED_TO & delta.getFlags()) == 0) { // if the file was deleted
					// NOTE: The case where an open, unsaved file is deleted is being handled by the 
					// PartListener added to the Workbench in the initialize() method.
					display.asyncExec(new Runnable() {
						public void run() {
							if (!isDirty()) 
								closeEditor(false); 
						}
					});
				} else { // else if it was moved or renamed
					final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(delta.getMovedToPath());
					display.asyncExec(new Runnable() {
						public void run() {
							superSetInput(new FileEditorInput(newFile));
						}
					});
				}
			} else if (delta.getKind() == IResourceDelta.CHANGED) {
				if (!editorSaving) {
					final IFile newFile = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(delta.getFullPath());
					Display display = getSite().getShell().getDisplay();
					if ((IResourceDelta.MARKERS & delta.getFlags()) == IResourceDelta.MARKERS) {
						display.asyncExec(new Runnable() {
							public void run() {
								firePropertyChange(IWorkbenchPart.PROP_TITLE);
							}
						});
					} else {
						// the file was overwritten somehow (could have been replaced by another 
						// version in the respository)
						display.asyncExec(new Runnable() {
							public void run() {
								setInput(new FileEditorInput(newFile));
								getCommandStack().flush();
							}
						});
					}
				}
			}
			return false; 
		}
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		//selection is updated from fillContextMenu except for originalActions (canc,...)
		super.selectionChanged(part, selection);

		updatePalette(selection);
	}

	protected void updatePalette(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object first = structuredSelection.getFirstElement();
				if (first instanceof IEntityPart) {
					IEntity selectedEntity = ((IEntityPart) first).getModelEntity();

					IEditorKit editorKit = selectedEntity.wGetEditorKit();
					if (editorKit instanceof IGEFEditorKit) {
						IUITemplate template = ((IGEFEditorKit) editorKit).getUITemplate(selectedEntity.wGetLanguageKit());
						WholePaletteFactory.ensurePaletteTemplate(getPaletteRoot(), template);
					}
				}
			}
		}
	}


	private static PaletteRoot paletteRoot;
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null)
			paletteRoot = WholePaletteFactory.createPalette();
		return paletteRoot;
	}
	protected FlyoutPreferences getPalettePreferences() {
		return WholePaletteFactory.createPalettePreferences();
	}
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				viewer.setCustomizer(new WholePaletteCustomizer());
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
			//			private IMenuListener menuListener;
			//			protected void hookPaletteViewer(PaletteViewer viewer) {
			//				super.hookPaletteViewer(viewer);
			//				final CopyTemplateAction copy = (CopyTemplateAction)
			//				final ModelCopyAction copy = (ModelCopyAction)
			//					getActionRegistry().getAction(ActionFactory.COPY.getId());
			//				viewer.addSelectionChangedListener(copy);
			//				if (menuListener == null)
			//					menuListener = new IMenuListener() {
			//						public void menuAboutToShow(IMenuManager manager) {
			//							manager.appendToGroup(GEFActionConstants.GROUP_COPY, copy);
			//						}
			//					};
			//				viewer.getContextMenu().addMenuListener(menuListener);
			//			}
		};
	}


	public IEntity createEmptyModel() {
		if (ReflectionFactory.getLanguageKits(false).size() > 0)
			return ReflectionFactory.getLanguageKit(CommonsLanguageKit.URI).getTemplateManager().createEmpty();
		else
			return null;
	}

	private IPersistenceKit persistenceKit;
	protected IPersistenceKit getPersistenceKit() {
		if (persistenceKit == null) {
			String editorId = getSite().getId();
			persistenceKit = ReflectionFactory.getPersistenceKitFromEditorId(editorId);
		}
		return persistenceKit;
	}
	protected void setPersistenceKit(IPersistenceKit persistenceKit) {
		this.persistenceKit = persistenceKit;
	}

	protected IEntity readModel(IEditorInput input) {
		IEntity model = CommonsEntityFactory.instance.createResolver();
		IStatus status;
		try {
			IFile file = ResourceUtils.getFile(input);
			if (file != null) {
				model = getPersistenceKit().readModel(new IFilePersistenceProvider(file));
				status = Status.OK_STATUS;
			} else
				status = new Status(IStatus.ERROR, WholeUIPlugin.PLUGIN_ID, "Editor's input is not a regular file");
		} catch (Throwable e) {
			String errorMessage = "Unable to open \"" + input.getName() + 
			"\" using \"" + persistenceKit.getDescription() + "\" persitence kit\n";
			status = new Status(IStatus.ERROR, WholeUIPlugin.PLUGIN_ID, errorMessage, e);
		}
		setStatus(status);
		return model;
	}

	protected void writeModel(IEntity model, IFile file, IPersistenceKit persistenceKit) throws Exception {
		if (file.isReadOnly() && MessageDialog.openQuestion(getSite().getShell(), "Read-only File Encountered", "File '"+file.getFullPath().toOSString()+ "' is read-only. Do you wish to make it writable?"))
			try {
				ResourceAttributes attributes = file.getResourceAttributes();
				attributes.setReadOnly(false);
				file.setResourceAttributes(attributes);
			} catch (CoreException e) {
			}

		persistenceKit.writeModel(model, new IFilePersistenceProvider(file));
	}

	public ILanguageKit getRootLanguageKit() {
		IEntity rootEntity = getRootEntity();
		if (rootEntity == null)
			return null;
		return rootEntity.wGetLanguageKit();
	}
	public IGEFEditorKit getRootEditorKit() {
		IEntity rootEntity = getRootEntity();
		if (rootEntity == null)
			return null;
		return (IGEFEditorKit) rootEntity.wGetEditorKit();
	}

	public IEntity getRootEntity() {
		GraphicalViewer viewer = getGraphicalViewer();
		if (viewer == null)
			return null;
		RootFragment model = (RootFragment) viewer.getContents().getModel();
		return model.wGetRoot();
	}

	@Override
	public Image getTitleImage() {
		IFile file = ResourceUtils.getFile(getEditorInput());
		Image newimg = problemsImageDecorator.decorateImage(super.getTitleImage(), file);
		return newimg;
	}

	public void gotoMarker(IMarker marker) {
		try {
			if (!marker.isSubtypeOf(MarkerUtils.MARKER_TYPE))
				return;
		} catch (CoreException e) {
			return;
		}
		String locationPath = marker.getAttribute("uri", "/");
		IEntity locationEntity = EntityUtils.getEntity(getRootEntity(), locationPath);
		if (locationEntity != null)
			selectAndReveal(locationEntity);
	}

	public void selectAndReveal(IEntity entity) {
		final GraphicalViewer viewer = getGraphicalViewer();
		Map<?, ?> mapping = viewer.getEditPartRegistry();
		IEntity matchEntity = entity;
		GraphicalEditPart matchPart;
		do {
			matchPart = (GraphicalEditPart) mapping.get(matchEntity);
		} while (matchPart == null && !EntityUtils.isNull(matchEntity = matchEntity.wGetParent()));

		if (matchPart != null) {
			final EditPart editPart = matchPart;
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					viewer.reveal(editPart);
					viewer.select(editPart);
				}
			});
		}
	}
}
