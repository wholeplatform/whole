package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface AttributeUseRef extends IXsdEntity, Reference, AttributeUse,
		Annotated {
	public StringData getDefaultValue();

	public void setDefaultValue(StringData defaultValue);

	public StringData getFixedValue();

	public void setFixedValue(StringData fixedValue);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
