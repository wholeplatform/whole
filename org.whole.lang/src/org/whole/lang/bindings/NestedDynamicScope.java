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

import java.util.Set;
import java.util.TreeSet;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class NestedDynamicScope extends AbstractScope implements INestableScope {
	private IBindingScope targetScope;
	private IBindingScope enclosingScope = NullScope.instance;

	protected NestedDynamicScope(IBindingScope targetScope) {
		this.targetScope = targetScope;
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		NestedDynamicScope scope = (NestedDynamicScope) super.clone(cc);
		scope.targetScope = cc.clone(targetScope);
		scope.enclosingScope = cc.clone(enclosingScope);
		scope.resultScope = resultScope == this ? scope : null;
		return scope;
	}

	public IBindingScope wTargetScope() {
		return targetScope;
	}
	public IBindingScope wEnclosingScope() {
		return enclosingScope;
	}
	public INestableScope wWithEnclosingScope(IBindingScope enclosingScope) {
		this.enclosingScope = enclosingScope;
		resultScope = null;
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

	private IBindingScope resultScope;
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

	protected final IBindingScope resultScopeDelegate() {
		return wResultScope() != this ? wEnclosingScope() : wTargetScope();
	}
	public boolean hasResultIterator() {
		return resultScopeDelegate().hasResultIterator();
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return resultScopeDelegate().getResultIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		resultScopeDelegate().setResultIterator(resultIterator);
	}
	public IEntity getResult() {
		return resultScopeDelegate().getResult();
	}
	public void setResult(IEntity result) {
		resultScopeDelegate().setResult(result);
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
