package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Schema extends IXsdEntity, NSContainer {
	public AnyURI getTargetNamespace();

	public void setTargetNamespace(AnyURI targetNamespace);

	public StringData getVersion();

	public void setVersion(StringData version);

	public XMLLanguageType getLanguage();

	public void setLanguage(XMLLanguageType language);

	public Qualify getAttributeFormDefault();

	public void setAttributeFormDefault(Qualify attributeFormDefault);

	public Qualify getElementFormDefault();

	public void setElementFormDefault(Qualify elementFormDefault);

	public DerivationSet getBlockDefault();

	public void setBlockDefault(DerivationSet blockDefault);

	public DerivationSet getFinalDefault();

	public void setFinalDefault(DerivationSet finalDefault);

	public SchemaDirectives getDirectives();

	public void setDirectives(SchemaDirectives directives);

	public SchemaComponents getComponents();

	public void setComponents(SchemaComponents components);
}
