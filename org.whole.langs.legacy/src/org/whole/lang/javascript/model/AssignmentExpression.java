package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface AssignmentExpression extends IJavaScriptEntity,
		BinaryExpression {
	public Expression getLeft();

	public void setLeft(Expression left);

	public AssignmentOperator getOperator();

	public void setOperator(AssignmentOperator operator);

	public Expression getRight();

	public void setRight(Expression right);
}
