/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.HashSet;
import java.util.Set;

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class CallEvaluator extends AbstractDelegatingNestedEvaluator {
	protected String queryName;
	protected IEntity queryBody;
	protected String[] queryParams;
	protected AbstractFilterScope filterScope;
	protected IExecutable queryExecutable;
	protected boolean queryExecutableNeedInit;

	public CallEvaluator(String queryName, IExecutable... argsExecutables) {
		super(argsExecutables);
		this.queryName = queryName;
	}

	@Override
	public CallEvaluator clone(ICloneContext cc) {
		CallEvaluator result = (CallEvaluator) super.clone(cc);
		result.queryExecutable = cc.differentiate(queryExecutable);
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
			filterScope = BindingManagerFactory.instance.createExcludeFilterScope(new HashSet<String>());

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

	protected IExecutable queryExecutable() {
		ResourceUtils.handleCancelRequest(getBindings());

		if (queryExecutable == null) {
			Set<String> freshNames = filterScope().getFilterNames();
			freshNames.clear();

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
						freshNames.add(queryParams[i] = parameters.wGet(i).wStringValue());
				} else
					queryParams = null;

				IBindingScope results = DynamicCompilerOperation.compile(queryBody, getBindings());
				queryExecutable = results.getExecutableResult();
				if (results.isExecutableResult())
					results.setExecutableResult(null);
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
		IExecutable qe = queryExecutable();
		try {
			getBindings().wEnterScope(filterScope());
			getBindings().wEnterScope(executorScope(), true);
//			getBindings().wEnterScope((INestableScope) executorScope());

			return lastEntity = qe.evaluateNext();
		} finally {
			getBindings().wExitScope(lastEntity != null);
			getBindings().wExitScope();
		}
	}

	public IEntity evaluateRemaining() {
		IEntity lastEntity = null;
		clearExecutorScope();
		IExecutable qe = queryExecutable();
		try {
			getBindings().wEnterScope(filterScope());
			getBindings().wEnterScope(executorScope(), true);
//			getBindings().wEnterScope((INestableScope) executorScope());
	
			return lastEntity = qe.evaluateRemaining();
		} finally {
			getBindings().wExitScope(lastEntity != null);
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
