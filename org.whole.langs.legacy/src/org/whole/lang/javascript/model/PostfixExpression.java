package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface PostfixExpression extends IJavaScriptEntity, UnaryExpression {
	public Expression getOperand();

	public void setOperand(Expression operand);

	public PostfixOperator getOperator();

	public void setOperator(PostfixOperator operator);
}
