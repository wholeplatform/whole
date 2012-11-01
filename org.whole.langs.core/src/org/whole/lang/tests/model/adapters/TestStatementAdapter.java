package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestStatementAdapter extends AbstractEntityAdapter implements
		TestStatement {
	private static final long serialVersionUID = 1;

	public TestStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestStatementAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TestStatement> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.TestStatement;
	}
}
