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
public class SubsetGroupAdapter extends AbstractEntityAdapter implements
		SubsetGroup {
	private static final long serialVersionUID = 1;

	public SubsetGroupAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubsetGroupAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SubsetGroup> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.SubsetGroup;
	}

	public Cardinality getCardinality() {
		return wGet(FramesFeatureDescriptorEnum.cardinality).wGetAdapter(
				FramesEntityDescriptorEnum.Cardinality);
	}

	public void setCardinality(Cardinality cardinality) {
		wSet(FramesFeatureDescriptorEnum.cardinality, cardinality);
	}

	public VariableFeatures getFeatures() {
		return wGet(FramesFeatureDescriptorEnum.features).wGetAdapter(
				FramesEntityDescriptorEnum.VariableFeatures);
	}

	public void setFeatures(VariableFeatures features) {
		wSet(FramesFeatureDescriptorEnum.features, features);
	}
}
