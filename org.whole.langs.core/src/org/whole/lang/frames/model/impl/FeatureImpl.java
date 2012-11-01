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
public class FeatureImpl extends AbstractSimpleEntity implements Feature {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Feature> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Feature;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Feature_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private SolitaryFeatureName name;

	public SolitaryFeatureName getName() {
		return notifyRequested(FramesFeatureDescriptorEnum.name, name);
	}

	public void setName(SolitaryFeatureName name) {
		notifyChanged(FramesFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Annotations annotations;

	public Annotations getAnnotations() {
		return notifyRequested(FramesFeatureDescriptorEnum.annotations,
				annotations);
	}

	public void setAnnotations(Annotations annotations) {
		notifyChanged(FramesFeatureDescriptorEnum.annotations,
				this.annotations, this.annotations = annotations);
	}

	private Subfeatures features;

	public Subfeatures getFeatures() {
		return notifyRequested(FramesFeatureDescriptorEnum.features, features);
	}

	public void setFeatures(Subfeatures features) {
		notifyChanged(FramesFeatureDescriptorEnum.features, this.features,
				this.features = features);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getAnnotations().wGetAdaptee(false);
		case 2:
			return getFeatures().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value
					.wGetAdapter(FramesEntityDescriptorEnum.SolitaryFeatureName));
			break;
		case 1:
			setAnnotations(value
					.wGetAdapter(FramesEntityDescriptorEnum.Annotations));
			break;
		case 2:
			setFeatures(value
					.wGetAdapter(FramesEntityDescriptorEnum.Subfeatures));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
