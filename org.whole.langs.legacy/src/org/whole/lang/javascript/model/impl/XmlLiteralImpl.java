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
public class XmlLiteralImpl extends AbstractSimpleEntity implements XmlLiteral {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<XmlLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlLiteral;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.XmlLiteral_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private XmlFragments fragments;

	public XmlFragments getFragments() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.fragments,
				fragments);
	}

	public void setFragments(XmlFragments fragments) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.fragments,
				this.fragments, this.fragments = fragments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFragments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFragments(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.XmlFragments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
