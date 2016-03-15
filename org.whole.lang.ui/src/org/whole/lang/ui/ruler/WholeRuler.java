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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.rulers.RulerProvider;

/**
 * @author Riccardo Solmi
 */
public class WholeRuler {
	public static final String PROPERTY_CHILDREN = "children changed";
	public static final String PROPERTY_UNIT = "units changed";

	private List guides = new ArrayList();
	private boolean horizontal;
	private int unit;

	public WholeRuler() {
		this(true);
	}
	public WholeRuler(boolean horizontal) {
		this(horizontal, RulerProvider.UNIT_INCHES);
	}
	public WholeRuler(boolean horizontal, int unit) {
		this.horizontal = horizontal;
		this.unit = unit;
	}

	public boolean isHorizontal() {
		return horizontal;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}

	public List getGuides() {
		return guides;
	}
	public void addGuide(WholeGuide guide) {
		if (!guides.contains(guide)) {
			guides.add(guide);
			listeners.firePropertyChange(PROPERTY_CHILDREN, null, guide);
		}
	}
	public void removeGuide(WholeGuide guide) {
		if (guides.remove(guide)) {
			listeners.firePropertyChange(PROPERTY_CHILDREN, null, guide);
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
