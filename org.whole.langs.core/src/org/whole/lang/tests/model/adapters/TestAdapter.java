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
public class TestAdapter extends AbstractEntityAdapter implements Test {
	private static final long serialVersionUID = 1;

	public TestAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Test> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Test;
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

	public TestStatements getBody() {
		return wGet(TestsFeatureDescriptorEnum.body).wGetAdapter(
				TestsEntityDescriptorEnum.TestStatements);
	}

	public void setBody(TestStatements body) {
		wSet(TestsFeatureDescriptorEnum.body, body);
	}
}
