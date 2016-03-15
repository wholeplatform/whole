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
package org.whole.lang.util;

import java.beans.BeanInfo;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ReflectiveUtils {
	@SuppressWarnings("unchecked")
	public static final <T> T reflectiveClone(T object) {
		try {
			Method cloneMethod = object.getClass().getMethod("clone", new Class<?>[] {});
			return (T) cloneMethod.invoke(object, new Object[] {});
		} catch (Exception e) {
			throw new IllegalArgumentException("Clone not supported in bean", e);
		}
	}

	public static final Map<String, PropertyDescriptor> getBeanPropertyMap(Class<?> bean) {
		Map<String, PropertyDescriptor> propertyMap = new HashMap<String, PropertyDescriptor>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean);
			for (PropertyDescriptor property : beanInfo.getPropertyDescriptors()) {
				propertyMap.put(property.getName(), property);
			}
			return propertyMap;
		} catch (IntrospectionException e) {
			throw new RuntimeException(e);
		}
	}

	public static final Class<?> propertyType(Map<String, PropertyDescriptor> propertyMap, String name) {
		return propertyMap.get(name).getPropertyType();
	}
	public static final Class<?> propertyIndexedType(Map<String, PropertyDescriptor> propertyMap, String name) {
		return ((IndexedPropertyDescriptor)propertyMap.get(name)).getIndexedPropertyType();
	}
	public static final boolean hasProperty(
			Map<String, PropertyDescriptor> propertyMap, String name) {
		PropertyDescriptor property = propertyMap.get(name);
		return property != null;
	}

	public static final boolean hasPrimitiveProperty(Map<String, PropertyDescriptor> propertyMap, String name) {
		PropertyDescriptor property = propertyMap.get(name);
		return property != null && property.getPropertyType().isPrimitive();
	}

	public static final boolean hasReferenceProperty(Map<String, PropertyDescriptor> propertyMap, String name) {
		PropertyDescriptor property = propertyMap.get(name);
		return property != null && !property.getPropertyType().isPrimitive();
	}

	public static final boolean hasIndexedProperty(Map<String, PropertyDescriptor> propertyMap, String name) {
		PropertyDescriptor property = propertyMap.get(name);
		return property != null && property instanceof IndexedPropertyDescriptor;
	}

	public static final <T> boolean hasCollectionProperty(Map<String, PropertyDescriptor> propertyMap, String name) {
		PropertyDescriptor property = propertyMap.get(name);
		return property != null && Collection.class.isAssignableFrom(property.getPropertyType());
	}

	public static final TypeVariable<?>[] collectionPropertyTypeVariables(Map<String, PropertyDescriptor> propertyMap, String name) {
		PropertyDescriptor property = propertyMap.get(name);
		return property.getPropertyType().getTypeParameters();
	}

	public static final Object getProperty(Map<String, PropertyDescriptor> propertyMap, Object bean, String name) {
		PropertyDescriptor property = propertyMap.get(name);
		try {
			Method readMethod = property.getReadMethod();
			return readMethod.invoke(bean, new Object[] {});
		} catch (Exception e) {
			throw new IllegalArgumentException("No such property: \"" + name + "\"", e);
		}
	}
	public static final void setProperty(Map<String, PropertyDescriptor> propertyMap, Object bean, String name, Object value) {
		PropertyDescriptor property = propertyMap.get(name);
		try {
			Method writeMethod = property.getWriteMethod();
			writeMethod.invoke(bean, new Object[] {value});
		} catch (Exception e) {
			throw new IllegalArgumentException("No such property: \"" + name + "\"", e);
		}
	}

	public static final <T> void addIndexedProperty(Map<String, PropertyDescriptor> propertyMap, Object bean, String name, T value) {
		Object array = getProperty(propertyMap, bean, name);
		if (array == null)
			throw new IllegalArgumentException("No such property: \"" + name + "\"");

		int length = Array.getLength(array);
		Object newArray = Array.newInstance(array.getClass().getComponentType(), length + 1);
		System.arraycopy(array, 0, newArray, 0, length);
		Array.set(newArray, length, value);
		setProperty(propertyMap, bean, name, newArray);
	}
	@SuppressWarnings("unchecked")
	public static final boolean addCollectionProperty(Map<String, PropertyDescriptor> propertyMap, Object bean, String name, Object value) {
		Collection<Object> collection = (Collection<Object>) getProperty(propertyMap, bean, name);
		return collection != null ? collection.add(value) : false;
	}
}
