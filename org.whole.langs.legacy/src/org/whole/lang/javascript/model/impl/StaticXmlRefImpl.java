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
public class StaticXmlRefImpl extends AbstractSimpleEntity implements
		StaticXmlRef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<StaticXmlRef> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.StaticXmlRef;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.StaticXmlRef_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	private IdentifierOrXmlAny property;

	public IdentifierOrXmlAny getProperty() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.property,
				property);
	}

	public void setProperty(IdentifierOrXmlAny property) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.property, this.property,
				this.property = property);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAttribute().wGetAdaptee(false);
		case 1:
			return getNamespace().wGetAdaptee(false);
		case 2:
			return getProperty().wGetAdaptee(false);
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
			setProperty(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.IdentifierOrXmlAny));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
