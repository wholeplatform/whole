/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
public abstract class AbstractDelegatingEventHandler implements IEventHandler {
    public IRequestEventHandler cloneRequestEventHandler(IRequestEventHandler parentEventHandler) {
    	throw new UnsupportedOperationException();
    }
    public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler) {
    	throw new UnsupportedOperationException();
    }
    public IRequestEventHandler removeRequestEventHandler(IRequestEventHandler eventHandler) {
    	throw new UnsupportedOperationException();
    }

    public IChangeEventHandler cloneChangeEventHandler(IChangeEventHandler parentEventHandler) {
    	throw new UnsupportedOperationException();
    }
    public IChangeEventHandler addChangeEventHandler(IChangeEventHandler eventHandler) {
    	throw new UnsupportedOperationException();
    }
    public IChangeEventHandler removeChangeEventHandler(IChangeEventHandler eventHandler) {
    	throw new UnsupportedOperationException();
    }

    public boolean hasSharingEventHandler() {
        return false;
    }
    public SharingChangeEventHandler getSharingEventHandler(IEntity entity) {
        SharingChangeEventHandler handler = new SharingChangeEventHandler(entity);
        entity.wAddChangeEventHandler(handler);
        return handler;
    }

    protected abstract IRequestEventHandler getRequestEventHandler(IEntity source, FeatureDescriptor fd);
    protected abstract IChangeEventHandler getChangeEventHandler(IEntity source, FeatureDescriptor fd);

    public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor fd, int index, E value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, index, value);
	}

	public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor fd, E value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public boolean notifyRequested(IEntity source, FeatureDescriptor fd, boolean value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public byte notifyRequested(IEntity source, FeatureDescriptor fd, byte value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public char notifyRequested(IEntity source, FeatureDescriptor fd, char value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public double notifyRequested(IEntity source, FeatureDescriptor fd, double value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public float notifyRequested(IEntity source, FeatureDescriptor fd, float value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public int notifyRequested(IEntity source, FeatureDescriptor fd, int value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public long notifyRequested(IEntity source, FeatureDescriptor fd, long value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public short notifyRequested(IEntity source, FeatureDescriptor fd, short value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public String notifyRequested(IEntity source, FeatureDescriptor fd, String value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public Date notifyRequested(IEntity source, FeatureDescriptor fd, Date value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public <E extends EnumValue> E notifyRequested(IEntity source, FeatureDescriptor fd, E value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public Object notifyRequested(IEntity source, FeatureDescriptor fd, Object value) {
		return getRequestEventHandler(source, fd).notifyRequested(source, fd, value);
	}

	public void notifyAdded(IEntity source, FeatureDescriptor fd, int index, IEntity newValue) {
        getChangeEventHandler(source, fd).notifyAdded(source, fd, index, newValue);
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue) {
        getChangeEventHandler(source, fd).notifyRemoved(source, fd, index, oldValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue, IEntity newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, index, oldValue, newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, boolean oldValue, boolean newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, byte oldValue, byte newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, char oldValue, char newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, double oldValue, double newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, float oldValue, float newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, int oldValue, int newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, long oldValue, long newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, short oldValue, short newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, String oldValue, String newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, Date oldValue, Date newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, EnumValue oldValue, EnumValue newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, Object oldValue, Object newValue) {
        getChangeEventHandler(source, fd).notifyChanged(source, fd, oldValue, newValue);
    }
}
