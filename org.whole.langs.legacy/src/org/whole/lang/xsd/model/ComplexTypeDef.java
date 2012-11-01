package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface ComplexTypeDef extends IXsdEntity, TypeDef, Annotated {
	public BooleanData getAbstract();

	public void setAbstract(BooleanData _abstract);

	public BooleanData getMixed();

	public void setMixed(BooleanData mixed);

	public DerivationSet getBlock();

	public void setBlock(DerivationSet block);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public ComplexTypeContent getContent();

	public void setContent(ComplexTypeContent content);
}
