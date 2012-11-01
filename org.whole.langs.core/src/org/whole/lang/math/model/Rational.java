package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Rational extends IMathEntity, Number {
	public IntegerNumber getNumerator();

	public void setNumerator(IntegerNumber numerator);

	public IntegerNumber getDenominator();

	public void setDenominator(IntegerNumber denominator);
}
