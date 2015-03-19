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
public class VariableFeatureImpl extends AbstractSimpleEntity implements
		VariableFeature {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableFeature> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.VariableFeature;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.VariableFeature_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SolitaryFeature feature;

	public SolitaryFeature getFeature() {
		return notifyRequested(FramesFeatureDescriptorEnum.feature, feature);
	}

	public void setFeature(SolitaryFeature feature) {
		notifyChanged(FramesFeatureDescriptorEnum.feature, this.feature,
				this.feature = feature);
	}

	private VariableValue value;

	public VariableValue getValue() {
		return notifyRequested(FramesFeatureDescriptorEnum.value, value);
	}

	public void setValue(VariableValue value) {
		notifyChanged(FramesFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFeature().wGetAdaptee(false);
		case 1:
			return getValue().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFeature(value
					.wGetAdapter(FramesEntityDescriptorEnum.SolitaryFeature));
			break;
		case 1:
			setValue(value
					.wGetAdapter(FramesEntityDescriptorEnum.VariableValue));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
