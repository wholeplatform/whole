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
public class NestedDynamicScope extends AbstractScope {
	private IBindingScope currentScope;
	private IBindingScope enclosingScope;

	protected NestedDynamicScope(IBindingScope enclosingScope, IBindingScope nestedScope) {
		this.enclosingScope = enclosingScope;
		this.currentScope = nestedScope;
	}

	public IBindingScope wClone() {
		return new NestedDynamicScope(wEnclosingScope().wClone(), wCurrentScope().wClone());
	}

	public IBindingScope wCurrentScope() {
		return currentScope;
	}
	public IBindingScope wEnclosingScope() {
		return enclosingScope;
	}

	public void wClear() {
		wCurrentScope().wClear();
	}

	public Set<String> wLocalNames() {
		return wCurrentScope().wLocalNames();
	}

	public Set<String> wNames() {
		Set<String> nameSet = wEnclosingScope().wNames();
		nameSet.addAll(wCurrentScope().wNames());
		return nameSet;
	}

	public boolean wIsSet(String name) {
		return wCurrentScope().wIsSet(name) ? true : wEnclosingScope().wIsSet(name);
	}
	public IEntity wGet(String name) {
		IEntity value = wCurrentScope().wGet(name);
		return (value != null) ? value : wEnclosingScope().wGet(name);
	}
	public void wSet(String name, IEntity value) {
		if (wCurrentScope().wIsSet(name))
			wCurrentScope().wSet(name, value);
		else
			wEnclosingScope().wSet(name, value);
	}
	public void wAdd(String name, IEntity value) {
		if (wCurrentScope().wIsSet(name))
			wCurrentScope().wAdd(name, value);
		else
			wEnclosingScope().wAdd(name, value);		
	}
	public void wDef(String name, IEntity value) {
		wCurrentScope().wDef(name, value);
	}

	public void wUnset(String name) {
		if (wCurrentScope().wIsSet(name))
			wCurrentScope().wUnset(name);
		else
			wEnclosingScope().wUnset(name);
	}

	public boolean isResultIterator() {
		return wEnclosingScope().isResultIterator();
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return wEnclosingScope().getResultIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		wEnclosingScope().setResultIterator(resultIterator);
	}
	public IEntity getResult() {
		return wEnclosingScope().getResult();
	}
	public void setResult(IEntity result) {
		wEnclosingScope().setResult(result);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--- begin dynamic scope ---\n");
		Set<String> localNames = currentScope.wLocalNames();
		toString(sb, currentScope, new TreeSet<String>(localNames));
		sb.append("--- enclosing scope(s) ----\n");
		Set<String> enclosingNames = new TreeSet<String>(enclosingScope.wNames());
		enclosingNames.removeAll(localNames);
		toString(sb, enclosingScope, enclosingNames);
		sb.append("--- end dynamic scope -----\n");
		return sb.toString();
	}
}
