package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface IfStatement extends IJavaEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Statement getThenStatement();

	public void setThenStatement(Statement thenStatement);

	public Statement getElseStatement();

	public void setElseStatement(Statement elseStatement);
}
