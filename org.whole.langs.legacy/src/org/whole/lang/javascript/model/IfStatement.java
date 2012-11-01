package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface IfStatement extends IJavaScriptEntity, Statement {
	public Expression getTest();

	public void setTest(Expression test);

	public Statement getConsequent();

	public void setConsequent(Statement consequent);

	public Statement getAlternate();

	public void setAlternate(Statement alternate);
}
