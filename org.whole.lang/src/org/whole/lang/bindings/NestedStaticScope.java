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

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;


/**
 * @author Riccardo Solmi
 */
public class NestedStaticScope extends AbstractDelegatingScope implements INestableScope {
	private IBindingScope enclosingScope = NullScope.instance;

	protected NestedStaticScope(IBindingScope targetScope) {
		super(targetScope);
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		NestedStaticScope scope = (NestedStaticScope) super.clone(cc);
		scope.enclosingScope = cc.clone(enclosingScope);
		scope.resultScope = resultScope == this ? scope : null;
		return scope;
	}

	public Kind getKind() {
		return Kind.SCOPE;
	}

	public IBindingScope wTargetScope() {
		return wDelegateScope();
	}
	public IBindingScope wEnclosingScope() {
		return enclosingScope;
	}
	public INestableScope wWithEnclosingScope(IBindingScope enclosingScope) {
		this.enclosingScope = enclosingScope;
		return this;
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
}
