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

import java.io.ObjectStreamException;
import java.util.Date;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public abstract class IdentityChangeEventHandler implements IChangeEventHandler {
	private static final long serialVersionUID = 1L;
    public static final IdentityChangeEventHandler instance = new IdentityChangeEventHandler() {
    	private static final long serialVersionUID = 1L;
        public IChangeEventHandler addChangeEventHandler(IChangeEventHandler eventHandler) {
        	return eventHandler;
        }

        public Object readResolve() throws ObjectStreamException {
        	return IdentityChangeEventHandler.instance;
        }
    };

    public IChangeEventHandler cloneChangeEventHandler(IChangeEventHandler parentEventHandler) {
        return this;
    }
    public IChangeEventHandler addChangeEventHandler(IChangeEventHandler eventHandler) {
    	if (this == eventHandler)
    		return this;
    	return new CompositeChangeEventHandler(this, eventHandler);
    }
    public IChangeEventHandler removeChangeEventHandler(IChangeEventHandler eventHandler) {
    	if (this == eventHandler)
    		return IdentityChangeEventHandler.instance;
    	return this;
    }

    public boolean hasSharingEventHandler() {
        return false;
    }
    public SharingChangeEventHandler getSharingEventHandler(IEntity entity) {
        SharingChangeEventHandler handler = new SharingChangeEventHandler(entity);
        entity.wAddChangeEventHandler(handler);
        return handler;
    }


    public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue, IEntity newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, IEntity oldValue, IEntity newValue) {
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, boolean oldValue, boolean newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, byte oldValue, byte newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, char oldValue, char newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, double oldValue, double newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, float oldValue, float newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int oldValue, int newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, long oldValue, long newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, short oldValue, short newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, String oldValue, String newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Date oldValue, Date newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, EnumValue oldValue, EnumValue newValue) {
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Object oldValue, Object newValue) {
    }
}
