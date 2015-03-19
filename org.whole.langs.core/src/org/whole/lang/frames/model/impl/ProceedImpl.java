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
public class ProceedImpl extends AbstractSimpleEntity implements Proceed {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Proceed> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Proceed;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Proceed_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Feature joinpoints;

	public Feature getJoinpoints() {
		return notifyRequested(FramesFeatureDescriptorEnum.joinpoints,
				joinpoints);
	}

	public void setJoinpoints(Feature joinpoints) {
		notifyChanged(FramesFeatureDescriptorEnum.joinpoints, this.joinpoints,
				this.joinpoints = joinpoints);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getJoinpoints().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setJoinpoints(value.wGetAdapter(FramesEntityDescriptorEnum.Feature));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
