package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface PrefixExpression extends IJavaEntity, Expression {
	public PrefixOperator getOperator();

	public void setOperator(PrefixOperator operator);

	public Expression getOperand();

	public void setOperand(Expression operand);
}
