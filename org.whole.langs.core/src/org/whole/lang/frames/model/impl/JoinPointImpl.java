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
public class JoinPointImpl extends AbstractSimpleEntity implements JoinPoint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<JoinPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.JoinPoint;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.JoinPoint_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private FeatureName name;

	public FeatureName getName() {
		return notifyRequested(FramesFeatureDescriptorEnum.name, name);
	}

	public void setName(FeatureName name) {
		notifyChanged(FramesFeatureDescriptorEnum.name, this.name,
				this.name = name);
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
			return getName().wGetAdaptee(false);
		case 1:
			return getContent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(FramesEntityDescriptorEnum.FeatureName));
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
