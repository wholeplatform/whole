package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface SimpleVariableDeclaration extends ISQLEntity, ProcedureDeclaration {
	public Name getName();

	public void setName(Name name);

	public Type getType();

	public void setType(Type type);
}
