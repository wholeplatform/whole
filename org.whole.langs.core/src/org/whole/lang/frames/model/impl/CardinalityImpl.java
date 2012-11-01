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
public class CardinalityImpl extends AbstractSimpleEntity implements
		Cardinality {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Cardinality> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Cardinality;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Cardinality_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private IntValue min;

	public IntValue getMin() {
		return notifyRequested(FramesFeatureDescriptorEnum.min, min);
	}

	public void setMin(IntValue min) {
		notifyChanged(FramesFeatureDescriptorEnum.min, this.min, this.min = min);
	}

	private IntValue max;

	public IntValue getMax() {
		return notifyRequested(FramesFeatureDescriptorEnum.max, max);
	}

	public void setMax(IntValue max) {
		notifyChanged(FramesFeatureDescriptorEnum.max, this.max, this.max = max);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getMin().wGetAdaptee(false);
		case 1:
			return getMax().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setMin(value.wGetAdapter(FramesEntityDescriptorEnum.IntValue));
			break;
		case 1:
			setMax(value.wGetAdapter(FramesEntityDescriptorEnum.IntValue));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
