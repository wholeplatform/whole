package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.visitors.IFramesVisitor;

/** 
 * @generator Whole
 */
public class EmptyImpl extends AbstractSimpleEntity implements Empty {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Empty> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Empty;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Empty_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
