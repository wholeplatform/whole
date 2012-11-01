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
public class AttributeUseRefAdapter extends AbstractEntityAdapter implements
		AttributeUseRef {
	private static final long serialVersionUID = 1;

	public AttributeUseRefAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributeUseRefAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AttributeUseRef> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AttributeUseRef;
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

	public QName getRef() {
		return wGet(XsdFeatureDescriptorEnum.ref).wGetAdapter(
				XsdEntityDescriptorEnum.QName);
	}

	public void setRef(QName ref) {
		wSet(XsdFeatureDescriptorEnum.ref, ref);
	}

	public Use getUse() {
		return wGet(XsdFeatureDescriptorEnum.use).wGetAdapter(
				XsdEntityDescriptorEnum.Use);
	}

	public void setUse(Use use) {
		wSet(XsdFeatureDescriptorEnum.use, use);
	}

	public Qualify getForm() {
		return wGet(XsdFeatureDescriptorEnum.form).wGetAdapter(
				XsdEntityDescriptorEnum.Qualify);
	}

	public void setForm(Qualify form) {
		wSet(XsdFeatureDescriptorEnum.form, form);
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
}
