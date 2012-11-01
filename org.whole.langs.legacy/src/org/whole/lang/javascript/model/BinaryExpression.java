package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface BinaryExpression extends IJavaScriptEntity, Expression {
	public Expression getLeft();

	public void setLeft(Expression left);

	public Expression getRight();

	public void setRight(Expression right);
}
