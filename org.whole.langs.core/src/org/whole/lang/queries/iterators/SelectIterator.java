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

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Set;

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.WholeIllegalStateException;
import org.whole.lang.iterators.AbstractLazyCloneableIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class SelectIterator<E extends IEntity> extends AbstractLazyCloneableIterator<E> {
	private AbstractFilterScope lookaheadScope;
	private IEntityIterator<?> fromIterator;
	private IEntityIterator<E> selectIterator;
	private IEntityIterator<?> whereIterator;
	private boolean lazyCloneSelect, lazyCloneWhere; 
	private E nextEntity = null;
    private E lastEntity;
	private Set<String> namesToBind = Collections.emptySet();
	private boolean withNamesComplement;

	protected SelectIterator(IEntityIterator<E> selectIterator, IEntityIterator<?> fromIterator, IEntityIterator<? extends IEntity> whereIterator) {
		this.selectIterator = selectIterator;
		this.fromIterator = fromIterator;
		this.whereIterator = whereIterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		SelectIterator<E> iterator = (SelectIterator<E>) super.clone(cc);
		iterator.fromIterator = cc.clone(fromIterator);
		iterator.lazyCloneSelect = lazyCloneSelect = iterator.lazyCloneWhere = lazyCloneWhere = true;
		return iterator;
	}

	protected boolean isLazyCloneEmpty() {
		return !lazyCloneSelect && !lazyCloneWhere;
	}

	public IEntityIterator<?> getFromIterator() {
		return fromIterator;
	}

	public IEntityIterator<E> getSelectIterator() {
		if (lazyCloneSelect) {
			selectIterator = getCloneContext().clone(selectIterator);
			lazyCloneSelect = false;
			updateCloneContext();
			selectIterator.setBindings(bindings);
		}
		return selectIterator;
	}

	public IEntityIterator<?> getWhereIterator() {
		if (lazyCloneWhere) {
			whereIterator = getCloneContext().clone(whereIterator);
			lazyCloneWhere = false;
			updateCloneContext();
			whereIterator.setBindings(bindings);
		}
		return whereIterator;
	}

	public Set<String> namesToBind() {
		return namesToBind;
	}
	public SelectIterator<E> withNamesToBind(Set<String> namesToBind) {
		this.namesToBind = namesToBind;
		return this;
	}
	public boolean withNamesComplement() {
		return withNamesComplement;
	}
	public SelectIterator<E> withNamesComplement(boolean withNamesComplement) {
		this.withNamesComplement = withNamesComplement;
		return this;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		IEntity selfEntityOld = getBindings().wGet("self");
		lookaheadScope().setFilterEnabled(false);
		clearLookaheadScope();
		IEntity selfEntity = getFromIterator().lookahead();
		if (selfEntity == null) {
			lookaheadScope().setFilterEnabled(true);
			return null;
		}
		getBindings().wEnterScope(lookaheadScope(), true);

		getSelectIterator().reset(selfEntity);

		lookaheadScope().wAddAll(getFromIterator().lookaheadScope());
		Set<String> filterNames = lookaheadScope().getFilterNames();
		for (String name : getFromIterator().lookaheadScope().wLocalNames())
			filterNames.add(name);

		lookaheadScope().wDef("self", selfEntity);
		filterNames.add("self");

		try {
			nextEntity = getSelectIterator().next();
		} catch (NoSuchElementException e) {
			throw new WholeIllegalStateException("Select clause must return a value", e).withSourceEntity(getSourceEntity()).withBindings(getBindings());
		}

		lookaheadScope().wAddAll(getSelectIterator().lookaheadScope());
		//enable select names hidden by from iterator 
		filterNames.removeAll(getSelectIterator().lookaheadScope().wLocalNames());
		
		applyWhereClause(nextEntity, selfEntity, getBindings());

		filterNames.addAll(getWhereIterator().lookaheadScope().wLocalNames());
		lookaheadScope().setFilterEnabled(true);
		getBindings().wExitScope();

		if (!Matcher.removeVars(nextEntity, namesToBind(), withNamesComplement())) {
			Set<String> unboundedNames = Matcher.vars(nextEntity, false);
			if (withNamesComplement())
				unboundedNames.removeAll(namesToBind());
			else
				unboundedNames.retainAll(namesToBind());
			throw new MissingVariableException("Unbounded names in select clause: ", null, unboundedNames.toArray(new String[unboundedNames.size()])).withSourceEntity(getSourceEntity()).withBindings(getBindings());
		}

		if (selfEntityOld != null)
			getBindings().wDef("self", selfEntityOld);
		return nextEntity;
	}
	protected void applyWhereClause(E pattern, IEntity selfEntity, IBindingManager bindings) {
		getWhereIterator().reset(selfEntity);
		bindings.wDef("self", selfEntity);
		for (IEntity e : getWhereIterator()) {
			bindings.wDef("self", e);
			Matcher.substitute(pattern, bindings, true);
			bindings.wDef("self", selfEntity);
		}
	}

	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();
		
		getBindings().wEnterScope();
		getFromIterator().next();
		getBindings().wExitScope();

		getBindings().wAddAll(lookaheadScope());

		nextEntity = null;
		return lastEntity = result;
	}

	public void reset(IEntity entity) {
		getFromIterator().reset(entity);
		clearLookaheadScope();
		lastEntity = null;
		nextEntity = null;
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			this.bindings = bindings;
	    	fromIterator.setBindings(bindings);
	    	if (!lazyCloneSelect)
	    		selectIterator.setBindings(bindings);
	    	if (!lazyCloneWhere)
	    		whereIterator.setBindings(bindings);
		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	public AbstractFilterScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createExcludeFilterSimpleScope();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : lookaheadScope.wLocalNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
			lookaheadScope.getFilterNames().clear();
		}
	}

	public void prune() {
	}
	public void add(E entity) {
		throw new UnsupportedOperationException();
	}
	public void set(E entity) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	lastEntity.wGetParent().wSet(lastEntity, entity);
    	lastEntity = entity;
	}
	public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
		lastEntity.wGetParent().wRemove(lastEntity);
    	lastEntity = null;
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append("select ");
		sb.append(selectIterator);
		sb.append(" from ");
		sb.append(fromIterator);
		sb.append(" where ");
		sb.append(whereIterator);
	}
}
