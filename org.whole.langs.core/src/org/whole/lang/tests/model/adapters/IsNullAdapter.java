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
public class IsNullAdapter extends AbstractEntityAdapter implements IsNull {
	private static final long serialVersionUID = 1;

	public IsNullAdapter(IEntity implementor) {
		super(implementor);
	}

	public IsNullAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IsNull> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsNull;
	}
}
