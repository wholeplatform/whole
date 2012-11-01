package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypeExpressionAdapter extends AbstractEntityAdapter implements
		TypeExpression {
	private static final long serialVersionUID = 1;

	public TypeExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeExpressionAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeExpression> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.TypeExpression;
	}
}
