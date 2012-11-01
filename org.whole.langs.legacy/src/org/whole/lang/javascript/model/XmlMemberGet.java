package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface XmlMemberGet extends IJavaScriptEntity, BinaryExpression {
	public Expression getLeft();

	public void setLeft(Expression left);

	public XmlMemberOperator getOperator();

	public void setOperator(XmlMemberOperator operator);

	public Expression getRight();

	public void setRight(Expression right);
}
