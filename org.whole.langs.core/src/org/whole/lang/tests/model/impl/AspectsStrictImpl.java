package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractUniqueListCompositeEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class AspectsStrictImpl extends
		AbstractUniqueListCompositeEntity<Aspect> implements Aspects {
	private static final long serialVersionUID = 1;

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.Aspects_ord;
	}

	public EntityDescriptor<Aspects> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Aspects;
	}
}
