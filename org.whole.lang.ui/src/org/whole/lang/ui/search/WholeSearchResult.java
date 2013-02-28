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
package org.whole.lang.ui.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Enrico Persiani
 */
public class WholeSearchResult implements ISearchResult {
	private Map<IFile, Set<WholeMatch>> elementMatches;
	private ListenerList listenerList;
	private WholeSearchQuery searchQuery;
	private WholeMatchEvent searchResultEvent;

	public WholeSearchResult(ISearchQuery searchQuery) {
		this.elementMatches = new HashMap<IFile, Set<WholeMatch>>();
		this.listenerList = new ListenerList();
		this.searchQuery = (WholeSearchQuery) searchQuery;
		this.searchResultEvent = new WholeMatchEvent(this);
	}

	public ImageDescriptor getImageDescriptor() {
		return WholeUIPlugin.getImageDescriptor("icons/views/search_result.gif");
	}

	public String getLabel() {
		return searchQuery.getLabel();
	}

	public ISearchQuery getQuery() {
		return searchQuery;
	}

	public String getTooltip() {
		return getLabel();
	}

	public void addListener(ISearchResultListener listener) {
		listenerList.add(listener);
	}

	public void removeListener(ISearchResultListener listener) {
		listenerList.remove(listener);
	}

	public Collection<IFile> getMatchedFiles() {
		synchronized (elementMatches) {
			return new TreeSet<IFile>(elementMatches.keySet());
		}
	}

	public void addMatches(IFile file, IPersistenceKit persistenceKit, Collection<IEntity> matches) {
		WholeMatch match = new WholeMatch(file, persistenceKit, matches);
		synchronized (elementMatches) {
			Set<WholeMatch> matchSet = elementMatches.get(file);
			if (matchSet == null)
				matchSet = new HashSet<WholeMatch>();
			matchSet.add(match);
			elementMatches.put(file, matchSet);
		}
		fireChange(getAddEvent(file));
	}

	public Set<WholeMatch> getMatchSet(IFile file) {
		synchronized (elementMatches) {
			Set<WholeMatch> matches = elementMatches.get(file);
			if (matches == null)
				matches = Collections.emptySet();
			return matches;
		}
	}

	public void removeMatches(IFile file) {
		WholeMatchEvent event;
		synchronized (elementMatches) {
			event = getRemoveEvent(file);
			elementMatches.remove(file);
		}
		fireChange(event);
	}

	public void removeAll() {
		synchronized (elementMatches) {
			elementMatches.clear();
		}
		fireChange(getRemoveAllEvent());
	}

	protected void fireChange(SearchResultEvent e) {
		List<ISearchResultListener> list;
		synchronized (listenerList) {
			list = new ArrayList<ISearchResultListener>(listenerList.size());
			for(Object listener : listenerList.getListeners())
				list.add((ISearchResultListener)listener);
		}
		Iterator<ISearchResultListener> listeners= list.iterator();
		while (listeners.hasNext()) {
			listeners.next().searchResultChanged(e);
		}
	}

	private WholeMatchEvent getRemoveEvent(IFile file) {
		searchResultEvent.setType(WholeMatchEvent.EVENT_TYPE.REMOVE);
		searchResultEvent.setElements(getMatchSet(file).toArray());
		return searchResultEvent;
	}

	private WholeMatchEvent getRemoveAllEvent() {
		searchResultEvent.setType(WholeMatchEvent.EVENT_TYPE.REMOVEALL);
		return searchResultEvent;
	}

	private WholeMatchEvent getAddEvent(IFile file) {
		searchResultEvent.setType(WholeMatchEvent.EVENT_TYPE.ADD);
		searchResultEvent.setElements(getMatchSet(file).toArray());
		return searchResultEvent;
	}
}
