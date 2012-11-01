package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface SemanticFunction extends ISemanticsEntity {
	public Name getName();

	public void setName(Name name);

	public FunctionType getSignature();

	public void setSignature(FunctionType signature);

	public FunctionBody getRules();

	public void setRules(FunctionBody rules);
}
