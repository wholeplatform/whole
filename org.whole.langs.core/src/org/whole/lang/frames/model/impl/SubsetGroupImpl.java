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
public class SubsetGroupImpl extends AbstractSimpleEntity implements
		SubsetGroup {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SubsetGroup> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.SubsetGroup;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.SubsetGroup_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
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

	private VariableFeatures features;

	public VariableFeatures getFeatures() {
		return notifyRequested(FramesFeatureDescriptorEnum.features, features);
	}

	public void setFeatures(VariableFeatures features) {
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
					.wGetAdapter(FramesEntityDescriptorEnum.VariableFeatures));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
