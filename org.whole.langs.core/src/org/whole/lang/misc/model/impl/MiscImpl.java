package org.whole.lang.misc.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.misc.model.*;
import org.whole.lang.misc.visitors.IMiscVisitor;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MiscImpl extends AbstractListCompositeEntity<Any> implements Misc {
	private static final long serialVersionUID = 1;

	public void accept(IMiscVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return MiscEntityDescriptorEnum.Misc_ord;
	}

	public EntityDescriptor<Misc> wGetEntityDescriptor() {
		return MiscEntityDescriptorEnum.Misc;
	}
}
