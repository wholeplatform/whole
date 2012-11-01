package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestCasesAdapter extends AbstractListEntityAdapter<TestCase>
		implements TestCases {
	private static final long serialVersionUID = 1;

	public TestCasesAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestCasesAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TestCases> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.TestCases;
	}
}
