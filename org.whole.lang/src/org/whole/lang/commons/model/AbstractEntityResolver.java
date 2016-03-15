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
package org.whole.lang.commons.model;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractEntityResolver extends AbstractListCompositeEntity<org.whole.lang.model.IEntity> implements IEntityAdapter {//TODO remove IEntityAdapter
	private Map<FeatureDescriptor, IEntity> namedFeaturesMap = new HashMap<FeatureDescriptor, IEntity>();
	private transient Set<EntityDescriptor<?>> assignableSet = null;

	public IEntity wShallowClone() {
    	AbstractEntityResolver entity = (AbstractEntityResolver) super.wShallowClone();
    	entity.namedFeaturesMap = new HashMap<FeatureDescriptor, IEntity>();//entity.namedFeaturesMap);
    	if (assignableSet != null)
	    	entity.assignableSet = null;//FIXME new HashSet<EntityDescriptor<?>>(entity.assignableSet);
    	return entity;
	}

    @Override
    public int wSize() {
    	if (namedFeaturesMap.isEmpty())
    		return super.wSize();
    	else
    		return namedFeaturesMap.size();
    }
    @Override
    public IEntity wGet(int index) {
    	if (index < namedFeaturesMap.size())
    		return wGet(getFeatureDescriptorArray()[index]);
    	else
    		return super.wGet(index);
    }    

	public IEntity wGetAdaptee(boolean force) {
		return this;
	}
	public void wSetAdaptee(IEntity implementor) {
	}


    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    }

	protected boolean hasAssignableSet() {
		return true;
	}
	protected Set<EntityDescriptor<?>> getAssignableSet() {
		if (assignableSet == null) {
			assignableSet = calculateAssignableSet();
			
			//filter abstract types
			Iterator<EntityDescriptor<?>> i = assignableSet.iterator();
			while (i.hasNext())
				if (i.next().isAbstract())
					i.remove();
		}
		return assignableSet;
	}
	protected Set<EntityDescriptor<?>> calculateAssignableSet() {
		return wGetEntityDescriptor().getLanguageConcreteSubtypes();
	}
	protected void updateAssignableSet() {
		assignableSet = null;
		if (!namedFeaturesMap.isEmpty()) {
			for (FeatureDescriptor fd : namedFeaturesMap.keySet()) {
				IEntity result = wResolveWith(fd);
				if (result != this)
					return;
			}
		} else if (!elements.isEmpty()) {
			for (IEntity element : elements) {
				IEntity result = wResolveWithComposite(element);
				if (result != this)
					return;
			}
		}
	}

    public final EntityKinds wGetEntityKind() {
    	return EntityKinds.SIMPLE;//WAS RESOLVER;
    }

    public void wAccept(GenericMatcher matcher, IEntity other) {
    	matcher.matchEntityResolver(this, other);
    }

	public <T extends IEntity> T wResolveWith(EntityDescriptor<T> ed) {
		T newChild = GenericEntityFactory.instance.create(ed);
		
		if (ed.getEntityKind().isComposite()) {
			for (IEntity element : elements)
				newChild.wAdd(EntityUtils.clone(element));
		} else {
			Set<FeatureDescriptor> features = new HashSet<FeatureDescriptor>(
					newChild.wGetEntityDescriptor().getEntityFeatureDescriptors());
			features.retainAll(namedFeaturesMap.keySet());

			for (FeatureDescriptor fd : features)
				newChild.wSet(fd, EntityUtils.clone(this.wGet(fd)));
		}

		wGetParent().wSet(this, newChild);

//FIXME This class should delegate to the newChild
//		IEntity adapter = wGetParent().wGet(this); //No longer returns adapter
//		wGetParent().wSet(adapter, newChild);
//
//		if (adapter instanceof IEntityAdapter)
//			((IEntityAdapter) adapter).wSetAdaptee(newChild);

		return newChild;
	}
    protected IEntity wResolveWith(FeatureDescriptor feature) {
    	if (hasAssignableSet()) {
    		Iterator<EntityDescriptor<?>> i = getAssignableSet().iterator();
    		while (i.hasNext())
    			if (!i.next().has(feature))
    				i.remove();

    		if (getAssignableSet().size() == 1) {
    			EntityDescriptor<?> descriptor = getAssignableSet().iterator().next();
    			return wResolveWith(descriptor);
    		} else if (getAssignableSet().isEmpty())
    			throw new IllegalArgumentException("The feature "+feature.getName()+" is incompatible with this entity.");    		
    	}
		return this;
	}
    //FIXME add a field for storing a data entity when two or more data entity descriptors are available
	protected IEntity wResolveWith(Class<?> type) {
    	if (hasAssignableSet()) {
			Iterator<EntityDescriptor<?>> i = getAssignableSet().iterator();
			while (i.hasNext()) {
				EntityDescriptor<?> ed = i.next();
				Class<?> dataType = ed.getDataType();
				if (dataType == null || !dataType.isAssignableFrom(type))
					i.remove();
			}
	
			if (getAssignableSet().size() == 1) {
				EntityDescriptor<?> descriptor = getAssignableSet().iterator().next();
				return wResolveWith(descriptor);
			} else if (getAssignableSet().isEmpty())
				throw new IllegalArgumentException("The feature "+type.getName()+" is incompatible with this entity.");
    	}
		return this;
	}
	protected IEntity wResolveWithComposite(IEntity child) {
    	if (hasAssignableSet()) {
    		EntityDescriptor<?> childED = child.wGetEntityDescriptor();
			Iterator<EntityDescriptor<?>> i = getAssignableSet().iterator();
			while (i.hasNext()) {
				EntityDescriptor<?> ed = i.next();
				if (!ed.getEntityKind().isComposite() || !ed.getEntityDescriptor(0).isPlatformSupertypeOf(childED))
					i.remove();
			}
	
			if (getAssignableSet().size() == 1) {
				EntityDescriptor<?> descriptor = getAssignableSet().iterator().next();
				return wResolveWith(descriptor);
			} else if (getAssignableSet().isEmpty())
				throw new IllegalArgumentException("The child "+childED+" is incompatible with this entity.");
    	}
		return this;
	}
		
	public Class<?> wGetType(IEntity child) {
		return child.getClass();
	}

	public boolean wAdd(int index, IEntity child) {
		IEntity result = wResolveWithComposite(child);
		if (result == this)
			return super.wAdd(index, child);
		else
			return result.wAdd(index, child);
	}

	public boolean wAdd(IEntity child) {
		IEntity result = wResolveWithComposite(child);
		if (result == this)
			return super.wAdd(child);
		else
			return result.wAdd(child);
	}

	@Override
	protected IEntity adaptElement(IEntity child) {
		return child;
	}
	
	public FeatureDescriptor wGetFeatureDescriptor(int index) {
		if (index < namedFeaturesMap.size())
			return getFeatureDescriptorArray()[index];
		else
			return CommonsFeatureDescriptorEnum.composite_element;			
	}

	public Set<FeatureDescriptor> getFeatureDescriptorSet() {
		return namedFeaturesMap.keySet();
	}
	public FeatureDescriptor[] getFeatureDescriptorArray() {
		return namedFeaturesMap.keySet().toArray(new FeatureDescriptor[namedFeaturesMap.size()]);
	}

    public boolean wContains(FeatureDescriptor feature) {
        return namedFeaturesMap.containsKey(feature);
    }
   
    public IEntity wGet(FeatureDescriptor feature) {
        Object value = namedFeaturesMap.get(feature);
        if (value == null || !(value instanceof IEntity))
            throw new IllegalArgumentException("Feature return type error: "+feature.getName());
        return (IEntity) value;
    }

	public void wSet(FeatureDescriptor feature, IEntity value) {
    	IEntity result = wResolveWith(feature);
    	if (result == this) {
    		namedFeaturesMap.put(feature, null);//FIXME default value;
        	if (!wContains(feature))
    			throw new IllegalArgumentException("feature: "+feature.getName()+" is not defined");
        	notifyChanged(feature, (IEntity) namedFeaturesMap.put(feature, value), value);
    	} else
    		result.wSet(feature, value);
    }


    public boolean wBooleanValue() {
		return notifyRequested(false);
	}
	public byte wByteValue() {
		return notifyRequested((byte) 0);
	}
	public char wCharValue() {
		return notifyRequested('c');
	}
	public double wDoubleValue() {
		return notifyRequested(0d);
	}
	public float wFloatValue() {
		return notifyRequested(0f);
	}
	public int wIntValue() {
		return notifyRequested(0);
	}
	public long wLongValue() {
		return notifyRequested(0l);
	}
	public short wShortValue() {
		return notifyRequested((short) 0);
	}
	public String wStringValue() {
		return notifyRequested("");
	}
	public Date wDateValue() {
		return notifyRequested((java.util.Date) null);
	}
	public EnumValue wEnumValue() {
		return notifyRequested((EnumValue) null);
	}
	public Object wGetValue() {
		return notifyRequested((Object) null);
	}
	public void wSetValue(boolean value) {
		wResolveWith(boolean.class).wSetValue(value);
	}
	public void wSetValue(byte value) {
		wResolveWith(byte.class).wSetValue(value);
	}
	public void wSetValue(char value) {
		wResolveWith(char.class).wSetValue(value);
	}
	public void wSetValue(double value) {
		wResolveWith(double.class).wSetValue(value);
	}
	public void wSetValue(float value) {
		wResolveWith(float.class).wSetValue(value);
	}
	public void wSetValue(int value) {
		wResolveWith(int.class).wSetValue(value);
	}
	public void wSetValue(long value) {
		wResolveWith(long.class).wSetValue(value);
	}
	public void wSetValue(short value) {
		wResolveWith(short.class).wSetValue(value);
	}
	public void wSetValue(String value) {
		wResolveWith(String.class).wSetValue(value);
	}
	public void wSetValue(Date value) {
		wResolveWith(Date.class).wSetValue(value);
	}
	public void wSetValue(EnumValue value) {
		wResolveWith(value.getClass()).wSetValue(value);
	}
	public void wSetValue(Object value) {
		Class<?> valueClass = value.getClass();
		if (valueClass.isPrimitive() || value instanceof String
				|| value instanceof Date || value instanceof EnumValue)
			wResolveWith(valueClass).wSetValue(value);
		else if (StringUtils.isWrapper(valueClass.getName()))
			wResolveWith(DataTypeUtils.unboxFilter(valueClass)).wSetValue(value);
		else
			wResolveWith(Object.class).wSetValue(value);
	}
    public boolean wIsSet() {
		return false;
    }
    public void wUnset() {
    }
    public void wUnset(FeatureDescriptor feature) {
    	namedFeaturesMap.remove(feature);
    }
    public void wUnset(int index) {
    	super.wUnset(index);//FIXME
    }
}
