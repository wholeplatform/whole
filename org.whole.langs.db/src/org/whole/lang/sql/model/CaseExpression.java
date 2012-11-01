package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface CaseExpression extends ISQLEntity, SQLExpression {
	public WhenClauses getWhenClauses();

	public void setWhenClauses(WhenClauses whenClauses);

	public SQLExpression getElseClause();

	public void setElseClause(SQLExpression elseClause);
}
