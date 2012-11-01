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
public class FeatureReferenceAdapter extends AbstractEntityAdapter implements
		FeatureReference {
	private static final long serialVersionUID = 1;

	public FeatureReferenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureReferenceAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeatureReference> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.FeatureReference;
	}

	public SolitaryFeatureName getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.SolitaryFeatureName);
	}

	public void setName(SolitaryFeatureName name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}
}
