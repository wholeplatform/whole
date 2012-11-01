package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TestStatementsImpl extends
		AbstractListCompositeEntity<TestStatement> implements TestStatements {
	private static final long serialVersionUID = 1;

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.TestStatements_ord;
	}

	public EntityDescriptor<TestStatements> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.TestStatements;
	}
}
