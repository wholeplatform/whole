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
public class UnionImpl extends AbstractSimpleEntity implements Union {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Union> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Union;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.Union_ord;
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

	private MemberTypes memberTypes;

	public MemberTypes getMemberTypes() {
		return notifyRequested(XsdFeatureDescriptorEnum.memberTypes,
				memberTypes);
	}

	public void setMemberTypes(MemberTypes memberTypes) {
		notifyChanged(XsdFeatureDescriptorEnum.memberTypes, this.memberTypes,
				this.memberTypes = memberTypes);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	private SimpleTypeDefs memberTypesDefs;

	public SimpleTypeDefs getMemberTypesDefs() {
		return notifyRequested(XsdFeatureDescriptorEnum.memberTypesDefs,
				memberTypesDefs);
	}

	public void setMemberTypesDefs(SimpleTypeDefs memberTypesDefs) {
		notifyChanged(XsdFeatureDescriptorEnum.memberTypesDefs,
				this.memberTypesDefs, this.memberTypesDefs = memberTypesDefs);
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
			return getMemberTypes().wGetAdaptee(false);
		case 4:
			return getAnnotation().wGetAdaptee(false);
		case 5:
			return getMemberTypesDefs().wGetAdaptee(false);
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
			setMemberTypes(value
					.wGetAdapter(XsdEntityDescriptorEnum.MemberTypes));
			break;
		case 4:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		case 5:
			setMemberTypesDefs(value
					.wGetAdapter(XsdEntityDescriptorEnum.SimpleTypeDefs));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
