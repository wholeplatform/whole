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
public class PostfixExpressionAdapter extends AbstractEntityAdapter implements
		PostfixExpression {
	private static final long serialVersionUID = 1;

	public PostfixExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public PostfixExpressionAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PostfixExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.PostfixExpression;
	}

	public Expression getOperand() {
		return wGet(JavaFeatureDescriptorEnum.operand).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setOperand(Expression operand) {
		wSet(JavaFeatureDescriptorEnum.operand, operand);
	}

	public PostfixOperator getOperator() {
		return wGet(JavaFeatureDescriptorEnum.operator).wGetAdapter(
				JavaEntityDescriptorEnum.PostfixOperator);
	}

	public void setOperator(PostfixOperator operator) {
		wSet(JavaFeatureDescriptorEnum.operator, operator);
	}
}
