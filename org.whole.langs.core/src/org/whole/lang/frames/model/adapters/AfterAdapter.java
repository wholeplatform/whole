package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class AfterAdapter extends AbstractEntityAdapter implements After {
	private static final long serialVersionUID = 1;

	public AfterAdapter(IEntity implementor) {
		super(implementor);
	}

	public AfterAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<After> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.After;
	}

	public JoinpointExpression getJoinpoints() {
		return wGet(FramesFeatureDescriptorEnum.joinpoints).wGetAdapter(
				FramesEntityDescriptorEnum.JoinpointExpression);
	}

	public void setJoinpoints(JoinpointExpression joinpoints) {
		wSet(FramesFeatureDescriptorEnum.joinpoints, joinpoints);
	}

	public Content getContent() {
		return wGet(FramesFeatureDescriptorEnum.content).wGetAdapter(
				FramesEntityDescriptorEnum.Content);
	}

	public void setContent(Content content) {
		wSet(FramesFeatureDescriptorEnum.content, content);
	}
}
