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
public class IterationPointImpl extends AbstractSimpleEntity implements
		IterationPoint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IterationPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.IterationPoint;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.IterationPoint_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private FeatureName iterator;

	public FeatureName getIterator() {
		return notifyRequested(FramesFeatureDescriptorEnum.iterator, iterator);
	}

	public void setIterator(FeatureName iterator) {
		notifyChanged(FramesFeatureDescriptorEnum.iterator, this.iterator,
				this.iterator = iterator);
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
			return getIterator().wGetAdaptee(false);
		case 1:
			return getContent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIterator(value
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
