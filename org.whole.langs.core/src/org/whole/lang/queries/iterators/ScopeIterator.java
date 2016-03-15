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
public class ScopeIterator<E extends IEntity> extends AbstractCloneableIterator<E> {
	private IBindingManager bindings;
	private IBindingManager queryBindings;
	private String environmentName;
	private Set<String> localNames;
	private IEntityIterator<E> scopeIterator;
	private E nextEntity = null;

	protected ScopeIterator(IEntityIterator<E> scopeIterator, String environmentName, Set<String> localNames) {
		this.scopeIterator = scopeIterator;
		this.environmentName = environmentName;
		this.localNames = localNames;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		ScopeIterator<E> iterator = (ScopeIterator<E>) super.clone(cc);
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
		// getBindings().wAddAll(lookaheadScope());

		nextEntity = null;
		return result;
	}
	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

//		IBindingScope laScope = lookaheadScope();
//		for (String name : laScope.wLocalNames())
//			getBindings().wUnset(name);

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

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			this.bindings = bindings;

			if (!localNames.isEmpty())
				lookaheadScope = BindingManagerFactory.instance.createExcludeFilterScope(localNames);

			queryBindings = BindingManagerFactory.instance.createBindingManager(
					localNames.isEmpty() ? getBindings() :
					BindingManagerFactory.instance.createExcludeFilterScope(localNames).wWithEnclosingScope(getBindings()),
						getBindings().wGetEnvironmentManager());
			queryBindings.wEnterScope();
			queryBindings.withSourceEntity(getSourceEntity());

			scopeIterator.setBindings(queryBindings);//was bindings);
		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
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
    	
    	if (!localNames.isEmpty()) {
	    	Iterator<String> nameIterator = localNames.iterator();
	    	sb.append(nameIterator.next());
	    	while (nameIterator.hasNext()) {
				sb.append(",");
				sb.append(nameIterator.next());
			}
    	}

		sb.append("|");
		
		sb.append(scopeIterator);
		
    	sb.append(")");
    }
}
