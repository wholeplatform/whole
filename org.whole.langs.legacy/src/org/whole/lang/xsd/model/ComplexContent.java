package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface ComplexContent extends IXsdEntity, NSContainer, Annotated,
		ComplexTypeContent {
	public BooleanData getMixed();

	public void setMixed(BooleanData mixed);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public ComplexDerivation getDerivation();

	public void setDerivation(ComplexDerivation derivation);
}
