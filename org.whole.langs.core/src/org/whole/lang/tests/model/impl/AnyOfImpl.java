package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class AnyOfImpl extends AbstractListCompositeEntity<Constraint>
		implements AnyOf {
	private static final long serialVersionUID = 1;

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.AnyOf_ord;
	}

	public EntityDescriptor<AnyOf> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.AnyOf;
	}
}
