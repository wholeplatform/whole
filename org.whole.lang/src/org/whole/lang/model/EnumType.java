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

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author Riccardo Solmi
 */
public class EnumType<E extends EnumValue> implements Iterable<E>, Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, E> namesMap = new HashMap<String, E>();
	private Map<String, E> implNamesMap = new HashMap<String, E>();
	private List<E> values = new ArrayList<E>();

//FIXME enumType should be a singleton
//  public Object readResolve() throws ObjectStreamException {
//	return getEnumType().wValueOf(ordinal);
//}
    public boolean equals(Object o) {
    	if (o instanceof EnumType<?>) {
    		return getClass().getName().equals(o.getClass().getName());
    	}
    	return false;
    }

    public int size() {
    	return values.size();
    }
    public Set<String> names() {
        return Collections.unmodifiableSet(namesMap.keySet());
    }
    public Set<String> implNames() {
        return Collections.unmodifiableSet(implNamesMap.keySet());
    }
    public List<E> values() {
        return Collections.unmodifiableList(values);
    }
    public Iterator<E> iterator() {
    	return values().iterator();
    }

    public E valueOf(int ordinal) {
        return values.get(ordinal);
    }
    public E valueOf(String name) {
    	E value = namesMap.get(name);
        return value != null ? value : implNamesMap.get(name);
    }

    protected void putEnumValue(E value) {
    	value.setEnumType(this);
    	
        namesMap.put(value.getName(), value);
        implNamesMap.put(value.getImplName(), value);

    	if (value.getOrdinal() == values.size())
    		values.add(value);
    	else {
    		for (int i=values.size(); i<=value.getOrdinal(); i++)
    			values.add(null);
    		values.set(value.getOrdinal(), value);
    	}
    }
    
    public static EnumType<? extends EnumValue> instance(Class<?> enumDataType) {
    	Class<?> enumType = enumDataType.getDeclaringClass();
		try {
			Field instanceField = enumType.getDeclaredField("instance");
			return (EnumType<?>) instanceField.get(null);
		} catch (SecurityException e) {
			throw new IllegalArgumentException();
		} catch (NoSuchFieldException e) {
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException();
		}
    }
}
