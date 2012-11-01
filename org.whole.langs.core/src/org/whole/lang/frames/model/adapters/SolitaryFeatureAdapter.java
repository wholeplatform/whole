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
public class SolitaryFeatureAdapter extends AbstractEntityAdapter implements
		SolitaryFeature {
	private static final long serialVersionUID = 1;

	public SolitaryFeatureAdapter(IEntity implementor) {
		super(implementor);
	}

	public SolitaryFeatureAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SolitaryFeature> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.SolitaryFeature;
	}

	public SolitaryFeatureName getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.SolitaryFeatureName);
	}

	public void setName(SolitaryFeatureName name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}
}
