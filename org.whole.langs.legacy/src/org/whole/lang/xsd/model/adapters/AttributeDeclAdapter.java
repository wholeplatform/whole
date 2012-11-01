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
public class AttributeDeclAdapter extends AbstractEntityAdapter implements
		AttributeDecl {
	private static final long serialVersionUID = 1;

	public AttributeDeclAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributeDeclAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AttributeDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AttributeDecl;
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

	public QName getSimpleType() {
		return wGet(XsdFeatureDescriptorEnum.simpleType).wGetAdapter(
				XsdEntityDescriptorEnum.QName);
	}

	public void setSimpleType(QName simpleType) {
		wSet(XsdFeatureDescriptorEnum.simpleType, simpleType);
	}

	public StringData getDefaultValue() {
		return wGet(XsdFeatureDescriptorEnum.defaultValue).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setDefaultValue(StringData defaultValue) {
		wSet(XsdFeatureDescriptorEnum.defaultValue, defaultValue);
	}

	public StringData getFixedValue() {
		return wGet(XsdFeatureDescriptorEnum.fixedValue).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setFixedValue(StringData fixedValue) {
		wSet(XsdFeatureDescriptorEnum.fixedValue, fixedValue);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public SimpleTypeDef getSimpleTypeDef() {
		return wGet(XsdFeatureDescriptorEnum.simpleTypeDef).wGetAdapter(
				XsdEntityDescriptorEnum.SimpleTypeDef);
	}

	public void setSimpleTypeDef(SimpleTypeDef simpleTypeDef) {
		wSet(XsdFeatureDescriptorEnum.simpleTypeDef, simpleTypeDef);
	}
}
