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
public class KeyrefImpl extends AbstractSimpleEntity implements Keyref {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Keyref> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Keyref;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.Keyref_ord;
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

	private Name name;

	public Name getName() {
		return notifyRequested(XsdFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(XsdFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private QName refer;

	public QName getRefer() {
		return notifyRequested(XsdFeatureDescriptorEnum.refer, refer);
	}

	public void setRefer(QName refer) {
		notifyChanged(XsdFeatureDescriptorEnum.refer, this.refer,
				this.refer = refer);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	private Selector selector;

	public Selector getSelector() {
		return notifyRequested(XsdFeatureDescriptorEnum.selector, selector);
	}

	public void setSelector(Selector selector) {
		notifyChanged(XsdFeatureDescriptorEnum.selector, this.selector,
				this.selector = selector);
	}

	private Fields fields;

	public Fields getFields() {
		return notifyRequested(XsdFeatureDescriptorEnum.fields, fields);
	}

	public void setFields(Fields fields) {
		notifyChanged(XsdFeatureDescriptorEnum.fields, this.fields,
				this.fields = fields);
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
			return getName().wGetAdaptee(false);
		case 4:
			return getRefer().wGetAdaptee(false);
		case 5:
			return getAnnotation().wGetAdaptee(false);
		case 6:
			return getSelector().wGetAdaptee(false);
		case 7:
			return getFields().wGetAdaptee(false);
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
			setName(value.wGetAdapter(XsdEntityDescriptorEnum.Name));
			break;
		case 4:
			setRefer(value.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 5:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		case 6:
			setSelector(value.wGetAdapter(XsdEntityDescriptorEnum.Selector));
			break;
		case 7:
			setFields(value.wGetAdapter(XsdEntityDescriptorEnum.Fields));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 8;
	}
}
