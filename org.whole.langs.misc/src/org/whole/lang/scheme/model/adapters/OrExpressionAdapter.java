package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class OrExpressionAdapter extends AbstractEntityAdapter implements
		OrExpression {
	private static final long serialVersionUID = 1;

	public OrExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public OrExpressionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OrExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.OrExpression;
	}

	public SchemeExpressions getExpressions() {
		return wGet(SchemeFeatureDescriptorEnum.expressions).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpressions);
	}

	public void setExpressions(SchemeExpressions expressions) {
		wSet(SchemeFeatureDescriptorEnum.expressions, expressions);
	}
}
