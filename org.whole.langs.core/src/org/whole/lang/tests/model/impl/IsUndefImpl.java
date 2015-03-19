package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;

/** 
 * @generator Whole
 */
public class IsUndefImpl extends AbstractSimpleEntity implements IsUndef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IsUndef> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsUndef;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.IsUndef_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
