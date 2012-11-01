package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArithmeticExpressionAdapter extends AbstractEntityAdapter
		implements ArithmeticExpression {
	private static final long serialVersionUID = 1;

	public ArithmeticExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArithmeticExpressionAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArithmeticExpression> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.ArithmeticExpression;
	}
}
