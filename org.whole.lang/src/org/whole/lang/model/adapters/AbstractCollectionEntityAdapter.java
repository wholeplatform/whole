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
package org.whole.lang.model.adapters;

import java.util.Collection;
import java.util.Iterator;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractCollectionEntityAdapter<E extends IEntity> extends AbstractEntityAdapter implements Collection<E> {
	public AbstractCollectionEntityAdapter() {
		super();
	}
	public AbstractCollectionEntityAdapter(IEntity adaptee) {
		super(adaptee);
	}

	@SuppressWarnings("unchecked")
	protected Collection<E> wGetCollectionAdaptee() {
		if (wGetAdaptee(false) instanceof Collection<?>)
			return  (Collection<E>) wGetAdaptee(false);
		else throw new UnsupportedOperationException();
	}


	public boolean add(E o) {
		return wGetCollectionAdaptee().add(o);
	}
	public boolean addAll(Collection<? extends E> c) {
		return wGetCollectionAdaptee().addAll(c);
	}
	public void clear() {
		wGetCollectionAdaptee().clear();
	}
	public boolean contains(Object o) {
		return wGetCollectionAdaptee().contains(o);
	}
	public boolean containsAll(Collection<?> c) {
		return wGetCollectionAdaptee().containsAll(c);
	}
	public boolean isEmpty() {
		return wGetCollectionAdaptee().isEmpty();
	}
	public Iterator<E> iterator() {
		return wGetCollectionAdaptee().iterator();
	}
	public boolean remove(Object o) {
		return wGetCollectionAdaptee().remove(o);
	}
	public boolean removeAll(Collection<?> c) {
		return wGetCollectionAdaptee().removeAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return wGetCollectionAdaptee().retainAll(c);
	}
	public int size() {
		return wGetCollectionAdaptee().size();
	}
	public Object[] toArray() {
		return wGetCollectionAdaptee().toArray();
	}
	public <T> T[] toArray(T[] a) {
		return wGetCollectionAdaptee().toArray(a);
	}
}
