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
public class PrefixExpressionAdapter extends AbstractEntityAdapter implements
		PrefixExpression {
	private static final long serialVersionUID = 1;

	public PrefixExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public PrefixExpressionAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PrefixExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PrefixExpression;
	}

	public PrefixOperator getOperator() {
		return wGet(JavaFeatureDescriptorEnum.operator).wGetAdapter(
				JavaEntityDescriptorEnum.PrefixOperator);
	}

	public void setOperator(PrefixOperator operator) {
		wSet(JavaFeatureDescriptorEnum.operator, operator);
	}

	public Expression getOperand() {
		return wGet(JavaFeatureDescriptorEnum.operand).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setOperand(Expression operand) {
		wSet(JavaFeatureDescriptorEnum.operand, operand);
	}
}
