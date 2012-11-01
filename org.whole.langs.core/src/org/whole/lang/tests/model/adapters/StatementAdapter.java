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
public class StatementAdapter extends AbstractEntityAdapter implements
		Statement {
	private static final long serialVersionUID = 1;

	public StatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public StatementAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Statement> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Statement;
	}
}
