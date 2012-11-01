package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PostfixExpressionImpl extends AbstractSimpleEntity implements
		PostfixExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PostfixExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.PostfixExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.PostfixExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression operand;

	public Expression getOperand() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.operand, operand);
	}

	public void setOperand(Expression operand) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.operand, this.operand,
				this.operand = operand);
	}

	private PostfixOperator operator;

	public PostfixOperator getOperator() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.operator,
				operator);
	}

	public void setOperator(PostfixOperator operator) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.operator, this.operator,
				this.operator = operator);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getOperand().wGetAdaptee(false);
		case 1:
			return getOperator().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setOperand(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setOperator(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.PostfixOperator));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
