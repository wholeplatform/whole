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

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.BindingUtils;

/**
 * @author Riccardo Solmi
 */
public class BindingManager extends AbstractDelegatingScope implements IBindingManager {
	private IEnvironmentManager environmentManager;
	protected BindingManager(IEnvironmentManager environmentManager, IBindingScope currentScope) {
		super(currentScope);
		this.environmentManager = environmentManager;
	}

	public IBindingManager wClone() {
		return new BindingManager(environmentManager, wTargetScope().wClone());
	}

	public Kind getKind() {
		return Kind.OUTER_GROUP_ADAPTER;
	}

	public IBindingScope wTargetScope() {
		return wDelegateScope();
	}
	public void wSetTargetScope(IBindingScope scope) {
		wSetDelegateScope(scope);
	}

	public IBindingScope wEnclosingScope() {
		return wTargetScope().wEnclosingScope();
	}

    public IEnvironmentManager wGetEnvironmentManager() {
		return environmentManager;
	}

	public IBindingScope wFindScope(String name) {
		return wTargetScope().wFindScope(name);
	}

	public void wEnterScope() {
		wEnterScope(BindingManagerFactory.instance.createNestedDynamicSimpleScope());
	}
	public void wEnterScope(INestableScope scope) {
//FIX result scope first
		final IBindingScope outerScope = BindingUtils.wOuterScope(scope, true);
		if (outerScope == scope)
		wSetTargetScope(((INestableScope) outerScope).wWithEnclosingScope(wTargetScope()));
		else
		wSetTargetScope(scope.wWithEnclosingScope(wTargetScope()));
	}
	public void wEnterScope(IBindingScope scope, boolean dynamic) {
		wEnterScope(BindingManagerFactory.instance.createNestedScope(scope, dynamic));
	}
	public void wEnterScope(String name, boolean dynamic) {
		wEnterScope(wGet(name), dynamic);
	}
	public void wEnterScope(IEntity entity, boolean dynamic) {
		wEnterScope(BindingManagerFactory.instance.createEntityScope(entity), dynamic);
	}

	public void wExitScope() {
		wExitScope(false);
	}
	public void wExitScope(boolean merge) {
		IBindingScope scope = wTargetScope();
		wSetTargetScope(scope.wEnclosingScope());
		if (wTargetScope() == NullScope.instance)
			throw new IllegalStateException("exitScope from top level");
		
		//TODO test
		if (scope instanceof INestableScope) {
			IEntity result = null;
			IEntityIterator<IEntity> resultIterator = null;
			if (scope.hasResultIterator())
				resultIterator = scope.getResultIterator();
			else
				result = scope.getResult();

			((INestableScope) scope).wWithEnclosingScope(NullScope.instance);

			if (scope instanceof NestedDynamicScope ||
					scope instanceof NestedDynamicSimpleScope) {
				if (resultIterator != null)
					scope.wTargetScope().setResultIterator(resultIterator);
				else
					scope.wTargetScope().setResult(result);
			}
		}

		if (merge)
			wTargetScope().wAddAll(scope);
	}
}
