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
public class AnyAttributeImpl extends AbstractSimpleEntity implements
		AnyAttribute {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnyAttribute> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AnyAttribute;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.AnyAttribute_ord;
	}

	public void accept(IXsdVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	private NamespaceSpecs namespaceSpecs;

	public NamespaceSpecs getNamespaceSpecs() {
		return notifyRequested(XsdFeatureDescriptorEnum.namespaceSpecs,
				namespaceSpecs);
	}

	public void setNamespaceSpecs(NamespaceSpecs namespaceSpecs) {
		notifyChanged(XsdFeatureDescriptorEnum.namespaceSpecs,
				this.namespaceSpecs, this.namespaceSpecs = namespaceSpecs);
	}

	private ProcessContents processContents;

	public ProcessContents getProcessContents() {
		return notifyRequested(XsdFeatureDescriptorEnum.processContents,
				processContents);
	}

	public void setProcessContents(ProcessContents processContents) {
		notifyChanged(XsdFeatureDescriptorEnum.processContents,
				this.processContents, this.processContents = processContents);
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
			return getNamespaceSpecs().wGetAdaptee(false);
		case 4:
			return getProcessContents().wGetAdaptee(false);
		case 5:
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
			setNamespaceSpecs(value
					.wGetAdapter(XsdEntityDescriptorEnum.NamespaceSpecs));
			break;
		case 4:
			setProcessContents(value
					.wGetAdapter(XsdEntityDescriptorEnum.ProcessContents));
			break;
		case 5:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
