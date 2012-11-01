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
public class ObjectConstraintAdapter extends AbstractEntityAdapter implements
		ObjectConstraint {
	private static final long serialVersionUID = 1;

	public ObjectConstraintAdapter(IEntity implementor) {
		super(implementor);
	}

	public ObjectConstraintAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ObjectConstraint> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.ObjectConstraint;
	}

	public Expression getObject() {
		return wGet(TestsFeatureDescriptorEnum.object).wGetAdapter(
				TestsEntityDescriptorEnum.Expression);
	}

	public void setObject(Expression object) {
		wSet(TestsFeatureDescriptorEnum.object, object);
	}
}
