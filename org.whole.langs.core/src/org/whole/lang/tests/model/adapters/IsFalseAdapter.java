package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IsFalseAdapter extends AbstractEntityAdapter implements IsFalse {
	private static final long serialVersionUID = 1;

	public IsFalseAdapter(IEntity implementor) {
		super(implementor);
	}

	public IsFalseAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IsFalse> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsFalse;
	}
}
