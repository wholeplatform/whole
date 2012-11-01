package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VariableFeaturesAdapter extends
		AbstractListEntityAdapter<VariableFeature> implements VariableFeatures {
	private static final long serialVersionUID = 1;

	public VariableFeaturesAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableFeaturesAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableFeatures> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.VariableFeatures;
	}
}
