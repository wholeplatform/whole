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
public class CollectionExpressionAdapter extends AbstractEntityAdapter
		implements CollectionExpression {
	private static final long serialVersionUID = 1;

	public CollectionExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public CollectionExpressionAdapter() {
	}

	public void accept(IMathVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CollectionExpression> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.CollectionExpression;
	}
}
