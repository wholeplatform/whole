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
 * Demand driven event notification mechanism
 * 
 * @author Riccardo Solmi
 */
public interface IRequestEventHandler {
    public IRequestEventHandler cloneRequestEventHandler(IRequestEventHandler parentEventHandler);
    public IRequestEventHandler addRequestEventHandler(IRequestEventHandler eventHandler);
    public IRequestEventHandler removeRequestEventHandler(IRequestEventHandler eventHandler);
	
    public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, int index, E value);
    public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor feature, E value);

    public boolean notifyRequested(IEntity source, FeatureDescriptor feature, boolean value);
    public byte notifyRequested(IEntity source, FeatureDescriptor feature, byte value);
    public char notifyRequested(IEntity source, FeatureDescriptor feature, char value);
    public double notifyRequested(IEntity source, FeatureDescriptor feature, double value);
    public float notifyRequested(IEntity source, FeatureDescriptor feature, float value);
    public int notifyRequested(IEntity source, FeatureDescriptor feature, int value);
    public long notifyRequested(IEntity source, FeatureDescriptor feature, long value);
    public short notifyRequested(IEntity source, FeatureDescriptor feature, short value);
    public String notifyRequested(IEntity source, FeatureDescriptor feature, String value);
    public Date notifyRequested(IEntity source, FeatureDescriptor feature, Date value);
    public <E extends EnumValue> E notifyRequested(IEntity source, FeatureDescriptor feature, E value);
    public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value);
}
