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
public class SimpleRestrictionAdapter extends AbstractEntityAdapter implements
		SimpleRestriction {
	private static final long serialVersionUID = 1;

	public SimpleRestrictionAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleRestrictionAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleRestriction> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.SimpleRestriction;
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

	public SimpleTypeDef getBaseDef() {
		return wGet(XsdFeatureDescriptorEnum.baseDef).wGetAdapter(
				XsdEntityDescriptorEnum.SimpleTypeDef);
	}

	public void setBaseDef(SimpleTypeDef baseDef) {
		wSet(XsdFeatureDescriptorEnum.baseDef, baseDef);
	}

	public Facets getFacets() {
		return wGet(XsdFeatureDescriptorEnum.facets).wGetAdapter(
				XsdEntityDescriptorEnum.Facets);
	}

	public void setFacets(Facets facets) {
		wSet(XsdFeatureDescriptorEnum.facets, facets);
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
