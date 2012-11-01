package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class NotAdapter extends AbstractEntityAdapter implements Not {
	private static final long serialVersionUID = 1;

	public NotAdapter(IEntity implementor) {
		super(implementor);
	}

	public NotAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Not> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Not;
	}

	public Constraint getConstraint() {
		return wGet(TestsFeatureDescriptorEnum.constraint).wGetAdapter(
				TestsEntityDescriptorEnum.Constraint);
	}

	public void setConstraint(Constraint constraint) {
		wSet(TestsFeatureDescriptorEnum.constraint, constraint);
	}
}
