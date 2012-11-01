package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ConstExpressionAdapter extends AbstractEntityAdapter implements
		ConstExpression {
	private static final long serialVersionUID = 1;

	public ConstExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConstExpressionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConstExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.ConstExpression;
	}
}
