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

import java.util.Date;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class DelegatingChangeEventHandler extends IdentityChangeEventHandler {
    protected abstract IChangeEventHandler getEventHandler(IEntity source, FeatureDescriptor fd);

    public void notifyAdded(IEntity source, FeatureDescriptor fd, int index, IEntity newValue) {
        getEventHandler(source, fd).notifyAdded(source, fd, index, newValue);
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue) {
        getEventHandler(source, fd).notifyRemoved(source, fd, index, oldValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue, IEntity newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, index, oldValue, newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, boolean oldValue, boolean newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, byte oldValue, byte newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, char oldValue, char newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, double oldValue, double newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, float oldValue, float newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, int oldValue, int newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, long oldValue, long newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, short oldValue, short newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, String oldValue, String newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, Date oldValue, Date newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, EnumValue oldValue, EnumValue newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, Object oldValue, Object newValue) {
        getEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }
}
