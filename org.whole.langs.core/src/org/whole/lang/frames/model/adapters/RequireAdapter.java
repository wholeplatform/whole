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
public class RequireAdapter extends AbstractEntityAdapter implements Require {
	private static final long serialVersionUID = 1;

	public RequireAdapter(IEntity implementor) {
		super(implementor);
	}

	public RequireAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Require> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Require;
	}

	public FeatureName getFeature() {
		return wGet(FramesFeatureDescriptorEnum.feature).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setFeature(FeatureName feature) {
		wSet(FramesFeatureDescriptorEnum.feature, feature);
	}

	public FeatureNames getRequiredFeatures() {
		return wGet(FramesFeatureDescriptorEnum.requiredFeatures).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureNames);
	}

	public void setRequiredFeatures(FeatureNames requiredFeatures) {
		wSet(FramesFeatureDescriptorEnum.requiredFeatures, requiredFeatures);
	}
}
