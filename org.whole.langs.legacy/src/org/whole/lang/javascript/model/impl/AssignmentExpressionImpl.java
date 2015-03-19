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
public class AssignmentExpressionImpl extends AbstractSimpleEntity implements
		AssignmentExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AssignmentExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.AssignmentExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.AssignmentExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression left;

	public Expression getLeft() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.left, left);
	}

	public void setLeft(Expression left) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.left, this.left,
				this.left = left);
	}

	private AssignmentOperator operator;

	public AssignmentOperator getOperator() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.operator,
				operator);
	}

	public void setOperator(AssignmentOperator operator) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.operator, this.operator,
				this.operator = operator);
	}

	private Expression right;

	public Expression getRight() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.right, right);
	}

	public void setRight(Expression right) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.right, this.right,
				this.right = right);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLeft().wGetAdaptee(false);
		case 1:
			return getOperator().wGetAdaptee(false);
		case 2:
			return getRight().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLeft(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setOperator(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.AssignmentOperator));
			break;
		case 2:
			setRight(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
