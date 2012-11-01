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
public class PostfixExpressionAdapter extends AbstractEntityAdapter implements
		PostfixExpression {
	private static final long serialVersionUID = 1;

	public PostfixExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public PostfixExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PostfixExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.PostfixExpression;
	}

	public Expression getOperand() {
		return wGet(JavaScriptFeatureDescriptorEnum.operand).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setOperand(Expression operand) {
		wSet(JavaScriptFeatureDescriptorEnum.operand, operand);
	}

	public PostfixOperator getOperator() {
		return wGet(JavaScriptFeatureDescriptorEnum.operator).wGetAdapter(
				JavaScriptEntityDescriptorEnum.PostfixOperator);
	}

	public void setOperator(PostfixOperator operator) {
		wSet(JavaScriptFeatureDescriptorEnum.operator, operator);
	}
}
