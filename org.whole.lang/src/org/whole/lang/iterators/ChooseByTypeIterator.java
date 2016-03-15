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

import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public class ChooseByTypeIterator<E extends IEntity> extends AbstractLazyCloneableCompositeIterator<E> {
	private ILanguageKit languageKit;
	private IEntityIterator<?>[] iteratorChain;
	protected int iteratorIndex = -1;

	protected ChooseByTypeIterator(ILanguageKit languageKit) {
		this.languageKit = languageKit;
		this.iteratorChain = new IEntityIterator<?>[languageKit.getEntityDescriptorEnum().size()];
		for (int i = 0; i < this.iteratorChain.length; i++) {
			this.iteratorChain[i] = IteratorFactory.constantIterator(
					BindingManagerFactory.instance.createVoid(), true);
		}
		initLazyClone(false);
	}

	public boolean hasCase(EntityDescriptor<?> ed) {
		return ed.getLanguageKit().equals(languageKit) && iteratorChain[ed.getOrdinal()] != null;
	}
	public void setCases(Map<EntityDescriptor<?>, IEntityIterator<?>> cases) {
		for (Map.Entry<EntityDescriptor<?>, IEntityIterator<?>> entry : cases.entrySet())
			setCase(entry.getKey(), entry.getValue());
	}
	public void setCase(EntityDescriptor<?> ed, IEntityIterator<?> iterator) {
		if (!ed.getLanguageKit().equals(languageKit))
			throw new IllegalArgumentException();

		iteratorChain[ed.getOrdinal()] = iterator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		ChooseByTypeIterator<E> iterator = (ChooseByTypeIterator<E>) super.clone(cc);
		iterator.iteratorChain = iterator.iteratorChain.clone();
		return iterator;
	}

	public int childIteratorSize() {
		return iteratorChain.length;
	}
	protected IEntityIterator<?> childIterator(int index) {
		return iteratorChain[index];
	}
	protected void childIterator(int index, IEntityIterator<?> iterator) {
		iteratorChain[index] = iterator;
	}

	@SuppressWarnings("unchecked")
	protected IEntityIterator<? extends E> chosenIterator() {
		if (iteratorIndex >= 0) {
			IEntityIterator<?> childIterator = getChildIterator(iteratorIndex);
			if (childIterator != null)
				return (IEntityIterator<? extends E>) childIterator;
		}
		return IteratorFactory.emptyIterator();
	}

	public IBindingScope lookaheadScope() {
		return chosenIterator().lookaheadScope();
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
		iteratorIndex = entity.wGetLanguageKit().equals(languageKit) ?
				entity.wGetEntityOrd() : -1;
	}

	public void prune() {
		chosenIterator().prune();
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append("chooseByType(");
    	
		for (int i=0; i<iteratorChain.length; i++) {
			if (i>0)
				sb.append(",");
			sb.append(String.valueOf(iteratorChain[i]));
		}

    	sb.append(")");
    }
}
