package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface WhileStatement extends IJavaScriptEntity, Statement {
	public Expression getTest();

	public void setTest(Expression test);

	public Statement getBody();

	public void setBody(Statement body);
}
