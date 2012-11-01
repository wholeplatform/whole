package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface Assignment extends IJavaEntity, Expression {
	public Expression getLeftHandSide();

	public void setLeftHandSide(Expression leftHandSide);

	public AssignmentOperator getOperator();

	public void setOperator(AssignmentOperator operator);

	public Expression getRightHandSide();

	public void setRightHandSide(Expression rightHandSide);
}
