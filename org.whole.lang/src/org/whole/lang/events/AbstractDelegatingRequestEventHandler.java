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
public abstract class AbstractDelegatingRequestEventHandler implements IRequestEventHandler {
    protected abstract IRequestEventHandler getRequestEventHandler(IEntity source, FeatureDescriptor fd);

    public IRequestEventHandler cloneRequestEventHandler(IRequestEventHandler parentEventHandler) {
    	throw new UnsupportedOperationException();
    }
    public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler) {
    	throw new UnsupportedOperationException();
    }
    public IRequestEventHandler removeRequestEventHandler(IRequestEventHandler eventHandler) {
    	throw new UnsupportedOperationException();
    }

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
}
