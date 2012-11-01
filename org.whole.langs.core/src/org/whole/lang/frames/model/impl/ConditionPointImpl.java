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
public class ConditionPointImpl extends AbstractSimpleEntity implements
		ConditionPoint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ConditionPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.ConditionPoint;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.ConditionPoint_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private FeatureName enabler;

	public FeatureName getEnabler() {
		return notifyRequested(FramesFeatureDescriptorEnum.enabler, enabler);
	}

	public void setEnabler(FeatureName enabler) {
		notifyChanged(FramesFeatureDescriptorEnum.enabler, this.enabler,
				this.enabler = enabler);
	}

	private Content content;

	public Content getContent() {
		return notifyRequested(FramesFeatureDescriptorEnum.content, content);
	}

	public void setContent(Content content) {
		notifyChanged(FramesFeatureDescriptorEnum.content, this.content,
				this.content = content);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getEnabler().wGetAdaptee(false);
		case 1:
			return getContent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setEnabler(value
					.wGetAdapter(FramesEntityDescriptorEnum.FeatureName));
			break;
		case 1:
			setContent(value.wGetAdapter(FramesEntityDescriptorEnum.Content));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
