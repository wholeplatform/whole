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
public class IdentityRequestEventHandler implements IRequestEventHandler {
    public static final IdentityRequestEventHandler instance = new IdentityRequestEventHandler() {
        public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler) {
        	return eventHandler;
        }

        public Object readResolve() throws ObjectStreamException {
        	return IdentityRequestEventHandler.instance;
        }
    };

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

    
    public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, int index, E value) {
		return value;
	}

	public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, E value) {
		return value;
	}

	public boolean notifyRequested(IEntity source, FeatureDescriptor feature, boolean value) {
		return value;
	}

	public byte notifyRequested(IEntity source, FeatureDescriptor feature, byte value) {
		return value;
	}

	public char notifyRequested(IEntity source, FeatureDescriptor feature, char value) {
		return value;
	}

	public double notifyRequested(IEntity source, FeatureDescriptor feature, double value) {
		return value;
	}

	public float notifyRequested(IEntity source, FeatureDescriptor feature, float value) {
		return value;
	}

	public int notifyRequested(IEntity source, FeatureDescriptor feature, int value) {
		return value;
	}

	public long notifyRequested(IEntity source, FeatureDescriptor feature, long value) {
		return value;
	}

	public short notifyRequested(IEntity source, FeatureDescriptor feature, short value) {
		return value;
	}

	public String notifyRequested(IEntity source, FeatureDescriptor feature, String value) {
		return value;
	}

	public Date notifyRequested(IEntity source, FeatureDescriptor feature, Date value) {
		return value;
	}

	public <E extends EnumValue> E notifyRequested(IEntity source, FeatureDescriptor feature, E value) {
		return value;
	}

	public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
		return value;
	}
}
