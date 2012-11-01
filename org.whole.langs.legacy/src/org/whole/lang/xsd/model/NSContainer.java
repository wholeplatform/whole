package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface NSContainer extends IXsdEntity {
	public NamespaceDecls getNamespaces();

	public void setNamespaces(NamespaceDecls namespaces);

	public StringData getId();

	public void setId(StringData id);

	public Attributes getAttributes();

	public void setAttributes(Attributes attributes);
}
