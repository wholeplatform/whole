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
public class AroundAdapter extends AbstractEntityAdapter implements Around {
	private static final long serialVersionUID = 1;

	public AroundAdapter(IEntity implementor) {
		super(implementor);
	}

	public AroundAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Around> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Around;
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
