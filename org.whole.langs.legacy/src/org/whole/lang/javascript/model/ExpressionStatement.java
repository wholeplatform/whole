package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ExpressionStatement extends IJavaScriptEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);
}
