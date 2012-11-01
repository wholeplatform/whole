package org.whole.lang.xml.model;

/** 
 * @generator Whole
 */
public interface Prolog extends IXmlEntity {
	public XMLDecl getXmlDecl();

	public void setXmlDecl(XMLDecl xmlDecl);

	public DocTypeDecl getDocTypeDecl();

	public void setDocTypeDecl(DocTypeDecl docTypeDecl);

	public Misc getMisc();

	public void setMisc(Misc misc);
}
