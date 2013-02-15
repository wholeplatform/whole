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

import java.util.Set;
import java.util.TreeSet;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class NestedDynamicScope extends AbstractScope implements INestableScope {
	private IBindingScope targetScope;
	private IBindingScope enclosingScope = NullScope.instance;

	protected NestedDynamicScope(IBindingScope targetScope) {
		this.targetScope = targetScope;
	}

	public INestableScope wClone() {
		return new NestedDynamicScope(wTargetScope().wClone()).wWithEnclosingScope(wEnclosingScope().wClone());
	}

	public IBindingScope wTargetScope() {
		return targetScope;
	}
	public IBindingScope wEnclosingScope() {
		return enclosingScope;
	}
	public INestableScope wWithEnclosingScope(IBindingScope enclosingScope) {
		this.enclosingScope = enclosingScope;
		return this;
	}

	public void wClear() {
		wTargetScope().wClear();
	}

	public Set<String> wLocalNames() {
		return wTargetScope().wLocalNames();
	}

	public Set<String> wNames() {
		Set<String> nameSet = wEnclosingScope().wNames();
		nameSet.addAll(wTargetScope().wNames());
		return nameSet;
	}

	public IBindingScope wFindScope(String name) {
		IBindingScope scope = wTargetScope().wFindScope(name);
		return scope != VoidScope.instance ? scope : wEnclosingScope().wFindScope(name);
	}

	public boolean wIsSet(String name) {
		return wTargetScope().wIsSet(name) ? true : wEnclosingScope().wIsSet(name);
	}
	public IEntity wGet(String name) {
		IEntity value = wTargetScope().wGet(name);
		return (value != null) ? value : wEnclosingScope().wGet(name);
	}
	public void wSet(String name, IEntity value) {
		if (wTargetScope().wIsSet(name))
			wTargetScope().wSet(name, value);
		else
			wEnclosingScope().wSet(name, value);
	}
	public void wDef(String name, IEntity value) {
		wTargetScope().wDef(name, value);
	}

	public void wUnset(String name) {
		if (wTargetScope().wIsSet(name))
			wTargetScope().wUnset(name);
		else
			wEnclosingScope().wUnset(name);
	}

	public boolean hasResultIterator() {
		//TODO test
		if (wEnclosingScope() == NullScope.instance)
			return wTargetScope().hasResultIterator();

		return wEnclosingScope().hasResultIterator();
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		//TODO test
		if (wEnclosingScope() == NullScope.instance)
			return wTargetScope().getResultIterator();

		return wEnclosingScope().getResultIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		//TODO test
		if (wEnclosingScope() == NullScope.instance) {
			wTargetScope().setResultIterator(resultIterator);
			return;
		}

		wEnclosingScope().setResultIterator(resultIterator);
	}
	public IEntity getResult() {
		//TODO test
		if (wEnclosingScope() == NullScope.instance)
			return wTargetScope().getResult();

		return wEnclosingScope().getResult();
	}
	public void setResult(IEntity result) {
		//TODO test
		if (wEnclosingScope() == NullScope.instance) {
			wTargetScope().setResult(result);
			return;
		}

		wEnclosingScope().setResult(result);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- begin dynamic scope ---\n");
		Set<String> localNames = targetScope.wLocalNames();
		toString(sb, targetScope, new TreeSet<String>(localNames));
		sb.append("--- enclosing scope(s) ----\n");
		Set<String> enclosingNames = new TreeSet<String>(enclosingScope.wNames());
		enclosingNames.removeAll(localNames);
		toString(sb, enclosingScope, enclosingNames);
		sb.append("--- end dynamic scope -----\n");
		return sb.toString();
	}
}
