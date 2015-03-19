package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class NamespaceDeclImpl extends AbstractSimpleEntity implements
		NamespaceDecl {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NamespaceDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.NamespaceDecl;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.NamespaceDecl_ord;
	}

	public void accept(IXsdVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name prefix;

	public Name getPrefix() {
		return notifyRequested(XsdFeatureDescriptorEnum.prefix, prefix);
	}

	public void setPrefix(Name prefix) {
		notifyChanged(XsdFeatureDescriptorEnum.prefix, this.prefix,
				this.prefix = prefix);
	}

	private AnyURI uri;

	public AnyURI getUri() {
		return notifyRequested(XsdFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(AnyURI uri) {
		notifyChanged(XsdFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPrefix().wGetAdaptee(false);
		case 1:
			return getUri().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPrefix(value.wGetAdapter(XsdEntityDescriptorEnum.Name));
			break;
		case 1:
			setUri(value.wGetAdapter(XsdEntityDescriptorEnum.AnyURI));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
