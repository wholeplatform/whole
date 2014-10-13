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
public class InfixExpressionImpl extends AbstractSimpleEntity implements
		InfixExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InfixExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.InfixExpression;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.InfixExpression_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expression leftOperand;

	public Expression getLeftOperand() {
		return notifyRequested(JavaFeatureDescriptorEnum.leftOperand,
				leftOperand);
	}

	public void setLeftOperand(Expression leftOperand) {
		notifyChanged(JavaFeatureDescriptorEnum.leftOperand, this.leftOperand,
				this.leftOperand = leftOperand);
	}

	private InfixOperator operator;

	public InfixOperator getOperator() {
		return notifyRequested(JavaFeatureDescriptorEnum.operator, operator);
	}

	public void setOperator(InfixOperator operator) {
		notifyChanged(JavaFeatureDescriptorEnum.operator, this.operator,
				this.operator = operator);
	}

	private Expression rightOperand;

	public Expression getRightOperand() {
		return notifyRequested(JavaFeatureDescriptorEnum.rightOperand,
				rightOperand);
	}

	public void setRightOperand(Expression rightOperand) {
		notifyChanged(JavaFeatureDescriptorEnum.rightOperand,
				this.rightOperand, this.rightOperand = rightOperand);
	}

	private Expressions extendedOperands;

	public Expressions getExtendedOperands() {
		return notifyRequested(JavaFeatureDescriptorEnum.extendedOperands,
				extendedOperands);
	}

	public void setExtendedOperands(Expressions extendedOperands) {
		notifyChanged(JavaFeatureDescriptorEnum.extendedOperands,
				this.extendedOperands, this.extendedOperands = extendedOperands);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeftOperand().wGetAdaptee(false);
		case 1:
			return getOperator().wGetAdaptee(false);
		case 2:
			return getRightOperand().wGetAdaptee(false);
		case 3:
			return getExtendedOperands().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLeftOperand(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 1:
			setOperator(value
					.wGetAdapter(JavaEntityDescriptorEnum.InfixOperator));
			break;
		case 2:
			setRightOperand(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 3:
			setExtendedOperands(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
