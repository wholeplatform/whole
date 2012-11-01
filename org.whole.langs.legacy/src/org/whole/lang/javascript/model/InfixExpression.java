package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface InfixExpression extends IJavaScriptEntity, BinaryExpression {
	public Expression getLeft();

	public void setLeft(Expression left);

	public InfixOperator getOperator();

	public void setOperator(InfixOperator operator);

	public Expression getRight();

	public void setRight(Expression right);
}
