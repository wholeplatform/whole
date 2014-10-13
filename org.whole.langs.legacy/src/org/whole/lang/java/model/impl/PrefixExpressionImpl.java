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
public class PrefixExpressionImpl extends AbstractSimpleEntity implements
		PrefixExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PrefixExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PrefixExpression;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.PrefixExpression_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private PrefixOperator operator;

	public PrefixOperator getOperator() {
		return notifyRequested(JavaFeatureDescriptorEnum.operator, operator);
	}

	public void setOperator(PrefixOperator operator) {
		notifyChanged(JavaFeatureDescriptorEnum.operator, this.operator,
				this.operator = operator);
	}

	private Expression operand;

	public Expression getOperand() {
		return notifyRequested(JavaFeatureDescriptorEnum.operand, operand);
	}

	public void setOperand(Expression operand) {
		notifyChanged(JavaFeatureDescriptorEnum.operand, this.operand,
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
					.wGetAdapter(JavaEntityDescriptorEnum.PrefixOperator));
			break;
		case 1:
			setOperand(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
