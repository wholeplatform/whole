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
public class ComputedXmlRefImpl extends AbstractSimpleEntity implements
		ComputedXmlRef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ComputedXmlRef> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ComputedXmlRef;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ComputedXmlRef_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private BooleanData attribute;

	public BooleanData getAttribute() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.attribute,
				attribute);
	}

	public void setAttribute(BooleanData attribute) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.attribute,
				this.attribute, this.attribute = attribute);
	}

	private IdentifierOrXmlAny namespace;

	public IdentifierOrXmlAny getNamespace() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.namespace,
				namespace);
	}

	public void setNamespace(IdentifierOrXmlAny namespace) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.namespace,
				this.namespace, this.namespace = namespace);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.expression,
				this.expression, this.expression = expression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAttribute().wGetAdaptee(false);
		case 1:
			return getNamespace().wGetAdaptee(false);
		case 2:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAttribute(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.BooleanData));
			break;
		case 1:
			setNamespace(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.IdentifierOrXmlAny));
			break;
		case 2:
			setExpression(value
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
