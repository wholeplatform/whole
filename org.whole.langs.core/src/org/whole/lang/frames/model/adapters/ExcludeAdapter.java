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
public class ExcludeAdapter extends AbstractEntityAdapter implements Exclude {
	private static final long serialVersionUID = 1;

	public ExcludeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExcludeAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Exclude> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Exclude;
	}

	public FeatureName getFeature() {
		return wGet(FramesFeatureDescriptorEnum.feature).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setFeature(FeatureName feature) {
		wSet(FramesFeatureDescriptorEnum.feature, feature);
	}

	public FeatureNames getExcludedFeatures() {
		return wGet(FramesFeatureDescriptorEnum.excludedFeatures).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureNames);
	}

	public void setExcludedFeatures(FeatureNames excludedFeatures) {
		wSet(FramesFeatureDescriptorEnum.excludedFeatures, excludedFeatures);
	}
}
