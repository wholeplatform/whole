package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Subtraction extends IMathEntity, ArithmeticExpression {
	public Expression getMinuend();

	public void setMinuend(Expression minuend);

	public Expression getSubtrahend();

	public void setSubtrahend(Expression subtrahend);
}
