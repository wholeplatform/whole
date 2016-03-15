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
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.ReflectiveUtils;

/**
 * @author Riccardo Solmi
 */
public class JavaBeanScope extends AbstractCloneableScope {
	private Object bean;
	final private Map<String, PropertyDescriptor> propertyMap;

	public JavaBeanScope(Object bean) {
		this.bean = bean;
		propertyMap = ReflectiveUtils.getBeanPropertyMap(bean.getClass());
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		JavaBeanScope scope = (JavaBeanScope) super.clone(cc);
		scope.bean = ReflectiveUtils.reflectiveClone(bean);
		scope.resultScope = resultScope == this ? scope : null;
		return scope;
	}

	public Kind getKind() {
		return Kind.SCOPE;
	}

	public IBindingScope wTargetScope() {
		return this;
	}
	public IBindingScope wEnclosingScope() {
		return NullScope.instance;
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

	public IEntity wGet(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name))
			try {
				return (IEntity) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (Exception e) {
			}
		return null;
	}

	public void wDef(String name, IEntity value) {
		ReflectiveUtils.setProperty(propertyMap, bean, name, value);
	}
	public void wSet(String name, IEntity value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name))
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		else
			throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public boolean wIsSet(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name))
			return ReflectiveUtils.hasPrimitiveProperty(propertyMap, name) ? 
					true : ReflectiveUtils.getProperty(propertyMap, bean, name) != null;
		else
			return false;
	}
	public void wUnset(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			// check if we really need to unset
			if (ReflectiveUtils.hasReferenceProperty(propertyMap, name)) {
				ReflectiveUtils.setProperty(propertyMap, bean, name, null);
			}
		}
	}

	public IBindingScope wFindScope(String name) {
		return wIsSet(name) ? this : VoidScope.instance;
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
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public byte wByteValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Byte) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public char wCharValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Character) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public Date wDateValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Date) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public double wDoubleValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Double) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public EnumValue wEnumValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (EnumValue) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public float wFloatValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Float) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public Object wGetValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public int wIntValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Integer) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public long wLongValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Long) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public short wShortValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (Short) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public String wStringValue(String name) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			try {
				return (String) ReflectiveUtils.getProperty(propertyMap, bean, name);
			} catch (ClassCastException e) {
				throw new IllegalArgumentException(e);
			}
		}
		throw BindingManagerFactory.instance.createNoBindingException(name);
	}

	public void wSetValue(String name, boolean value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, byte value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, char value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, double value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, float value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, int value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, long value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, short value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, String value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, Date value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, EnumValue value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, Object value) {
		if (ReflectiveUtils.hasProperty(propertyMap, name)) {
			ReflectiveUtils.setProperty(propertyMap, bean, name, value);
		} else {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}

	private IBindingScope resultScope;
	public IBindingScope wResultScope() {
		return resultScope;
	}
	public void wSetResultScope(IBindingScope scope) {
		resultScope = scope;	
	}

	public boolean hasResultIterator() {
		return false;
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return IteratorFactory.emptyIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
	}
	public IEntity getResult() {
		return null;
	}
	public void setResult(IEntity value) {
	}
}
