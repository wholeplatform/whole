package org.whole.lang.types.model;

/** 
 * @generator Whole
 */
public interface Supertype extends ITypesEntity, TypeExpression {
	public VariableType getName();

	public void setName(VariableType name);

	public VariableType getType();

	public void setType(VariableType type);
}
