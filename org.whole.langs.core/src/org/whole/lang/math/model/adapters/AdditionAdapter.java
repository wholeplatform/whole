package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AdditionAdapter extends AbstractListEntityAdapter<Expression>
		implements Addition {
	private static final long serialVersionUID = 1;

	public AdditionAdapter(IEntity implementor) {
		super(implementor);
	}

	public AdditionAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Addition> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Addition;
	}
}
