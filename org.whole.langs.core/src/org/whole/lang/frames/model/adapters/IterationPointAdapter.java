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
public class IterationPointAdapter extends AbstractEntityAdapter implements
		IterationPoint {
	private static final long serialVersionUID = 1;

	public IterationPointAdapter(IEntity implementor) {
		super(implementor);
	}

	public IterationPointAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IterationPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.IterationPoint;
	}

	public FeatureName getIterator() {
		return wGet(FramesFeatureDescriptorEnum.iterator).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setIterator(FeatureName iterator) {
		wSet(FramesFeatureDescriptorEnum.iterator, iterator);
	}

	public Content getContent() {
		return wGet(FramesFeatureDescriptorEnum.content).wGetAdapter(
				FramesEntityDescriptorEnum.Content);
	}

	public void setContent(Content content) {
		wSet(FramesFeatureDescriptorEnum.content, content);
	}
}
