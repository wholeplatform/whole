package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Exponentiation extends IMathEntity, ArithmeticExpression {
	public Expression getBase();

	public void setBase(Expression base);

	public Expression getExponent();

	public void setExponent(Expression exponent);
}
