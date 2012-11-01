package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface IntegerFacet extends IXsdEntity, FixedFacet {
	public IntegerData getValue();

	public void setValue(IntegerData value);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
