package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class NamespaceDeclAdapter extends AbstractEntityAdapter implements
		NamespaceDecl {
	private static final long serialVersionUID = 1;

	public NamespaceDeclAdapter(IEntity implementor) {
		super(implementor);
	}

	public NamespaceDeclAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NamespaceDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.NamespaceDecl;
	}

	public Name getPrefix() {
		return wGet(XsdFeatureDescriptorEnum.prefix).wGetAdapter(
				XsdEntityDescriptorEnum.Name);
	}

	public void setPrefix(Name prefix) {
		wSet(XsdFeatureDescriptorEnum.prefix, prefix);
	}

	public AnyURI getUri() {
		return wGet(XsdFeatureDescriptorEnum.uri).wGetAdapter(
				XsdEntityDescriptorEnum.AnyURI);
	}

	public void setUri(AnyURI uri) {
		wSet(XsdFeatureDescriptorEnum.uri, uri);
	}
}
