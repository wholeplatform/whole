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
public class InfixExpressionAdapter extends AbstractEntityAdapter implements
		InfixExpression {
	private static final long serialVersionUID = 1;

	public InfixExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public InfixExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InfixExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.InfixExpression;
	}

	public Expression getLeft() {
		return wGet(JavaScriptFeatureDescriptorEnum.left).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setLeft(Expression left) {
		wSet(JavaScriptFeatureDescriptorEnum.left, left);
	}

	public InfixOperator getOperator() {
		return wGet(JavaScriptFeatureDescriptorEnum.operator).wGetAdapter(
				JavaScriptEntityDescriptorEnum.InfixOperator);
	}

	public void setOperator(InfixOperator operator) {
		wSet(JavaScriptFeatureDescriptorEnum.operator, operator);
	}

	public Expression getRight() {
		return wGet(JavaScriptFeatureDescriptorEnum.right).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setRight(Expression right) {
		wSet(JavaScriptFeatureDescriptorEnum.right, right);
	}
}
