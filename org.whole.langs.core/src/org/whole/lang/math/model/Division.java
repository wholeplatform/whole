package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Division extends IMathEntity, ArithmeticExpression {
	public Expression getDividend();

	public void setDividend(Expression dividend);

	public Expression getDivisor();

	public void setDivisor(Expression divisor);
}
