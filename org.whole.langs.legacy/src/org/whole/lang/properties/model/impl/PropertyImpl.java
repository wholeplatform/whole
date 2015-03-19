package org.whole.lang.properties.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.properties.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertyImpl extends AbstractSimpleEntity implements Property {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Property> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Property;
	}

	public int wGetEntityOrd() {
		return PropertiesEntityDescriptorEnum.Property_ord;
	}

	public void accept(IPropertiesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(PropertiesFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private PropertyName name;

	public PropertyName getName() {
		return notifyRequested(PropertiesFeatureDescriptorEnum.name, name);
	}

	public void setName(PropertyName name) {
		notifyChanged(PropertiesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private PropertyValue value;

	public PropertyValue getValue() {
		return notifyRequested(PropertiesFeatureDescriptorEnum.value, value);
	}

	public void setValue(PropertyValue value) {
		notifyChanged(PropertiesFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getValue().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value
					.wGetAdapter(PropertiesEntityDescriptorEnum.PropertyName));
			break;
		case 1:
			setValue(value
					.wGetAdapter(PropertiesEntityDescriptorEnum.PropertyValue));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
