package org.whole.lang.xml.model;

/** 
 * @generator Whole
 */
public interface PublicId extends IXmlEntity, IExternalId {
	public PubidLiteral getPubidLiteral();

	public void setPubidLiteral(PubidLiteral pubidLiteral);

	public SystemLiteral getSystemLiteral();

	public void setSystemLiteral(SystemLiteral systemLiteral);
}
