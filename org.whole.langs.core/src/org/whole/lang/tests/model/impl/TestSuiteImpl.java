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
public class TestSuiteImpl extends AbstractSimpleEntity implements TestSuite {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TestSuite> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.TestSuite;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.TestSuite_ord;
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
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

	private FilterFamilies filterFamilies;

	public FilterFamilies getFilterFamilies() {
		return notifyRequested(TestsFeatureDescriptorEnum.filterFamilies,
				filterFamilies);
	}

	public void setFilterFamilies(FilterFamilies filterFamilies) {
		notifyChanged(TestsFeatureDescriptorEnum.filterFamilies,
				this.filterFamilies, this.filterFamilies = filterFamilies);
	}

	private TestCases testCases;

	public TestCases getTestCases() {
		return notifyRequested(TestsFeatureDescriptorEnum.testCases, testCases);
	}

	public void setTestCases(TestCases testCases) {
		notifyChanged(TestsFeatureDescriptorEnum.testCases, this.testCases,
				this.testCases = testCases);
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
			return getFilterFamilies().wGetAdaptee(false);
		case 5:
			return getTestCases().wGetAdaptee(false);
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
			setFilterFamilies(value
					.wGetAdapter(TestsEntityDescriptorEnum.FilterFamilies));
			break;
		case 5:
			setTestCases(value.wGetAdapter(TestsEntityDescriptorEnum.TestCases));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
