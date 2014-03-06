/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
    protected abstract IChangeEventHandler getEventHandler(IEntity source, FeatureDescriptor featureDesc);

    public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
        getEventHandler(source, featureDesc).notifyAdded(source, featureDesc, index, newValue);
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
        getEventHandler(source, featureDesc).notifyRemoved(source, featureDesc, index, oldValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue, IEntity newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, index, oldValue, newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, IEntity oldValue, IEntity newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, boolean oldValue, boolean newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, byte oldValue, byte newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, char oldValue, char newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, double oldValue, double newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, float oldValue, float newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int oldValue, int newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, long oldValue, long newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, short oldValue, short newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, String oldValue, String newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Date oldValue, Date newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, EnumValue oldValue, EnumValue newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Object oldValue, Object newValue) {
        getEventHandler(source, featureDesc).notifyChanged(source, featureDesc, oldValue, newValue);
    }
}
