package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class NotImpl extends AbstractSimpleEntity implements Not {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Not> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Not;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.Not_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Constraint constraint;

	public Constraint getConstraint() {
		return notifyRequested(TestsFeatureDescriptorEnum.constraint,
				constraint);
	}

	public void setConstraint(Constraint constraint) {
		notifyChanged(TestsFeatureDescriptorEnum.constraint, this.constraint,
				this.constraint = constraint);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getConstraint().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setConstraint(value
					.wGetAdapter(TestsEntityDescriptorEnum.Constraint));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
