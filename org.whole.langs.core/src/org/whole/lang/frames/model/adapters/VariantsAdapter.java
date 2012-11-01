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
public class VariantsAdapter extends AbstractListEntityAdapter<VariationPoint>
		implements Variants {
	private static final long serialVersionUID = 1;

	public VariantsAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariantsAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Variants> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Variants;
	}
}
