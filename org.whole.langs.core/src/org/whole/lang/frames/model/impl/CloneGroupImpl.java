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
public class CloneGroupImpl extends AbstractSimpleEntity implements CloneGroup {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CloneGroup> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.CloneGroup;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.CloneGroup_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Cardinality cardinality;

	public Cardinality getCardinality() {
		return notifyRequested(FramesFeatureDescriptorEnum.cardinality,
				cardinality);
	}

	public void setCardinality(Cardinality cardinality) {
		notifyChanged(FramesFeatureDescriptorEnum.cardinality,
				this.cardinality, this.cardinality = cardinality);
	}

	private SolitaryFeatures features;

	public SolitaryFeatures getFeatures() {
		return notifyRequested(FramesFeatureDescriptorEnum.features, features);
	}

	public void setFeatures(SolitaryFeatures features) {
		notifyChanged(FramesFeatureDescriptorEnum.features, this.features,
				this.features = features);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getCardinality().wGetAdaptee(false);
		case 1:
			return getFeatures().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setCardinality(value
					.wGetAdapter(FramesEntityDescriptorEnum.Cardinality));
			break;
		case 1:
			setFeatures(value
					.wGetAdapter(FramesEntityDescriptorEnum.SolitaryFeatures));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
