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
public class ElementRefImpl extends AbstractSimpleEntity implements ElementRef {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ElementRef> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ElementRef;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.ElementRef_ord;
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	private NamespaceDecls namespaces;

	public NamespaceDecls getNamespaces() {
		return notifyRequested(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		notifyChanged(XsdFeatureDescriptorEnum.namespaces, this.namespaces,
				this.namespaces = namespaces);
	}

	private StringData id;

	public StringData getId() {
		return notifyRequested(XsdFeatureDescriptorEnum.id, id);
	}

	public void setId(StringData id) {
		notifyChanged(XsdFeatureDescriptorEnum.id, this.id, this.id = id);
	}

	private Attributes attributes;

	public Attributes getAttributes() {
		return notifyRequested(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public void setAttributes(Attributes attributes) {
		notifyChanged(XsdFeatureDescriptorEnum.attributes, this.attributes,
				this.attributes = attributes);
	}

	private Bounded minOccurs;

	public Bounded getMinOccurs() {
		return notifyRequested(XsdFeatureDescriptorEnum.minOccurs, minOccurs);
	}

	public void setMinOccurs(Bounded minOccurs) {
		notifyChanged(XsdFeatureDescriptorEnum.minOccurs, this.minOccurs,
				this.minOccurs = minOccurs);
	}

	private Occurrence maxOccurs;

	public Occurrence getMaxOccurs() {
		return notifyRequested(XsdFeatureDescriptorEnum.maxOccurs, maxOccurs);
	}

	public void setMaxOccurs(Occurrence maxOccurs) {
		notifyChanged(XsdFeatureDescriptorEnum.maxOccurs, this.maxOccurs,
				this.maxOccurs = maxOccurs);
	}

	private QName ref;

	public QName getRef() {
		return notifyRequested(XsdFeatureDescriptorEnum.ref, ref);
	}

	public void setRef(QName ref) {
		notifyChanged(XsdFeatureDescriptorEnum.ref, this.ref, this.ref = ref);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNamespaces().wGetAdaptee(false);
		case 1:
			return getId().wGetAdaptee(false);
		case 2:
			return getAttributes().wGetAdaptee(false);
		case 3:
			return getMinOccurs().wGetAdaptee(false);
		case 4:
			return getMaxOccurs().wGetAdaptee(false);
		case 5:
			return getRef().wGetAdaptee(false);
		case 6:
			return getAnnotation().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNamespaces(value
					.wGetAdapter(XsdEntityDescriptorEnum.NamespaceDecls));
			break;
		case 1:
			setId(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 2:
			setAttributes(value.wGetAdapter(XsdEntityDescriptorEnum.Attributes));
			break;
		case 3:
			setMinOccurs(value.wGetAdapter(XsdEntityDescriptorEnum.Bounded));
			break;
		case 4:
			setMaxOccurs(value.wGetAdapter(XsdEntityDescriptorEnum.Occurrence));
			break;
		case 5:
			setRef(value.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 6:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 7;
	}
}
