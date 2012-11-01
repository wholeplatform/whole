package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AssertionAdapter extends AbstractEntityAdapter implements
		Assertion {
	private static final long serialVersionUID = 1;

	public AssertionAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssertionAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Assertion> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Assertion;
	}
}
