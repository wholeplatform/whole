package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface UnaryExpression extends IJavaScriptEntity, Expression {
	public Expression getOperand();

	public void setOperand(Expression operand);
}
