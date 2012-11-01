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
public class ThrowsAdapter extends AbstractEntityAdapter implements Throws {
	private static final long serialVersionUID = 1;

	public ThrowsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ThrowsAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Throws> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Throws;
	}

	public ThrowableType getThrowableType() {
		return wGet(TestsFeatureDescriptorEnum.throwableType).wGetAdapter(
				TestsEntityDescriptorEnum.ThrowableType);
	}

	public void setThrowableType(ThrowableType throwableType) {
		wSet(TestsFeatureDescriptorEnum.throwableType, throwableType);
	}
}
