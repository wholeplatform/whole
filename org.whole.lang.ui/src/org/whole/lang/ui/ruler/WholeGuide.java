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
package org.whole.lang.ui.ruler;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class WholeGuide {
	public static final String PROPERTY_CHILDREN = "attached parts changed";
	public static final String PROPERTY_POSITION = "position changed";

	public WholeGuide(boolean horizontal) {
		setHorizontal(horizontal);
	}

	private int position;
	public int getPosition() {
		return position;
	}
	public void setPosition(int offset) {
		if (position != offset)
			listeners.firePropertyChange(PROPERTY_POSITION,
					new Integer(position), new Integer(position = offset));
	}

	private boolean horizontal;
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean isHorizontal) {
		horizontal = isHorizontal;
	}

	private Map map;
	public Map getMap() {
		if (map == null) {
			map = new Hashtable();
		}
		return map;
	}
	public Set getParts() {
		return getMap().keySet();
	}

	public void attachPart(IEntity part, int alignment) {
		if (getMap().containsKey(part))
			return;

		getMap().put(part, new Integer(alignment));
		listeners.firePropertyChange(PROPERTY_CHILDREN, null, part);
	}
	public void detachPart(IEntity part) {
		if (getMap().containsKey(part)) {
			getMap().remove(part);
			listeners.firePropertyChange(PROPERTY_CHILDREN, null, part);
		}
	}

	private PropertyChangeSupport listeners = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}

}
