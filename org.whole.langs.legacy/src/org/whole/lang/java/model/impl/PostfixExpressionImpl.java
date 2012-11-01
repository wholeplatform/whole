package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PostfixExpressionImpl extends AbstractSimpleEntity implements
		PostfixExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PostfixExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PostfixExpression;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.PostfixExpression_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expression operand;

	public Expression getOperand() {
		return notifyRequested(JavaFeatureDescriptorEnum.operand, operand);
	}

	public void setOperand(Expression operand) {
		notifyChanged(JavaFeatureDescriptorEnum.operand, this.operand,
				this.operand = operand);
	}

	private PostfixOperator operator;

	public PostfixOperator getOperator() {
		return notifyRequested(JavaFeatureDescriptorEnum.operator, operator);
	}

	public void setOperator(PostfixOperator operator) {
		notifyChanged(JavaFeatureDescriptorEnum.operator, this.operator,
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
			setOperand(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 1:
			setOperator(value
					.wGetAdapter(JavaEntityDescriptorEnum.PostfixOperator));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
