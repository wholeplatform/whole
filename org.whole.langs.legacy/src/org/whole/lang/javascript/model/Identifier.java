package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface Identifier extends IJavaScriptEntity, Expression,
		LiteralOrIdentifier, IdentifierOrXmlAny {
	public String getValue();

	public void setValue(String value);
}
