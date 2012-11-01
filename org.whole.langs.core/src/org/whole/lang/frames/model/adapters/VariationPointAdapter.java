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
public class VariationPointAdapter extends AbstractEntityAdapter implements
		VariationPoint {
	private static final long serialVersionUID = 1;

	public VariationPointAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariationPointAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariationPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.VariationPoint;
	}
}
