package org.whole.lang.xml.model;

/** 
 * @generator Whole
 */
public interface XMLDecl extends IXmlEntity {
	public Version getVersion();

	public void setVersion(Version version);

	public Encoding getEncoding();

	public void setEncoding(Encoding encoding);

	public Standalone getStandalone();

	public void setStandalone(Standalone standalone);
}
