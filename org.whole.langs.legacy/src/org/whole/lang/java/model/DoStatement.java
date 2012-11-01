package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface DoStatement extends IJavaEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Statement getBody();

	public void setBody(Statement body);
}
