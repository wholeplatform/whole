package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface DeclareCursor extends ISQLEntity, ProcedureDeclaration {
	public Name getName();

	public void setName(Name name);

	public SQLStatement getSqlStatement();

	public void setSqlStatement(SQLStatement sqlStatement);
}
