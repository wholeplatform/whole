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
public class TestSuiteAdapter extends AbstractEntityAdapter implements
		TestSuite {
	private static final long serialVersionUID = 1;

	public TestSuiteAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestSuiteAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TestSuite> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.TestSuite;
	}

	public PackageName getPackageName() {
		return wGet(TestsFeatureDescriptorEnum.packageName).wGetAdapter(
				TestsEntityDescriptorEnum.PackageName);
	}

	public void setPackageName(PackageName packageName) {
		wSet(TestsFeatureDescriptorEnum.packageName, packageName);
	}

	public Description getDescription() {
		return wGet(TestsFeatureDescriptorEnum.description).wGetAdapter(
				TestsEntityDescriptorEnum.Description);
	}

	public void setDescription(Description description) {
		wSet(TestsFeatureDescriptorEnum.description, description);
	}

	public Name getName() {
		return wGet(TestsFeatureDescriptorEnum.name).wGetAdapter(
				TestsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(TestsFeatureDescriptorEnum.name, name);
	}

	public Statement getDeployer() {
		return wGet(TestsFeatureDescriptorEnum.deployer).wGetAdapter(
				TestsEntityDescriptorEnum.Statement);
	}

	public void setDeployer(Statement deployer) {
		wSet(TestsFeatureDescriptorEnum.deployer, deployer);
	}

	public FilterFamilies getFilterFamilies() {
		return wGet(TestsFeatureDescriptorEnum.filterFamilies).wGetAdapter(
				TestsEntityDescriptorEnum.FilterFamilies);
	}

	public void setFilterFamilies(FilterFamilies filterFamilies) {
		wSet(TestsFeatureDescriptorEnum.filterFamilies, filterFamilies);
	}

	public TestCases getTestCases() {
		return wGet(TestsFeatureDescriptorEnum.testCases).wGetAdapter(
				TestsEntityDescriptorEnum.TestCases);
	}

	public void setTestCases(TestCases testCases) {
		wSet(TestsFeatureDescriptorEnum.testCases, testCases);
	}
}
