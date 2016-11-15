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
import java.util.logging.Logger;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class LoggerEventHandler implements IEventHandler {
	private static final long serialVersionUID = 1L;
	private static Logger logger;

	private static class SingletonHolder {
		private static final LoggerEventHandler instance = new LoggerEventHandler();
	}
	public static final LoggerEventHandler instance() {
		return SingletonHolder.instance;
	}
    private LoggerEventHandler() {
    	logger = Logger.getLogger("org.whole.lang.events");
    }

    private final String id(IEntity entity) {
    	return StringUtils.transientId(entity);
    }

    public IRequestEventHandler cloneRequestEventHandler(IRequestEventHandler parentEventHandler) {
        return this;
    }
    public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler) {
    	if (this == eventHandler)
    		return this;
    	return new CompositeOneRequestEventHandler(this, eventHandler);
    }
    public IRequestEventHandler removeRequestEventHandler(IRequestEventHandler eventHandler) {
    	if (this == eventHandler)
    		return IdentityRequestEventHandler.instance;
    	return this;
    }
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

   
    public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, int index, E value) {
		logger.info(id(source)+"."+feature.getName()+"["+index+"] = "+id(value));
    	return value;
	}

	public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, E value) {
		logger.info(id(source)+"."+feature.getName()+" = "+id(value));
		return value;
	}

	public boolean notifyRequested(IEntity source, FeatureDescriptor feature, boolean value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public byte notifyRequested(IEntity source, FeatureDescriptor feature, byte value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public char notifyRequested(IEntity source, FeatureDescriptor feature, char value) {
		logger.info(id(source)+"."+feature.getName()+" = '"+value+"'");
		return value;
	}

	public double notifyRequested(IEntity source, FeatureDescriptor feature, double value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public float notifyRequested(IEntity source, FeatureDescriptor feature, float value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public int notifyRequested(IEntity source, FeatureDescriptor feature, int value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public long notifyRequested(IEntity source, FeatureDescriptor feature, long value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public short notifyRequested(IEntity source, FeatureDescriptor feature, short value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public String notifyRequested(IEntity source, FeatureDescriptor feature, String value) {
		logger.info(id(source)+"."+feature.getName()+" = \""+value+"\"");
		return value;
	}

	public Date notifyRequested(IEntity source, FeatureDescriptor feature, Date value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public <E extends EnumValue> E notifyRequested(IEntity source, FeatureDescriptor feature, E value) {
		logger.info(id(source)+"."+feature.getName()+" = "+value);
		return value;
	}

	public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
		logger.info(id(source)+"."+feature.getName()+" = "+System.identityHashCode(value));
		return value;
	}


    public void notifyAdded(IEntity source, FeatureDescriptor feature, int index, IEntity newValue) {
		logger.info(id(source)+"."+feature.getName()+"["+index+"] = "+id(newValue));
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor feature, int index, IEntity oldValue) {
		logger.info(id(source)+"."+feature.getName()+"["+index+"] (was "+id(oldValue)+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, int index, IEntity oldValue, IEntity newValue) {
		logger.info(id(source)+"."+feature.getName()+"["+index+"] = "+id(newValue)+" (was "+id(oldValue)+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, IEntity oldValue, IEntity newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+id(newValue)+" (was "+id(oldValue)+")");
    }

    public void notifyChanged(IEntity source, FeatureDescriptor feature, boolean oldValue, boolean newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, byte oldValue, byte newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, char oldValue, char newValue) {
		logger.info(id(source)+"."+feature.getName()+" = '"+newValue+"' (was '"+oldValue+"')");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, double oldValue, double newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, float oldValue, float newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, int oldValue, int newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, long oldValue, long newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, short oldValue, short newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, String oldValue, String newValue) {
		logger.info(id(source)+"."+feature.getName()+" = \""+newValue+"\" (was \""+oldValue+"\")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, Date oldValue, Date newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, EnumValue oldValue, EnumValue newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+newValue+" (was "+oldValue+")");
    }
    public void notifyChanged(IEntity source, FeatureDescriptor feature, Object oldValue, Object newValue) {
		logger.info(id(source)+"."+feature.getName()+" = "+System.identityHashCode(newValue)+" (was "+System.identityHashCode(oldValue)+")");
    }
}
