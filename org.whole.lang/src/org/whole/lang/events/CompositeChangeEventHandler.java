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
    public CompositeChangeEventHandler(IChangeEventHandler... eventHandlers) {
    	handlers = eventHandlers;
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
  
    public void setChangeEventHandler(int index, IChangeEventHandler eventHandler) {
        handlers[index] = eventHandler;
    }

    public IChangeEventHandler cloneChangeEventHandler(IChangeEventHandler parentEventHandler) {
    	for (int i=0; i<handlers.length; i++)
    	    parentEventHandler = parentEventHandler.addChangeEventHandler(
    	    		handlers[i].cloneChangeEventHandler(IdentityChangeEventHandler.instance));
    	
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

    public void notifyAdded(IEntity source, FeatureDescriptor fd, int index, IEntity newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyAdded(source, fd, index, newValue);
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyRemoved(source, fd, index, oldValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue, IEntity newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, index, oldValue, newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, boolean oldValue, boolean newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, byte oldValue, byte newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, char oldValue, char newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, double oldValue, double newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, float oldValue, float newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, int oldValue, int newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, long oldValue, long newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, short oldValue, short newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, String oldValue, String newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, Date oldValue, Date newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, EnumValue oldValue, EnumValue newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, Object oldValue, Object newValue) {
    	for (int i=0; i<handlers.length; i++)
    		getActualEventHandler(handlers[i], source).notifyChanged(source, fd, oldValue, newValue);
    }
}
