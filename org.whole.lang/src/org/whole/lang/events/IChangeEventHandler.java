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

import java.io.Serializable;
import java.util.Date;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * Data driven event notification mechanism
 * 
 * invariants:
 * 		oldValue != newValue
 * 		oldValue xor newValue can be null
 * 
 * @author Riccardo Solmi
 */
public interface IChangeEventHandler extends Serializable {
    public IChangeEventHandler cloneChangeEventHandler(IChangeEventHandler parentEventHandler);
    public IChangeEventHandler addChangeEventHandler(IChangeEventHandler eventHandler);
    public IChangeEventHandler removeChangeEventHandler(IChangeEventHandler eventHandler);

    public boolean hasSharingEventHandler();
    public SharingChangeEventHandler getSharingEventHandler(IEntity entity);

    public void notifyAdded(IEntity source, FeatureDescriptor feature, int index, IEntity newValue);
    public void notifyRemoved(IEntity source, FeatureDescriptor feature, int index, IEntity oldValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, int index, IEntity oldValue, IEntity newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, IEntity oldValue, IEntity newValue);

    public void notifyChanged(IEntity source, FeatureDescriptor feature, boolean oldValue, boolean newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, byte oldValue, byte newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, char oldValue, char newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, double oldValue, double newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, float oldValue, float newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, int oldValue, int newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, long oldValue, long newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, short oldValue, short newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, String oldValue, String newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, Date oldValue, Date newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, EnumValue oldValue, EnumValue newValue);
    public void notifyChanged(IEntity source, FeatureDescriptor feature, Object oldValue, Object newValue);
}
