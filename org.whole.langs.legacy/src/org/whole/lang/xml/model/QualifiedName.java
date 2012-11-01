package org.whole.lang.xml.model;

/** 
 * @generator Whole
 */
public interface QualifiedName extends IXmlEntity, IName {
	public NameSpace getNameSpace();

	public void setNameSpace(NameSpace nameSpace);

	public Name getName();

	public void setName(Name name);
}
