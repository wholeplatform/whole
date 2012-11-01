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
public class ComplexTypeDefAdapter extends AbstractEntityAdapter implements
		ComplexTypeDef {
	private static final long serialVersionUID = 1;

	public ComplexTypeDefAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComplexTypeDefAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComplexTypeDef> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ComplexTypeDef;
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

	public DerivationSet getFinal() {
		return wGet(XsdFeatureDescriptorEnum._final).wGetAdapter(
				XsdEntityDescriptorEnum.DerivationSet);
	}

	public void setFinal(DerivationSet _final) {
		wSet(XsdFeatureDescriptorEnum._final, _final);
	}

	public BooleanData getAbstract() {
		return wGet(XsdFeatureDescriptorEnum._abstract).wGetAdapter(
				XsdEntityDescriptorEnum.BooleanData);
	}

	public void setAbstract(BooleanData _abstract) {
		wSet(XsdFeatureDescriptorEnum._abstract, _abstract);
	}

	public BooleanData getMixed() {
		return wGet(XsdFeatureDescriptorEnum.mixed).wGetAdapter(
				XsdEntityDescriptorEnum.BooleanData);
	}

	public void setMixed(BooleanData mixed) {
		wSet(XsdFeatureDescriptorEnum.mixed, mixed);
	}

	public DerivationSet getBlock() {
		return wGet(XsdFeatureDescriptorEnum.block).wGetAdapter(
				XsdEntityDescriptorEnum.DerivationSet);
	}

	public void setBlock(DerivationSet block) {
		wSet(XsdFeatureDescriptorEnum.block, block);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public ComplexTypeContent getContent() {
		return wGet(XsdFeatureDescriptorEnum.content).wGetAdapter(
				XsdEntityDescriptorEnum.ComplexTypeContent);
	}

	public void setContent(ComplexTypeContent content) {
		wSet(XsdFeatureDescriptorEnum.content, content);
	}
}
