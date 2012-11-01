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
public class TestsAdapter extends AbstractListEntityAdapter<Test> implements
		Tests {
	private static final long serialVersionUID = 1;

	public TestsAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestsAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Tests> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Tests;
	}
}
