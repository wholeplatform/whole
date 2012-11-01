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
public class RelationalExpressionAdapter extends AbstractEntityAdapter
		implements RelationalExpression {
	private static final long serialVersionUID = 1;

	public RelationalExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public RelationalExpressionAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RelationalExpression> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.RelationalExpression;
	}
}
