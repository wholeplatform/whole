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

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.SelectionSynchronizer;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.editparts.OutlineViewEditPartFactory;
import org.whole.lang.ui.editparts.OutlineViewEditPartFactory.OutlineTreeNodeEditPart;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E3OutlinePage extends ContentOutlinePage implements IAdaptable {
	private IEclipseContext context;
	private IEntityPartViewer graphicalViewer;
	private SelectionSynchronizer synchronizer;
	private ActionRegistry actionRegistry;
	private PageBook pageBook;
	private Control outline;
	private Canvas overview;
	private Thumbnail thumbnail;

	private IAction collapseAllAction;
	private IAction toggleOverviewAction;
	static final int OUTLINE = 0;
	static final int OVERVIEW = 1;

	private DisposeListener disposeListener;

	public E3OutlinePage(IEclipseContext context, IEntityPartViewer graphicalViewer, SelectionSynchronizer synchronizer) {
		super(new TreeViewer());
		this.context = context.getParent();
		this.graphicalViewer = graphicalViewer;
		this.synchronizer = synchronizer;
	}

	@Override
	public void setFocus() {
//		context.set(IEntityPartViewer.class, graphicalViewer);
//		IActionBars actionBars = getSite().getActionBars();
//		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), actionRegistry.getAction(EDIT_UNDO));
//		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), actionRegistry.getAction(EDIT_UNDO));
//		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), actionRegistry.getAction(EDIT_DELETE));
		super.setFocus();
	}

	public void init(IPageSite pageSite) {
		super.init(pageSite);
		IActionBars actionBars = pageSite.getActionBars();

//		getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
//			@Override
//			public void selectionChanged(SelectionChangedEvent event) {
//				context.get(ESelectionService.class).setSelection(E4Utils.createSelectionBindings(event));
//			}
//		});
//		this.actionRegistry = new ActionRegistry(context, graphicalViewer.getControl());

//		// setup global actions
//		ActionRegistry registry = getActionFactory().getActionRegistry();
//		List<String> actionIds = new ArrayList<String>();
//		for (String actionId  : createGlobalActions(actionIds, registry))
//			actionBars.setGlobalActionHandler(actionId, registry.getAction(actionId));

		// create contributions
		createContributions(actionBars);
		actionBars.updateActionBars();
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
				showPage(isChecked() ? OVERVIEW : OUTLINE);
			}
		};
		toggleOverviewAction.setImageDescriptor(ImageDescriptor.createFromImage(WholeImages.OVERVIEW));
		tbm.add(toggleOverviewAction);
	}

	protected List<String> createGlobalActions(List<String> actions, ActionRegistry registry) {
		actions.add(ActionFactory.UNDO.getId());
		actions.add(ActionFactory.REDO.getId());
		actions.add(ActionFactory.CUT.getId());
		actions.add(ActionFactory.COPY.getId());
		actions.add(ActionFactory.PASTE.getId());
		actions.add(ActionFactory.DELETE.getId());
		actions.add(ActionFactory.FIND.getId());
		return actions;
	}

	public static final String PROPERTY_DIRTY = "Dirty";

	protected void configureOutlineViewer() {
		getViewer().setEditDomain(graphicalViewer.getEditDomain());
		getViewer().setEditPartFactory(new OutlineViewEditPartFactory());
		graphicalViewer.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {

				// check if we are enabling updates delaying
				if (!WholeGraphicalViewer.PROPERTY_DELAY_UPDATES.equals(evt.getPropertyName()) ||
						evt.getNewValue() == null || ((Boolean) evt.getNewValue())) {
					getViewer().setProperty(PROPERTY_DIRTY, false);
					return;
				}

				// rebuild if outline is dirty
				if ((Boolean) getViewer().getProperty(PROPERTY_DIRTY)) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
//							RootEditPart rootEditPart = getViewer().getRootEditPart();
//							IEntityPart contents = (IEntityPart) rootEditPart.getContents();
//							setContents(contents.getModelEntity());
							updateContents();
						}
					});
				}
			}
		});

//		ContextMenuProvider provider = new WholeContextMenuProvider(getViewer(), getActionFactory());
//		getViewer().setContextMenu(provider);
//		getSite().registerContextMenu("org.whole.lang.outline.contextmenu", provider, getSite().getSelectionProvider());
//		getViewer().setKeyHandler(graphicalViewer.getKeyHandler()); //TODO replace with parent keyHandler

		showPage(OUTLINE);
	}
	
	protected void showPage(int id) {
		if (id == OUTLINE) {
			collapseAllAction.setEnabled(true);
			toggleOverviewAction.setChecked(false);
			pageBook.showPage(outline);
			if (thumbnail != null)
				thumbnail.setVisible(false);
		} else if (id == OVERVIEW) {
			if (thumbnail == null)
				initializeOverview();
			collapseAllAction.setEnabled(false);
			toggleOverviewAction.setChecked(true);
			pageBook.showPage(overview);
			thumbnail.setVisible(true);
		}
	}

	public void createControl(Composite parent) {
		pageBook = new PageBook(parent, SWT.NONE);
		outline = getViewer().createControl(pageBook);
		overview = new Canvas(pageBook, SWT.NONE);
		pageBook.showPage(outline);
		configureOutlineViewer();
		hookOutlineViewer();
		initializeOutlineViewer();
	}

	private boolean valid = true;
	public boolean isValid() {
		return valid;
	}
	public void dispose() {
		valid = false;
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

	protected void hookOutlineViewer() {
		synchronizer.addViewer(getViewer());
	}

	ModelObserver modelObserver;
	@SuppressWarnings("unchecked")
	protected void initializeOutlineViewer() {
		updateContents();
		modelObserver = new ModelObserver(
				graphicalViewer.getEntityContents().wGetModel().getCompoundModel(),
				getViewer().getEditPartRegistry());
	}

	protected void initializeOverview() {
		LightweightSystem lws = new LightweightSystem(overview);
		RootEditPart rep = graphicalViewer.getRootEditPart();
//		if (rep instanceof ScalableFreeformRootEditPart) {
//			ScalableFreeformRootEditPart root = (ScalableFreeformRootEditPart) rep;
		if (rep instanceof ScalableRootEditPart) {
			ScalableRootEditPart root = (ScalableRootEditPart) rep;
			thumbnail = new ScrollableThumbnail((Viewport) root.getFigure());
			thumbnail.setBorder(new MarginBorder(3));
			thumbnail.setSource(root.getLayer(LayerConstants.PRINTABLE_LAYERS));
			lws.setContents(thumbnail);
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

	public void updateContents() {
		getViewer().setContents(graphicalViewer.getContents().getModel());
	}

	protected void unhookOutlineViewer() {
		Control control = graphicalViewer.getControl();
		synchronizer.removeViewer(getViewer());
		if (disposeListener != null && control != null
				&& !control.isDisposed())
			control.removeDisposeListener(disposeListener);
	}
}
