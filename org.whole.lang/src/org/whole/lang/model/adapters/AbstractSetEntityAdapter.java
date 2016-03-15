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
import java.util.Set;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractSetEntityAdapter<E extends IEntity> extends AbstractEntityAdapter implements Set<E> {
	public AbstractSetEntityAdapter() {
		super();
	}
	public AbstractSetEntityAdapter(IEntity adaptee) {
		super(adaptee);
	}

	@SuppressWarnings("unchecked")
	protected Set<E> wGetSetAdaptee() {
		if (wGetAdaptee(false) instanceof Set<?>)
			return  (Set<E>) wGetAdaptee(false);
		else throw new UnsupportedOperationException();
	}


	public boolean add(E o) {
		return wGetSetAdaptee().add(o);
	}
	public boolean addAll(Collection<? extends E> c) {
		return wGetSetAdaptee().addAll(c);
	}
	public void clear() {
		wGetSetAdaptee().clear();
	}
	public boolean contains(Object o) {
		return wGetSetAdaptee().contains(o);
	}
	public boolean containsAll(Collection<?> c) {
		return wGetSetAdaptee().containsAll(c);
	}
	public boolean isEmpty() {
		return wGetSetAdaptee().isEmpty();
	}
	public Iterator<E> iterator() {
		return wGetSetAdaptee().iterator();
	}
	public boolean remove(Object o) {
		return wGetSetAdaptee().remove(o);
	}
	public boolean removeAll(Collection<?> c) {
		return wGetSetAdaptee().removeAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return wGetSetAdaptee().retainAll(c);
	}
	public int size() {
		return wGetSetAdaptee().size();
	}
	public Object[] toArray() {
		return wGetSetAdaptee().toArray();
	}
	public <T> T[] toArray(T[] a) {
		return wGetSetAdaptee().toArray(a);
	}
}
