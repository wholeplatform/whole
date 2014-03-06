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

import java.io.IOException;
import java.util.Date;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class CompositeChangeEventHandler implements IChangeEventHandler {
	private static final long serialVersionUID = 1L;
	transient private IChangeEventHandler[] handlers = new IChangeEventHandler[0];

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	handlers = new IChangeEventHandler[0];
    }

    public CompositeChangeEventHandler() {
    	handlers = new IChangeEventHandler[0];
    }
    public CompositeChangeEventHandler(IChangeEventHandler eventHandler1, IChangeEventHandler eventHandler2) {
    	handlers = new IChangeEventHandler[2];
    	handlers[0] = eventHandler1;
    	handlers[1] = eventHandler2;
    }

    public boolean hasSharingEventHandler() {
    	for (int i=0; i<handlers.length; i++)
    	    if (handlers[i].hasSharingEventHandler())
    	        return true;
        return false;
    }
    public SharingChangeEventHandler getSharingEventHandler(IEntity entity) {
        if (handlers[0].hasSharingEventHandler())
            return (SharingChangeEventHandler) handlers[0];

        SharingChangeEventHandler handler;
    	for (int i=1; i<handlers.length; i++)
    	    if (handlers[i].hasSharingEventHandler()) {
    	        handler = (SharingChangeEventHandler) handlers[i];
    	        handlers[i] = handlers[0];
    	        handlers[0] = handler;
    	        return handler;
    	    }
    	IChangeEventHandler[] result = new IChangeEventHandler[handlers.length+1];
    	result[0] = handler = new SharingChangeEventHandler(entity);
    	for (int i=0; i<handlers.length; i++)
    		result[i+1] = handlers[i];
    	handlers = result;
        return handler;
    }
  
/*
    public int indexOf(IEventHandler eventHandler) {
        return handlers.indexOf(eventHandler);
    }
    public void add(int index, IEventHandler eventHandler) {
        handlers.add(index, eventHandler);
    }
    public void remove(IEventHandler eventHandler) {
        handlers.remove(eventHandler);
    }
*/
    public void set(int index, IChangeEventHandler eventHandler) {
        handlers[index] = eventHandler;
    }

    public IChangeEventHandler cloneChangeEventHandler(IChangeEventHandler parentEventHandler) {
    	for (int i=0; i<handlers.length; i++)
    	    parentEventHandler = handlers[i].cloneChangeEventHandler(parentEventHandler);
    	
    	return parentEventHandler;
    }
    
    public IChangeEventHandler addChangeEventHandler(IChangeEventHandler eventHandler) {
    	if (handlers == null)
    		handlers = new IChangeEventHandler[0]; //FIXME hotfix for standard serialization
    	
    	for (int i=0; i<handlers.length; i++)
    		if (handlers[i] == eventHandler)
    			return this;

    	IChangeEventHandler[] result = new IChangeEventHandler[handlers.length+1];
    	for (int i=0; i<handlers.length; i++)
    		result[i] = handlers[i];
    	result[handlers.length] = eventHandler;
    	handlers = result;
        return this;
    }
    public IChangeEventHandler removeChangeEventHandler(IChangeEventHandler eventHandler) {
    	for (int i=0; i<handlers.length; i++) {
    		if (handlers[i] == eventHandler) {
    			IChangeEventHandler[] result = new IChangeEventHandler[handlers.length-1];

    	    	for (int j=0; j<i; j++)
    	    		result[j] = handlers[j];
    	    	for (int j=i; j<handlers.length-1; j++)
    	    		result[j] = handlers[j+1];

    	    	handlers = result;
    	        return this;
    		}
    	}

    	for (int i=0; i<handlers.length; i++)
    		handlers[i] = handlers[i].removeChangeEventHandler(eventHandler);

        return this;
    }

    public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyAdded(source, featureDesc, index, newValue);
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyRemoved(source, featureDesc, index, oldValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue, IEntity newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, index, oldValue, newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, IEntity oldValue, IEntity newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, boolean oldValue, boolean newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, byte oldValue, byte newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, char oldValue, char newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, double oldValue, double newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, float oldValue, float newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, int oldValue, int newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, long oldValue, long newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, short oldValue, short newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, String oldValue, String newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Date oldValue, Date newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, EnumValue oldValue, EnumValue newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Object oldValue, Object newValue) {
    	for (int i=0; i<handlers.length; i++)
    		handlers[i].notifyChanged(source, featureDesc, oldValue, newValue);
    }
}
