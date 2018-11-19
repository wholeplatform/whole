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
package org.whole.lang.actions.evaluators;

import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.evaluators.AbstractDelegatingNestedEvaluator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ActionCallEvaluator extends AbstractDelegatingNestedEvaluator<IEntity>{
	protected String functionUri;
	protected IExecutable<IEntity> functionExecutable;
	protected boolean functionExecutableNeedInit;
	protected boolean useSelectedEntities;

	@SuppressWarnings("unchecked")
	public ActionCallEvaluator(String functionUri) {
		this(functionUri, new IExecutable[0]);
		useSelectedEntities = true;
	}
	@SuppressWarnings("unchecked")
	public ActionCallEvaluator(String functionUri, IExecutable<IEntity>... optArgsExecutables) {
		super(optArgsExecutables != null ? optArgsExecutables : new IExecutable[0]);
		this.functionUri = functionUri;
		useSelectedEntities = false;
	}

	@Override
	public IExecutable<IEntity> clone(ICloneContext cc) {
		ActionCallEvaluator result = (ActionCallEvaluator) super.clone(cc);
		result.functionExecutable = cc.clone(functionExecutable);
		result.functionExecutableNeedInit = true;
		return result;
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		functionExecutable = null;
		functionExecutableNeedInit = true;
	}

	protected IExecutable<IEntity> functionExecutable() {
		if (functionExecutable == null) {
			functionExecutable = ActionsRegistry.instance().getFunctionCode(functionUri, true, getBindings());
			functionExecutable.setBindings(getBindings());
		}

		if (functionExecutableNeedInit) {
			functionExecutableNeedInit = false;

			functionExecutable.setBindings(getBindings());
			functionExecutable.reset(selfEntity);
			initArguments();
		}
		return functionExecutable;
	}
	protected void initArguments() {
		if (!useSelectedEntities) {
			IEntity selectedEntities = BindingManagerFactory.instance.createTuple();

			if (producersSize() > 0)
				for (int i=0; i<producersSize(); i++)
					for (IEntity arg = getProducer(i).evaluateNext(); arg != null; arg = getProducer(i).evaluateNext())
						selectedEntities.wAdd(arg);
			else
				selectedEntities.wAdd(selfEntity);
	
			getBindings().wDef("selectedEntities", selectedEntities);
			if (selectedEntities.wSize() > 0)
				getBindings().wDef("primarySelectedEntity", selectedEntities.wGet(0));
		}
		getBindings().enforceSelfBinding(selfEntity);
	}

	public IEntity evaluateNext() {
		if (functionExecutable == null && selfEntity == null)
			return null;

		clearExecutorScope();
		getBindings().wEnterScope(executorScope(), true);
		lastEntity = functionExecutable().evaluateNext();
		getBindings().wExitScope(lastEntity != null);
		return lastEntity;
	}

	public void prune() {
		functionExecutable().prune();
	}

	public void set(IEntity entity) {
		functionExecutable().set(entity);
	}
	public void add(IEntity entity) {
		functionExecutable().add(entity);
	}
	public void remove() {
		functionExecutable().remove();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append(functionUri);
    	sb.append("(...)");
    }
}
