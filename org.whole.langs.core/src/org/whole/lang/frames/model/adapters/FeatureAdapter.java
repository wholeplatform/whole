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
public class FeatureAdapter extends AbstractEntityAdapter implements Feature {
	private static final long serialVersionUID = 1;

	public FeatureAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Feature> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Feature;
	}

	public SolitaryFeatureName getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.SolitaryFeatureName);
	}

	public void setName(SolitaryFeatureName name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}

	public Annotations getAnnotations() {
		return wGet(FramesFeatureDescriptorEnum.annotations).wGetAdapter(
				FramesEntityDescriptorEnum.Annotations);
	}

	public void setAnnotations(Annotations annotations) {
		wSet(FramesFeatureDescriptorEnum.annotations, annotations);
	}

	public Subfeatures getFeatures() {
		return wGet(FramesFeatureDescriptorEnum.features).wGetAdapter(
				FramesEntityDescriptorEnum.Subfeatures);
	}

	public void setFeatures(Subfeatures features) {
		wSet(FramesFeatureDescriptorEnum.features, features);
	}
}
