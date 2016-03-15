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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class EarlyTransactionScope extends AbstractDelegatingScope implements ITransactionScope {
	private static final IEntity UNDEF_VALUE = BindingManagerFactory.instance.createValue((Object) null);
	protected Map<String, IEntity> map;
	public static enum CachedResult { NONE, VALUE, ITERATOR };
	protected CachedResult cachedResult = CachedResult.NONE;
	protected IEntity result = null;
	protected IEntityIterator<?> resultIterator = null;

	protected EarlyTransactionScope() {
		this(new HashMap<String, IEntity>());
	}
	protected EarlyTransactionScope(Map<String, IEntity> map) {
		super(NullScope.instance);
		this.map = map;
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		EarlyTransactionScope scope = (EarlyTransactionScope) super.clone(cc);
		scope.map = new HashMap<String, IEntity>(map);
		return scope;
	}

	public Kind getKind() {
		return Kind.OUTER_SCOPE_ADAPTER;
	}

	public IBindingScope wTargetScope() {
		return this;
	}
	public final IBindingScope wEnclosingScope() {
		return wDelegateScope();
	}
	public final ITransactionScope wWithEnclosingScope(IBindingScope enclosingScope) {
		wSetDelegateScope(enclosingScope);
		return this;
	}

	public boolean isChanged() {
		return !map.isEmpty() || cachedResult != CachedResult.NONE;
	}
	public void commit() {
		map.clear();

		cachedResult = CachedResult.NONE;
		result = null;
		resultIterator = null;
	}
	public void rollback() {
		for (Entry<String, IEntity> entry : map.entrySet()) {
			final String name = entry.getKey();
			final IEntity value = entry.getValue();
			if (value == UNDEF_VALUE)
				super.wUnset(name);
			else if (super.wIsSet(name))
				super.wSet(name, value);
			else
				super.wDef(name, value);
		}

		if (cachedResult == CachedResult.VALUE)
			super.setResult(result);
		if (cachedResult == CachedResult.ITERATOR)
			super.setResultIterator(resultIterator);
	}
	
	private void updateMap(String name) {
		if (!map.containsKey(name)) {
//TODO
//			IBindingScope scope = wFindScope(name);
//			IEntity value = scope.wGet(name);
			IEntity value = super.wGet(name);
			map.put(name, value != null ? value : UNDEF_VALUE);
		}
	}

	@Override
	public void wAddAll(IBindingScope scope) {
		if (scope == NullScope.instance)
			return;
		Set<String> names = scope.wEnclosingScope() == this ?
				scope.wLocalNames() :
				scope.wNames();
		for (String name : names)
			updateMap(name);
		super.wAddAll(scope);
	}

	public void wClear() {
		for (String name : super.wLocalNames())
			updateMap(name);
		super.wClear();
	}

	public void wUnset(String name) {
		updateMap(name);
		super.wUnset(name);
	}

	public void wSet(String name, IEntity value) {
		updateMap(name);
		super.wSet(name, value);
	}

	public void wDef(String name, IEntity value) {
		updateMap(name);
		super.wDef(name, value);
	}

	public void wSetValue(String name, boolean value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, byte value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, char value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, Date value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, double value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, EnumValue value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, float value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, int value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, long value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, Object value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, short value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, String value) {
		updateMap(name);
		super.wSetValue(name, value);
	}

	public void wDefValue(String name, boolean value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, byte value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, char value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, Date value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, double value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, EnumValue value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, float value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, int value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, long value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, Object value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, short value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, String value) {
		updateMap(name);
		super.wDefValue(name, value);
	}

	@Override
	public void wSetResultScope(IBindingScope scope) {
		super.wSetResultScope(scope != this ? scope : scope.wEnclosingScope());
	}

	public void setResultIterator(IEntityIterator<?> resultIterator) {
		if (cachedResult == CachedResult.NONE) {
			cachedResult = CachedResult.ITERATOR;
			this.resultIterator = super.getResultIterator();
		}
		super.setResultIterator(resultIterator);
	}
	public void setResult(IEntity value) {
		if (cachedResult == CachedResult.NONE) {
			cachedResult = CachedResult.VALUE;
			this.result = super.getResult();
		}
		super.setResult(value);
	}

	public String toString() {
		SortedSet<String> treeSet = new TreeSet<String>(map.keySet());
		StringBuilder sb = new StringBuilder();
		sb.append("--- begin resettable scope ---\n");
		sb.append("--- changed names: ");
		sb.append(treeSet);
		sb.append('\n');
		sb.append(super.toString());
		sb.append("--- end resettable scope -----\n");
		return sb.toString();
	}
}
