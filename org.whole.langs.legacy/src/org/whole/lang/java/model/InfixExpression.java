package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface InfixExpression extends IJavaEntity, Expression {
	public Expression getLeftOperand();

	public void setLeftOperand(Expression leftOperand);

	public InfixOperator getOperator();

	public void setOperator(InfixOperator operator);

	public Expression getRightOperand();

	public void setRightOperand(Expression rightOperand);

	public Expressions getExtendedOperands();

	public void setExtendedOperands(Expressions extendedOperands);
}
