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

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;

/**
 * @author Enrico Persiani
 */
public class WholeMatchEvent extends SearchResultEvent {
	private static final long serialVersionUID = 1L;

	public enum EVENT_TYPE { ADD, REMOVE, REMOVEALL }

	private EVENT_TYPE eventType;
	private Object[] elements;

	protected WholeMatchEvent(ISearchResult searchResult) {
		super(searchResult);
	}

	public void setType(EVENT_TYPE eventType) {
		this.eventType = eventType;
	}

	public EVENT_TYPE getType() {
		return eventType;
	}

	public Object[] getElements() {
		return elements;
	}

	public void setElements(Object[] elements) {
		this.elements = elements;
	}

	public void setElement(Object element) {
		this.elements = new Object[] {element};
	}
}
