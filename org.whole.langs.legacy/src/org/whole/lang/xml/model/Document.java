package org.whole.lang.xml.model;

/** 
 * @generator Whole
 */
public interface Document extends IXmlEntity {
	public Prolog getProlog();

	public void setProlog(Prolog prolog);

	public Element getElement();

	public void setElement(Element element);
}
