package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface PrefixExpression extends IJavaScriptEntity, UnaryExpression {
	public PrefixOperator getOperator();

	public void setOperator(PrefixOperator operator);

	public Expression getOperand();

	public void setOperand(Expression operand);
}
