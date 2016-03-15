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
import java.util.List;
import java.util.ListIterator;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractListEntityAdapter<E extends IEntity> extends AbstractEntityAdapter implements List<E> {
	public AbstractListEntityAdapter() {
		super();
	}
	public AbstractListEntityAdapter(IEntity adaptee) {
		super(adaptee);
	}

	@SuppressWarnings("unchecked")
	protected List<E> wGetListAdaptee() {
		if (wGetAdaptee(false) instanceof List<?>)
			return  (List<E>) wGetAdaptee(false);
		else throw new UnsupportedOperationException();
	}


	public boolean add(E o) {
		return wGetListAdaptee().add(o);
	}

	public void add(int index, E element) {
		wGetListAdaptee().add(index, element);
	}

	public boolean addAll(Collection<? extends E> c) {
		return wGetListAdaptee().addAll(c);
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return wGetListAdaptee().addAll(index, c);
	}

	public void clear() {
		wGetListAdaptee().clear();
	}

	public boolean contains(Object o) {
		return wGetListAdaptee().contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return wGetListAdaptee().containsAll(c);
	}

	public E get(int index) {
		return wGetListAdaptee().get(index);
	}

	public int indexOf(Object o) {
		return wGetListAdaptee().indexOf(o);
	}

	public boolean isEmpty() {
		return wGetListAdaptee().isEmpty();
	}

	public Iterator<E> iterator() {
		return wGetListAdaptee().iterator();
	}

	public int lastIndexOf(Object o) {
		return wGetListAdaptee().lastIndexOf(o);
	}

	public ListIterator<E> listIterator() {
		return wGetListAdaptee().listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		return wGetListAdaptee().listIterator(index);
	}

	public E remove(int index) {
		return wGetListAdaptee().remove(index);
	}

	public boolean remove(Object o) {
		return wGetListAdaptee().remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return wGetListAdaptee().removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return wGetListAdaptee().retainAll(c);
	}

	public E set(int index, E element) {
		return wGetListAdaptee().set(index, element);
	}

	public int size() {
		return wGetListAdaptee().size();
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return wGetListAdaptee().subList(fromIndex, toIndex);
	}

	public Object[] toArray() {
		return wGetListAdaptee().toArray();
	}

	public <T> T[] toArray(T[] a) {
		return wGetListAdaptee().toArray(a);
	}
}
