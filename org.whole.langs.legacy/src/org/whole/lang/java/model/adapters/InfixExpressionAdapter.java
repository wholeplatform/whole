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
public class InfixExpressionAdapter extends AbstractEntityAdapter implements
		InfixExpression {
	private static final long serialVersionUID = 1;

	public InfixExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public InfixExpressionAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InfixExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.InfixExpression;
	}

	public Expression getLeftOperand() {
		return wGet(JavaFeatureDescriptorEnum.leftOperand).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setLeftOperand(Expression leftOperand) {
		wSet(JavaFeatureDescriptorEnum.leftOperand, leftOperand);
	}

	public InfixOperator getOperator() {
		return wGet(JavaFeatureDescriptorEnum.operator).wGetAdapter(
				JavaEntityDescriptorEnum.InfixOperator);
	}

	public void setOperator(InfixOperator operator) {
		wSet(JavaFeatureDescriptorEnum.operator, operator);
	}

	public Expression getRightOperand() {
		return wGet(JavaFeatureDescriptorEnum.rightOperand).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setRightOperand(Expression rightOperand) {
		wSet(JavaFeatureDescriptorEnum.rightOperand, rightOperand);
	}

	public Expressions getExtendedOperands() {
		return wGet(JavaFeatureDescriptorEnum.extendedOperands).wGetAdapter(
				JavaEntityDescriptorEnum.Expressions);
	}

	public void setExtendedOperands(Expressions extendedOperands) {
		wSet(JavaFeatureDescriptorEnum.extendedOperands, extendedOperands);
	}
}
