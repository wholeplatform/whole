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
public class JoinPointAdapter extends AbstractEntityAdapter implements
		JoinPoint {
	private static final long serialVersionUID = 1;

	public JoinPointAdapter(IEntity implementor) {
		super(implementor);
	}

	public JoinPointAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<JoinPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.JoinPoint;
	}

	public FeatureName getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setName(FeatureName name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}

	public Content getContent() {
		return wGet(FramesFeatureDescriptorEnum.content).wGetAdapter(
				FramesEntityDescriptorEnum.Content);
	}

	public void setContent(Content content) {
		wSet(FramesFeatureDescriptorEnum.content, content);
	}
}
