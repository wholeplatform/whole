package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface SwitchStatement extends IJavaScriptEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public SwitchCases getCases();

	public void setCases(SwitchCases cases);
}
