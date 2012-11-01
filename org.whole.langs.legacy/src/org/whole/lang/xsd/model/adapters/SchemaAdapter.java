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
public class SchemaAdapter extends AbstractEntityAdapter implements Schema {
	private static final long serialVersionUID = 1;

	public SchemaAdapter(IEntity implementor) {
		super(implementor);
	}

	public SchemaAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Schema> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Schema;
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

	public AnyURI getTargetNamespace() {
		return wGet(XsdFeatureDescriptorEnum.targetNamespace).wGetAdapter(
				XsdEntityDescriptorEnum.AnyURI);
	}

	public void setTargetNamespace(AnyURI targetNamespace) {
		wSet(XsdFeatureDescriptorEnum.targetNamespace, targetNamespace);
	}

	public StringData getVersion() {
		return wGet(XsdFeatureDescriptorEnum.version).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setVersion(StringData version) {
		wSet(XsdFeatureDescriptorEnum.version, version);
	}

	public XMLLanguageType getLanguage() {
		return wGet(XsdFeatureDescriptorEnum.language).wGetAdapter(
				XsdEntityDescriptorEnum.XMLLanguageType);
	}

	public void setLanguage(XMLLanguageType language) {
		wSet(XsdFeatureDescriptorEnum.language, language);
	}

	public Qualify getAttributeFormDefault() {
		return wGet(XsdFeatureDescriptorEnum.attributeFormDefault).wGetAdapter(
				XsdEntityDescriptorEnum.Qualify);
	}

	public void setAttributeFormDefault(Qualify attributeFormDefault) {
		wSet(XsdFeatureDescriptorEnum.attributeFormDefault,
				attributeFormDefault);
	}

	public Qualify getElementFormDefault() {
		return wGet(XsdFeatureDescriptorEnum.elementFormDefault).wGetAdapter(
				XsdEntityDescriptorEnum.Qualify);
	}

	public void setElementFormDefault(Qualify elementFormDefault) {
		wSet(XsdFeatureDescriptorEnum.elementFormDefault, elementFormDefault);
	}

	public DerivationSet getBlockDefault() {
		return wGet(XsdFeatureDescriptorEnum.blockDefault).wGetAdapter(
				XsdEntityDescriptorEnum.DerivationSet);
	}

	public void setBlockDefault(DerivationSet blockDefault) {
		wSet(XsdFeatureDescriptorEnum.blockDefault, blockDefault);
	}

	public DerivationSet getFinalDefault() {
		return wGet(XsdFeatureDescriptorEnum.finalDefault).wGetAdapter(
				XsdEntityDescriptorEnum.DerivationSet);
	}

	public void setFinalDefault(DerivationSet finalDefault) {
		wSet(XsdFeatureDescriptorEnum.finalDefault, finalDefault);
	}

	public SchemaDirectives getDirectives() {
		return wGet(XsdFeatureDescriptorEnum.directives).wGetAdapter(
				XsdEntityDescriptorEnum.SchemaDirectives);
	}

	public void setDirectives(SchemaDirectives directives) {
		wSet(XsdFeatureDescriptorEnum.directives, directives);
	}

	public SchemaComponents getComponents() {
		return wGet(XsdFeatureDescriptorEnum.components).wGetAdapter(
				XsdEntityDescriptorEnum.SchemaComponents);
	}

	public void setComponents(SchemaComponents components) {
		wSet(XsdFeatureDescriptorEnum.components, components);
	}
}
