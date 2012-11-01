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
public class OrAdapter extends AbstractListEntityAdapter<Expression> implements
		Or {
	private static final long serialVersionUID = 1;

	public OrAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Or> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Or;
	}
}
