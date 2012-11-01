package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AssertionsAdapter extends AbstractListEntityAdapter<Assertion>
		implements Assertions {
	private static final long serialVersionUID = 1;

	public AssertionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssertionsAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Assertions> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Assertions;
	}
}
