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

import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.PartEventAction;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.whole.lang.commons.model.Fragment;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.actions.LinkToEditorAction;
import org.whole.lang.ui.editors.WholeGraphicalEditor;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.ui.views.properties.tabbed.WholeTabbedPropertySheetPage;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeGraphicalView extends PageBookView implements ITabbedPropertySheetPageContributor {
	public static final String VIEW_ACTIONS = "ViewActionsGroup";

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		WholeGraphicalPage activePage = getActivePage();
		
		if (activePage != null) {
			WholeGraphicalViewer viewer = activePage.getViewer();
			if (adapter == CommandStack.class)
				return viewer.getEditDomain().getCommandStack();
			if (adapter == GraphicalViewer.class)
				return viewer;
			if (adapter == ActionRegistry.class)
				return viewer.getActionRegistry();
		}
		if (adapter == IPropertySheetPage.class)
			return new WholeTabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	public String getContributorId() {
		return WholeGraphicalEditor.class.getName();
	}

	public String getViewId() {
		return getClass().getName();
	}

	public WholeGraphicalPage getActivePage() {
		IPage currentPage = getCurrentPage();
		return currentPage instanceof WholeGraphicalPage ? (WholeGraphicalPage) currentPage : null;
	}

	private static int viewCounter;
	public int nextViewCounter() {
		return viewCounter++;
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		IActionBars actionBars = site.getActionBars();

		// create contributions
		createContributions(actionBars);
		actionBars.updateActionBars();
	}
	
	@Override
	public void dispose() {
		if (linkToEditorAction != null)
			getSite().getPage().removePartListener(linkToEditorAction);

		hasContents = false;
		defaultPageRec = null;
		super.dispose();
	}
	
	public boolean isDisposed() {
		return defaultPageRec == null;
	}

	@Override
	protected IPage createDefaultPage(PageBook book) {
		MessagePage page = new MessagePage();
		initPage(page);
		page.createControl(book);
		page.setMessage("Contents not available.");
		return page;
	}

	protected boolean hasContents = false;

	public IEntity getContents() {
		if (hasContents && !isDisposed()) {
			try {
				return ((IEntity) getActivePage().getViewer().getContents().getModel()).wGet(0);
			} catch (NullPointerException e) {
			}
		}
		return null;
	}
	public void setContents(IEntity contents) {
		setContents(this, contents);
	}
	public void setContents(IWorkbenchPart part, IEntity contents) {
		hasContents = contents != null;
		
		if (hasContents && !isDisposed()) {
			showContentPage(part);
			PageRec pageRec = getPageRec(part);
			if (pageRec != null) {
				WholeGraphicalPage wholeGraphicalPage = (WholeGraphicalPage) pageRec.page;
				if (wholeGraphicalPage != null) {
					final WholeGraphicalViewer viewer = wholeGraphicalPage.getViewer();
					viewer.setContents(contents);
					viewer.flush();
//					viewer.addEntityPartListener(new EntityPartListener() {
//						public void beforeUpdate(EntityPartEvent event) {
//						}
//						public void afterUpdate(EntityPartEvent event) {
//							if (event.getEntityPart().getModelEntity().equals(viewer.getContents()))
//								setInteractiveMode(viewer);
//						}
//					});

					setInteractiveMode(viewer, contents);
				}
			}
		} else
			showDefaultPage();
	}
	public void setInteractiveMode(WholeGraphicalViewer viewer, IEntity contents) {
//		viewer.setInteractive(true, true, true);
	}

	//workaround for getting private super field
	protected PageRec defaultPageRec;
	@Override
	protected void showPageRec(PageRec pageRec) {
		if (defaultPageRec == null && pageRec != null && pageRec.page == getDefaultPage())
			defaultPageRec = pageRec;
		super.showPageRec(hasContents ? pageRec : defaultPageRec);
	}

	public void showDefaultPage() {
		if (defaultPageRec != null)
			super.showPageRec(defaultPageRec);
	}
	private boolean isImportant;
	public void showContentPage(IWorkbenchPart part) {
		try {
			isImportant = true;
			partActivated(part);
		} finally {
			isImportant = false;
		}
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		if (isImportant)
			return true;

		if (!(part instanceof IEditorPart))
			return false;

		boolean isWholeEditor = part instanceof WholeGraphicalEditor;
		boolean isDefaultPage = getCurrentPage() == getDefaultPage();
		return !(isWholeEditor ^ isDefaultPage);
	}

	protected PageRec doCreatePage(IWorkbenchPart part) {
		WholeGraphicalViewer viewer = createGraphicalViewer(part);
		getViewSite().getPage().addSelectionListener(viewer);

		Page page = createGraphicalPage(viewer);
		initPage(page);
		page.getSite().setSelectionProvider(viewer);
		return new PageRec(part, page);
	}

	protected WholeGraphicalViewer createGraphicalViewer(IWorkbenchPart part) {
		return new WholeGraphicalViewer(getPageBook(), this);
	}

	protected Page createGraphicalPage(WholeGraphicalViewer viewer) {
		return new WholeGraphicalPage(viewer, this);
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		getViewSite().getPage().removeSelectionListener(((WholeGraphicalPage) pageRecord.page).getViewer());
		pageRecord.page.dispose();
		pageRecord.dispose();
	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		return page != null ? page.getActiveEditor() : null;
	}


	protected void createContributions(IActionBars actionBars) {
	}

	private PartEventAction linkToEditorAction;
	protected Action createLinkToEditorAction(boolean triState) {
		if (!triState) {
			linkToEditorAction = new PartEventAction("Link to active editor", Action.AS_CHECK_BOX) {
				private IWorkbenchPart lastActivated = null;
				public void run() {
					setLinkType(getLinkType().isNotLinked() ? LinkType.ACTIVE_EDITOR : LinkType.NOT_LINKED);
					if (lastActivated != null && getLinkType().isLinkedToActiveEditor()) {
						ISelection selection = ((GraphicalViewer) lastActivated.getAdapter(GraphicalViewer.class)).getSelection();
						WholeGraphicalPage activePage = getActivePage();
						if (activePage != null)
							activePage.getViewer().selectionChanged(lastActivated, selection);
						else
							activePage = null;
					}
				}
				@Override
				public void partActivated(IWorkbenchPart part) {
					super.partActivated(part);
					if (part instanceof IEditorPart) {
						setEnabled(part instanceof WholeGraphicalEditor);
						lastActivated = part;
					}
				}
			};
			linkToEditorAction.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/link_to_active_editor.gif"));
			linkToEditorAction.setChecked(true);
			linkToEditorAction.setToolTipText("Link with active editor");
			getSite().getPage().addPartListener(linkToEditorAction);
			return linkToEditorAction;
		} else
			return new LinkToEditorAction(this);
	}

	public enum LinkType {
		ACTIVE_EDITOR, FIXED_EDITOR, FIXED_EDITOR_SELECTION, NOT_LINKED;
		
		public boolean isLinkedToActiveEditor() {
			return this == ACTIVE_EDITOR;
		}
		public boolean isLinkedToFixedEditor() {
			return this == FIXED_EDITOR || this == FIXED_EDITOR_SELECTION;
		}
		public boolean isLinkedToFixedEditorSelection() {
			return this == FIXED_EDITOR_SELECTION;
		}
		public boolean isNotLinked() {
			return this == NOT_LINKED;
		}
	}

	private IEditorPart linkedEditor = null;
	public IEditorPart getLinkedEditor() {
		return linkedEditor;
	}
	private IEntity linkedFirstSelectedEntity = null;
	public IEntity getLinkedFirstSelectedEntity() {
		return linkedFirstSelectedEntity;
	}

	private LinkType linkType = LinkType.ACTIVE_EDITOR;
	public LinkType getLinkType() {
		return linkType;
	}
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
		if (linkType.isLinkedToFixedEditor()) {
			linkedEditor = UIUtils.getActiveEditor();
			if (linkType.isLinkedToFixedEditorSelection()) {
				if (linkedEditor instanceof WholeGraphicalEditor) {
					ISelection selection = ((GraphicalViewer) linkedEditor.getAdapter(GraphicalViewer.class)).getSelection();
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					Object firstSelectedElement = structuredSelection.getFirstElement();
					if (firstSelectedElement instanceof IEntityPart)
						linkedFirstSelectedEntity = ((IEntityPart) firstSelectedElement).getModelEntity();
				}
			}
		}
	}

	protected Action createMultiViewAction(final boolean cloneContents) {
		Action multiViewAction = new Action("New View", Action.AS_PUSH_BUTTON) {
			public void run() {
				try {
					WholeGraphicalView view = (WholeGraphicalView) getSite().getPage().showView(getViewId(),
							"secondaryID" + nextViewCounter(),
							IWorkbenchPage.VIEW_CREATE);
					if (cloneContents) {
						Fragment rootFragment = (Fragment) getActivePage().getViewer().getContents().getModel();
						view.setContents(EntityUtils.clone(rootFragment.wGetRoot()));
					}
				} catch (PartInitException e) {
					WholeUIPlugin.log(e);
				}
			}
		};
		multiViewAction.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/new_view.gif"));
		return multiViewAction;
	}

	public void selectAndReveal(IEntity entity) {
		final GraphicalViewer viewer = getActivePage().getViewer();
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
