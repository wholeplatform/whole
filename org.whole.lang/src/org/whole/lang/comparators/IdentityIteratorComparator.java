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
package org.whole.lang.comparators;

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class IdentityIteratorComparator<T extends IEntity> extends AbstractEqualityComparator<T> {
	protected IEntityIterator<? extends T> iterator;
	protected IEntityComparator<? super T> comparator;

	public IdentityIteratorComparator(IEntityIterator<T> iterator) {
		this(iterator, BusinessIdentityComparator.instance);
	}
	public IdentityIteratorComparator(IEntityIterator<? extends T> iterator, IEntityComparator<? super T> collector) {
		this.iterator = iterator;
		this.comparator = collector;
	}

	@Override
	public IEntityComparator<T> clone(ICloneContext cc) {
		IdentityIteratorComparator<T> comparator = (IdentityIteratorComparator<T>) super.clone(cc);
		comparator.iterator = cc.clone(this.iterator);
		comparator.comparator = cc.clone(this.comparator);
		return comparator;
	}

	public void setBindings(IBindingManager bm) {
		iterator.setBindings(bm);
		comparator.setBindings(bm);
	}

	public boolean equals(T e1, T e2) {
		return hasIdentity(e2, identityOf(e1));
	}
	protected List<T> identityOf(T e) {
		List<T> identityList = new ArrayList<T>();
		
		iterator.reset(e);
		while (iterator.hasNext())
			identityList.add(iterator.next());

		return identityList;
	}
	protected <R extends IEntity> boolean hasIdentity(IEntity e, List<? extends T> identity) {
		iterator.reset(e);
		for (int i=0, size=identity.size(); i<size; i++)
			if (!iterator.hasNext() || !comparator.equals(identity.get(i), iterator.next()))
				return false;
		return !iterator.hasNext();
	}

	public boolean contains(IEntity container, T e) {
		List<T> eIdentity = identityOf(e);
		for (int i=0, size=container.wSize(); i<size; i++)
			if (hasIdentity(container.wGet(i), eIdentity))
				return true;
		return false;
	}

	public IEntity get(IEntity container, T e) {
		List<T> eIdentity = identityOf(e);
		for (int i=0, size=container.wSize(); i<size; i++) {
			IEntity e0 = container.wGet(i);
			if (hasIdentity(e0, eIdentity))
				return e0;
		}
		return null;
	}
}
