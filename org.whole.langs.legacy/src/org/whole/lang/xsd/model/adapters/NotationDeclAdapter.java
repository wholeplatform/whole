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
public class NotationDeclAdapter extends AbstractEntityAdapter implements
		NotationDecl {
	private static final long serialVersionUID = 1;

	public NotationDeclAdapter(IEntity implementor) {
		super(implementor);
	}

	public NotationDeclAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NotationDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.NotationDecl;
	}

	public NamespaceDecls getNamespaces() {
		return wGet(XsdFeatureDescriptorEnum.namespaces).wGetAdapter(
				XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		wSet(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public StringData getId() {
		return wGet(XsdFeatureDescriptorEnum.id).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setId(StringData id) {
		wSet(XsdFeatureDescriptorEnum.id, id);
	}

	public Attributes getAttributes() {
		return wGet(XsdFeatureDescriptorEnum.attributes).wGetAdapter(
				XsdEntityDescriptorEnum.Attributes);
	}

	public void setAttributes(Attributes attributes) {
		wSet(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public Name getName() {
		return wGet(XsdFeatureDescriptorEnum.name).wGetAdapter(
				XsdEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(XsdFeatureDescriptorEnum.name, name);
	}

	public StringData getPublic() {
		return wGet(XsdFeatureDescriptorEnum._public).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setPublic(StringData _public) {
		wSet(XsdFeatureDescriptorEnum._public, _public);
	}

	public AnyURI getSystem() {
		return wGet(XsdFeatureDescriptorEnum.system).wGetAdapter(
				XsdEntityDescriptorEnum.AnyURI);
	}

	public void setSystem(AnyURI system) {
		wSet(XsdFeatureDescriptorEnum.system, system);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}
}
