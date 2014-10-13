package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ConditionalExpressionAdapter extends AbstractEntityAdapter
		implements ConditionalExpression {
	private static final long serialVersionUID = 1;

	public ConditionalExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConditionalExpressionAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConditionalExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ConditionalExpression;
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}

	public Expression getThenExpression() {
		return wGet(JavaFeatureDescriptorEnum.thenExpression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setThenExpression(Expression thenExpression) {
		wSet(JavaFeatureDescriptorEnum.thenExpression, thenExpression);
	}

	public Expression getElseExpression() {
		return wGet(JavaFeatureDescriptorEnum.elseExpression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setElseExpression(Expression elseExpression) {
		wSet(JavaFeatureDescriptorEnum.elseExpression, elseExpression);
	}
}
