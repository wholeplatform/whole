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
public class CompositeOneRequestEventHandler implements IRequestEventHandler {
	transient private IRequestEventHandler[] handlers;

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	handlers = new IRequestEventHandler[0];
    }

    public CompositeOneRequestEventHandler() {
    	handlers = new IRequestEventHandler[0];
    }
    public CompositeOneRequestEventHandler(IRequestEventHandler eventHandler1, IRequestEventHandler eventHandler2) {
    	handlers = new IRequestEventHandler[2];
    	handlers[0] = eventHandler1;
    	handlers[1] = eventHandler2;
    }

    public IRequestEventHandler cloneRequestEventHandler(IRequestEventHandler parentEventHandler) {
    	for (int i=0; i<handlers.length; i++)
    	    parentEventHandler = handlers[i].cloneRequestEventHandler(parentEventHandler);
    	
    	return parentEventHandler;
    }
    public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler) {
    	IRequestEventHandler[] result = new IRequestEventHandler[handlers.length+1];
    	for (int i=0; i<handlers.length; i++) {
    		result[i] = handlers[i];
    		if (handlers[i] == eventHandler)
    			return this;
    	}
    	result[handlers.length] = eventHandler;
    	handlers = result;
        return this;
    }
    public IRequestEventHandler removeRequestEventHandler(IRequestEventHandler eventHandler) {
    	for (int i=0; i<handlers.length; i++) {
    		if (handlers[i] == eventHandler) {
    	    	IRequestEventHandler[] result = new IRequestEventHandler[handlers.length-1];

    	    	for (int j=0; j<i; j++)
    	    		result[j] = handlers[j];
    	    	for (int j=i; j<handlers.length-1; j++)
    	    		result[j] = handlers[j+1];

    	    	handlers = result;
    	        return this;
    		}
    	}

    	for (int i=0; i<handlers.length; i++) {
    		handlers[i] = removeRequestEventHandler(eventHandler);
    	}
        return this;
    }

    
    public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, int index, E value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, index, value);
    		} catch (RequestException e) {
    		}
    	return value;
	}

	public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, E value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			E newValue = handlers[i].notifyRequested(source, feature, value);
    			if (newValue != value)
    				return newValue;
    		} catch (RequestException e) {
    		}
		return value;
	}

	public boolean notifyRequested(IEntity source, FeatureDescriptor feature, boolean value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public byte notifyRequested(IEntity source, FeatureDescriptor feature, byte value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public char notifyRequested(IEntity source, FeatureDescriptor feature, char value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public double notifyRequested(IEntity source, FeatureDescriptor feature, double value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public float notifyRequested(IEntity source, FeatureDescriptor feature, float value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public int notifyRequested(IEntity source, FeatureDescriptor feature, int value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public long notifyRequested(IEntity source, FeatureDescriptor feature, long value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public short notifyRequested(IEntity source, FeatureDescriptor feature, short value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public String notifyRequested(IEntity source, FeatureDescriptor feature, String value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public Date notifyRequested(IEntity source, FeatureDescriptor feature, Date value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public <E extends EnumValue> E notifyRequested(IEntity source, FeatureDescriptor feature, E value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}

	public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
    	for (int i=0; i<handlers.length; i++)
    		try {
    			return handlers[i].notifyRequested(source, feature, value);
    		} catch (RequestException e) {
    		}
		return value;
	}
}
