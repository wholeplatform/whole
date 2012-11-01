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
public class BeforeTestCaseAdapter extends AbstractEntityAdapter implements
		BeforeTestCase {
	private static final long serialVersionUID = 1;

	public BeforeTestCaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public BeforeTestCaseAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BeforeTestCase> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.BeforeTestCase;
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

	public Statement getBody() {
		return wGet(TestsFeatureDescriptorEnum.body).wGetAdapter(
				TestsEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(TestsFeatureDescriptorEnum.body, body);
	}
}
