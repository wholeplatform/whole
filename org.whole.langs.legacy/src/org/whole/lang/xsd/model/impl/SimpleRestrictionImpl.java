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
public class SimpleRestrictionImpl extends AbstractSimpleEntity implements
		SimpleRestriction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SimpleRestriction> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.SimpleRestriction;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.SimpleRestriction_ord;
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

	private QName base;

	public QName getBase() {
		return notifyRequested(XsdFeatureDescriptorEnum.base, base);
	}

	public void setBase(QName base) {
		notifyChanged(XsdFeatureDescriptorEnum.base, this.base,
				this.base = base);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	private SimpleTypeDef baseDef;

	public SimpleTypeDef getBaseDef() {
		return notifyRequested(XsdFeatureDescriptorEnum.baseDef, baseDef);
	}

	public void setBaseDef(SimpleTypeDef baseDef) {
		notifyChanged(XsdFeatureDescriptorEnum.baseDef, this.baseDef,
				this.baseDef = baseDef);
	}

	private Facets facets;

	public Facets getFacets() {
		return notifyRequested(XsdFeatureDescriptorEnum.facets, facets);
	}

	public void setFacets(Facets facets) {
		notifyChanged(XsdFeatureDescriptorEnum.facets, this.facets,
				this.facets = facets);
	}

	private AttributeUseOrGroups attributeUses;

	public AttributeUseOrGroups getAttributeUses() {
		return notifyRequested(XsdFeatureDescriptorEnum.attributeUses,
				attributeUses);
	}

	public void setAttributeUses(AttributeUseOrGroups attributeUses) {
		notifyChanged(XsdFeatureDescriptorEnum.attributeUses,
				this.attributeUses, this.attributeUses = attributeUses);
	}

	private AnyAttribute anyAttribute;

	public AnyAttribute getAnyAttribute() {
		return notifyRequested(XsdFeatureDescriptorEnum.anyAttribute,
				anyAttribute);
	}

	public void setAnyAttribute(AnyAttribute anyAttribute) {
		notifyChanged(XsdFeatureDescriptorEnum.anyAttribute, this.anyAttribute,
				this.anyAttribute = anyAttribute);
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
			return getBase().wGetAdaptee(false);
		case 4:
			return getAnnotation().wGetAdaptee(false);
		case 5:
			return getBaseDef().wGetAdaptee(false);
		case 6:
			return getFacets().wGetAdaptee(false);
		case 7:
			return getAttributeUses().wGetAdaptee(false);
		case 8:
			return getAnyAttribute().wGetAdaptee(false);
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
			setBase(value.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 4:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		case 5:
			setBaseDef(value.wGetAdapter(XsdEntityDescriptorEnum.SimpleTypeDef));
			break;
		case 6:
			setFacets(value.wGetAdapter(XsdEntityDescriptorEnum.Facets));
			break;
		case 7:
			setAttributeUses(value
					.wGetAdapter(XsdEntityDescriptorEnum.AttributeUseOrGroups));
			break;
		case 8:
			setAnyAttribute(value
					.wGetAdapter(XsdEntityDescriptorEnum.AnyAttribute));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 9;
	}
}
