package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AllOfAdapter extends AbstractListEntityAdapter<Constraint>
		implements AllOf {
	private static final long serialVersionUID = 1;

	public AllOfAdapter(IEntity implementor) {
		super(implementor);
	}

	public AllOfAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AllOf> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.AllOf;
	}
}
