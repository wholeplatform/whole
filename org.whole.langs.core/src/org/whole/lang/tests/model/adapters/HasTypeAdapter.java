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
public class HasTypeAdapter extends AbstractEntityAdapter implements HasType {
	private static final long serialVersionUID = 1;

	public HasTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public HasTypeAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<HasType> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.HasType;
	}

	public Name getDescriptorName() {
		return wGet(TestsFeatureDescriptorEnum.descriptorName).wGetAdapter(
				TestsEntityDescriptorEnum.Name);
	}

	public void setDescriptorName(Name descriptorName) {
		wSet(TestsFeatureDescriptorEnum.descriptorName, descriptorName);
	}
}
