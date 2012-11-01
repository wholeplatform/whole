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
public class AttributeGroupDefAdapter extends AbstractEntityAdapter implements
		AttributeGroupDef {
	private static final long serialVersionUID = 1;

	public AttributeGroupDefAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributeGroupDefAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AttributeGroupDef> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AttributeGroupDef;
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

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public AttributeUseOrGroups getAttributeUses() {
		return wGet(XsdFeatureDescriptorEnum.attributeUses).wGetAdapter(
				XsdEntityDescriptorEnum.AttributeUseOrGroups);
	}

	public void setAttributeUses(AttributeUseOrGroups attributeUses) {
		wSet(XsdFeatureDescriptorEnum.attributeUses, attributeUses);
	}

	public AnyAttribute getAnyAttribute() {
		return wGet(XsdFeatureDescriptorEnum.anyAttribute).wGetAdapter(
				XsdEntityDescriptorEnum.AnyAttribute);
	}

	public void setAnyAttribute(AnyAttribute anyAttribute) {
		wSet(XsdFeatureDescriptorEnum.anyAttribute, anyAttribute);
	}
}
