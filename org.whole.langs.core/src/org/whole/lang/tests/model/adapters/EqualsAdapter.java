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
public class EqualsAdapter extends AbstractEntityAdapter implements Equals {
	private static final long serialVersionUID = 1;

	public EqualsAdapter(IEntity implementor) {
		super(implementor);
	}

	public EqualsAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Equals> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Equals;
	}

	public Expression getObject() {
		return wGet(TestsFeatureDescriptorEnum.object).wGetAdapter(
				TestsEntityDescriptorEnum.Expression);
	}

	public void setObject(Expression object) {
		wSet(TestsFeatureDescriptorEnum.object, object);
	}
}
