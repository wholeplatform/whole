package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;

/** 
 * @generator Whole
 */
public class IsDefImpl extends AbstractSimpleEntity implements IsDef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IsDef> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsDef;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.IsDef_ord;
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}
}
