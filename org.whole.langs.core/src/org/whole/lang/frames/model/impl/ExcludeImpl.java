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
public class ExcludeImpl extends AbstractSimpleEntity implements Exclude {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Exclude> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Exclude;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Exclude_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private FeatureName feature;

	public FeatureName getFeature() {
		return notifyRequested(FramesFeatureDescriptorEnum.feature, feature);
	}

	public void setFeature(FeatureName feature) {
		notifyChanged(FramesFeatureDescriptorEnum.feature, this.feature,
				this.feature = feature);
	}

	private FeatureNames excludedFeatures;

	public FeatureNames getExcludedFeatures() {
		return notifyRequested(FramesFeatureDescriptorEnum.excludedFeatures,
				excludedFeatures);
	}

	public void setExcludedFeatures(FeatureNames excludedFeatures) {
		notifyChanged(FramesFeatureDescriptorEnum.excludedFeatures,
				this.excludedFeatures, this.excludedFeatures = excludedFeatures);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFeature().wGetAdaptee(false);
		case 1:
			return getExcludedFeatures().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFeature(value
					.wGetAdapter(FramesEntityDescriptorEnum.FeatureName));
			break;
		case 1:
			setExcludedFeatures(value
					.wGetAdapter(FramesEntityDescriptorEnum.FeatureNames));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
