package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface InstanceofExpression extends IJavaEntity, Expression {
	public Expression getLeftOperand();

	public void setLeftOperand(Expression leftOperand);

	public Type getRightOperand();

	public void setRightOperand(Type rightOperand);
}
