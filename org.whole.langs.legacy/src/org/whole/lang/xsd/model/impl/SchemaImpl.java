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
public class SchemaImpl extends AbstractSimpleEntity implements Schema {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Schema> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.Schema;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.Schema_ord;
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

	private AnyURI targetNamespace;

	public AnyURI getTargetNamespace() {
		return notifyRequested(XsdFeatureDescriptorEnum.targetNamespace,
				targetNamespace);
	}

	public void setTargetNamespace(AnyURI targetNamespace) {
		notifyChanged(XsdFeatureDescriptorEnum.targetNamespace,
				this.targetNamespace, this.targetNamespace = targetNamespace);
	}

	private StringData version;

	public StringData getVersion() {
		return notifyRequested(XsdFeatureDescriptorEnum.version, version);
	}

	public void setVersion(StringData version) {
		notifyChanged(XsdFeatureDescriptorEnum.version, this.version,
				this.version = version);
	}

	private XMLLanguageType language;

	public XMLLanguageType getLanguage() {
		return notifyRequested(XsdFeatureDescriptorEnum.language, language);
	}

	public void setLanguage(XMLLanguageType language) {
		notifyChanged(XsdFeatureDescriptorEnum.language, this.language,
				this.language = language);
	}

	private Qualify attributeFormDefault;

	public Qualify getAttributeFormDefault() {
		return notifyRequested(XsdFeatureDescriptorEnum.attributeFormDefault,
				attributeFormDefault);
	}

	public void setAttributeFormDefault(Qualify attributeFormDefault) {
		notifyChanged(XsdFeatureDescriptorEnum.attributeFormDefault,
				this.attributeFormDefault,
				this.attributeFormDefault = attributeFormDefault);
	}

	private Qualify elementFormDefault;

	public Qualify getElementFormDefault() {
		return notifyRequested(XsdFeatureDescriptorEnum.elementFormDefault,
				elementFormDefault);
	}

	public void setElementFormDefault(Qualify elementFormDefault) {
		notifyChanged(XsdFeatureDescriptorEnum.elementFormDefault,
				this.elementFormDefault,
				this.elementFormDefault = elementFormDefault);
	}

	private DerivationSet blockDefault;

	public DerivationSet getBlockDefault() {
		return notifyRequested(XsdFeatureDescriptorEnum.blockDefault,
				blockDefault);
	}

	public void setBlockDefault(DerivationSet blockDefault) {
		notifyChanged(XsdFeatureDescriptorEnum.blockDefault, this.blockDefault,
				this.blockDefault = blockDefault);
	}

	private DerivationSet finalDefault;

	public DerivationSet getFinalDefault() {
		return notifyRequested(XsdFeatureDescriptorEnum.finalDefault,
				finalDefault);
	}

	public void setFinalDefault(DerivationSet finalDefault) {
		notifyChanged(XsdFeatureDescriptorEnum.finalDefault, this.finalDefault,
				this.finalDefault = finalDefault);
	}

	private SchemaDirectives directives;

	public SchemaDirectives getDirectives() {
		return notifyRequested(XsdFeatureDescriptorEnum.directives, directives);
	}

	public void setDirectives(SchemaDirectives directives) {
		notifyChanged(XsdFeatureDescriptorEnum.directives, this.directives,
				this.directives = directives);
	}

	private SchemaComponents components;

	public SchemaComponents getComponents() {
		return notifyRequested(XsdFeatureDescriptorEnum.components, components);
	}

	public void setComponents(SchemaComponents components) {
		notifyChanged(XsdFeatureDescriptorEnum.components, this.components,
				this.components = components);
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
			return getTargetNamespace().wGetAdaptee(false);
		case 4:
			return getVersion().wGetAdaptee(false);
		case 5:
			return getLanguage().wGetAdaptee(false);
		case 6:
			return getAttributeFormDefault().wGetAdaptee(false);
		case 7:
			return getElementFormDefault().wGetAdaptee(false);
		case 8:
			return getBlockDefault().wGetAdaptee(false);
		case 9:
			return getFinalDefault().wGetAdaptee(false);
		case 10:
			return getDirectives().wGetAdaptee(false);
		case 11:
			return getComponents().wGetAdaptee(false);
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
			setTargetNamespace(value
					.wGetAdapter(XsdEntityDescriptorEnum.AnyURI));
			break;
		case 4:
			setVersion(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 5:
			setLanguage(value
					.wGetAdapter(XsdEntityDescriptorEnum.XMLLanguageType));
			break;
		case 6:
			setAttributeFormDefault(value
					.wGetAdapter(XsdEntityDescriptorEnum.Qualify));
			break;
		case 7:
			setElementFormDefault(value
					.wGetAdapter(XsdEntityDescriptorEnum.Qualify));
			break;
		case 8:
			setBlockDefault(value
					.wGetAdapter(XsdEntityDescriptorEnum.DerivationSet));
			break;
		case 9:
			setFinalDefault(value
					.wGetAdapter(XsdEntityDescriptorEnum.DerivationSet));
			break;
		case 10:
			setDirectives(value
					.wGetAdapter(XsdEntityDescriptorEnum.SchemaDirectives));
			break;
		case 11:
			setComponents(value
					.wGetAdapter(XsdEntityDescriptorEnum.SchemaComponents));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 12;
	}
}
