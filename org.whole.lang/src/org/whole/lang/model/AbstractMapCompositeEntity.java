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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractMapCompositeEntity<K extends IEntity, V extends IEntity> extends AbstractOrderedCompositeEntity<K> implements Map<K, V> {
	protected Map<K, V> childrenMap;

	@Override
	protected void initElements(int initialCapacity) {
		super.initElements(initialCapacity);
		childrenMap = new HashMap<K, V>(initialCapacity);
	}

	@SuppressWarnings("unchecked")
	public IEntity wShallowClone() {
    	AbstractMapCompositeEntity<K, V> entity = (AbstractMapCompositeEntity<K, V>) super.wShallowClone();
    	entity.childrenMap = (Map<K, V>) ((HashMap<K, V>) entity.childrenMap).clone();
    	return entity;
	}

    public String toDebugString() {
    	return childrenMap.toString();
    }

	@SuppressWarnings("unchecked")
	protected V adaptValue(IEntity value) {
		return (V) value.wGetAdapter(wGetEntityDescriptor(1));
	}

	public int wIndexOf(IEntity key) {
		IEntity childAdaptee = key.wGetAdaptee(false);
		for (int i=0, size=elements.size(); i<size; i++)
			if (childAdaptee.wEquals(elements.get(i)))
			    return i;
		return -1;
	}

	public IEntity wGet(IEntity key) {
		V value = get(key);
		return value != null ? value.wGetAdaptee(false) : null;//TODO NullEntity.instance ?
	}

	public V get(Object key) {
		if (key instanceof IEntity) {
			for (Map.Entry<K, V> entry : childrenMap.entrySet())
				if (entry.getKey().wEquals((IEntity) key))
					return entry.getValue();//TODO notifyRequested
		}
		return null;
	}

	public void/*boolean*/ wSet(int index, IEntity value) {
		if (index < childrenMap.size())
			/*return*/ wSet(wGet(index), value);
		else
			throw new IndexOutOfBoundsException();
	}


	public boolean wSet(IEntity key, IEntity value) {
    	put(adaptElement(key), adaptValue(value));
		return true;
	}
	public V put(K key, V value) {
		for (Map.Entry<K, V> entry : childrenMap.entrySet())
			if (entry.getKey().wEquals(key)) {
				V oldValue = entry.getValue();
				entry.setValue(value);
				notifyChanged(oldValue, value, isContainment());
				return oldValue;
			}
		childrenMap.put(key, value);
		super.add(key);
		notifyAdded(-1, value, isContainment());
		return null;
	}

	public void putAll(Map<? extends K, ? extends V> t) {
		for (Map.Entry<K, V> entry : childrenMap.entrySet())
			put(entry.getKey(), entry.getValue());
	}

	@Override
	protected void elementsRemove(K key) {
		childrenMap.remove(key);
	}

	//FIXME childrenList
	public V remove(Object key) {
		return childrenMap.remove(key);
	}


	public boolean containsKey(Object key) {
		return key instanceof IEntity ? wContains((IEntity) key) : false;
	}
	@Override
	protected boolean elementsContains(IEntity key) {
		if (childrenMap.containsKey(key))
			return true;
		else
			return super.elementsContains(key);
	}

	public boolean containsValue(Object value) {
		return value instanceof IEntity ? wContainsValue(value) : false;
	}
    public boolean wContainsValue(Object value) {
    	if (value instanceof IEntity)
	    	for (V childValue : childrenMap.values())
	    		if (childValue.wEquals((IEntity) value))
					return true;
		return false;
    }


	public Set<Entry<K, V>> entrySet() {
		return childrenMap.entrySet();
	}

	public Set<K> keySet() {
		return childrenMap.keySet();
	}

	public Collection<V> values() {
		return childrenMap.values();
	}
}
