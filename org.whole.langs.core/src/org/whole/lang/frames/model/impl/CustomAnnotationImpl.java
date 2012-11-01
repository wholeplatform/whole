package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CustomAnnotationImpl extends AbstractSimpleEntity implements
		CustomAnnotation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CustomAnnotation> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.CustomAnnotation;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.CustomAnnotation_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(FramesFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(FramesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Expression value;

	public Expression getValue() {
		return notifyRequested(FramesFeatureDescriptorEnum.value, value);
	}

	public void setValue(Expression value) {
		notifyChanged(FramesFeatureDescriptorEnum.value, this.value,
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
			setName(value.wGetAdapter(FramesEntityDescriptorEnum.Name));
			break;
		case 1:
			setValue(value.wGetAdapter(FramesEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
