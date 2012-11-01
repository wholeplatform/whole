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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author Enrico Persiani
 */
public class SearchResultContentProvider implements ITreeContentProvider {
	private WholeSearchResult results;
	private AbstractTreeViewer viewer;
	private Map<Object, Set<Object>> childrenMap;

	private final Object[] EMPTY_ARR = new Object[0];

	public SearchResultContentProvider(AbstractTreeViewer viewer) {
		this.viewer = viewer;
	}

	public Object[] getChildren(Object parentElement) {
		Set<Object> children = childrenMap.get(parentElement);
		if (children == null)
			return EMPTY_ARR;
		return children.toArray();
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public Object getParent(Object element) {
		if (element instanceof IProject)
			return null;
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			return resource.getParent();
		}
		if (element instanceof WholeMatch) {
			WholeMatch match = (WholeMatch) element;
			return match.getFile().getParent();
		}
		return null;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
	}

	protected synchronized void initialize(WholeSearchResult results) {
		this.results = results;
		childrenMap = new HashMap<Object, Set<Object>>();
		if (results != null) {
			Collection<IFile> matchedFiles = results.getMatchedFiles();
			for (IFile file : matchedFiles) {
				for(WholeMatch match : results.getMatchSet(file)) {
					insertMatches(match, false);
				}
//				insertFile(file, false);
			}
		}
	}
	
//	protected void insertFile(IFile file, boolean refreshViewer) {
//		for(WholeMatch match : results.getMatchSet(file)) {
//			insertMatches(match, refreshViewer);
//		}
//	}

//	protected void removeFile(IFile file, boolean refreshViewer) {
//		for(WholeMatch match : results.getMatchSet(file)) {
//			removeMatches(match, refreshViewer);
//		}
//	}

	protected void insertMatches(Object child, boolean refreshViewer) {
		Object parent = getParent(child);
		while (parent != null) {
			if (insertChild(parent, child)) {
				if (refreshViewer)
					viewer.add(parent, child);
			} else {
				if (refreshViewer)
					viewer.refresh(parent);
				return;
			}
			child= parent;
			parent= getParent(child);
		}
		if (insertChild(results, child)) {
			if (refreshViewer)
				viewer.add(results, child);
		}
	}

	protected void removeMatches(Object element, boolean refreshViewer) {
		if (hasChildren(element)) {
			if (refreshViewer)
				viewer.refresh(element);
		} else {
			if (element instanceof WholeMatch) {
				childrenMap.remove(element);
				Object parent= getParent(element);
				if (parent != null) {
					removeFromSiblings(element, parent);
					removeMatches(parent, refreshViewer);
				} else {
					removeFromSiblings(element, results);
					if (refreshViewer)
						viewer.refresh();
				}
			} else {
				if (refreshViewer) {
					viewer.refresh(element);
				}
			}
		}
	}

	private void removeFromSiblings(Object element, Object parent) {
		Set<Object> siblings= childrenMap.get(parent);
		if (siblings != null) {
			siblings.remove(element);
		}
	}

	private boolean insertChild(Object parent, Object child) {
		Set<Object> children = childrenMap.get(parent);
		if (children == null) {
			children= new HashSet<Object>();
			childrenMap.put(parent, children);
		}
		return children.add(child);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof WholeSearchResult)
			initialize((WholeSearchResult) newInput);
	}

	public synchronized void elementsChanged(WholeMatchEvent event) {
		if(event.getElements() == null)
			return;
		
		for (Object updated : event.getElements()) {
			if(event.getType() == WholeMatchEvent.EVENT_TYPE.ADD)
				insertMatches((WholeMatch) updated, true);
			else
				removeMatches((WholeMatch) updated, true);
		}
	}

	public void clear() {
		initialize(results);
		viewer.refresh();
	}
}
