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
public class InstanceofExpressionImpl extends AbstractSimpleEntity implements
		InstanceofExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InstanceofExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.InstanceofExpression;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.InstanceofExpression_ord;
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

	private Type rightOperand;

	public Type getRightOperand() {
		return notifyRequested(JavaFeatureDescriptorEnum.rightOperand,
				rightOperand);
	}

	public void setRightOperand(Type rightOperand) {
		notifyChanged(JavaFeatureDescriptorEnum.rightOperand,
				this.rightOperand, this.rightOperand = rightOperand);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeftOperand().wGetAdaptee(false);
		case 1:
			return getRightOperand().wGetAdaptee(false);
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
			setRightOperand(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
