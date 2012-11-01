package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface XPathExpression extends IXsdEntity, NSContainer, Annotated {
	public XPath getXpath();

	public void setXpath(XPath xpath);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
