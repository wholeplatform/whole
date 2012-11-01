/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.bindings;

import java.beans.PropertyDescriptor;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.ReflectiveUtils;

/**
 * @author Riccardo Solmi
 */
public class JavaBeanScope implements IBindingScope {
	private IBindingScope enclosingScope; //TODO remove
	private Object bean;
	private Map<String, PropertyDescriptor> propertyMap;

	public JavaBeanScope(IBindingScope enclosingScope, Object bean) {
		this.enclosingScope = enclosingScope;
		this.bean = bean;
		propertyMap = ReflectiveUtils.getBeanPropertyMap(bean.getClass());
	}

	public void wClear() {
		for (String propertyName : propertyMap.keySet())
			wUnset(propertyName);
	}

	public void wAddAll(IBindingScope scope) {
		if (scope == NullScope.instance)
			return;
		Set<String> names = scope.wEnclosingScope() == this ? scope.wLocalNames() : scope.wNames();
		for (String name : names)
			wDef(name, scope.wGet(name));
	}

	public Set<String> wNames() {
		Set<String> nameSet = wEnclosingScope().wNames();
		nameSet.addAll(wLocalNames());
		return nameSet;
	}

	public Set<String> wLocalNames() {
		return Collections.unmodifiableSet(propertyMap.keySet());
	}

	public IBindingScope wClone() {
		return new JavaBeanScope(
				enclosingScope.wClone(),
				ReflectiveUtils.reflectiveClone(bean));
	}

	public IBindingScope wEnclosingScope() {
		return enclosingScope;
	}

	public IEntity wGet(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (IEntity) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (Exception e) {
				return null;
			}
		}
		return enclosingScope.wGet(name);
	}

	public void wAdd(String name, IEntity value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}

	public void wDef(String name, IEntity value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wSet(String name, IEntity value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name))
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wSet(name, value);
	}
	public boolean wIsSet(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name))
			return ReflectiveUtils.hasPrimitiveProperty(propertyMap, name) ? 
					true : ReflectiveUtils.getProperty(propertyMap, bean, name) != null;
		else
			return enclosingScope.wIsSet(name);
	}
	public void wUnset(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			// check if we really need to unset
			if (ReflectiveUtils.hasReferenceProperty(propertyMap, name)) {
				ReflectiveUtils.setProperty(propertyMap, bean, name, null);
			}
		} else {
			enclosingScope.wUnset(name);
		}
	}

	public void wAddValue(String name, boolean value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, byte value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, char value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, double value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, float value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, int value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, long value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, short value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, String value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, Date value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, EnumValue value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}
	public void wAddValue(String name, Object value) {
		if (ReflectiveUtils.hasIndexedProperty(propertyMap, name)) 
			ReflectiveUtils.addIndexedProperty(propertyMap, bean, name, value);
		else if(ReflectiveUtils.hasCollectionProperty(propertyMap, name))
			ReflectiveUtils.addCollectionProperty(propertyMap, bean, name, value);
		else
			enclosingScope.wAddValue(name, value);
	}

	public void wDefValue(String name, boolean value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, byte value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, char value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, double value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, float value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, int value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, long value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, short value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, String value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, Date value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, EnumValue value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wDefValue(String name, Object value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}

	public boolean wBooleanValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Boolean) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wBooleanValue(name);
	}
	public byte wByteValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Byte) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wByteValue(name);
	}
	public char wCharValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Character) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wCharValue(name);
	}
	public Date wDateValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Date) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wDateValue(name);
	}
	public double wDoubleValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Double) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wDoubleValue(name);
	}
	public EnumValue wEnumValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (EnumValue) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wEnumValue(name);
	}
	public float wFloatValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Float) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wFloatValue(name);
	}
	public Object wGetValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wGetValue(name);
	}
	public int wIntValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Integer) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wIntValue(name);
	}
	public long wLongValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Long) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wLongValue(name);
	}
	public short wShortValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Short) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wShortValue(name);
	}
	public String wStringValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (String) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return enclosingScope.wStringValue(name);
	}

	public void wSetValue(String name, boolean value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, byte value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, char value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, double value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, float value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, int value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, long value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, short value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, String value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, Date value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, EnumValue value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}
	public void wSetValue(String name, Object value) {
		if(ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			enclosingScope.wSetValue(name, value);
		}
	}

	public boolean isResultIterator() {
		return false;		
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return IteratorFactory.emptyIterator();		
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		throw new IllegalStateException("JavaBeanBindingManager");		
	}
	public IEntity getResult() {
		throw new IllegalStateException("JavaBeanBindingManager");		
	}
	public void setResult(IEntity value) {
		throw new IllegalStateException("JavaBeanBindingManager");		
	}
}
