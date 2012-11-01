package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface EnhancedForStatement extends IJavaEntity, Statement {
	public SingleVariableDeclaration getParameter();

	public void setParameter(SingleVariableDeclaration parameter);

	public Expression getExpression();

	public void setExpression(Expression expression);

	public Statement getBody();

	public void setBody(Statement body);
}
