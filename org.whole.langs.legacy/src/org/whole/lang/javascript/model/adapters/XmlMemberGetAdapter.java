package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class XmlMemberGetAdapter extends AbstractEntityAdapter implements
		XmlMemberGet {
	private static final long serialVersionUID = 1;

	public XmlMemberGetAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlMemberGetAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlMemberGet> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlMemberGet;
	}

	public Expression getLeft() {
		return wGet(JavaScriptFeatureDescriptorEnum.left).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setLeft(Expression left) {
		wSet(JavaScriptFeatureDescriptorEnum.left, left);
	}

	public XmlMemberOperator getOperator() {
		return wGet(JavaScriptFeatureDescriptorEnum.operator).wGetAdapter(
				JavaScriptEntityDescriptorEnum.XmlMemberOperator);
	}

	public void setOperator(XmlMemberOperator operator) {
		wSet(JavaScriptFeatureDescriptorEnum.operator, operator);
	}

	public Expression getRight() {
		return wGet(JavaScriptFeatureDescriptorEnum.right).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setRight(Expression right) {
		wSet(JavaScriptFeatureDescriptorEnum.right, right);
	}
}
