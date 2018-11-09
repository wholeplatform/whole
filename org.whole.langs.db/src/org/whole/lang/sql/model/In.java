package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface In extends ISQLEntity, BooleanExpression {
	public SQLExpression getLeftExpr();

	public void setLeftExpr(SQLExpression leftExpr);

	public InPredicate getInPredicate();

	public void setInPredicate(InPredicate inPredicate);
}
