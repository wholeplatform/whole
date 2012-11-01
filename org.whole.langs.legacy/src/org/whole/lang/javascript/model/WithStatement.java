package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface WithStatement extends IJavaScriptEntity, Statement {
	public Expression getObject();

	public void setObject(Expression object);

	public Statement getBody();

	public void setBody(Statement body);
}
