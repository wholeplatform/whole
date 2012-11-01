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
public class ElementRefAdapter extends AbstractEntityAdapter implements
		ElementRef {
	private static final long serialVersionUID = 1;

	public ElementRefAdapter(IEntity implementor) {
		super(implementor);
	}

	public ElementRefAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ElementRef> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ElementRef;
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

	public Bounded getMinOccurs() {
		return wGet(XsdFeatureDescriptorEnum.minOccurs).wGetAdapter(
				XsdEntityDescriptorEnum.Bounded);
	}

	public void setMinOccurs(Bounded minOccurs) {
		wSet(XsdFeatureDescriptorEnum.minOccurs, minOccurs);
	}

	public Occurrence getMaxOccurs() {
		return wGet(XsdFeatureDescriptorEnum.maxOccurs).wGetAdapter(
				XsdEntityDescriptorEnum.Occurrence);
	}

	public void setMaxOccurs(Occurrence maxOccurs) {
		wSet(XsdFeatureDescriptorEnum.maxOccurs, maxOccurs);
	}

	public QName getRef() {
		return wGet(XsdFeatureDescriptorEnum.ref).wGetAdapter(
				XsdEntityDescriptorEnum.QName);
	}

	public void setRef(QName ref) {
		wSet(XsdFeatureDescriptorEnum.ref, ref);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}
}
