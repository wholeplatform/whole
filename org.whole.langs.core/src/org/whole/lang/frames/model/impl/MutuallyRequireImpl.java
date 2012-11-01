package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MutuallyRequireImpl extends
		AbstractCollectionCompositeEntity<FeatureName> implements
		MutuallyRequire {
	private static final long serialVersionUID = 1;

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.MutuallyRequire_ord;
	}

	public EntityDescriptor<MutuallyRequire> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.MutuallyRequire;
	}
}
