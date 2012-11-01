package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface SwitchCase extends IJavaScriptEntity {
	public Expression getTest();

	public void setTest(Expression test);

	public Statements getStatements();

	public void setStatements(Statements statements);
}
