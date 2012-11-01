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
public class VariableFeatureAdapter extends AbstractEntityAdapter implements
		VariableFeature {
	private static final long serialVersionUID = 1;

	public VariableFeatureAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableFeatureAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableFeature> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.VariableFeature;
	}

	public SolitaryFeature getFeature() {
		return wGet(FramesFeatureDescriptorEnum.feature).wGetAdapter(
				FramesEntityDescriptorEnum.SolitaryFeature);
	}

	public void setFeature(SolitaryFeature feature) {
		wSet(FramesFeatureDescriptorEnum.feature, feature);
	}

	public VariableValue getValue() {
		return wGet(FramesFeatureDescriptorEnum.value).wGetAdapter(
				FramesEntityDescriptorEnum.VariableValue);
	}

	public void setValue(VariableValue value) {
		wSet(FramesFeatureDescriptorEnum.value, value);
	}
}
