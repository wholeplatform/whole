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

import java.util.Iterator;
import java.util.Set;

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class LocalScopeEvaluator extends AbstractDelegatingNestedEvaluator {
//	TODO remove
	private Set<String> names;
	private boolean asFreshNames;
	private AbstractFilterScope filterScope;

	public LocalScopeEvaluator(IExecutable scopeExecutable, Set<String> names, boolean asFreshNames) {
		super(scopeExecutable);
//		executorScope = BindingManagerFactory.instance.createNestedDynamicSimpleFilterScope(names, asFreshNames);
		this.names = names;
		this.asFreshNames = asFreshNames;
	}

	//FIXME clone filterScope = null

	@Override
	public void reset(IEntity entity) {
		super.reset(entity);
		filterScope = null;
	}

//	@Override
//	protected IBindingScope executorScope() {
//		if (executorScope == null)
//			executorScope = BindingManagerFactory.instance.createNestedDynamicSimpleFilterScope(names, asFreshNames);
//		return executorScope;
//	}

	protected AbstractFilterScope filterScope() {
		if (filterScope == null)
			filterScope = createScopeFilter(names);

		return filterScope;
	}
	protected AbstractFilterScope createScopeFilter(Set<String> names) {
		return asFreshNames ?
				BindingManagerFactory.instance.createExcludeFilterScope(names) :
				BindingManagerFactory.instance.createIncludeFilterScope(names);
	}
	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			Set<String> boundNames = executorScope.wNames();
			if (lastEntity != null) {
				if (asFreshNames)
					boundNames.removeAll(names);
				else
					boundNames.retainAll(names);
				for (String name : boundNames)
					getBindings().wUnset(name);
			}
			executorScope.wClear();
		}
	}

	@Override
	protected IEntity scopedEvaluateNext() {
		IEntity result = null;
		try {
			clearProducerScope();
			getBindings().wEnterScope(filterScope());
			getBindings().wEnterScope(executorScope(), true);
//			getBindings().wEnterScope((INestableScope) executorScope());

			return result = getProducer().evaluateNext();
		} finally {
			getBindings().wExitScope(result != null);
			getBindings().wExitScope();
		}
	}
	@Override
	protected IEntity scopedEvaluateRemaining() {
		IEntity result = null;
		try {
			clearProducerScope();
			getBindings().wEnterScope(filterScope());
			getBindings().wEnterScope(executorScope(), true);
//			getBindings().wEnterScope((INestableScope) executorScope());

			return result = getProducer().evaluateRemaining();
		} finally {
			getBindings().wExitScope(result != null);
			getBindings().wExitScope();
		}
	}

	public IEntity evaluateNext() {
		return lastEntity = scopedEvaluateNext();
	}

//	public IEntity evaluateRemaining() {
//		return lastEntity = scopedEvaluateRemaining();
//	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append("(");

		Iterator<String> nameIterator = names.iterator();
    	if (nameIterator.hasNext()) {
	    	sb.append(nameIterator.next());
	    	while (nameIterator.hasNext()) {
				sb.append(",");
				sb.append(nameIterator.next());
			}
    	}

		super.toString(sb);
	}
	protected String toStringPrefix() {
		return "|";
	}
	protected String toStringSuffix() {
		return ")";
	}
}

