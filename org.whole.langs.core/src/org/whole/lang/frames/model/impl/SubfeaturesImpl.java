package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SubfeaturesImpl extends AbstractListCompositeEntity<Subfeature>
		implements Subfeatures {
	private static final long serialVersionUID = 1;

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Subfeatures_ord;
	}

	public EntityDescriptor<Subfeatures> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Subfeatures;
	}
}
