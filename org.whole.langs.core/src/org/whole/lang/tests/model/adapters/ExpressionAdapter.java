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
public class ExpressionAdapter extends AbstractEntityAdapter implements
		Expression {
	private static final long serialVersionUID = 1;

	public ExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExpressionAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Expression> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Expression;
	}
}
