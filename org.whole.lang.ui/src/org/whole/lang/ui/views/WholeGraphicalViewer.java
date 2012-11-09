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
package org.whole.lang.ui.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.DeferredUpdateManager;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.AutoexposeHelper;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ExposeHelper;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.commons.model.Any;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.impl.RootFragmentImpl;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.ContentAssistAction;
import org.whole.lang.ui.actions.WholeActionFactory;
import org.whole.lang.ui.dnd.EditPartTransferDragSourceListener;
import org.whole.lang.ui.dnd.EditPartTransferDropTargetListener;
import org.whole.lang.ui.dnd.FileTransferDropTargetListener;
import org.whole.lang.ui.dnd.TextTransferDragSourceListener;
import org.whole.lang.ui.dnd.TextTransferDropTargetListener;
import org.whole.lang.ui.dnd.XmlBuilderFileTransferDragSourceListener;
import org.whole.lang.ui.editors.ActiveEditorPart;
import org.whole.lang.ui.editparts.EntityPartListener;
import org.whole.lang.ui.editparts.ExtendedExposeHelper;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.editparts.WholeEditPartFactory;
import org.whole.lang.ui.editparts.WholeKeyHandler;
import org.whole.lang.ui.editparts.WholeViewportAutoexposeHelper;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.menu.WholeContextMenuProvider;
import org.whole.lang.ui.resources.ColorRegistry;
import org.whole.lang.ui.resources.FontRegistry;
import org.whole.lang.ui.resources.IColorRegistry;
import org.whole.lang.ui.resources.IFontRegistry;
import org.whole.lang.ui.resources.IResourceManager;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeGraphicalViewer extends ScrollingGraphicalViewer implements IResourceManager, ISelectionListener, ISelectionChangedListener {
	private ModelObserver modelObserver;
	private WholeActionFactory actionFactory;
	private List<String> selectionActionIds;

	//FIXME migrating to e4
	public static WholeGraphicalViewer create(Composite parent) {
		return new WholeGraphicalViewer(parent, (IWorkbenchPart) null);
	}

	public WholeGraphicalViewer(Composite parent) {
		this(parent, new WholeEditDomain(new ActiveEditorPart()));
		WholeEditDomain editDomain = getEditDomain();
		ActiveEditorPart part = (ActiveEditorPart) editDomain.getEditorPart();
		part.setCommandStack(editDomain.getCommandStack());
		part.setViewer(this);
	}
	public WholeGraphicalViewer(Composite parent, IEntity model) {
		this(parent);
		setContents(model);
	}
	public WholeGraphicalViewer(Composite parent, WholeEditDomain domain) {
		this(parent, domain, domain.getEditorPart());
		initEmbedded(domain);
	}
	public WholeGraphicalViewer(Composite parent, IWorkbenchPart part) {
		this(parent, new WholeEditDomain(), part);
	}
	public WholeGraphicalViewer(Composite parent, WholeEditDomain domain, IWorkbenchPart part) {
		this(parent, domain, part, new ActionRegistry());
	}
	public WholeGraphicalViewer(Composite parent, WholeEditDomain domain, IWorkbenchPart part, ActionRegistry actionRegistry) {
		createControl(parent);
		
		setRootEditPart(new ScalableRootEditPart() {
			@Override
			protected Viewport createViewport() {
				Viewport viewport = super.createViewport();
				viewport.setContentsTracksWidth(true);
				viewport.setContentsTracksHeight(true);
				return viewport;
			}
			@SuppressWarnings("rawtypes")
			@Override
			public Object getAdapter(Class key) {
				if (key == AutoexposeHelper.class)
					return new WholeViewportAutoexposeHelper(this);
				return super.getAdapter(key);
			}
			//TODO workaround for incorrect handling of -1 hint in super implementation
			protected ScalableLayeredPane createScaledLayers() {
				ScalableLayeredPane layers = new ScalableLayeredPane() {
					public Dimension superGetMinimumSize(int wHint, int hHint) {
						if (minSize != null)
							return minSize;
						if (getLayoutManager() != null) {
							Dimension d = getLayoutManager().getMinimumSize(this, wHint, hHint);
							if (d != null)
								return d;
						}
						return getPreferredSize(wHint, hHint);
					}
					public Dimension superGetPreferredSize(int wHint, int hHint) {
						if (prefSize != null)
							return prefSize;
						if (getLayoutManager() != null) {
							Dimension d = getLayoutManager().getPreferredSize(this, wHint, hHint);
							if (d != null)
								return d;
						}
						return getSize();
					}

					@Override
					public Dimension getMinimumSize(int wHint, int hHint) {
						Dimension d = superGetMinimumSize(
								wHint == -1 ? -1 : (int) (wHint / getScale()),
								hHint == -1 ? -1 : (int) (hHint / getScale()));
						int w = getInsets().getWidth();
						int h = getInsets().getHeight();
						return d.getExpanded(-w, -h).scale(getScale()).expand(w, h);
					}
					@Override
					public Dimension getPreferredSize(int wHint, int hHint) {
						Dimension d = superGetPreferredSize(
								wHint == -1 ? -1 : (int) (wHint / getScale()),
								hHint == -1 ? -1 : (int) (hHint / getScale()));
						int w = getInsets().getWidth();
						int h = getInsets().getHeight();
						return d.getExpanded(-w, -h).scale(getScale()).expand(w, h);
					}
				};
				layers.add(createGridLayer(), GRID_LAYER);
				layers.add(getPrintableLayers(), PRINTABLE_LAYERS);
				layers.add(new FeedbackLayer(), SCALED_FEEDBACK_LAYER);
				return layers;
			}

			class FeedbackLayer extends Layer {
				FeedbackLayer() {
					setEnabled(false);
				}
				public Dimension getPreferredSize(int wHint, int hHint) {
					Rectangle rect = new Rectangle();
					for (int i = 0; i < getChildren().size(); i++)
						rect.union(((IFigure)getChildren().get(i)).getBounds());
					return rect.getSize();
				}
			}
		});
		domain.addViewer(this);
		Tools.PANNING.ensureActive(domain);

//TODO remove ?		getControl().setBackground(ColorConstants.listBackground);

		selectionActionIds = new ArrayList<String>();
		setEditPartFactory(createEditPartFactory());
		setActionFactory(createWholeActionFactory(actionRegistry));
		setContextMenu(createContextMenuProvider(actionFactory));

		//FIXME migrating to e4
		if (part != null) {
			WholeKeyHandler wholeKeyHandler = new WholeKeyHandler(this, part, getActionRegistry());
			setKeyHandler(wholeKeyHandler.setParent(new KeyHandler()));
			createActions(part);
		}

		addDragSourceListener(new EditPartTransferDragSourceListener(this));
		addDropTargetListener(new EditPartTransferDropTargetListener(this));

		addDragSourceListener(new XmlBuilderFileTransferDragSourceListener(this));
		addDropTargetListener(new FileTransferDropTargetListener(this));

		addDragSourceListener(new TextTransferDragSourceListener(this));
		addDropTargetListener(new TextTransferDropTargetListener(this));

	}

	protected EditPartFactory createEditPartFactory() {
		return new WholeEditPartFactory();
	}

	protected void createActions(IWorkbenchPart workbenchPart) {
		WholeActionFactory.addSelectionActions(workbenchPart, actionFactory,
				getActionRegistry(), selectionActionIds);
		getKeyHandler().put(KeyStroke.getPressed(SWT.F2, 0), 
				getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));
		getKeyHandler().put(KeyStroke.getReleased(SWT.getPlatform().equals("cocoa") ? '\000' : ' ', 32, SWT.CTRL),//SWT.MOD1+space is reserved on Mac
				getActionRegistry().getAction(ContentAssistAction.ID));
	}
	protected  void createGlobalActions(IWorkbenchPart workbenchPart) {
		getKeyHandler().put(KeyStroke.getPressed(SWT.DEL, 127, 0), 
				getActionRegistry().getAction(org.eclipse.ui.actions.ActionFactory.DELETE.getId()));
		getKeyHandler().put(KeyStroke.getPressed('\u001a', 122, SWT.MOD1), 
				new UndoAction(workbenchPart));
		getKeyHandler().put(KeyStroke.getPressed('\u0019', 121, SWT.MOD1), 
				new RedoAction(workbenchPart));
	}
	protected void initEmbedded(WholeEditDomain domain) {
		addSelectionChangedListener(this);
		createGlobalActions(domain.getEditorPart());
	}

	public void setActionFactory(WholeActionFactory actionFactory) {
		this.actionFactory = actionFactory;
	}
	public WholeActionFactory getActionFactory() {
		return actionFactory;
	}

	protected WholeActionFactory createWholeActionFactory(ActionRegistry actionRegistry) {
		WholeActionFactory actionFactory = new WholeActionFactory();
		actionFactory.setActionRegistry(actionRegistry);
		return actionFactory;
	}

	protected ContextMenuProvider createContextMenuProvider(WholeActionFactory actionFactoryv) {
		return new WholeContextMenuProvider(this, actionFactory);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		updateSelectionActions(true);
	}
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		updateSelectionActions(false);
	}
	public void updateSelectionActions(boolean updateProvider) {
		updateActions(selectionActionIds, updateProvider);
	}

	protected void updateActions(List<String> actionIds, boolean updateProvider) {
		ActionRegistry registry = getActionRegistry();
		Iterator<String> iterator = actionIds.iterator();
		while (iterator.hasNext()) {
			IAction action = registry.getAction(iterator.next());
			if (action instanceof UpdateAction) {
				UpdateAction updateAction = (UpdateAction) action;
				if (updateProvider && updateAction instanceof SelectionAction)
					((SelectionAction) updateAction).setSelectionProvider(this);
				updateAction.update();
			}
		}
	}

	protected ActionRegistry getActionRegistry() {
		return actionFactory.getActionRegistry();
	}

	public void setContents(Object contents) {
		IEntity root = (IEntity) contents;
		super.setContents(wrapContents(root));
		updateModelObserver(root);
	}
	protected RootFragment wrapContents(IEntity entity) {
		return entity instanceof RootFragment ? (RootFragment) entity :
			new LazyContainmentRootFragmentImpl(entity);//new RootFragmentImpl(entity);
//		FIXME		CommonsEntityFactory.instance.createRootFragment(entity);
	}

	public void setInteractive(IEntity entity, boolean edit, boolean browse, boolean inherited) {
		Map<?, ?> mapping = getEditPartRegistry();
		GraphicalEditPart entityPart = (GraphicalEditPart) mapping.get(entity);
		if (entityPart != null) {
			IEntityFigure entityFigure = (IEntityFigure) entityPart.getFigure();
			entityFigure.setInteractiveEdit(edit);
			entityFigure.setInteractiveBrowse(browse);
			entityFigure.setInteractiveInherited(inherited);
		}
	}

	public static class LazyContainmentRootFragmentImpl extends RootFragmentImpl {
		private static final long serialVersionUID = 1L;

		public LazyContainmentRootFragmentImpl(IEntity fragment) {
			super(fragment);
		}

		boolean isContainment = false;
		@Override
		public boolean isContainment() {
			return isContainment;
		}

		@Override
		public void setRootEntity(Any entity) {
			isContainment = !EntityUtils.hasParent(entity);
			super.setRootEntity(entity);
		}
	}

	@SuppressWarnings("unchecked")
	protected void updateModelObserver(IEntity entity) {
		ICompoundModel model = entity.wGetModel().getCompoundModel();
		if (modelObserver != null && modelObserver.getModel() != model) {
			modelObserver.dispose();
			modelObserver = null;
		}
		if (modelObserver == null)
			modelObserver = new ModelObserver(model, (Map<IEntity, IEntityPart>) getEditPartRegistry());		
	}

	public void dispose() {
		if (modelObserver != null)
			modelObserver.dispose();
	}
	public void addEntityPartListener(EntityPartListener listener) {
		modelObserver.addEntityPartListener(listener);
	}
	public void removeEntityPartListener(EntityPartListener listener) {
		modelObserver.removeEntityPartListener(listener);
	}

	@Override
	public void reveal(EditPart part) {
		if (part == null)
			return;

		exposeEditPart(part);
		flush();
		exposeRegion(part);
	}

	public void exposeEditPart(EditPart part) {
		EditPart parentPart = part.getParent();
		EditPart childPart = part;

		while (parentPart != null) {
			ExposeHelper exposeHelper = (ExposeHelper) parentPart.getAdapter(ExposeHelper.class);
			if (exposeHelper instanceof ExtendedExposeHelper)
				((ExtendedExposeHelper) exposeHelper).exposeChild(childPart);
			else if (exposeHelper != null)
				exposeHelper.exposeDescendant(part);
			childPart = parentPart;
			parentPart = childPart.getParent();
		}

		AccessibleEditPart accessiblePart;
		if ((accessiblePart = (AccessibleEditPart) part.getAdapter(AccessibleEditPart.class)) != null)
			getControl().getAccessible().setFocus(accessiblePart.getAccessibleID());
	}

	public void exposeRegion(EditPart part) {
		Viewport port = getFigureCanvas().getViewport();
		IFigure target = ((GraphicalEditPart) part).getFigure();
		Rectangle exposeRegion = target.getBounds().getCopy();
		target = target.getParent();
		while (target != null && target != port) {
			target.translateToParent(exposeRegion);
			target = target.getParent();
		}

		Rectangle targetRegion = exposeRegion.getCopy().shrink(5, 5); //++
		if (!port.getClientArea().intersects(targetRegion)) { //++
			Dimension viewportSize = port.getClientArea().getSize();

			exposeRegion.expand(5, 5);

			Point topLeft = exposeRegion.getTopLeft();
			Point bottomRight = exposeRegion.getBottomRight().translate(viewportSize.getNegated());
			Point finalLocation = new Point();
			if (viewportSize.width < exposeRegion.width)
				finalLocation.x = Math.min(bottomRight.x, Math.max(topLeft.x, port.getViewLocation().x));
			else
				finalLocation.x = Math.min(topLeft.x, Math.max(bottomRight.x, port.getViewLocation().x));

			if (viewportSize.height < exposeRegion.height)
				finalLocation.y = Math.min(bottomRight.y, Math.max(topLeft.y, port.getViewLocation().y));
			else
				finalLocation.y = Math.min(topLeft.y, Math.max(bottomRight.y, port.getViewLocation().y));

			getFigureCanvas().scrollSmoothTo(finalLocation.x, finalLocation.y);
		}
	}

	private EditPart focusEditPart;
	@Override
	protected void handleFocusGained(FocusEvent fe) {
		if (focusEditPart != null)
			setFocus(focusEditPart);
		focusEditPart = null;
	}
	@Override
	protected void handleFocusLost(FocusEvent fe) {
		focusEditPart = getFocusEditPart();
		focusEditPart = focusEditPart.hasFocus() ? focusEditPart : null;
		setFocus(null);
	}
	@Override
	public void setFocus(EditPart part) {
		super.setFocus(part);

		SelectionAction pasteAction = ((SelectionAction) getActionRegistry().getAction(ActionFactory.PASTE.getId()));
		//FIXME migrating to e4
		if (pasteAction != null) {
			pasteAction.setSelectionProvider(this);
			pasteAction.update();
		}
	}
	@Override
	public WholeEditDomain getEditDomain() {
		return (WholeEditDomain) super.getEditDomain();
	}
	@SuppressWarnings("unchecked")
	public static <T> T safeGetProperty(EditPartViewer viewer, String propertyName, T defaultValue) {
		Object propertyValue = viewer.getProperty(propertyName);
		return propertyValue == null ? defaultValue : (T) propertyValue;
	}

