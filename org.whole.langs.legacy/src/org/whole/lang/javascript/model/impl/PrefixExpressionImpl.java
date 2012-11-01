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
public class PrefixExpressionImpl extends AbstractSimpleEntity implements
		PrefixExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PrefixExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.PrefixExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.PrefixExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private PrefixOperator operator;

	public PrefixOperator getOperator() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.operator,
				operator);
	}

	public void setOperator(PrefixOperator operator) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.operator, this.operator,
				this.operator = operator);
	}

	private Expression operand;

	public Expression getOperand() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.operand, operand);
	}

	public void setOperand(Expression operand) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.operand, this.operand,
				this.operand = operand);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getOperator().wGetAdaptee(false);
		case 1:
			return getOperand().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setOperator(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.PrefixOperator));
			break;
		case 1:
			setOperand(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
