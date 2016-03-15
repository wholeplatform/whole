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

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SharingChangeEventHandler extends IdentityChangeEventHandler {
	private static final long serialVersionUID = 1L;
    private Set<IEntity> sharingSet = new HashSet<IEntity>();
    private boolean sharingCycle = false;

    // reserved to standard serialization
    public SharingChangeEventHandler() {
    }
    public SharingChangeEventHandler(IEntity entity) {
        addEntity(entity);
    }

    public boolean hasSharingEventHandler() {
        return true;
    }
    public SharingChangeEventHandler getSharingEventHandler(IEntity entity) {
    	addEntity(entity);
        return this;
    }

    public IChangeEventHandler cloneChangeEventHandler(IChangeEventHandler parentEventHandler) {
        return parentEventHandler.addChangeEventHandler(this);
    }

    public boolean addEntity(IEntity entity) {
        return sharingSet.add(entity);
    }
    public boolean removeEntity(IEntity entity) {
        return sharingSet.remove(entity);
    }
    public Set<IEntity> sharingSet() {
        return Collections.unmodifiableSet(sharingSet);
    }

    public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
        if (sharingCycle)
        	return;
        sharingCycle = true;
        for (IEntity sharedEntity : sharingSet)
        	if (sharedEntity != source)
        		sharedEntity.wAdd(index, EntityUtils.clone(newValue));
        sharingCycle = false;
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
        if (sharingCycle)
        	return;
        sharingCycle = true;
        Iterator<IEntity> i = sharingSet.iterator();
        while (i.hasNext())
            i.next().wRemove(index);
        sharingCycle = false;
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue, IEntity newValue) {
        if (sharingCycle)
        	return;
        sharingCycle = true;
        for (IEntity sharedEntity : sharingSet)
        	if (sharedEntity != source)
        		sharedEntity.wSet(index, EntityUtils.clone(newValue));
        sharingCycle = false;
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, IEntity oldValue, IEntity newValue) {
        if (sharingCycle)
        	return;
        sharingCycle = true;
        for (IEntity sharedEntity : sharingSet)
        	if (sharedEntity != source)
        		sharedEntity.wSet(featureDesc, EntityUtils.clone(newValue));
        sharingCycle = false;
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, boolean oldValue, boolean newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, byte oldValue, byte newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, char oldValue, char newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, double oldValue, double newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, float oldValue, float newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int oldValue, int newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, long oldValue, long newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, short oldValue, short newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, String oldValue, String newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Date oldValue, Date newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, EnumValue oldValue, EnumValue newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Object oldValue, Object newValue) {
        for (IEntity e : sharingSet)
        	e.wSetValue(newValue);
    }
}
