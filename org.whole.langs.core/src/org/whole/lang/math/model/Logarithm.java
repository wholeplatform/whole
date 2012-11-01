package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Logarithm extends IMathEntity, Expression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Expression getBase();

	public void setBase(Expression base);
}
