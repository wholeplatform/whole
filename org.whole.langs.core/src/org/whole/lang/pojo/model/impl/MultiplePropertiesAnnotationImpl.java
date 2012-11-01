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
public class MultiplePropertiesAnnotationImpl extends AbstractSimpleEntity
		implements MultiplePropertiesAnnotation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<MultiplePropertiesAnnotation> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.MultiplePropertiesAnnotation;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.MultiplePropertiesAnnotation_ord;
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

	private PropertyValuePairs propertyValuePairs;

	public PropertyValuePairs getPropertyValuePairs() {
		return notifyRequested(PojoFeatureDescriptorEnum.propertyValuePairs,
				propertyValuePairs);
	}

	public void setPropertyValuePairs(PropertyValuePairs propertyValuePairs) {
		notifyChanged(PojoFeatureDescriptorEnum.propertyValuePairs,
				this.propertyValuePairs,
				this.propertyValuePairs = propertyValuePairs);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getPropertyValuePairs().wGetAdaptee(false);
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
			setPropertyValuePairs(value
					.wGetAdapter(PojoEntityDescriptorEnum.PropertyValuePairs));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
