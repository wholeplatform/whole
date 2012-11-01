package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Implies extends IMathEntity, LogicExpression {
	public Expression getExp1();

	public void setExp1(Expression exp1);

	public Expression getExp2();

	public void setExp2(Expression exp2);
}
