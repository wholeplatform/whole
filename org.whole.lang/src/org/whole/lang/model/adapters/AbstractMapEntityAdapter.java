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
import java.util.Map;
import java.util.Set;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractMapEntityAdapter<K extends IEntity, V extends IEntity> extends AbstractEntityAdapter implements Map<K, V> {
	public AbstractMapEntityAdapter() {
		super();
	}
	public AbstractMapEntityAdapter(IEntity adaptee) {
		super(adaptee);
	}

	@SuppressWarnings("unchecked")
	protected Map<K, V> wGetMapAdaptee() {
		if (wGetAdaptee(false) instanceof Map<?,?>)
			return  (Map<K,V>) wGetAdaptee(false);
		else throw new UnsupportedOperationException();
	}

	public void clear() {
		wGetMapAdaptee().clear();
	}
	public boolean containsKey(Object key) {
		return wGetMapAdaptee().containsKey(key);
	}
	public boolean containsValue(Object value) {
		return wGetMapAdaptee().containsValue(value);
	}
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return wGetMapAdaptee().entrySet();
	}
	public V get(Object key) {
		return wGetMapAdaptee().get(key);
	}
	public boolean isEmpty() {
		return wGetMapAdaptee().isEmpty();
	}
	public Set<K> keySet() {
		return wGetMapAdaptee().keySet();
	}
	public V put(K key, V value) {
		return wGetMapAdaptee().put(key, value);
	}
	public void putAll(Map<? extends K, ? extends V> t) {
		wGetMapAdaptee().putAll(t);
	}
	public V remove(Object key) {
		return wGetMapAdaptee().remove(key);
	}
	public int size() {
		return wGetMapAdaptee().size();
	}
	public Collection<V> values() {
		return wGetMapAdaptee().values();
	}
}
