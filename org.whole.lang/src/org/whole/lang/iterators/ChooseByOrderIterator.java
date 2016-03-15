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

import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ChooseByOrderIterator<E extends IEntity> extends AbstractLazyCloneableCompositeIterator<E> {
	private IEntityIterator<? extends E>[] iteratorChain;
	protected int iteratorIndex = -1;

	protected ChooseByOrderIterator(IEntityIterator<? extends E>... iteratorChain) {
		assert iteratorChain.length > 0;
		this.iteratorChain = iteratorChain;
		initLazyClone(false);
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		ChooseByOrderIterator<E> iterator = (ChooseByOrderIterator<E>) super.clone(cc);
		iterator.iteratorChain = iterator.iteratorChain.clone();
		return iterator;
	}

	public int childIteratorSize() {
		return iteratorChain.length;
	}
	protected IEntityIterator<?> childIterator(int index) {
		return iteratorChain[index];
	}
	@SuppressWarnings("unchecked")
	protected void childIterator(int index, IEntityIterator<?> iterator) {
		iteratorChain[index] = (IEntityIterator<? extends E>) iterator;
	}

	@SuppressWarnings("unchecked")
	protected IEntityIterator<? extends E> chosenIterator() {
		if (iteratorIndex == -1)
			while (++iteratorIndex < childIteratorSize()-1 && !getChildIterator(iteratorIndex).hasNext())
				;
		return (IEntityIterator<? extends E>) getChildIterator(iteratorIndex);
	}

	public IBindingScope lookaheadScope() {
		return iteratorIndex == -1 ? NullScope.instance : chosenIterator().lookaheadScope();
	}

	public boolean hasNext() {
		return chosenIterator().hasNext();
	}

	public E next() {
		return chosenIterator().next();
	}
	public E lookahead() {
		return chosenIterator().lookahead();
	}

	@SuppressWarnings("unchecked")
	public void set(E entity) {
		((IEntityIterator<? super E>) chosenIterator()).set(entity);
	}
	@SuppressWarnings("unchecked")
	public void add(E entity) {
		((IEntityIterator<? super E>) chosenIterator()).add(entity);
	}

	public void remove() {
		chosenIterator().remove();
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		iteratorIndex = -1;
	}

	public void prune() {
		chosenIterator().prune();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("chooseByOrder(");
    	
		for (int i=0; i<iteratorChain.length; i++) {
			if (i>0)
				sb.append(",");
			sb.append(iteratorChain[i].toString());
		}

    	sb.append(")");
    }
}
