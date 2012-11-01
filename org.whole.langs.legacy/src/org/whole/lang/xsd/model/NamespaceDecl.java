package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface NamespaceDecl extends IXsdEntity {
	public Name getPrefix();

	public void setPrefix(Name prefix);

	public AnyURI getUri();

	public void setUri(AnyURI uri);
}
