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

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.util.EntityUtils;

/**
 * IEntity adapter
 * @author Riccardo Solmi
 */
public class EntityScope extends AbstractCloneableScope {
	private IEntity entity;
	final private FeatureDescriptorEnum features;

	protected EntityScope(IEntity entity) {
		this.entity = entity;
		features = entity.wGetLanguageKit().getFeatureDescriptorEnum();
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		EntityScope scope = (EntityScope) super.clone(cc);
		scope.entity = EntityUtils.clone(entity);
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
		for (int i = 0; i < entity.wSize(); i++)
			entity.wUnset(i);
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
		Set<String> localNames = new HashSet<String>();
		for (FeatureDescriptor fd : entity.wGetEntityDescriptor().getEntityFeatureDescriptors())
			localNames.add(fd.getName());
		return Collections.unmodifiableSet(localNames);
	}

	private FeatureDescriptor getFeature(String name) {
		return features.valueOf(name);
	}
	protected FeatureDescriptor defFeature(String name) {
		FeatureDescriptor feature = getFeature(name);
		if (feature == null)
			;//FIXME entity.wAdd(feature);
		return feature;
	}

	public IEntity wGet(String name) {
		FeatureDescriptor feature = getFeature(name);
		if (feature != null)		
			return entity.wGet(feature);
		else
			return null;
	}
	public void wSet(String name, IEntity value) {
		FeatureDescriptor feature = getFeature(name);
		if (feature != null)
			entity.wSet(feature, value);
		else
			throw BindingManagerFactory.instance.createNoBindingException(name);
	}
	public void wDef(String name, IEntity value) {
		entity.wSet(defFeature(name), value);
	}
	public boolean wIsSet(String name) {
		FeatureDescriptor feature = getFeature(name);
		if (feature != null)
			return entity.wIsSet(feature);
		else
			return false;
	}
	public void wUnset(String name) {
		FeatureDescriptor feature = getFeature(name);
		if (feature != null)
			entity.wUnset(feature);
	}

	public IBindingScope wFindScope(String name) {
		return wIsSet(name) ? this : VoidScope.instance;
	}


	public boolean wBooleanValue(String name) {
		try {
			return wGet(name).wBooleanValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public byte wByteValue(String name) {
		try {
			return wGet(name).wByteValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public char wCharValue(String name) {
		try {
			return wGet(name).wCharValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public double wDoubleValue(String name) {
		try {
			return wGet(name).wDoubleValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public float wFloatValue(String name) {
		try {
			return wGet(name).wFloatValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public int wIntValue(String name) {
		try {
			return wGet(name).wIntValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public long wLongValue(String name) {
		try {
			return wGet(name).wLongValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public short wShortValue(String name) {
		try {
			return wGet(name).wShortValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public String wStringValue(String name) {
		try {
			return wGet(name).wStringValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public Date wDateValue(String name) {
		try {
			return wGet(name).wDateValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public EnumValue wEnumValue(String name) {
		try {
			return wGet(name).wEnumValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public Object wGetValue(String name) {
		try {
			return wGet(name).wGetValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}

	public void wSetValue(String name, boolean value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, byte value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, char value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, double value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, float value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, int value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, long value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, short value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, String value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, Date value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, EnumValue value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wSetValue(String name, Object value) {
		try {
			wGet(name).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}

	public void wDefValue(String name, boolean value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, byte value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, char value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, double value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, float value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, int value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, long value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, short value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, String value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, Date value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, EnumValue value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public void wDefValue(String name, Object value) {
		try {
			entity.wGet(defFeature(name)).wSetValue(value);
		} catch (NullPointerException e) {
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
