package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ParenthesizedExpression extends ISQLEntity, SQLExpression {
	public SQLExpression getExpression();

	public void setExpression(SQLExpression expression);
}
