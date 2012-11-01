package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface PostfixExpression extends IJavaEntity, Expression {
	public Expression getOperand();

	public void setOperand(Expression operand);

	public PostfixOperator getOperator();

	public void setOperator(PostfixOperator operator);
}
