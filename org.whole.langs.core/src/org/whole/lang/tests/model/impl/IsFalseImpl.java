package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;

/** 
 * @generator Whole
 */
public class IsFalseImpl extends AbstractSimpleEntity implements IsFalse {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IsFalse> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsFalse;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.IsFalse_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
