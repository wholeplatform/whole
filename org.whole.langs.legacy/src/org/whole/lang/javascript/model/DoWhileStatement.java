package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface DoWhileStatement extends IJavaScriptEntity, Statement {
	public Statement getBody();

	public void setBody(Statement body);

	public Expression getTest();

	public void setTest(Expression test);
}
