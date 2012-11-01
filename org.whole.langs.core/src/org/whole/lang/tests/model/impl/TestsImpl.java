package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TestsImpl extends AbstractCollectionCompositeEntity<Test>
		implements Tests {
	private static final long serialVersionUID = 1;

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.Tests_ord;
	}

	public EntityDescriptor<Tests> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Tests;
	}
}
