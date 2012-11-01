package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface ApproximatelyEqual extends IMathEntity, RelationalExpression {
	public Expression getExp1();

	public void setExp1(Expression exp1);

	public Expression getExp2();

	public void setExp2(Expression exp2);
}
