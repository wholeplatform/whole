package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface VariableValue extends ISemanticsEntity, LocalIdentifier {
	public Identifier getIdentifier();

	public void setIdentifier(Identifier identifier);
}
