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

import java.util.TreeSet;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class SortIterator<E extends IEntity> extends CollectionIterator<E> {
	protected IEntityIterator<? extends E> iterator;
	protected IEntityComparator<? super E> comparator;

	@SuppressWarnings("unchecked")
	protected SortIterator(IEntityIterator<? extends E> iterator) {
		this(iterator, (IEntityComparator<E>) BusinessIdentityComparator.instance);
	}
	protected SortIterator(IEntityIterator<? extends E> iterator, IEntityComparator<E> comparator) {
		this.iterator = iterator;
		this.comparator = comparator;
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		SortIterator<E> iterator = (SortIterator<E>) super.clone(cc);
		iterator.iterator = cc.clone(this.iterator);
		iterator.comparator = cc.clone(comparator);
		return iterator;
	}

	@Override
	protected Iterable<?> getCollectionIterable(IEntity entity) {
		iterator.reset(entity);

		TreeSet<E> treeSet = new TreeSet<E>(comparator);
		for (E e : iterator)
			treeSet.add(e);
		return treeSet;
	}

	@Override
	public void setBindings(IBindingManager bindings) {
		super.setBindings(bindings);
		iterator.setBindings(bindings);
		comparator.setBindings(bindings);
	}
}
