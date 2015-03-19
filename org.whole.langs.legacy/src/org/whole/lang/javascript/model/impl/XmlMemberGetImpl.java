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
public class XmlMemberGetImpl extends AbstractSimpleEntity implements
		XmlMemberGet {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<XmlMemberGet> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlMemberGet;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.XmlMemberGet_ord;
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

	private XmlMemberOperator operator;

	public XmlMemberOperator getOperator() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.operator,
				operator);
	}

	public void setOperator(XmlMemberOperator operator) {
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
					.wGetAdapter(JavaScriptEntityDescriptorEnum.XmlMemberOperator));
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
