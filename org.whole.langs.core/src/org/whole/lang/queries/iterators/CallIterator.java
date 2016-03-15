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

import java.util.HashSet;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.INestableScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.iterators.AbstractCloneableIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.queries.model.Names;
import org.whole.lang.queries.model.QueryDeclaration;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class CallIterator<E extends IEntity>  extends AbstractCloneableIterator<E> {
	private IBindingManager bindings;
	private IBindingManager queryBindings;
	protected String queryName;
	protected Names parameters;
	protected IEntity queryBody;
	private IEntityIterator<E> queryIterator;
	protected IEntityIterator<? extends IEntity>[] argsIterators;
	private E nextEntity = null;
	private IEntity resetEntity = null;

	protected CallIterator(String queryName, IEntityIterator<? extends E>... argsIterators) {
		this.queryName = queryName;
		this.argsIterators = argsIterators;
	}

	@Override
	public CallIterator<E> clone(ICloneContext cc) {
		CallIterator<E> iterator = (CallIterator<E>) super.clone(cc);
		iterator.queryIterator = cc.clone(queryIterator);
		if (argsIterators != null) {
			iterator.argsIterators = argsIterators.clone();
			for (int i=0; i<argsIterators.length; i++)
				iterator.argsIterators[i] = cc.clone(argsIterators[i]);
		}
		return iterator;
	}

	protected IEntityIterator<E> queryIterator() {
		ResourceUtils.handleCancelRequest(getBindings());

		if (queryIterator == null) {
			parameters = null;
			if (!getBindings().wIsSet(queryName))
				return queryIterator = IteratorFactory.emptyIterator();

			queryBody = getBindings().wGet(queryName);
			boolean isQueryDeclaration = Matcher.matchImpl(QueriesEntityDescriptorEnum.QueryDeclaration, queryBody);
			QueryDeclaration queryDeclaration = null;
			if (isQueryDeclaration) {
				queryDeclaration = (QueryDeclaration) queryBody;
				isQueryDeclaration = queryDeclaration.getName().wStringValue().equals(queryName);
			}

			if (isQueryDeclaration) {
				parameters = queryDeclaration.getParameters();
				int parametersSize = parameters.wSize();
				Set<String> freshNames = new HashSet<String>(parametersSize);
				for (int i=0; i<parametersSize; i++)
					freshNames.add(parameters.wGet(i).wStringValue());

				if (!freshNames.isEmpty())
					lookaheadScope = BindingManagerFactory.instance.createExcludeFilterScope(freshNames);

				queryBindings = BindingManagerFactory.instance.createBindingManager(
						freshNames.isEmpty() ? getBindings() :
						BindingManagerFactory.instance.createExcludeFilterScope(freshNames).wWithEnclosingScope(getBindings()),
						getBindings().wGetEnvironmentManager());
				queryBindings.wEnterScope();

				queryBody = queryDeclaration.getBody();
			} else
				queryBindings = getBindings();

			queryIterator = DynamicCompilerOperation.compile(queryBody, queryBindings).getResultIterator();

//TODO test
//			IBindingManager queriesRegistry = getDynamicQueriesRegistry();
//			if (!queriesRegistry.wIsSet(queryName)) {
//				//compile
//				queriesRegistry.wSetValue(queryName, queryIterator);
//			}
//			queryIterator = ((IEntityIterator<E>) queriesRegistry.wGetValue(queryName)).clone();
		}
		if (resetEntity != null) {
			queryIterator.reset(resetEntity);
			resetEntity = null;

			if (parameters != null) {
				queryBindings.wClear();
				for (int i=0; i<argsIterators.length; i++)
					if (argsIterators[i].hasNext()) {
						IEntity arg = argsIterators[i].next();
						if (i < parameters.wSize())
							queryBindings.wDef(parameters.wGet(i).wStringValue(), arg);
					}
			}
		}
		return queryIterator;
	}

	//TODO replace IBindingManager with a real registry
	protected IBindingManager getDynamicQueriesRegistry() {
		return getBindings().wGetEnvironmentManager().getEnvironment("DynamicQueriesRegistry");
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public E next() {
		E result = queryIterator().next();
		getBindings().wAddAll(lookaheadScope());

		nextEntity = null;
		return result;
	}
	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		if (queryIterator == null && resetEntity == null)
			return null;

		IBindingScope laScope = lookaheadScope();
		for (String name : laScope.wLocalNames())
			getBindings().wUnset(name);

		return nextEntity = queryIterator().lookahead();
	}

	public void set(E entity) {
		queryIterator().set(entity);
	}
	public void add(E entity) {
		queryIterator().add(entity);
	}

	public void remove() {
		queryIterator().remove();
	}

	public void reset(IEntity entity) {
		for (IEntityIterator<? extends IEntity> i : argsIterators)
			i.reset(entity);

		resetEntity = entity;
		nextEntity = null;

		if (queryIterator != null && queryBody != getBindings().wGet(queryName)) { //TODO || any change to queryBody
			queryIterator = null;
			lookaheadScope = null;
		}
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			this.bindings = bindings;
	    	for (IEntityIterator<? extends IEntity> i : argsIterators)
				i.setBindings(bindings);
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
			return lookaheadScope.wWithEnclosingScope(queryIterator().lookaheadScope());
		else
			return queryIterator != null ? queryIterator().lookaheadScope() : NullScope.instance;
	}

	public void prune() {
		queryIterator().prune();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append(queryName+"(");
    	
		for (int i=0; i<argsIterators.length; i++) {
			if (i>0)
				sb.append(",");
			sb.append(argsIterators[i].toString());
		}

    	sb.append(")");
    }
}
