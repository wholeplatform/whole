package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ForStatement extends IJavaScriptEntity, Statement {
	public VariableDeclarationOrExpression getInit();

	public void setInit(VariableDeclarationOrExpression init);

	public Expression getTest();

	public void setTest(Expression test);

	public Expression getUpdate();

	public void setUpdate(Expression update);

	public Statement getBody();

	public void setBody(Statement body);
}
