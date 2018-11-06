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

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class CallEvaluator extends AbstractDelegatingNestedEvaluator<IEntity> {
	protected String queryName;
	protected IEntity queryBody;
	protected String[] queryParams;
	protected AbstractFilterScope filterScope;
	protected IExecutable<IEntity> queryExecutable;
	protected boolean queryExecutableNeedInit;

	@SuppressWarnings("unchecked")
	public CallEvaluator(String queryName, IExecutable<IEntity>... argsExecutables) {
		super(argsExecutables);
		this.queryName = queryName;
	}

	@Override
	public CallEvaluator clone(ICloneContext cc) {
		CallEvaluator result = (CallEvaluator) super.clone(cc);
		result.queryExecutable = cc.clone(queryExecutable);
		result.queryExecutableNeedInit = true;
		return result;
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		queryExecutableNeedInit = true;
		if (queryExecutable != null && queryBody != getBindings().wGet(queryName)) { //TODO || any change to queryBody
			queryExecutable = null;
		}
	}

	protected AbstractFilterScope filterScope() {
		if (filterScope == null)
			filterScope = BindingManagerFactory.instance.createExcludeFilterScope(Collections.emptySet());

		return filterScope;
	}
	@Override
	protected void clearExecutorScope() {
		if (executorScope != null) {
			if (lastEntity != null) {
				Set<String> boundNames = executorScope.wNames();
				if (filterScope != null)
					boundNames.removeAll(filterScope.getFilterNames());
				for (String name : boundNames)
					getBindings().wUnset(name);
			}
			executorScope.wClear();
		}
	}

	@Override
	protected IEntity scopedEvaluateNext(boolean merge) {
		mergeLookaheadScope = merge;
		IEntity result = evaluateNext();
		mergeLookaheadScope = true;
		return result;
	}

	protected IExecutable<IEntity> queryExecutable() {
		ResourceUtils.handleCancelRequest(getBindings());

		if (queryExecutable == null) {
			if (getBindings().wIsSet(queryName)) {
				queryBody = getBindings().wGet(queryName);

				boolean isQueryDeclaration = queryBody.wGetEntityDescriptor().getURI().equals("http://lang.whole.org/Queries#QueryDeclaration");
						//Matcher.matchImpl(QueriesEntityDescriptorEnum.QueryDeclaration, queryBody);
				IEntity queryDeclaration = null; //QueryDeclaration
				if (isQueryDeclaration) {
					queryDeclaration = queryBody;
					isQueryDeclaration = queryDeclaration.wGet(0).wStringValue().equals(queryName); //getName
				}
				if (isQueryDeclaration) {
					IEntity parameters = queryDeclaration.wGet(1); //getParameters
					queryBody = queryDeclaration.wGet(2); //getBody

					int parametersSize = parameters.wSize();
					queryParams = new String[parametersSize];
					for (int i=0; i<parametersSize; i++)
						queryParams[i] = parameters.wGet(i).wStringValue();
	
					filterScope().setFilterNames(Set.of(queryParams));
				} else
					queryParams = null;
	
				queryExecutable = DynamicCompilerOperation.compile(queryBody, getBindings()).getExecutableResult();
			} else
				queryExecutable = executableFactory().createEmpty();
		}
		if (queryExecutableNeedInit) {
			queryExecutableNeedInit = false;

			queryExecutable.setBindings(getBindings());
			queryExecutable.reset(selfEntity);

			executorScope().wClear();
			for (int i=0; i<producersSize(); i++) {
				IEntity arg = getProducer(i).evaluateNext(); //FIXME ? evaluateRemaining
				if (arg != null && queryParams != null && i < queryParams.length)
					executorScope().wDef(queryParams[i], arg);
			}
		}
		return queryExecutable;
	}

	public IEntity evaluateNext() {
		IEntity lastEntity = null;
		clearExecutorScope();
		IExecutable<IEntity> qe = queryExecutable();
		try {
			getBindings().wEnterScope(filterScope());
			getBindings().wEnterScope(executorScope(), true);
//			getBindings().wEnterScope((INestableScope) executorScope());

			return lastEntity = qe.evaluateNext();
		} finally {
			getBindings().wExitScope(needMergeExecutorScope() && lastEntity != null);
			getBindings().wExitScope();
		}
	}

	public IEntity evaluateRemaining() {
		IEntity lastEntity = null;
		clearExecutorScope();
		IExecutable<IEntity> qe = queryExecutable();
		try {
			getBindings().wEnterScope(filterScope());
			getBindings().wEnterScope(executorScope(), true);
//			getBindings().wEnterScope((INestableScope) executorScope());
	
			return lastEntity = qe.evaluateRemaining();
		} finally {
			getBindings().wExitScope(needMergeExecutorScope() && lastEntity != null);
			getBindings().wExitScope();
		}
	}

	public void prune() {
		queryExecutable().prune();
	}

	public void set(IEntity entity) {
		queryExecutable().set(entity);
	}
	public void add(IEntity entity) {
		queryExecutable().add(entity);
	}

	public void remove() {
		queryExecutable().remove();
	}

    @Override
	protected String toStringPrefix() {
		return queryName+"(";
	}
}
