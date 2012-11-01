package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface SequenceType extends ISemanticsEntity, SignatureOrSequence {
	public Signature getSignature();

	public void setSignature(Signature signature);
}
