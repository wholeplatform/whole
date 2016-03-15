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
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class SimpleScope extends AbstractScope {
	protected Map<String, IEntity> map;
    protected IEntity result;
    protected IEntityIterator<?> resultIterator;

	protected SimpleScope() {
		this(new HashMap<String, IEntity>());
	}
	protected SimpleScope(Map<String, IEntity> map) {
		this.map = map;
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		SimpleScope scope = (SimpleScope) super.clone(cc);
		scope.map = new HashMap<String, IEntity>(map);
		scope.resultScope = resultScope == this ? scope : null;
		return scope;
	}

//	@SuppressWarnings("unchecked")
//	protected Map<String, IEntity> deepCloneMap() {
//		Map<String, IEntity> copy_map = (Map<String, IEntity>) ((HashMap<String, IEntity>) map).clone();
//		for (Entry<String, IEntity> entry : copy_map.entrySet()) {
//			entry.setValue(EntityUtils.clone(entry.getValue()));
//		}
//		return copy_map;
//	}

	public IBindingScope wTargetScope() {
		return this;
	}
	public IBindingScope wEnclosingScope() {
		return NullScope.instance;
	}

	public void wClear() {
		map.clear();
	}

	public Set<String> wLocalNames() {
		return Collections.unmodifiableSet(map.keySet());
	}

	public IEntity wGet(String name) {
		return map.get(name);
	}
	public void wSet(String name, IEntity value) {
		if (wIsSet(name))
			map.put(name, value);
		else
			throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public void wDef(String name, IEntity value) {
		map.put(name, value);
	}
	public boolean wIsSet(String name) {
		return map.containsKey(name);
	}
	public void wUnset(String name) {
		map.remove(name);
	}

	public IBindingScope wFindScope(String name) {
		return wIsSet(name) ? this : VoidScope.instance;
	}
	
	protected IBindingScope resultScope;
	public IBindingScope wResultScope() {
		return resultScope;
	}
	public void wSetResultScope(IBindingScope scope) {
		//assert scope == this;
		//assert resultScope == null || resultScope == scope;
		resultScope = scope;	
	}

	public boolean hasResultIterator() {
		return resultIterator != null;
	}
	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		if (resultIterator != null)
			return (IEntityIterator<E>) resultIterator;
		else
			return IteratorFactory.constantIterator((E) (result != null ? result : BindingManagerFactory.instance.createVoid()), false);
	}
	public IEntity getResult() {
		return result;
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		this.result = null;
		this.resultIterator = resultIterator;
	}
	public void setResult(IEntity result) {
		this.result = result;
		this.resultIterator = null;
	}

	public String toString() {
		SortedMap<String, IEntity> treeMap = new TreeMap<String, IEntity>(map);
		StringBuilder sb = new StringBuilder();
		sb.append("--- begin simple scope ---\n");
		toString(sb, treeMap);
		sb.append("--- end simple scope -----\n");
		return sb.toString();
	}
}
