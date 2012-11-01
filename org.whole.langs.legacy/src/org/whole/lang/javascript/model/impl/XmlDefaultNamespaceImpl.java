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
public class XmlDefaultNamespaceImpl extends AbstractSimpleEntity implements
		XmlDefaultNamespace {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<XmlDefaultNamespace> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlDefaultNamespace;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.XmlDefaultNamespace_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression operand;

	public Expression getOperand() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.operand, operand);
	}

	public void setOperand(Expression operand) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.operand, this.operand,
				this.operand = operand);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getOperand().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setOperand(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
