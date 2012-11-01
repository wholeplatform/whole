package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface FunctionType extends ISemanticsEntity, Signature {
	public SignatureOrSequence getSource();

	public void setSource(SignatureOrSequence source);

	public SignatureOrSequence getTarget();

	public void setTarget(SignatureOrSequence target);
}
