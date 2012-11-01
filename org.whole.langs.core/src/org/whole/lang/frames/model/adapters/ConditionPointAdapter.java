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
public class ConditionPointAdapter extends AbstractEntityAdapter implements
		ConditionPoint {
	private static final long serialVersionUID = 1;

	public ConditionPointAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConditionPointAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConditionPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.ConditionPoint;
	}

	public FeatureName getEnabler() {
		return wGet(FramesFeatureDescriptorEnum.enabler).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setEnabler(FeatureName enabler) {
		wSet(FramesFeatureDescriptorEnum.enabler, enabler);
	}

	public Content getContent() {
		return wGet(FramesFeatureDescriptorEnum.content).wGetAdapter(
				FramesEntityDescriptorEnum.Content);
	}

	public void setContent(Content content) {
		wSet(FramesFeatureDescriptorEnum.content, content);
	}
}
