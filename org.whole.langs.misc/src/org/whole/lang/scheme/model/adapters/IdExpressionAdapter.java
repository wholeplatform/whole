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
public class IdExpressionAdapter extends AbstractEntityAdapter implements
		IdExpression {
	private static final long serialVersionUID = 1;

	public IdExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public IdExpressionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IdExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.IdExpression;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
