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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class NestedDynamicSimpleScope extends SimpleScope implements INestableScope {
	private IBindingScope enclosingScope = NullScope.instance;

	protected NestedDynamicSimpleScope() {
		this(new HashMap<String, IEntity>());
	}
	protected NestedDynamicSimpleScope(Map<String, IEntity> map) {
		super(map);
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		NestedDynamicSimpleScope scope = (NestedDynamicSimpleScope) super.clone(cc);
		scope.enclosingScope = cc.clone(enclosingScope);
		return scope;
	}

	public IBindingScope wEnclosingScope() {
		return enclosingScope;
	}
	public INestableScope wWithEnclosingScope(IBindingScope enclosingScope) {
		this.enclosingScope = enclosingScope;
		resultScope = null;
		return this;
	}

	public IBindingScope wFindScope(String name) {
		return super.wIsSet(name) ? this : wEnclosingScope().wFindScope(name);
	}

	public boolean wIsSet(String name) {
		return super.wIsSet(name) ? true : wEnclosingScope().wIsSet(name);
	}
	public IEntity wGet(String name) {
		IEntity value = super.wGet(name);
		return (value != null) ? value : wEnclosingScope().wGet(name);
	}
	public void wSet(String name, IEntity value) {
		if (super.wIsSet(name))
			wDef(name, value);//= wSet without if wIsSet
		else
			wEnclosingScope().wSet(name, value);
	}
	public void wUnset(String name) {
		if (super.wIsSet(name))
			super.wUnset(name);
		else
			wEnclosingScope().wUnset(name);
	}

	public IBindingScope wResultScope() {
		if (resultScope == null)
			resultScope = wEnclosingScope().wResultScope();
		return resultScope != null ? resultScope : this;
	}
	public void wSetResultScope(IBindingScope scope) {
		if (scope != this)
			wEnclosingScope().wSetResultScope(scope);
		//assert resultScope == null || resultScope == scope;
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
		if (wResultScope() != this)
			wEnclosingScope().setResultIterator(resultIterator);
		else
			super.setResultIterator(resultIterator);
	}
	public IEntity getResult() {
		if (wResultScope() != this)
			return wEnclosingScope().getResult();
		else
			return super.getResult();
	}
	public void setResult(IEntity result) {
		if (wResultScope() != this)
			wEnclosingScope().setResult(result);
		else
			super.setResult(result);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- begin dynamic simple scope ---\n");
		SortedMap<String, IEntity> treeMap = new TreeMap<String, IEntity>(map);
		toString(sb, treeMap);
		sb.append("--- enclosing scope(s) ----\n");
		Set<String> enclosingNames = new TreeSet<String>(enclosingScope.wNames());
		enclosingNames.removeAll(map.keySet());
		toString(sb, enclosingScope, enclosingNames);
		sb.append("--- end dynamic simple scope -----\n");
		return sb.toString();
	}
}
