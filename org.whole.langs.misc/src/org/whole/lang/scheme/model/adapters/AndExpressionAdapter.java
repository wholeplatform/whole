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
public class AndExpressionAdapter extends AbstractEntityAdapter implements
		AndExpression {
	private static final long serialVersionUID = 1;

	public AndExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public AndExpressionAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AndExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.AndExpression;
	}

	public SchemeExpressions getExpressions() {
		return wGet(SchemeFeatureDescriptorEnum.expressions).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpressions);
	}

	public void setExpressions(SchemeExpressions expressions) {
		wSet(SchemeFeatureDescriptorEnum.expressions, expressions);
	}
}
