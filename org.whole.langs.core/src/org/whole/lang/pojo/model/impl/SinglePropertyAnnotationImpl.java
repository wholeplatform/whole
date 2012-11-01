package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SinglePropertyAnnotationImpl extends AbstractSimpleEntity
		implements SinglePropertyAnnotation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SinglePropertyAnnotation> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.SinglePropertyAnnotation;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.SinglePropertyAnnotation_ord;
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(PojoFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(PojoFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private PropertyValue value;

	public PropertyValue getValue() {
		return notifyRequested(PojoFeatureDescriptorEnum.value, value);
	}

	public void setValue(PropertyValue value) {
		notifyChanged(PojoFeatureDescriptorEnum.value, this.value,
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
			setName(value.wGetAdapter(PojoEntityDescriptorEnum.Name));
			break;
		case 1:
			setValue(value.wGetAdapter(PojoEntityDescriptorEnum.PropertyValue));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
