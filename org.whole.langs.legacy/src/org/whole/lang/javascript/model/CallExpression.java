package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface CallExpression extends IJavaScriptEntity, Expression {
	public Expression getCallee();

	public void setCallee(Expression callee);

	public Expressions getArguments();

	public void setArguments(Expressions arguments);
}
