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
public class ApplyExpressionAdapter extends AbstractEntityAdapter implements
		ApplyExpression {
	private static final long serialVersionUID = 1;

	public ApplyExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ApplyExpressionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ApplyExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.ApplyExpression;
	}

	public SchemeExpressions getExpressions() {
		return wGet(SchemeFeatureDescriptorEnum.expressions).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpressions);
	}

	public void setExpressions(SchemeExpressions expressions) {
		wSet(SchemeFeatureDescriptorEnum.expressions, expressions);
	}
}
