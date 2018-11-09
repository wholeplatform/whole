package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface NotBetween extends ISQLEntity, BooleanExpression {
	public SQLExpression getExpression();

	public void setExpression(SQLExpression expression);

	public SQLExpression getLowerExpression();

	public void setLowerExpression(SQLExpression lowerExpression);

	public SQLExpression getUpperExpression();

	public void setUpperExpression(SQLExpression upperExpression);
}
