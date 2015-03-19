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
public class FeatureReferenceImpl extends AbstractSimpleEntity implements
		FeatureReference {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FeatureReference> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.FeatureReference;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.FeatureReference_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SolitaryFeatureName name;

	public SolitaryFeatureName getName() {
		return notifyRequested(FramesFeatureDescriptorEnum.name, name);
	}

	public void setName(SolitaryFeatureName name) {
		notifyChanged(FramesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
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
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
