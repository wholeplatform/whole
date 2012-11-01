package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Is extends ISQLEntity, BooleanExpression {
	public SQLExpression getExpression();

	public void setExpression(SQLExpression expression);

	public IsType getType();

	public void setType(IsType type);
}
