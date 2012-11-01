package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface XmlRef extends IJavaScriptEntity, Expression {
	public BooleanData getAttribute();

	public void setAttribute(BooleanData attribute);

	public IdentifierOrXmlAny getNamespace();

	public void setNamespace(IdentifierOrXmlAny namespace);
}
