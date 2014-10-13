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
public class AssignmentImpl extends AbstractSimpleEntity implements Assignment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Assignment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Assignment;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.Assignment_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Expression leftHandSide;

	public Expression getLeftHandSide() {
		return notifyRequested(JavaFeatureDescriptorEnum.leftHandSide,
				leftHandSide);
	}

	public void setLeftHandSide(Expression leftHandSide) {
		notifyChanged(JavaFeatureDescriptorEnum.leftHandSide,
				this.leftHandSide, this.leftHandSide = leftHandSide);
	}

	private AssignmentOperator operator;

	public AssignmentOperator getOperator() {
		return notifyRequested(JavaFeatureDescriptorEnum.operator, operator);
	}

	public void setOperator(AssignmentOperator operator) {
		notifyChanged(JavaFeatureDescriptorEnum.operator, this.operator,
				this.operator = operator);
	}

	private Expression rightHandSide;

	public Expression getRightHandSide() {
		return notifyRequested(JavaFeatureDescriptorEnum.rightHandSide,
				rightHandSide);
	}

	public void setRightHandSide(Expression rightHandSide) {
		notifyChanged(JavaFeatureDescriptorEnum.rightHandSide,
				this.rightHandSide, this.rightHandSide = rightHandSide);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeftHandSide().wGetAdaptee(false);
		case 1:
			return getOperator().wGetAdaptee(false);
		case 2:
			return getRightHandSide().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLeftHandSide(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		case 1:
			setOperator(value
					.wGetAdapter(JavaEntityDescriptorEnum.AssignmentOperator));
			break;
		case 2:
			setRightHandSide(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
