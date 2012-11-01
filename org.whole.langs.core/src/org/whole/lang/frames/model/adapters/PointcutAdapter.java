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
public class PointcutAdapter extends AbstractEntityAdapter implements Pointcut {
	private static final long serialVersionUID = 1;

	public PointcutAdapter(IEntity implementor) {
		super(implementor);
	}

	public PointcutAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Pointcut> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Pointcut;
	}

	public Feature getFeature() {
		return wGet(FramesFeatureDescriptorEnum.feature).wGetAdapter(
				FramesEntityDescriptorEnum.Feature);
	}

	public void setFeature(Feature feature) {
		wSet(FramesFeatureDescriptorEnum.feature, feature);
	}

	public JoinpointExpression getJoinpoints() {
		return wGet(FramesFeatureDescriptorEnum.joinpoints).wGetAdapter(
				FramesEntityDescriptorEnum.JoinpointExpression);
	}

	public void setJoinpoints(JoinpointExpression joinpoints) {
		wSet(FramesFeatureDescriptorEnum.joinpoints, joinpoints);
	}
}
