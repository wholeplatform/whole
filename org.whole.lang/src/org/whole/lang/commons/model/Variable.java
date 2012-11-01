package org.whole.lang.commons.model;

/** 
 * @generator Whole
 */
public interface Variable extends ICommonsEntity, Any {
	public VarType getVarType();

	public void setVarType(VarType varType);

	public VarName getVarName();

	public void setVarName(VarName varName);

	public Quantifier getQuantifier();

	public void setQuantifier(Quantifier quantifier);
}
