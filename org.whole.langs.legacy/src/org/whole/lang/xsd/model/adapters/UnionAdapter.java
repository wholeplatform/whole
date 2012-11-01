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
public class UnionAdapter extends AbstractEntityAdapter implements Union {
	private static final long serialVersionUID = 1;

	public UnionAdapter(IEntity implementor) {
		super(implementor);
	}

	public UnionAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Union> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Union;
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

	public MemberTypes getMemberTypes() {
		return wGet(XsdFeatureDescriptorEnum.memberTypes).wGetAdapter(
				XsdEntityDescriptorEnum.MemberTypes);
	}

	public void setMemberTypes(MemberTypes memberTypes) {
		wSet(XsdFeatureDescriptorEnum.memberTypes, memberTypes);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public SimpleTypeDefs getMemberTypesDefs() {
		return wGet(XsdFeatureDescriptorEnum.memberTypesDefs).wGetAdapter(
				XsdEntityDescriptorEnum.SimpleTypeDefs);
	}

	public void setMemberTypesDefs(SimpleTypeDefs memberTypesDefs) {
		wSet(XsdFeatureDescriptorEnum.memberTypesDefs, memberTypesDefs);
	}
}
