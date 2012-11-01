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
public class ThrowsImpl extends AbstractSimpleEntity implements Throws {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Throws> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Throws;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.Throws_ord;
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	private ThrowableType throwableType;

	public ThrowableType getThrowableType() {
		return notifyRequested(TestsFeatureDescriptorEnum.throwableType,
				throwableType);
	}

	public void setThrowableType(ThrowableType throwableType) {
		notifyChanged(TestsFeatureDescriptorEnum.throwableType,
				this.throwableType, this.throwableType = throwableType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getThrowableType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setThrowableType(value
					.wGetAdapter(TestsEntityDescriptorEnum.ThrowableType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
