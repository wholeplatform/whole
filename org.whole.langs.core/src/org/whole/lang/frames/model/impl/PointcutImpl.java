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
public class PointcutImpl extends AbstractSimpleEntity implements Pointcut {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Pointcut> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Pointcut;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Pointcut_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Feature feature;

	public Feature getFeature() {
		return notifyRequested(FramesFeatureDescriptorEnum.feature, feature);
	}

	public void setFeature(Feature feature) {
		notifyChanged(FramesFeatureDescriptorEnum.feature, this.feature,
				this.feature = feature);
	}

	private JoinpointExpression joinpoints;

	public JoinpointExpression getJoinpoints() {
		return notifyRequested(FramesFeatureDescriptorEnum.joinpoints,
				joinpoints);
	}

	public void setJoinpoints(JoinpointExpression joinpoints) {
		notifyChanged(FramesFeatureDescriptorEnum.joinpoints, this.joinpoints,
				this.joinpoints = joinpoints);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFeature().wGetAdaptee(false);
		case 1:
			return getJoinpoints().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFeature(value.wGetAdapter(FramesEntityDescriptorEnum.Feature));
			break;
		case 1:
			setJoinpoints(value
					.wGetAdapter(FramesEntityDescriptorEnum.JoinpointExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
