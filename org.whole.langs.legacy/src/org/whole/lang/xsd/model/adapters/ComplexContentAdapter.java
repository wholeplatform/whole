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
public class ComplexContentAdapter extends AbstractEntityAdapter implements
		ComplexContent {
	private static final long serialVersionUID = 1;

	public ComplexContentAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComplexContentAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComplexContent> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ComplexContent;
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

	public BooleanData getMixed() {
		return wGet(XsdFeatureDescriptorEnum.mixed).wGetAdapter(
				XsdEntityDescriptorEnum.BooleanData);
	}

	public void setMixed(BooleanData mixed) {
		wSet(XsdFeatureDescriptorEnum.mixed, mixed);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public ComplexDerivation getDerivation() {
		return wGet(XsdFeatureDescriptorEnum.derivation).wGetAdapter(
				XsdEntityDescriptorEnum.ComplexDerivation);
	}

	public void setDerivation(ComplexDerivation derivation) {
		wSet(XsdFeatureDescriptorEnum.derivation, derivation);
	}
}
