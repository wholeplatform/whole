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
public class AttributeImpl extends AbstractSimpleEntity implements Attribute {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Attribute> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Attribute;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Attribute_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private SolitaryFeatureName name;

	public SolitaryFeatureName getName() {
		return notifyRequested(FramesFeatureDescriptorEnum.name, name);
	}

	public void setName(SolitaryFeatureName name) {
		notifyChanged(FramesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(FramesFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(FramesFeatureDescriptorEnum.type, this.type,
				this.type = type);
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
			return getType().wGetAdaptee(false);
		case 2:
			return getValue().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value
					.wGetAdapter(FramesEntityDescriptorEnum.SolitaryFeatureName));
			break;
		case 1:
			setType(value.wGetAdapter(FramesEntityDescriptorEnum.Type));
			break;
		case 2:
			setValue(value.wGetAdapter(FramesEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