//	private ResourceManager resourceManager;
	@Override
	public ResourceManager getResourceManager() {
//		return resourceManager;
		return super.getResourceManager();
	}
//	@Override
//	protected void hookControl() {
//		super.hookControl();
//
//		if (resourceManager == null)
//			resourceManager = new LocalResourceManager(JFaceResources.getResources());
//	}
//	@Override
//	protected void unhookControl() {
//		super.unhookControl();
//
//		if (resourceManager != null)
//			resourceManager.dispose();
//	}

	@Override
	protected void handleDispose(DisposeEvent e) {
		colorRegistry = null;
		fontRegistry = null;
		super.handleDispose(e);
	}

	private IColorRegistry colorRegistry;
	public IColorRegistry getColorRegistry() {
		if (colorRegistry == null)
			colorRegistry = new ColorRegistry(getResourceManager());
		return colorRegistry;
	}
	private IFontRegistry fontRegistry;
	public IFontRegistry getFontRegistry() {
		if (fontRegistry == null)
			fontRegistry = new FontRegistry(getResourceManager());
		return fontRegistry;
	}

	public static final String PROPERTY_DELAY_UPDATES = "DelayUpdates";
	private final class DelayableUpdateManager extends DeferredUpdateManager {
		private boolean hasDelayedUpdates;

		public DelayableUpdateManager() {
			hasDelayedUpdates = false;
			addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					if (!PROPERTY_DELAY_UPDATES.equals(evt.getPropertyName()))
						return;

					boolean oldValue = evt.getOldValue() != null ? ((Boolean) evt.getOldValue()).booleanValue() : false;
					boolean newValue = evt.getNewValue() != null ? ((Boolean) evt.getNewValue()).booleanValue() : false;
					if (hasDelayedUpdates && newValue != oldValue) {
						hasDelayedUpdates = false;
						executeDelayedUpdates();
					}
				}
			});
		}
		protected void executeDelayedUpdates() {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					DelayableUpdateManager.super.queueWork();
				}
			});
		}
		protected void queueWork() {
			Object value = getProperty(PROPERTY_DELAY_UPDATES);
			if (value != null && ((Boolean) value).booleanValue())
				hasDelayedUpdates = true;
			else
				super.queueWork();
		}
	}

	@Override
	protected LightweightSystem createLightweightSystem() {
		LightweightSystem lws = super.createLightweightSystem();
		lws.setUpdateManager(new DelayableUpdateManager());
		return lws;
	}
	public void refreshNotation() {
		FigureCanvas figureCanvas = getFigureCanvas();
		Viewport viewport = figureCanvas.getViewport();
		viewport.invalidateTree();
		viewport.revalidate();
		figureCanvas.redraw();
	}

	public void rebuildNotation() {
		setContents(getContents().getModel());
	}

	public void rebuildNotation(IEntity entity) {
		Object editPart = getEditPartRegistry().get(entity);
		if (editPart == null)
			editPart = getEditPartRegistry().get(entity.wGetParent().wGet(entity));
		if (editPart instanceof IEntityPart)
			((IEntityPart) editPart).rebuild();
	}
}
