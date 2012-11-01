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
public class ComplexRestrictionAdapter extends AbstractEntityAdapter implements
		ComplexRestriction {
	private static final long serialVersionUID = 1;

	public ComplexRestrictionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComplexRestrictionAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComplexRestriction> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ComplexRestriction;
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

	public QName getBase() {
		return wGet(XsdFeatureDescriptorEnum.base).wGetAdapter(
				XsdEntityDescriptorEnum.QName);
	}

	public void setBase(QName base) {
		wSet(XsdFeatureDescriptorEnum.base, base);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public DeclaredContent getContent() {
		return wGet(XsdFeatureDescriptorEnum.content).wGetAdapter(
				XsdEntityDescriptorEnum.DeclaredContent);
	}

	public void setContent(DeclaredContent content) {
		wSet(XsdFeatureDescriptorEnum.content, content);
	}
}
