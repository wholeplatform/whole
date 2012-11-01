package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ForEachIn extends IJavaScriptEntity, Statement {
	public VariableDeclarationOrExpression getIterator();

	public void setIterator(VariableDeclarationOrExpression iterator);

	public Expression getIterated();

	public void setIterated(Expression iterated);

	public Statement getBody();

	public void setBody(Statement body);
}
