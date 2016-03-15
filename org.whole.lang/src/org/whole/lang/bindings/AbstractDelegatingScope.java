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
package org.whole.lang.bindings;

import java.util.Date;
import java.util.Set;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDelegatingScope extends AbstractCloneableScope {
	private IBindingScope delegateScope;

	protected AbstractDelegatingScope(IBindingScope scope) {
		this.delegateScope = scope;
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		AbstractDelegatingScope scope = (AbstractDelegatingScope) super.clone(cc);
		scope.delegateScope = cc.clone(delegateScope);
		return scope;
	}

	protected IBindingScope wDelegateScope() {
		return delegateScope;
	}
	protected void wSetDelegateScope(IBindingScope scope) {
		delegateScope = scope;
	}

	public void wClear() {
		delegateScope.wClear();
	}

	public Set<String> wNames() {
		return delegateScope.wNames();
	}

	public Set<String> wLocalNames() {
		return delegateScope.wLocalNames();
	}

	public void wAddAll(IBindingScope scope) {
		if (scope == NullScope.instance)
			return;
		if (scope.wEnclosingScope() == this) {
			for (String name : scope.wLocalNames())
				delegateScope.wDef(name, scope.wGet(name));
		} else
			delegateScope.wAddAll(scope);
	}

	public IEntity wGet(String name) {
		return delegateScope.wGet(name);
	}
	public void wSet(String name, IEntity value) {
		delegateScope.wSet(name, value);
	}
	public void wDef(String name, IEntity value) {
		delegateScope.wDef(name, value);
	}
	public boolean wIsSet(String name) {
		return delegateScope.wIsSet(name);
	}
	public void wUnset(String name) {
		delegateScope.wUnset(name);
	}

	public final IBindingScope wFindScope(String name) {
		return delegateScope.wFindScope(name);
	}

	public boolean wBooleanValue(String name) {
		return delegateScope.wBooleanValue(name);
	}
	public byte wByteValue(String name) {
		return delegateScope.wByteValue(name);
	}
	public char wCharValue(String name) {
		return delegateScope.wCharValue(name);
	}
	public Date wDateValue(String name) {
		return delegateScope.wDateValue(name);
	}
	public double wDoubleValue(String name) {
		return delegateScope.wDoubleValue(name);
	}
	public EnumValue wEnumValue(String name) {
		return delegateScope.wEnumValue(name);
	}
	public float wFloatValue(String name) {
		return delegateScope.wFloatValue(name);
	}
	public Object wGetValue(String name) {
		return delegateScope.wGetValue(name);
	}
	public int wIntValue(String name) {
		return delegateScope.wIntValue(name);
	}
	public long wLongValue(String name) {
		return delegateScope.wLongValue(name);
	}
	public short wShortValue(String name) {
		return delegateScope.wShortValue(name);
	}
	public String wStringValue(String name) {
		return delegateScope.wStringValue(name);
	}

	public void wSetValue(String name, boolean value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, byte value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, char value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, Date value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, double value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, EnumValue value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, float value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, int value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, long value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, Object value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, short value) {
		delegateScope.wSetValue(name, value);
	}
	public void wSetValue(String name, String value) {
		delegateScope.wSetValue(name, value);
	}

	public void wDefValue(String name, boolean value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, byte value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, char value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, Date value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, double value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, EnumValue value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, float value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, int value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, long value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, Object value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, short value) {
		delegateScope.wDefValue(name, value);
	}
	public void wDefValue(String name, String value) {
		delegateScope.wDefValue(name, value);
	}

	public IBindingScope wResultScope() {
		return delegateScope.wResultScope();
	}
	public void wSetResultScope(IBindingScope scope) {
		delegateScope.wSetResultScope(scope);
	}

	public boolean hasResultIterator() {
		return delegateScope.hasResultIterator();
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return delegateScope.getResultIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		delegateScope.setResultIterator(resultIterator);
	}
	public IEntity getResult() {
		return delegateScope.getResult();
	}
	public void setResult(IEntity value) {
		delegateScope.setResult(value);
	}

	public String toString() {
		return delegateScope.toString();
	}
}
