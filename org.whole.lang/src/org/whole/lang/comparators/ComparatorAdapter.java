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

import java.util.Comparator;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class ComparatorAdapter<T extends IEntity> implements IEntityComparator<T> {
	protected Comparator<T> comparator;

	public ComparatorAdapter(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public IEntityComparator<T> clone() {
		return clone(new CloneContext());
	}

	@SuppressWarnings("unchecked")
	public IEntityComparator<T> clone(ICloneContext cc) {
		try {
			ComparatorAdapter<T> comparator = (ComparatorAdapter<T>) super.clone();
			cc.putClone(this, comparator);
			return comparator;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public void setBindings(IBindingManager bm) {
	}

	public boolean canOrder() {
		return true;
	}

	public int compare(T o1, T o2) {
		return comparator.compare(o1, o2);
	}

	public boolean equals(T o1, T o2) {
		try {
			return compare(o1, o2) == 0;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean contains(IEntity container, T e) {
		for (int i=0, size=container.wSize(); i<size; i++)
			if (equals((T) container.wGet(i), e))
				return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public IEntity get(IEntity container, T e) {
		for (int i=0, size=container.wSize(); i<size; i++) {
			T e0 = (T) container.wGet(i);
			if (equals(e0, e))
				return e0;
		}
		return null;
	}
}
