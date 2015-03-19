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
public class ReusePointImpl extends AbstractSimpleEntity implements ReusePoint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ReusePoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.ReusePoint;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.ReusePoint_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private ResourceIdentifier frame;

	public ResourceIdentifier getFrame() {
		return notifyRequested(FramesFeatureDescriptorEnum.frame, frame);
	}

	public void setFrame(ResourceIdentifier frame) {
		notifyChanged(FramesFeatureDescriptorEnum.frame, this.frame,
				this.frame = frame);
	}

	private Features configuration;

	public Features getConfiguration() {
		return notifyRequested(FramesFeatureDescriptorEnum.configuration,
				configuration);
	}

	public void setConfiguration(Features configuration) {
		notifyChanged(FramesFeatureDescriptorEnum.configuration,
				this.configuration, this.configuration = configuration);
	}

	private Relations relations;

	public Relations getRelations() {
		return notifyRequested(FramesFeatureDescriptorEnum.relations, relations);
	}

	public void setRelations(Relations relations) {
		notifyChanged(FramesFeatureDescriptorEnum.relations, this.relations,
				this.relations = relations);
	}

	private Advices advices;

	public Advices getAdvices() {
		return notifyRequested(FramesFeatureDescriptorEnum.advices, advices);
	}

	public void setAdvices(Advices advices) {
		notifyChanged(FramesFeatureDescriptorEnum.advices, this.advices,
				this.advices = advices);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFrame().wGetAdaptee(false);
		case 1:
			return getConfiguration().wGetAdaptee(false);
		case 2:
			return getRelations().wGetAdaptee(false);
		case 3:
			return getAdvices().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFrame(value
					.wGetAdapter(FramesEntityDescriptorEnum.ResourceIdentifier));
			break;
		case 1:
			setConfiguration(value
					.wGetAdapter(FramesEntityDescriptorEnum.Features));
			break;
		case 2:
			setRelations(value
					.wGetAdapter(FramesEntityDescriptorEnum.Relations));
			break;
		case 3:
			setAdvices(value.wGetAdapter(FramesEntityDescriptorEnum.Advices));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
