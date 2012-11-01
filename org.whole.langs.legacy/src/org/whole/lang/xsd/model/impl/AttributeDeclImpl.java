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
public class AttributeDeclImpl extends AbstractSimpleEntity implements
		AttributeDecl {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AttributeDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AttributeDecl;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.AttributeDecl_ord;
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

	private Name name;

	public Name getName() {
		return notifyRequested(XsdFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(XsdFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private QName simpleType;

	public QName getSimpleType() {
		return notifyRequested(XsdFeatureDescriptorEnum.simpleType, simpleType);
	}

	public void setSimpleType(QName simpleType) {
		notifyChanged(XsdFeatureDescriptorEnum.simpleType, this.simpleType,
				this.simpleType = simpleType);
	}

	private StringData defaultValue;

	public StringData getDefaultValue() {
		return notifyRequested(XsdFeatureDescriptorEnum.defaultValue,
				defaultValue);
	}

	public void setDefaultValue(StringData defaultValue) {
		notifyChanged(XsdFeatureDescriptorEnum.defaultValue, this.defaultValue,
				this.defaultValue = defaultValue);
	}

	private StringData fixedValue;

	public StringData getFixedValue() {
		return notifyRequested(XsdFeatureDescriptorEnum.fixedValue, fixedValue);
	}

	public void setFixedValue(StringData fixedValue) {
		notifyChanged(XsdFeatureDescriptorEnum.fixedValue, this.fixedValue,
				this.fixedValue = fixedValue);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	private SimpleTypeDef simpleTypeDef;

	public SimpleTypeDef getSimpleTypeDef() {
		return notifyRequested(XsdFeatureDescriptorEnum.simpleTypeDef,
				simpleTypeDef);
	}

	public void setSimpleTypeDef(SimpleTypeDef simpleTypeDef) {
		notifyChanged(XsdFeatureDescriptorEnum.simpleTypeDef,
				this.simpleTypeDef, this.simpleTypeDef = simpleTypeDef);
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
			return getSimpleType().wGetAdaptee(false);
		case 5:
			return getDefaultValue().wGetAdaptee(false);
		case 6:
			return getFixedValue().wGetAdaptee(false);
		case 7:
			return getAnnotation().wGetAdaptee(false);
		case 8:
			return getSimpleTypeDef().wGetAdaptee(false);
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
			setSimpleType(value.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 5:
			setDefaultValue(value
					.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 6:
			setFixedValue(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 7:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		case 8:
			setSimpleTypeDef(value
					.wGetAdapter(XsdEntityDescriptorEnum.SimpleTypeDef));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 9;
	}
}
