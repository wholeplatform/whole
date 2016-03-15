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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.SelfIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class TupleFactoryIterator extends SelfIterator<IEntity> {
	protected IEntityIterator<?>[] tupleIterators;
	private IEntity nextEntity = null;

	protected TupleFactoryIterator(IEntityIterator<?>... tupleIterators) {
		this.tupleIterators = tupleIterators;
	}

	@Override
	public IEntityIterator<IEntity> clone(ICloneContext cc) {
		TupleFactoryIterator iterator = (TupleFactoryIterator) super.clone(cc);
		iterator.tupleIterators = tupleIterators.clone();
		for (int i=0; i<tupleIterators.length; i++)
			iterator.tupleIterators[i] = cc.clone(tupleIterators[i]);
		return iterator;
	}

    public void setBindings(IBindingManager bindings) {
		super.setBindings(bindings);
		for (IEntityIterator<?> tupleIterator : tupleIterators)
			tupleIterator.setBindings(bindings);
	}

	private IBindingScope lookaheadScope;
	public IBindingScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createSimpleScope();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null)
			lookaheadScope.wClear();
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public IEntity lookahead() {
		if (nextEntity != null)
			return nextEntity;

		clearLookaheadScope();		
//		super.lookahead();

		nextEntity = BindingManagerFactory.instance.createTuple();
		boolean hasNext = false;
		for (IEntityIterator<?> tupleIterator : tupleIterators)
			if (tupleIterator.hasNext()) {
				hasNext = true;
				nextEntity.wAdd(tupleIterator.lookahead());
				lookaheadScope().wAddAll(tupleIterator.lookaheadScope());
			} else
				nextEntity.wAdd(CommonsEntityFactory.instance.createResolver());

		if (!hasNext)
			nextEntity = null;

		return nextEntity;
	}

	public IEntity next() {
		IEntity result = super.next(); //calls also this.lookahead();

		for (IEntityIterator<?> tupleIterator : tupleIterators)
			if (tupleIterator.hasNext())
				tupleIterator.next();

		nextEntity = null;
		return result;
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		for (IEntityIterator<?> tupleIterator : tupleIterators)
			tupleIterator.reset(entity);
		clearLookaheadScope();
		nextEntity = null;
	}

	public void toString(StringBuilder sb) {
		sb.append("Tuple");
		sb.append(tupleIterators.toString());
	}
}
