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
public class TestCaseImpl extends AbstractSimpleEntity implements TestCase {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TestCase> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.TestCase;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.TestCase_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getPackageName().wHashCode() + 29 * getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getPackageName().wEquals(
					entity.wGet(TestsFeatureDescriptorEnum.packageName))
					&& getName().wEquals(
							entity.wGet(TestsFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("packageName=");
		buffer.append(packageName);
		buffer.append("name=");
		buffer.append(name);
	}

	private PackageName packageName;

	public PackageName getPackageName() {
		return notifyRequested(TestsFeatureDescriptorEnum.packageName,
				packageName);
	}

	public void setPackageName(PackageName packageName) {
		notifyChanged(TestsFeatureDescriptorEnum.packageName, this.packageName,
				this.packageName = packageName);
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

	private Name name;

	public Name getName() {
		return notifyRequested(TestsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(TestsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Statement deployer;

	public Statement getDeployer() {
		return notifyRequested(TestsFeatureDescriptorEnum.deployer, deployer);
	}

	public void setDeployer(Statement deployer) {
		notifyChanged(TestsFeatureDescriptorEnum.deployer, this.deployer,
				this.deployer = deployer);
	}

	private Aspects aspects;

	public Aspects getAspects() {
		return notifyRequested(TestsFeatureDescriptorEnum.aspects, aspects);
	}

	public void setAspects(Aspects aspects) {
		notifyChanged(TestsFeatureDescriptorEnum.aspects, this.aspects,
				this.aspects = aspects);
	}

	private Tests tests;

	public Tests getTests() {
		return notifyRequested(TestsFeatureDescriptorEnum.tests, tests);
	}

	public void setTests(Tests tests) {
		notifyChanged(TestsFeatureDescriptorEnum.tests, this.tests,
				this.tests = tests);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPackageName().wGetAdaptee(false);
		case 1:
			return getDescription().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		case 3:
			return getDeployer().wGetAdaptee(false);
		case 4:
			return getAspects().wGetAdaptee(false);
		case 5:
			return getTests().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPackageName(value
					.wGetAdapter(TestsEntityDescriptorEnum.PackageName));
			break;
		case 1:
			setDescription(value
					.wGetAdapter(TestsEntityDescriptorEnum.Description));
			break;
		case 2:
			setName(value.wGetAdapter(TestsEntityDescriptorEnum.Name));
			break;
		case 3:
			setDeployer(value.wGetAdapter(TestsEntityDescriptorEnum.Statement));
			break;
		case 4:
			setAspects(value.wGetAdapter(TestsEntityDescriptorEnum.Aspects));
			break;
		case 5:
			setTests(value.wGetAdapter(TestsEntityDescriptorEnum.Tests));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
