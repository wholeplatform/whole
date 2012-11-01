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
public class InstanceofExpressionAdapter extends AbstractEntityAdapter
		implements InstanceofExpression {
	private static final long serialVersionUID = 1;

	public InstanceofExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public InstanceofExpressionAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InstanceofExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.InstanceofExpression;
	}

	public Expression getLeftOperand() {
		return wGet(JavaFeatureDescriptorEnum.leftOperand).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setLeftOperand(Expression leftOperand) {
		wSet(JavaFeatureDescriptorEnum.leftOperand, leftOperand);
	}

	public Type getRightOperand() {
		return wGet(JavaFeatureDescriptorEnum.rightOperand).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setRightOperand(Type rightOperand) {
		wSet(JavaFeatureDescriptorEnum.rightOperand, rightOperand);
	}
}
