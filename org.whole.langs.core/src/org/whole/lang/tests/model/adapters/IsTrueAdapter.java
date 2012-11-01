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
public class IsTrueAdapter extends AbstractEntityAdapter implements IsTrue {
	private static final long serialVersionUID = 1;

	public IsTrueAdapter(IEntity implementor) {
		super(implementor);
	}

	public IsTrueAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IsTrue> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsTrue;
	}
}
