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
public class IsAssignableToAdapter extends AbstractEntityAdapter implements
		IsAssignableTo {
	private static final long serialVersionUID = 1;

	public IsAssignableToAdapter(IEntity implementor) {
		super(implementor);
	}

	public IsAssignableToAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IsAssignableTo> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsAssignableTo;
	}

	public Name getDescriptorName() {
		return wGet(TestsFeatureDescriptorEnum.descriptorName).wGetAdapter(
				TestsEntityDescriptorEnum.Name);
	}

	public void setDescriptorName(Name descriptorName) {
		wSet(TestsFeatureDescriptorEnum.descriptorName, descriptorName);
	}
}
