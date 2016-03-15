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
package org.whole.lang.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.whole.lang.commands.ICommand;
import org.whole.lang.commands.NullCommand;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.util.EntityUtils;

/**
 * 
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractOrderedCompositeEntity<E extends IEntity> extends AbstractEntity {
	protected List<E> elements;
	private ICommand lastCommand = NullCommand.instance;

	protected AbstractOrderedCompositeEntity() {
		initElements(10);
	}

	protected void initElements(int initialCapacity) {
		elements = new ArrayList<E>(initialCapacity);
	}

    @SuppressWarnings("unchecked")
	public IEntity wShallowClone() {
    	AbstractOrderedCompositeEntity<E> entity = (AbstractOrderedCompositeEntity<E>) super.wShallowClone();
    	entity.elements = (List<E>) ((ArrayList<E>) entity.elements).clone();
    	entity.lastCommand = NullCommand.instance;
    	return entity;
    }

    public void wAccept(GenericMatcher matcher, IEntity other) {
    	matcher.matchCompositeEntity(this, other);
    }

	public /*final*/ ICommand wGetLastCommand() {
		return lastCommand;
	}
	public /*final*/ ICommand wSetLastCommand(ICommand command) {
		ICommand prevCommand = lastCommand;
		lastCommand = command;
		return prevCommand;
	}
    
    public EntityKinds wGetEntityKind() {
    	return EntityKinds.COMPOSITE;
    }

	@SuppressWarnings("unchecked")
	protected E adaptElement(IEntity entity) {
		return (E) entity.wGetAdapter(wGetEntityDescriptor(0));
	}

    public boolean isContainment() {
    	return true;
    }
//TODO test and remove
//	public List<IEntity> wFeatures() {
//		return Collections.unmodifiableList(new ArrayList<IEntity>(childrenList));
//	}

//	** by child features methods **

	public boolean wContains(IEntity entity) {
		if (isContainment() && entity.wGetParent() == this)
			return true;
		else
			return elementsContains(entity.wGetAdaptee(false));
	}
	protected boolean elementsContains(IEntity entity) {
		for (int i=0, size=elements.size(); i<size; i++) {
			IEntity child = elements.get(i).wGetAdaptee(false);
			if (child.wEquals(entity))
				return true; // i could be different from wIndexOf(child)
		}
		return false;
	}
	
	public boolean wContainsValue(Object value) {
		for (int i=0, size=elements.size(); i<size; i++) {
			IEntity child = elements.get(i);
			if (child.wContainsValue(value))
				return true; // i could be different from wIndexOf(child)
		}
		return false;
	}

	public int wIndexOf(IEntity entity) {
		IEntity childAdaptee = entity.wGetAdaptee(false);
		int result = -1;
		for (int i=0, size=elements.size(); i<size; i++) {
			IEntity childByIndex = elements.get(i).wGetAdaptee(false);
			if (childByIndex.equals(childAdaptee))
				return i; // object identity
			else if (result == -1 && childByIndex.wEquals(childAdaptee))
				result = i; // business identity
		}
		return result;
	}

	public boolean wAdd(IEntity entity) {
    	return add(adaptElement(entity));
	}

	public boolean wRemove(IEntity entity) {
		int index = wIndexOf(entity);
		return index >= 0 ? wRemove(index) : false;
	}


	private boolean testIsContainment() {
		return isContainment()
				|| wGetEntityDescriptor().getURI().equals("http://lang.whole.org/Environment#Tuple");//FIXME workaround
	}

//	** by index features methods **

	public int wSize() {
		return testIsContainment() ? elements.size() : 0;
	}
	public int wAdjacentSize() {
		return testIsContainment() ? 0 : elements.size();
	}
	public boolean wIsEmpty() {
	    return elements.isEmpty() || (elements.size() == 1 && EntityUtils.isResolver(elements.get(0)));
	}

	public IEntity wGet(int index) {
	    return get(index).wGetAdaptee(false);
	}

	public boolean wAdd(int index, IEntity entity) {
    	add(index, adaptElement(entity));
		return true;
	}

	public boolean wRemove(int index) {
		if (!wContains(index))
			return false;
		remove(index);
		return true;
	}


//	** specific API
	
	public boolean add(E entity) {
		int size = elements.size();
		elements.add(entity);
		elementsAdd(entity);
		notifyAdded(size, entity, isContainment());
	    return true;
	}

	public void add(int index, E entity) {
		elements.add(index, entity);
		elementsAdd(entity);
		notifyAdded(index, entity, isContainment());
	}

	public boolean addAll(Collection<? extends E> c) {
		((ArrayList<E>) elements).ensureCapacity(elements.size() + c.size());
		
		boolean modified = false;
		for (E e : c)
			modified |= add(e);
		return modified;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		int initialSize = elements.size();
		((ArrayList<E>) elements).ensureCapacity(initialSize + c.size());
		
		for (E e : c)
			add(index++, e);
		return elements.size() > initialSize;
	}

	public E remove(int index) {
		E value = elements.remove(index);
		elementsRemove(value);
		notifyRemoved(index, value, isContainment());
		return value;
	}

	public boolean retainAll(Collection<?> c) {
		boolean modified = false;

		for (int i=elements.size()-1; i>=0; i--)
			if (!c.contains(wGet(i))) {
				remove(i);
				modified = true;
			}

		return modified;
	}

	public E get(int index) {
		return notifyRequested(index, elements.get(index));
	}
	public E set(int index, E entity) {
		E value = elements.set(index, entity);
		elementsRemove(value);
		elementsAdd(entity);
		notifyChanged(index, value, entity, isContainment());
		return value;
	}

	public int indexOf(Object o) {
		return o instanceof IEntity ? wIndexOf((IEntity) o) : -1;
	}
	public int lastIndexOf(Object o) {
		if (!(o instanceof IEntity))
			return -1;

		int result = -1;
		IEntity childAdaptee = ((IEntity) o).wGetAdaptee(false);
		for (int size=elements.size(), i=size-1; i>=0; i--) {
			IEntity childByIndex = elements.get(i).wGetAdaptee(false);
			if (childByIndex.equals(childAdaptee))
				return i; // object identity
			else if (result == -1 && childByIndex.wEquals(childAdaptee))
				result = i; // business identity
		}
		return result;
	}

	public int size() {
		return elements.size();
	}

	public boolean isEmpty() {
		return wIsEmpty();
	}

	public void clear() {
		for (int i=elements.size()-1; i>=0; i--)
			remove(i);
	}

	public boolean contains(Object o) {
		return o instanceof IEntity ? wContains((IEntity) o) : false;
	}

	public boolean containsAll(Collection<?> c) {
		for (Object o : c)
			if (!contains(o))
				return false;
		return true;
	}

	//FIXME
	public Iterator<E> iterator() {
		return IteratorFactory.entityCollectionIterator(elements);
	}
	//FIXME
	public ListIterator<E> listIterator() {
		return elements.listIterator();
	}
	//FIXME
	public ListIterator<E> listIterator(int index) {
		return elements.listIterator(index);
	}
	//FIXME
	public List<E> subList(int fromIndex, int toIndex) {
		return elements.subList(fromIndex, toIndex);
	}

	public Object[] toArray() {
		return elements.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return elements.toArray(a);
	}

	public String toString() {
		return super.toString();//was toDebugString();
	}
	public String toDebugString() {
    	return elements.toString();
    }


	protected void elementsAdd(E entity) {
	}
	protected void elementsRemove(E entity) {
	}

}
