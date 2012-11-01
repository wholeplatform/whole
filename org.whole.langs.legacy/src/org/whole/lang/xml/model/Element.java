package org.whole.lang.xml.model;

/** 
 * @generator Whole
 */
public interface Element extends IXmlEntity, IContent {
	public IName getTag();

	public void setTag(IName tag);

	public Attributes getAttributes();

	public void setAttributes(Attributes attributes);

	public IContent getContent();

	public void setContent(IContent content);
}
