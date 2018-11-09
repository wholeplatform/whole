package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface BinaryExpression extends ISQLEntity, SQLExpression {
	public SQLExpression getLeftExpr();

	public void setLeftExpr(SQLExpression leftExpr);

	public BinaryOperator getOperator();

	public void setOperator(BinaryOperator operator);

	public SQLExpression getRightExpr();

	public void setRightExpr(SQLExpression rightExpr);
}
