package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface StringFacet extends IXsdEntity, Facet {
	public StringData getValue();

	public void setValue(StringData value);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
