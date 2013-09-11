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
package org.whole.lang.e4.ui.compatibility;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.SelectionSynchronizer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.PageBook;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.e4.ui.api.IUIProvider;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.menu.JFaceMenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4TreeViewer;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.editparts.OutlineViewEditPartFactory;
import org.whole.lang.ui.editparts.OutlineViewEditPartFactory.OutlineTreeNodeEditPart;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Enrico Persiani
 */
public class E3OutlinePage extends ContentOutlinePage implements IAdaptable {
	private static final int OUTLINE_PAGE_ID = 0;
	private static final int OVERVIEW_PAGE_ID = 1;

	private IEntityPartViewer graphicalViewer;
	private SelectionSynchronizer synchronizer;
	private ActionRegistry actionRegistry;
	private IEclipseContext context;

	static class OtlineTreeViewer extends E4TreeViewer {
		protected IEclipseContext context;
		public OtlineTreeViewer(IEclipseContext context) {
			this.context = context;
			this.modelInput = context.get(IModelInput.class);
		}
		@SuppressWarnings("unchecked")
		@Override
		public ISelection getSelection() {
			IStructuredSelection selection = (IStructuredSelection) super.getSelection();
			IBindingManager bm = E4Utils.createSelectionBindings(getSelectedEditParts(), this);
			if (modelInput != null)
				E4Utils.defineResourceBindings(bm, modelInput);
			return new BindingManagerAdapter(bm, selection);
		}
	}

	public E3OutlinePage(IEclipseContext context, IEntityPartViewer graphicalViewer, SelectionSynchronizer synchronizer) {
		super(new OtlineTreeViewer(context));
		this.graphicalViewer = graphicalViewer;
		this.synchronizer = synchronizer;

		this.context = context.getParent();
	}

	@Override
	protected IEntityPartViewer getViewer() {
		return (IEntityPartViewer) super.getViewer();
	}
	@Override
	public void setFocus() {
//		context.set(IEntityPartViewer.class, graphicalViewer);
		super.setFocus();
	}

	protected IUIProvider<IMenuManager> contextMenuProvider;
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		IActionBars actionBars = pageSite.getActionBars();

