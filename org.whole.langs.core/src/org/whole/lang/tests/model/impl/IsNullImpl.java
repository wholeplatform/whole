package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;

/** 
 * @generator Whole
 */
public class IsNullImpl extends AbstractSimpleEntity implements IsNull {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IsNull> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsNull;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.IsNull_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
