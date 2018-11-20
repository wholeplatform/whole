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
package org.whole.lang.evaluators;

import java.util.Collections;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.exceptions.WholeIllegalStateException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class SelectEvaluator extends AbstractDelegatingNestedEvaluator {
	private Set<String> namesToBind = Collections.emptySet();
	private boolean withNamesComplement;
	protected IBindingScope fromScope;
	protected IBindingScope selectScope;
	protected IBindingScope whereScope;

	@SuppressWarnings("unchecked")
	public SelectEvaluator(IExecutable selectExecutable, IExecutable fromExecutable, IExecutable whereExecutable) {
		super(fromExecutable, selectExecutable, whereExecutable);
	}

	public Set<String> namesToBind() {
		return namesToBind;
	}
	public SelectEvaluator withNamesToBind(Set<String> namesToBind) {
		this.namesToBind = namesToBind;
		return this;
	}
	public boolean withNamesComplement() {
		return withNamesComplement;
	}
	public SelectEvaluator withNamesComplement(boolean withNamesComplement) {
		this.withNamesComplement = withNamesComplement;
		return this;
	}

	@Override
	protected void initProducer(IExecutable p, int index) {
		p.setBindings(getBindings());
		if (index == 0)
			p.reset(selfEntity);
	}

	@Override
	protected IBindingManager executorScope() {
		if (executorScope == null) {
			selectScope = BindingManagerFactory.instance.createSimpleScope();

			executorScope = BindingManagerFactory.instance.createBindingManager(
					fromScope = BindingManagerFactory.instance.createSimpleScope(), getBindings().wGetEnvironmentManager());
			((IBindingManager) executorScope).wEnterScope(selectScope, true);
			((IBindingManager) executorScope).wEnterScope(whereScope = BindingManagerFactory.instance.createSimpleScope(), true);
		}

		return (IBindingManager) executorScope;
	}

	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			for (String name : selectScope.wTargetNames())
					getBindings().wUnset(name);

			fromScope.wClear();
			selectScope.wClear();
			whereScope.wClear();
		}
	}

	public IEntity evaluateNext() {
		IEntity selectEntity = null;
		IBindingManager bm = getBindings();

		clearExecutorScope();
		
		bm.wEnterScope(executorScope(), true);

		IEntity fromEntity = getProducer(0).evaluateNext();

		if (fromEntity == null) {
			bm.wExitScope();
			return lastEntity = null;
		}

		fromScope.wAddAll(whereScope);
		whereScope.wClear();

		getProducer(1).reset(fromEntity);

		selectEntity = getProducer(1).evaluateNext(); //FIXME ? evaluateRemaining
		if (selectEntity == null)
			throw new WholeIllegalStateException("Select clause must return a value").withSourceEntity(getSourceEntity()).withBindings(bm);

		selectScope.wAddAll(whereScope);
		whereScope.wClear();

		applyWhereClause(selectEntity, fromEntity, bm);

		bm.wExitScope();
		if (selectEntity != null)
			bm.wAddAll(selectScope);

		if (!Matcher.removeVars(selectEntity, namesToBind(), withNamesComplement())) {
			Set<String> unboundedNames = Matcher.vars(selectEntity, false);
			if (withNamesComplement())
				unboundedNames.removeAll(namesToBind());
			else
				unboundedNames.retainAll(namesToBind());
			throw new MissingVariableException("Unbounded names in select clause: ", null, unboundedNames.toArray(new String[unboundedNames.size()])).withSourceEntity(getSourceEntity()).withBindings(getBindings());
		}

		return lastEntity = selectEntity;
	}
	protected void applyWhereClause(IEntity selectEntity, IEntity fromEntity, IBindingManager bm) {
		getProducer(2).reset(fromEntity);
		bm.wDef(IBindingManager.SELF, fromEntity);
		for (IEntity whereEntity = getProducer(2).evaluateNext(); whereEntity != null; whereEntity = getProducer(2).evaluateNext()) {
			bm.wDef(IBindingManager.SELF, whereEntity);
			Matcher.substitute(selectEntity, bm, true);
			bm.wDef(IBindingManager.SELF, fromEntity);
		}
	}

	public void prune() {
	}
	public void add(IEntity entity) {
		throw new UnsupportedOperationException();
	}
	public void set(IEntity entity) {
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
		producers[1].toString(sb);
		sb.append(" from ");
		producers[0].toString(sb);
		sb.append(" where ");
		producers[2].toString(sb);
	}
}
