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
public class AssertThatAdapter extends AbstractEntityAdapter implements
		AssertThat {
	private static final long serialVersionUID = 1;

	public AssertThatAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssertThatAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AssertThat> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.AssertThat;
	}

	public Expression getSubject() {
		return wGet(TestsFeatureDescriptorEnum.subject).wGetAdapter(
				TestsEntityDescriptorEnum.Expression);
	}

	public void setSubject(Expression subject) {
		wSet(TestsFeatureDescriptorEnum.subject, subject);
	}

	public Constraint getConstraint() {
		return wGet(TestsFeatureDescriptorEnum.constraint).wGetAdapter(
				TestsEntityDescriptorEnum.Constraint);
	}

	public void setConstraint(Constraint constraint) {
		wSet(TestsFeatureDescriptorEnum.constraint, constraint);
	}
}
