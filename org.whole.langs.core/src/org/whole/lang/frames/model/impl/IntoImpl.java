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
public class IntoImpl extends AbstractSimpleEntity implements Into {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Into> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Into;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Into_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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
			return getJoinpoints().wGetAdaptee(false);
		case 1:
			return getContent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setJoinpoints(value
					.wGetAdapter(FramesEntityDescriptorEnum.JoinpointExpression));
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
