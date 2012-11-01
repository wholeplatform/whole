package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface SimpleContent extends IXsdEntity, NSContainer, Annotated,
		ComplexTypeContent {
	public SimpleDerivation getDerivation();

	public void setDerivation(SimpleDerivation derivation);
}
