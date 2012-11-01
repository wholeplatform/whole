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
package org.whole.lang.ui.search;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Enrico Persiani
 */
public class WholeSearchResultPage extends Page implements ISearchResultPage {
	private WholeSearchResult searchResult;
	private String idPage;
	private IPageSite pageSite;
	private ISearchResultViewPart viewPart;
	private ISearchResultListener serachResultListener;
	private TreeViewer resultViewer;
	private SearchResultContentProvider contentProvider;
	private IQueryListener queryListener;

	public WholeSearchResultPage() {
		serachResultListener = new ISearchResultListener() {
			public void searchResultChanged(SearchResultEvent e) {
				if (e instanceof WholeMatchEvent)
					handleSearchResultChanged((WholeMatchEvent)e);
			}
		};
		queryListener = new IQueryListener() {
			public void queryAdded(ISearchQuery query) { }
			public void queryRemoved(ISearchQuery query) { }
			public void queryStarting(ISearchQuery query) { }	
			public void queryFinished(ISearchQuery query) {
				handleQueryFinished((WholeSearchQuery) query);
			}
		};
	}

	public String getID() {
		return idPage;
	}

	public void setID(String id) {
		idPage = id;
	}

	public String getLabel() {
		if (searchResult == null)
			return "";
		else
			return searchResult.getLabel();
	}

	public Object getUIState() {
		return resultViewer.getSelection();
	}

	public void restoreState(IMemento memento) {
		// see saveState(...)
	}

	public void saveState(IMemento memento) {
		// here can be persisted options 
		// through workspace executions
	}

	public void init(IPageSite pageSite) {
		super.init(pageSite);
		IMenuManager menuManager= pageSite.getActionBars().getMenuManager();
		menuManager.appendToGroup(IContextMenuConstants.GROUP_PROPERTIES, 
			new OpenSearchPreferencesAction());
	}

	public void setInput(ISearchResult newSearch, Object uiState) {
		if (newSearch != null && !(newSearch instanceof WholeSearchResult))
			return;
		
		if(searchResult != null) {
			searchResult.removeListener(serachResultListener);
		}

		searchResult = (WholeSearchResult) newSearch;
		if(searchResult != null) {
			searchResult.addListener(serachResultListener);
			resultViewer.setInput(searchResult);
			if(uiState instanceof ISelection)
				resultViewer.setSelection((ISelection)uiState);
		}
	}

	private void handleSearchResultChanged(final WholeMatchEvent event) {
		getSite().getShell().getDisplay().syncExec(new Runnable() {
			public void run() {
				if(event.getType() == WholeMatchEvent.EVENT_TYPE.REMOVEALL)
					contentProvider.clear();
				else
					contentProvider.elementsChanged(event);
			}
		});
	}

	protected void handleQueryFinished(WholeSearchQuery query) {
		getSite().getShell().getDisplay().syncExec(new Runnable() {
			public void run() {
				selectAndRevealFirstElement();
			}
		});
	}

	private void selectAndRevealFirstElement() {
		if(resultViewer.getComparator() != null &&
				resultViewer.getContentProvider() != null) {

			ViewerComparator comparator = resultViewer.getComparator();
			ITreeContentProvider provider = (ITreeContentProvider) resultViewer.getContentProvider();
			Object parent = searchResult;
			while(parent != null && provider.hasChildren(parent)) {
				Object[] children = provider.getChildren(parent).clone();
				comparator.sort(resultViewer, children);
				parent = children[0];
			}
			resultViewer.setSelection(new StructuredSelection(parent), true);
		}
	}

	public void setViewPart(ISearchResultViewPart part) {
		viewPart = part;
	}

	public void createControl(Composite parent) {
		SearchResultLabelProvider labelProvider;
		ResourceComparator resourceComparator;
		
		final Tree mainTree = new Tree(parent, SWT.SINGLE);
		resultViewer = new TreeViewer(mainTree);
		labelProvider = new SearchResultLabelProvider(resultViewer);
		contentProvider = new SearchResultContentProvider(resultViewer);
		resourceComparator = new ResourceComparator(ResourceComparator.NAME);
		resultViewer.setContentProvider(contentProvider);
		resultViewer.setLabelProvider(labelProvider);
		resultViewer.setComparator(resourceComparator);
		resultViewer.addOpenListener(new IOpenListener() {
			public void open(OpenEvent event) {
				handleOpenModel(event);
			}
		});
		NewSearchUI.addQueryListener(queryListener);
	}

	protected void handleOpenModel(OpenEvent event) {
		WholeMatch wholeMatch = getFirstSelectedMatch();
		if (wholeMatch != null)
			revealAndOpen(wholeMatch);
	}

	private boolean revealAndOpen(WholeMatch wholeMatch) {
		IFile file = wholeMatch.getFile();
		BasicNewResourceWizard.selectAndReveal(file, PlatformUI.getWorkbench().getActiveWorkbenchWindow());

        IWorkbenchWindow dw = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        try {
            if (dw != null) {
                IWorkbenchPage page = dw.getActivePage();
                if (page != null) {
        			String editorID = ReflectionFactory.getEditorIdFromPersistenceKit(wholeMatch.getPersistenceKit());
        			IDE.setDefaultEditor(file, editorID);
                    IDE.openEditor(page, file, true);
                }
            }
        } catch (PartInitException e) {
        	WholeUIPlugin.log(e);
        	return false;
        }
        return true;
	}


	private WholeMatch getFirstSelectedMatch() {
		IStructuredSelection selection =
			(IStructuredSelection) resultViewer.getSelection();
		if (selection.size() > 0) {
			Object element =  selection.getFirstElement();
			return element instanceof WholeMatch ? (WholeMatch) element : null;
		}
		return null;
	}

	public void dispose() {
		if(searchResult != null)
			searchResult.removeListener(serachResultListener);
		super.dispose();
		NewSearchUI.removeQueryListener(queryListener);
	}

	public Control getControl() {
		if(resultViewer != null)
			return resultViewer.getControl();
		else
			return null;
	}

	public void setFocus() {
		Control control = getControl();
		if (control != null && !control.isDisposed())
			control.setFocus();
	}

	public IPageSite getPageSite() {
		return pageSite;
	}

	public ISearchResultViewPart getViewPart() {
		return viewPart;
	}
}
