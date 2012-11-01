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
public class CloneGroupAdapter extends AbstractEntityAdapter implements
		CloneGroup {
	private static final long serialVersionUID = 1;

	public CloneGroupAdapter(IEntity implementor) {
		super(implementor);
	}

	public CloneGroupAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CloneGroup> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.CloneGroup;
	}

	public Cardinality getCardinality() {
		return wGet(FramesFeatureDescriptorEnum.cardinality).wGetAdapter(
				FramesEntityDescriptorEnum.Cardinality);
	}

	public void setCardinality(Cardinality cardinality) {
		wSet(FramesFeatureDescriptorEnum.cardinality, cardinality);
	}

	public SolitaryFeatures getFeatures() {
		return wGet(FramesFeatureDescriptorEnum.features).wGetAdapter(
				FramesEntityDescriptorEnum.SolitaryFeatures);
	}

	public void setFeatures(SolitaryFeatures features) {
		wSet(FramesFeatureDescriptorEnum.features, features);
	}
}
