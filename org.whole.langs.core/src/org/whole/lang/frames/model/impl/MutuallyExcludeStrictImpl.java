package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MutuallyExcludeStrictImpl extends
		AbstractBagCompositeEntity<FeatureName> implements MutuallyExclude {
	private static final long serialVersionUID = 1;

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.MutuallyExclude_ord;
	}

	public EntityDescriptor<MutuallyExclude> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.MutuallyExclude;
	}
}
