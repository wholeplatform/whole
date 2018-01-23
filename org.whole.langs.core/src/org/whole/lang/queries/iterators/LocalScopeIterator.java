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
package org.whole.lang.queries.iterators;

import java.util.Iterator;
import java.util.Set;

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.INestableScope;
import org.whole.lang.iterators.AbstractCloneableIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class LocalScopeIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	private IBindingManager queryBindings;
	private Set<String> localNames;
	private IEntityIterator<E> scopeIterator;
	private E nextEntity = null;

	protected LocalScopeIterator(IEntityIterator<E> scopeIterator, Set<String> localNames) {
		this.scopeIterator = scopeIterator;
		this.localNames = localNames;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		LocalScopeIterator<E> iterator = (LocalScopeIterator<E>) super.clone(cc);
		iterator.scopeIterator = cc.clone(scopeIterator);
		return iterator;
	}

	protected IEntityIterator<E> scopeIterator() {
		return scopeIterator;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public E next() {
		E result = scopeIterator().next();
		getBindings().wAddAll(lookaheadScope());

		nextEntity = null;
		return result;
	}
	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		IBindingScope laScope = lookaheadScope();
		for (String name : laScope.wLocalNames())
			getBindings().wUnset(name);

		return nextEntity = scopeIterator().lookahead();
	}

	public void set(E entity) {
		scopeIterator().set(entity);
	}
	public void add(E entity) {
		scopeIterator().add(entity);
	}

	public void remove() {
		scopeIterator().remove();
	}

	public void reset(IEntity entity) {
		nextEntity = null;

		scopeIterator.reset(entity);
		if (queryBindings != null && localNames != null)
			queryBindings.wClear();
	}

    protected void setArgumentsBindings(IBindingManager bindings) {
		lookaheadScope = createScopeFilter(localNames);

		queryBindings = BindingManagerFactory.instance.createBindingManager(
				createScopeFilter(localNames).wWithEnclosingScope(bindings), bindings.wGetEnvironmentManager());
		queryBindings.wEnterScope();
		queryBindings.withSourceEntity(getSourceEntity());

		scopeIterator.setBindings(queryBindings);
	}
	protected AbstractFilterScope createScopeFilter(Set<String> localNames) {
		return BindingManagerFactory.instance.createExcludeFilterScope(localNames);
	}

	private INestableScope lookaheadScope;
	public IBindingScope lookaheadScope() {
		if (lookaheadScope != null)
			return lookaheadScope.wWithEnclosingScope(scopeIterator().lookaheadScope());
		else
			return scopeIterator().lookaheadScope();
	}

	public void prune() {
		scopeIterator().prune();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("(");
    	
    	Iterator<String> nameIterator = localNames.iterator();
    	sb.append(nameIterator.next());
    	while (nameIterator.hasNext()) {
			sb.append(",");
			sb.append(nameIterator.next());
		}

		sb.append("|");
		
		sb.append(scopeIterator);
		
    	sb.append(")");
    }
}
