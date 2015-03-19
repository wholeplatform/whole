package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;

/** 
 * @generator Whole
 */
public class IsTrueImpl extends AbstractSimpleEntity implements IsTrue {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IsTrue> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsTrue;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.IsTrue_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
