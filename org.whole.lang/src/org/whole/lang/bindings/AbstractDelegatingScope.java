/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.bindings;

import java.util.Date;
import java.util.Set;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDelegatingScope implements IDelegatingScope {
	private IBindingScope targetScope;
	
	protected AbstractDelegatingScope(IBindingScope targetScope) {
		this.targetScope = targetScope;
	}

	public IBindingScope wTargetScope() {
		return targetScope;
	}
	public void wSetTargetScope(IBindingScope scope) {
		targetScope = scope;
	}
	public IDelegatingScope wWithTargetScope(IBindingScope scope) {
		wSetTargetScope(scope);
		return this;
	}

	public IBindingScope wEnclosingScope() {
		return targetScope.wEnclosingScope();
	}

	public void wClear() {
		targetScope.wClear();
	}

	public Set<String> wNames() {
		return targetScope.wNames();
	}

	public Set<String> wLocalNames() {
		return targetScope.wLocalNames();
	}

	public void wAddAll(IBindingScope scope) {
		if (scope == NullScope.instance)
			return;
		if (scope.wEnclosingScope() == this) {
			for (String name : scope.wLocalNames())
				targetScope.wDef(name, scope.wGet(name));
		} else
			targetScope.wAddAll(scope);
	}

	public IEntity wGet(String name) {
		return targetScope.wGet(name);
	}
	public void wAdd(String name, IEntity value) {
		targetScope.wAdd(name, value);
	}
	public void wSet(String name, IEntity value) {
		targetScope.wSet(name, value);
	}
	public void wDef(String name, IEntity value) {
		targetScope.wDef(name, value);
	}
	public boolean wIsSet(String name) {
		return targetScope.wIsSet(name);
	}
	public void wUnset(String name) {
		targetScope.wUnset(name);
	}

	public boolean wBooleanValue(String name) {
		return targetScope.wBooleanValue(name);
	}
	public byte wByteValue(String name) {
		return targetScope.wByteValue(name);
	}
	public char wCharValue(String name) {
		return targetScope.wCharValue(name);
	}
	public Date wDateValue(String name) {
		return targetScope.wDateValue(name);
	}
	public double wDoubleValue(String name) {
		return targetScope.wDoubleValue(name);
	}
	public EnumValue wEnumValue(String name) {
		return targetScope.wEnumValue(name);
	}
	public float wFloatValue(String name) {
		return targetScope.wFloatValue(name);
	}
	public Object wGetValue(String name) {
		return targetScope.wGetValue(name);
	}
	public int wIntValue(String name) {
		return targetScope.wIntValue(name);
	}
	public long wLongValue(String name) {
		return targetScope.wLongValue(name);
	}
	public short wShortValue(String name) {
		return targetScope.wShortValue(name);
	}
	public String wStringValue(String name) {
		return targetScope.wStringValue(name);
	}

	public void wSetValue(String name, boolean value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, byte value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, char value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, Date value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, double value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, EnumValue value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, float value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, int value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, long value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, Object value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, short value) {
		targetScope.wSetValue(name, value);
	}
	public void wSetValue(String name, String value) {
		targetScope.wSetValue(name, value);
	}

	public void wAddValue(String name, boolean value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, byte value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, char value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, Date value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, double value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, EnumValue value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, float value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, int value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, long value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, Object value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, short value) {
		targetScope.wAddValue(name, value);
	}
	public void wAddValue(String name, String value) {
		targetScope.wAddValue(name, value);
	}

	public void wDefValue(String name, boolean value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, byte value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, char value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, Date value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, double value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, EnumValue value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, float value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, int value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, long value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, Object value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, short value) {
		targetScope.wDefValue(name, value);
	}
	public void wDefValue(String name, String value) {
		targetScope.wDefValue(name, value);
	}

	public boolean isResultIterator() {
		return targetScope.isResultIterator();
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return targetScope.getResultIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		targetScope.setResultIterator(resultIterator);
	}
	public IEntity getResult() {
		return targetScope.getResult();
	}
	public void setResult(IEntity value) {
		targetScope.setResult(value);
	}

	public String toString() {
		return targetScope.toString();
	}
}
