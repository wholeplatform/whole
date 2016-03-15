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
package org.whole.lang.model;

import java.io.IOException;
import java.util.Date;

import org.whole.lang.commands.ICommand;
import org.whole.lang.commands.NullCommand;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractDataEntity extends AbstractEntity {
	transient private ICommand lastCommand = NullCommand.instance;

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	lastCommand = NullCommand.instance;
    }

    public IEntity wShallowClone() {
    	AbstractDataEntity entity = (AbstractDataEntity) super.wShallowClone();
    	entity.lastCommand = NullCommand.instance;
    	return entity;
    }

	public /*final*/ ICommand wGetLastCommand() {
		return lastCommand;
	}
	public /*final*/ ICommand wSetLastCommand(ICommand command) {
		ICommand prevCommand = lastCommand;
		lastCommand = command;
		return prevCommand;
	}

    public EntityKinds wGetEntityKind() {
    	return EntityKinds.DATA;
    }

    public void wAccept(GenericMatcher matcher, IEntity other) {
    	matcher.matchDataEntity(this, other);
    }

    public boolean wIsSet(FeatureDescriptor feature) {
        return wContains(feature);
    }
    public void wUnset(FeatureDescriptor feature) {
    	if (wContains(feature))
    		wUnset();
    	else
    		super.wUnset();
    }
    public boolean wIsSet() {
        return true;
    }
    public void wUnset() {
    	wGetParent().wUnset(this);
    }

	public boolean wBooleanValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public byte wByteValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public char wCharValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public double wDoubleValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public float wFloatValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public int wIntValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public long wLongValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public short wShortValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public String wStringValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public Date wDateValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public EnumValue wEnumValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public Object wGetValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(boolean value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(byte value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(char value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(double value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(float value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(int value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(long value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(short value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(Date value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(EnumValue value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public void wSetValue(Object value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public int wHashCode() {
		return wGetValue().hashCode();
	}
	public boolean wEquals(IEntity entity) {
	  	if (this == entity) return true;
    	if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor())) return false;
		try {
			return wContainsValue(entity.wGetValue());
		} catch (Exception e) {
			return false;
		}
	}

	public boolean wContainsValue(Object otherValue) {
    	Object thisValue = wGetValue();
    	if (thisValue == null)
    		return otherValue == null;
		return thisValue.equals(otherValue);
	}
	
	public String toString() {
		return toDebugString();
	}
	public String toDebugString() {
		return String.valueOf(wGetValue());
	}
}
