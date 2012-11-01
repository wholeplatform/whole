package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface ShiftExpression extends IMathEntity, BitwiseExpression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Expression getBits();

	public void setBits(Expression bits);
}
