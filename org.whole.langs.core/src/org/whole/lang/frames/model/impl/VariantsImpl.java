package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VariantsImpl extends AbstractListCompositeEntity<VariationPoint>
		implements Variants {
	private static final long serialVersionUID = 1;

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Variants_ord;
	}

	public EntityDescriptor<Variants> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Variants;
	}
}
