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
package org.whole.lang.actions.iterators;

import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.iterators.AbstractCloneableIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ActionCallIterator extends AbstractCloneableIterator<IEntity>{
	private IBindingManager bindings;
	protected String functionUri;
	private IEntityIterator<IEntity> functionIterator;
	private IEntityIterator<?>[] argsIterators;
	private boolean useSelectedEntities;
	private IEntity nextEntity = null;
	private IEntity resetEntity = null;

	public /*protected*/ ActionCallIterator(String functionUri) {
		this(functionUri, null);
		useSelectedEntities = true;
	}
	public /*protected*/ ActionCallIterator(String functionUri, IEntityIterator<?>[] optArgsIterators) {
		this.functionUri = functionUri;
		this.argsIterators = optArgsIterators;
		useSelectedEntities = false;
	}

	@Override
	public IEntityIterator<IEntity> clone(ICloneContext cc) {
		ActionCallIterator iterator = (ActionCallIterator) super.clone(cc);
		iterator.functionIterator = cc.clone(functionIterator);
		if (argsIterators != null) {
			iterator.argsIterators = argsIterators.clone();
			for (int i=0; i<argsIterators.length; i++)
				iterator.argsIterators[i] = cc.clone(argsIterators[i]);
		}
		return iterator;
	}

	protected IEntityIterator<IEntity> functionIterator() {
		if (functionIterator == null) {
			String contextUri = getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;
			functionIterator = ActionsRegistry.instance().getFunctionCode(functionUri, true, contextUri);
			functionIterator.setBindings(getBindings());
		}

		if (resetEntity != null) {
			functionIterator.reset(resetEntity);
			initArguments();
			resetEntity = null;
		}
		return functionIterator;
	}
	protected void initArguments() {
		if (!useSelectedEntities) {
			IEntity selectedEntities = BindingManagerFactory.instance.createTuple();
	
			if (argsIterators != null && argsIterators.length > 0)
				for (IEntityIterator<?> argIterator : argsIterators) {
					argIterator.setBindings(getBindings());
					argIterator.reset(resetEntity);
					
					for (IEntity arg : argIterator)
						selectedEntities.wAdd(arg);
				}
			else
				selectedEntities.wAdd(resetEntity);
	
			getBindings().wDef("selectedEntities", selectedEntities);
			if (selectedEntities.wSize() > 0)
				getBindings().wDef("primarySelectedEntity", selectedEntities.wGet(0));
		}
		getBindings().wDef("self", resetEntity);
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public IEntity next() {
		IEntity result = functionIterator().next();
		getBindings().wAddAll(lookaheadScope());

		nextEntity = null;
		return result;
	}
	public IEntity lookahead() {
		if (nextEntity != null)
			return nextEntity;

		if (functionIterator == null && resetEntity == null)
			return null;

		IBindingScope laScope = lookaheadScope();
		for (String name : laScope.wLocalNames())
			getBindings().wUnset(name);

		return nextEntity = functionIterator().lookahead();
	}

	public void set(IEntity entity) {
		functionIterator().set(entity);
	}
	public void add(IEntity entity) {
		functionIterator().add(entity);
	}

	public void remove() {
		functionIterator().remove();
	}

	public void reset(IEntity entity) {
		resetEntity = entity;
		functionIterator = null;
//		lookaheadScope = null;
		nextEntity = null;
	}

    public void setBindings(IBindingManager bindings) {
    	this.bindings = bindings;
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

//	private IDelegatingScope lookaheadScope;
	public IBindingScope lookaheadScope() {
//		if (lookaheadScope != null)
//			return lookaheadScope.wWithTargetScope(functionIterator().lookaheadScope());
//		else
			return functionIterator != null ? functionIterator().lookaheadScope() : NullScope.instance;
	}

	public void prune() {
		functionIterator().prune();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append(functionUri);
    	sb.append("(...)");
    }
}
