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
public class IdentityDefaultChangeEventHandler extends IdentityChangeEventHandler {
	private static final long serialVersionUID = 1L;
    public static final IdentityDefaultChangeEventHandler INSTANCE = new IdentityDefaultChangeEventHandler();

    public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
    	notifyChanged(source, featureDesc, null, (Object)newValue);
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
    	notifyChanged(source, featureDesc, (Object)oldValue, null);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue, IEntity newValue) {
    	notifyChanged(source, featureDesc, (Object)oldValue, (Object)newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, IEntity oldValue, IEntity newValue) {
    	notifyChanged(source, featureDesc, (Object)oldValue, (Object)newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, boolean oldValue, boolean newValue) {
    	notifyChanged(source, featureDesc, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, byte oldValue, byte newValue) {
    	notifyChanged(source, featureDesc, new Byte(oldValue), new Byte(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, char oldValue, char newValue) {
    	notifyChanged(source, featureDesc, new Character(oldValue), new Character(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, double oldValue, double newValue) {
    	notifyChanged(source, featureDesc, new Double(oldValue), new Double(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, float oldValue, float newValue) {
    	notifyChanged(source, featureDesc, new Float(oldValue), new Float(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int oldValue, int newValue) {
    	notifyChanged(source, featureDesc, new Integer(oldValue), new Integer(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, long oldValue, long newValue) {
    	notifyChanged(source, featureDesc, new Long(oldValue), new Long(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, short oldValue, short newValue) {
    	notifyChanged(source, featureDesc, new Short(oldValue), new Short(newValue));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, String oldValue, String newValue) {
    	notifyChanged(source, featureDesc, (Object)oldValue, (Object)newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Date oldValue, Date newValue) {
    	notifyChanged(source, featureDesc, (Object)oldValue, (Object)newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, EnumValue oldValue, EnumValue newValue) {
    	notifyChanged(source, featureDesc, (Object)oldValue, (Object)newValue);
    }
}
