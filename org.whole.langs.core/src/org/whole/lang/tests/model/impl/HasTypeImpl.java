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
public class HasTypeImpl extends AbstractSimpleEntity implements HasType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<HasType> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.HasType;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.HasType_ord;
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	private Name descriptorName;

	public Name getDescriptorName() {
		return notifyRequested(TestsFeatureDescriptorEnum.descriptorName,
				descriptorName);
	}

	public void setDescriptorName(Name descriptorName) {
		notifyChanged(TestsFeatureDescriptorEnum.descriptorName,
				this.descriptorName, this.descriptorName = descriptorName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDescriptorName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDescriptorName(value.wGetAdapter(TestsEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