		createContributions(actionBars);
		actionBars.updateActionBars();
	}
	
	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
		List<String> actionIds = new ArrayList<String>();
		for (String actionId  : createGlobalActions(actionIds))
			actionBars.setGlobalActionHandler(actionId, actionRegistry.getAction(actionId));
	}
	
	protected List<String> createGlobalActions(List<String> actions) {
		actions.add(ActionFactory.UNDO.getId());
		actions.add(ActionFactory.REDO.getId());
		actions.add(ActionFactory.CUT.getId());
		actions.add(ActionFactory.COPY.getId());
		actions.add(ActionFactory.PASTE.getId());
		actions.add(ActionFactory.DELETE.getId());
		actions.add(ActionFactory.DELETE.getId());
		actions.add(ActionFactory.FIND.getId());
		return actions;
	}

	public void collapseAll(EditPart part) {
		if (part instanceof OutlineTreeNodeEditPart) {
			Widget w = ((TreeEditPart) part).getWidget();
			if (w instanceof TreeItem)
				((TreeItem) w).setExpanded(false);
		}
		part.getChildren();
		for (Iterator<?> i = part.getChildren().iterator(); i.hasNext();)
			collapseAll((EditPart) i.next());
	}

	private IAction collapseAllAction;
	private IAction toggleOverviewAction;
	private DisposeListener disposeListener;
	protected void createContributions(IActionBars actionBars) {
		IToolBarManager tbm = actionBars.getToolBarManager();
		collapseAllAction = new Action("collapse all") {
			public void run() {
				collapseAll(getViewer().getContents());
			}
		};
		collapseAllAction.setImageDescriptor(ImageDescriptor.createFromImage(WholeImages.COLLAPSE_ALL));
		collapseAllAction.setDisabledImageDescriptor(ImageDescriptor.createFromImage(WholeImages.COLLAPSE_ALL_DISABLED));
		tbm.add(collapseAllAction);

		toggleOverviewAction = new Action("overview", Action.AS_CHECK_BOX) {
			public void run() {
				showPage(isChecked() ? OVERVIEW_PAGE_ID : OUTLINE_PAGE_ID);
			}
		};
		toggleOverviewAction.setImageDescriptor(ImageDescriptor.createFromImage(WholeImages.OVERVIEW));
		tbm.add(toggleOverviewAction);
	}

	public static final String PROPERTY_DIRTY = "Dirty";

	private PropertyChangeListener propertyChangeListener;
	protected void configureOutlineViewer() {
		getViewer().setEditDomain(graphicalViewer.getEditDomain());
		getViewer().setEditPartFactory(new OutlineViewEditPartFactory());
		propertyChangeListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {

				// check if we are enabling updates delaying
				if (!WholeGraphicalViewer.PROPERTY_DELAY_UPDATES.equals(evt.getPropertyName()) ||
						evt.getNewValue() == null || ((Boolean) evt.getNewValue())) {
					getViewer().setProperty(PROPERTY_DIRTY, false);
					return;
				}

				// rebuild if outline is dirty
				Boolean isDirty = (Boolean) getViewer().getProperty(PROPERTY_DIRTY);
				if (isDirty != null && isDirty) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							updateContents();
						}
					});
				}
			}
		};
		graphicalViewer.addPropertyChangeListener(propertyChangeListener);
		showPage(OUTLINE_PAGE_ID);
	}

	private PageBook pageBook;
	private Control outline;
	private Canvas overview;
	private Thumbnail thumbnail;
	protected void showPage(int id) {
		if (id == OUTLINE_PAGE_ID) {
			collapseAllAction.setEnabled(true);
			toggleOverviewAction.setChecked(false);
			pageBook.showPage(outline);
			if (thumbnail != null)
				thumbnail.setVisible(false);
		} else if (id == OVERVIEW_PAGE_ID) {
			if (thumbnail == null)
				initializeOverview();
			collapseAllAction.setEnabled(false);
			toggleOverviewAction.setChecked(true);
			pageBook.showPage(overview);
			thumbnail.setVisible(true);
		}
	}

	public void createControl(Composite parent) {
		HandlersBehavior.registerHandlers(this.context.get(EHandlerService.class));

		pageBook = new PageBook(parent, SWT.NONE);
		outline = getViewer().createControl(pageBook);
		overview = new Canvas(pageBook, SWT.NONE);
		pageBook.showPage(outline);
		configureOutlineViewer();
		hookOutlineViewer();
		initializeOutlineViewer();

		IEntityPartViewer viewer = getViewer();
		viewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				context.remove(IEntityPartViewer.class);
				context.remove(ActionRegistry.class);
			}

			@Override
			public void focusGained(FocusEvent e) {
				context.set(IEntityPartViewer.class, graphicalViewer);
				context.set(ActionRegistry.class, actionRegistry);
			}
		});

		viewer.setKeyHandler(new E4KeyHandler(context));
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

	}

	public boolean isValid() {
		Control control = getControl();
		return control != null && !control.isDisposed();
	}
	public void dispose() {
		modelObserver.dispose();
		unhookOutlineViewer();
		if (thumbnail != null) {
			thumbnail.deactivate();
			thumbnail = null;
		}
		super.dispose();
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == ZoomManager.class)
			return graphicalViewer.getProperty(ZoomManager.class.toString());
		return null;
	}

	public Control getControl() {
		return pageBook;
	}

	ModelObserver modelObserver;
	protected void initializeOutlineViewer() {
		updateContents();

		ICompoundModel compoundModel = graphicalViewer.getEntityContents().wGetModel().getCompoundModel();
		Map<IEntity, IEntityPart> editPartRegistry = getViewer().getEditPartRegistry();
		modelObserver = new ModelObserver(compoundModel, editPartRegistry);
	}

	public void updateContents() {
		getViewer().setContents(graphicalViewer.getEntityContents());
	}

	protected void initializeOverview() {
		LightweightSystem lightWeightSystem = new LightweightSystem(overview);
		RootEditPart rootEditPart = graphicalViewer.getRootEditPart();
		if (rootEditPart instanceof ScalableRootEditPart) {
			ScalableRootEditPart scalableRootEditPart = (ScalableRootEditPart) rootEditPart;
			thumbnail = new ScrollableThumbnail((Viewport) scalableRootEditPart.getFigure());
			thumbnail.setBorder(new MarginBorder(3));
			thumbnail.setSource(scalableRootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS));
			lightWeightSystem.setContents(thumbnail);
			disposeListener = new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					if (thumbnail != null) {
						thumbnail.deactivate();
						thumbnail = null;
					}
				}
			};
			graphicalViewer.getControl().addDisposeListener(disposeListener);
		}
	}
	
	protected void hookOutlineViewer() {
		synchronizer.addViewer(getViewer());
	}

	protected void unhookOutlineViewer() {
		graphicalViewer.removePropertyChangeListener(propertyChangeListener);

		Control control = graphicalViewer.getControl();
		synchronizer.removeViewer(getViewer());
		if (disposeListener != null && control != null && !control.isDisposed())
			control.removeDisposeListener(disposeListener);
	}
}
