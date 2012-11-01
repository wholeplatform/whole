package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface AssertStatement extends IJavaEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Expression getMessage();

	public void setMessage(Expression message);
}
