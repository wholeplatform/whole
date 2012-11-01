package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ConditionalExpression extends IJavaEntity, Expression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Expression getThenExpression();

	public void setThenExpression(Expression thenExpression);

	public Expression getElseExpression();

	public void setElseExpression(Expression elseExpression);
}
