package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class SolitaryFeatureNameAdapter extends AbstractEntityAdapter implements
		SolitaryFeatureName {
	private static final long serialVersionUID = 1;

	public SolitaryFeatureNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public SolitaryFeatureNameAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SolitaryFeatureName> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.SolitaryFeatureName;
	}
}
