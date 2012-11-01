package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Root extends IMathEntity, ArithmeticExpression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Expression getDegree();

	public void setDegree(Expression degree);
}
