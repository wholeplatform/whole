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
package org.whole.lang.iterators;

import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.iterators.AbstractDelegatingIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class WithStageIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	private IBindingManager lookaheadScope;
	private IEntityIterator<?> stageIterator;
	private boolean stageEvaluated = false;
	private int stageValue;
	private E nextEntity = null;

	protected WithStageIterator(IEntityIterator<?> stageIterator, IEntityIterator<E> doIterator) {
		super(doIterator);
		this.stageIterator = stageIterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		WithStageIterator<E> iterator = (WithStageIterator<E>) super.clone(cc);
		iterator.stageIterator = cc.clone(stageIterator);
		return iterator;
	}

	protected int relativeStage() {
		if (!stageEvaluated) {
			stageEvaluated = true;
			if (stageIterator.hasNext()) {
				getBindings().wEnterScope(lookaheadScope(), true);
				stageValue = stageIterator.next().wIntValue();
				getBindings().wExitScope();
				lookaheadScope.wEnterScope();
			} else
				stageValue = 0;
		}
		return stageValue;
	}

	@Override
	public boolean hasNext() {
		return lookahead() != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E lookahead() {
		if (nextEntity != null)
			return nextEntity;

		boolean isFirstValue = !stageEvaluated;
		int stage = relativeStage();
//		if (stage != 0)
//FIXME		getBindings().wGetEnvironmentManager().getCurrentOperation().stagedVisit(entity, relativeStage)

			clearLookaheadScope();
			getBindings().wEnterScope(lookaheadScope(), true);
			nextEntity = super.lookahead();
			getBindings().wExitScope();
			lookaheadScope().wAddAll(super.lookaheadScope());

//			if (stage != 0)
//FIXME		getBindings().wGetEnvironmentManager().getCurrentOperation().stagedVisit(entity, relativeStage)

			if (isFirstValue && nextEntity == null)
				nextEntity = (E) BindingManagerFactory.instance.createVoid();

//else			nextEntity = null;

		return nextEntity;
	}

	@Override
	public E next() {
		E result = lookahead();
		if (result == null)
			throw new NoSuchElementException();
		
		getBindings().wEnterScope(lookaheadScope(), true);
		if (super.hasNext())
			super.next();
		getBindings().wExitScope(true);

		nextEntity = null;
		return result;
	}

	@Override
	public void reset(IEntity entity) {
		nextEntity = null;
		if (stageEvaluated) {
			stageEvaluated = false;
//FIXME			if (stageValue) {
//				lookaheadScope.wExitScope();
//				lookaheadScope.wClear();
//			}
		}
		stageIterator.reset(entity);
		super.reset(entity);
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
	    	super.setBindings(bindings);
	    	stageIterator.setBindings(bindings);
		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	public IBindingScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createBindingManager();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : lookaheadScope.wNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
		}
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append("withStage ");
		sb.append(stageIterator);
		sb.append(" do ");
		super.toString(sb);
	}
}
