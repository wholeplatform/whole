package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface WhenClause extends ISQLEntity {
	public BooleanExpression getCondition();

	public void setCondition(BooleanExpression condition);

	public SQLExpression getResult();

	public void setResult(SQLExpression result);
}
