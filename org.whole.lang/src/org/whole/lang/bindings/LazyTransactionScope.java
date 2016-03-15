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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 * 
 * TODO require managed outer scope propagation
 */
public class LazyTransactionScope extends SimpleScope implements ITransactionScope {
	private IBindingScope enclosingScope = NullScope.instance;
	protected Set<String> defNames, unsetNames;
	public static enum DefinedResult { NONE, VALUE, ITERATOR };
	protected DefinedResult definedResult = DefinedResult.NONE;

	protected LazyTransactionScope() {
		this(new HashMap<String, IEntity>(), new HashSet<String>(), new HashSet<String>());
	}
	protected LazyTransactionScope(Map<String, IEntity> map, Set<String> defNames, Set<String> unsetNames) {
		super(map);
		this.defNames = defNames;
		this.unsetNames = unsetNames;
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		LazyTransactionScope scope = (LazyTransactionScope) super.clone(cc);
		scope.defNames = new HashSet<String>(defNames);
		scope.unsetNames = new HashSet<String>(unsetNames);
		scope.enclosingScope = cc.clone(enclosingScope);
		return scope;
	}

	public Kind getKind() {
		return Kind.OUTER_SCOPE_ADAPTER;
	}

	public IBindingScope wTargetScope() {
		return this;
	}
	public IBindingScope wEnclosingScope() {
		return enclosingScope;
	}
	public ITransactionScope wWithEnclosingScope(IBindingScope enclosingScope) {
		this.enclosingScope = enclosingScope;
		return this;
	}

	public boolean isChanged() {
		return !map.isEmpty() || definedResult != DefinedResult.NONE;
	}
	public void rollback() {
		map.clear();
		defNames.clear();
		unsetNames.clear();

		definedResult = DefinedResult.NONE;
		result = null;
		resultIterator = null;
	}
	public void commit() {
		for (String name : unsetNames)
			wEnclosingScope().wUnset(name);
		for (Entry<String, IEntity> entry : map.entrySet()) {
			final String name = entry.getKey();
			final IEntity value = entry.getValue();
			if (defNames.contains(name))
				wEnclosingScope().wDef(name, value);
			else
				wEnclosingScope().wSet(name, value);
		}

		if (definedResult == DefinedResult.VALUE)
			wEnclosingScope().setResult(result);
		if (definedResult == DefinedResult.ITERATOR)
			wEnclosingScope().setResultIterator(resultIterator);

		map.clear();
		defNames.clear();
		unsetNames.clear();

		definedResult = DefinedResult.NONE;
		result = null;
		resultIterator = null;
	}

	public void wClear() {
		for (String name : defNames)
			super.wUnset(name);
		defNames.clear();
	}

	public Set<String> wLocalNames() {
		Set<String> nameSet = new HashSet<String>(wEnclosingScope().wLocalNames());
		nameSet.removeAll(unsetNames);
		nameSet.addAll(defNames);
		return Collections.unmodifiableSet(nameSet);
	}
	public Set<String> wNames() {
		Set<String> nameSet = wEnclosingScope().wNames();
		nameSet.removeAll(unsetNames);
		nameSet.addAll(defNames);
		return nameSet;
	}

	public IBindingScope wFindScope(String name) {
		if (unsetNames.contains(name))
			return VoidScope.instance;
		else
			return super.wIsSet(name) ? this : wEnclosingScope().wFindScope(name);
	}

	public boolean wIsSet(String name) {
		if (defNames.contains(name))
			return true;
		else if (unsetNames.contains(name))
			return false;
		else
			return super.wIsSet(name) ? true : wEnclosingScope().wIsSet(name);
	}
	public IEntity wGet(String name) {
		if (unsetNames.contains(name))
			return null;
		IEntity value = super.wGet(name);
		return (value != null) ? value : wEnclosingScope().wGet(name);
	}
	public void wSet(String name, IEntity value) {
		unsetNames.remove(name);
		super.wDef(name, value);
	}
	public void wDef(String name, IEntity value) {
		defNames.add(name);
		unsetNames.remove(name);
		super.wDef(name, value);
	}

	public void wUnset(String name) {
		defNames.remove(name);
		unsetNames.add(name);
		super.wUnset(name);
	}

	public IBindingScope wResultScope() {
		return resultScope != null ? resultScope : wEnclosingScope().wResultScope();
	}
	public void wSetResultScope(IBindingScope scope) {
		resultScope = scope;
	}

	public boolean hasResultIterator() {
		if (wResultScope() != this)
			return wEnclosingScope().hasResultIterator();
		else
			return super.hasResultIterator();
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		if (wResultScope() != this)
			return wEnclosingScope().getResultIterator();
		else
			return super.getResultIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		definedResult = DefinedResult.ITERATOR;
		super.setResultIterator(resultIterator);
	}
	public void setResult(IEntity value) {
		definedResult = DefinedResult.VALUE;
		super.setResult(value);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- begin transaction scope ---\n");
		sb.append("--- defined names: ");
		sb.append(new TreeSet<String>(defNames));
		sb.append('\n');
		sb.append("--- unset names: ");
		sb.append(new TreeSet<String>(unsetNames));
		sb.append('\n');
		sb.append(super.toString());
		sb.append("--- end transaction scope -----\n");
		return sb.toString();
	}
}
