package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface StaticMemberExpression extends IJavaScriptEntity,
		MemberExpression {
	public IdentifierOrXmlAny getProperty();

	public void setProperty(IdentifierOrXmlAny property);
}
