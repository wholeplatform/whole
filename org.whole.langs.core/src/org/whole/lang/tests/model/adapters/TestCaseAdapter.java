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
public class TestCaseAdapter extends AbstractEntityAdapter implements TestCase {
	private static final long serialVersionUID = 1;

	public TestCaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestCaseAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TestCase> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.TestCase;
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

	public Aspects getAspects() {
		return wGet(TestsFeatureDescriptorEnum.aspects).wGetAdapter(
				TestsEntityDescriptorEnum.Aspects);
	}

	public void setAspects(Aspects aspects) {
		wSet(TestsFeatureDescriptorEnum.aspects, aspects);
	}

	public Tests getTests() {
		return wGet(TestsFeatureDescriptorEnum.tests).wGetAdapter(
				TestsEntityDescriptorEnum.Tests);
	}

	public void setTests(Tests tests) {
		wSet(TestsFeatureDescriptorEnum.tests, tests);
	}
}
