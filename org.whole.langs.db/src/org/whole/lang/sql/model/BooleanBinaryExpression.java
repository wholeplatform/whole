package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface BooleanBinaryExpression extends ISQLEntity, BooleanExpression {
	public SQLExpression getLeftExpr();

	public void setLeftExpr(SQLExpression leftExpr);

	public BooleanOperator getOperator();

	public void setOperator(BooleanOperator operator);

	public SQLExpression getRightExpr();

	public void setRightExpr(SQLExpression rightExpr);
}
