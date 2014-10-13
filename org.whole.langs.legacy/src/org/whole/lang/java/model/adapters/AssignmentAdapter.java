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
public class AssignmentAdapter extends AbstractEntityAdapter implements
		Assignment {
	private static final long serialVersionUID = 1;

	public AssignmentAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssignmentAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Assignment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Assignment;
	}

	public Expression getLeftHandSide() {
		return wGet(JavaFeatureDescriptorEnum.leftHandSide).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setLeftHandSide(Expression leftHandSide) {
		wSet(JavaFeatureDescriptorEnum.leftHandSide, leftHandSide);
	}

	public AssignmentOperator getOperator() {
		return wGet(JavaFeatureDescriptorEnum.operator).wGetAdapter(
				JavaEntityDescriptorEnum.AssignmentOperator);
	}

	public void setOperator(AssignmentOperator operator) {
		wSet(JavaFeatureDescriptorEnum.operator, operator);
	}

	public Expression getRightHandSide() {
		return wGet(JavaFeatureDescriptorEnum.rightHandSide).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setRightHandSide(Expression rightHandSide) {
		wSet(JavaFeatureDescriptorEnum.rightHandSide, rightHandSide);
	}
}
