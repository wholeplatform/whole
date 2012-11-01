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
public class IsUndefAdapter extends AbstractEntityAdapter implements IsUndef {
	private static final long serialVersionUID = 1;

	public IsUndefAdapter(IEntity implementor) {
		super(implementor);
	}

	public IsUndefAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IsUndef> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.IsUndef;
	}
}
