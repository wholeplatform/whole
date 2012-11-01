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
public class AfterTestImpl extends AbstractSimpleEntity implements AfterTest {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AfterTest> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.AfterTest;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.AfterTest_ord;
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	private Description description;

	public Description getDescription() {
		return notifyRequested(TestsFeatureDescriptorEnum.description,
				description);
	}

	public void setDescription(Description description) {
		notifyChanged(TestsFeatureDescriptorEnum.description, this.description,
				this.description = description);
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(TestsFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(TestsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(TestsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Statement body;

	public Statement getBody() {
		return notifyRequested(TestsFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statement body) {
		notifyChanged(TestsFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDescription().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		case 2:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDescription(value
					.wGetAdapter(TestsEntityDescriptorEnum.Description));
			break;
		case 1:
			setName(value.wGetAdapter(TestsEntityDescriptorEnum.Name));
			break;
		case 2:
			setBody(value.wGetAdapter(TestsEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
