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
public class AndAdapter extends AbstractListEntityAdapter<Expression> implements
		And {
	private static final long serialVersionUID = 1;

	public AndAdapter(IEntity implementor) {
		super(implementor);
	}

	public AndAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<And> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.And;
	}
}
