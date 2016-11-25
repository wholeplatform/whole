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
package org.whole.lang.events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ObjectStreamException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class PropertyChangeEventHandler extends IdentityDefaultChangeEventHandler {
	private static final long serialVersionUID = 1L;
    transient private Set<IPropertyChangeObserver> eventListeners = new HashSet<>();
    public Object readResolve() throws ObjectStreamException {
    	return new PropertyChangeEventHandler();
    }

	public boolean hasEventListeners() {
	    return !eventListeners.isEmpty();
	}

	public synchronized Set<IPropertyChangeObserver> getEventListeners() {
		return eventListeners;
	}
	public synchronized void setEventListeners(Set<IPropertyChangeObserver> eventListeners) {
	    this.eventListeners = eventListeners;
	}
	public synchronized void addAllEventListeners(Collection<? extends IPropertyChangeObserver> eventListeners) {
	    getEventListeners().addAll(eventListeners);
	}
	public synchronized void addEventListener(IPropertyChangeObserver eventListener) {
		getEventListeners().add(eventListener);
    }
    public synchronized void removeEventListener(IPropertyChangeObserver eventListener) {
    	getEventListeners().remove(eventListener);
    }

    public void notifyEvent(IEntity source, String name, Object data) {
    	notifyChanged(source, name, null, data);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, Object oldValue, Object newValue) {
    	notifyChanged(source, fd.getName(), oldValue, newValue);
    }
    public void notifyChanged(IEntity source, String featureName, Object oldValue, Object newValue) {
        if (eventListeners.isEmpty())
        	return;

    	PropertyChangeEvent event = new PropertyChangeEvent(source, featureName, oldValue, newValue);

		Object[] targets;
    	synchronized (this) {
   	        targets = eventListeners.toArray();
    	}
	    for (int i = 0; i < targets.length; i++)
	        ((PropertyChangeListener) targets[i]).propertyChange(event);
    }
}
