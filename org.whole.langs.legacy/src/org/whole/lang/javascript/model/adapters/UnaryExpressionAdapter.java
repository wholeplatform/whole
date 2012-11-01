package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class UnaryExpressionAdapter extends AbstractEntityAdapter implements
		UnaryExpression {
	private static final long serialVersionUID = 1;

	public UnaryExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public UnaryExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UnaryExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.UnaryExpression;
	}

	public Expression getOperand() {
		return wGet(JavaScriptFeatureDescriptorEnum.operand).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setOperand(Expression operand) {
		wSet(JavaScriptFeatureDescriptorEnum.operand, operand);
	}
}
