package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface TypedVariable extends ISemanticsEntity, AbstractVariable,
		Signature {
	public Signature getSignature();

	public void setSignature(Signature signature);
}
