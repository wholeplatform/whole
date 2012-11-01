package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ForStatement extends IJavaEntity, Statement {
	public Expressions getInitializers();

	public void setInitializers(Expressions initializers);

	public Expression getExpression();

	public void setExpression(Expression expression);

	public Expressions getUpdaters();

	public void setUpdaters(Expressions updaters);

	public Statement getBody();

	public void setBody(Statement body);
}
