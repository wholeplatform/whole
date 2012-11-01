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
public class AnyAttributeAdapter extends AbstractEntityAdapter implements
		AnyAttribute {
	private static final long serialVersionUID = 1;

	public AnyAttributeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnyAttributeAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnyAttribute> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.AnyAttribute;
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

	public NamespaceSpecs getNamespaceSpecs() {
		return wGet(XsdFeatureDescriptorEnum.namespaceSpecs).wGetAdapter(
				XsdEntityDescriptorEnum.NamespaceSpecs);
	}

	public void setNamespaceSpecs(NamespaceSpecs namespaceSpecs) {
		wSet(XsdFeatureDescriptorEnum.namespaceSpecs, namespaceSpecs);
	}

	public ProcessContents getProcessContents() {
		return wGet(XsdFeatureDescriptorEnum.processContents).wGetAdapter(
				XsdEntityDescriptorEnum.ProcessContents);
	}

	public void setProcessContents(ProcessContents processContents) {
		wSet(XsdFeatureDescriptorEnum.processContents, processContents);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}
}
