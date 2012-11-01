package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface NewExpression extends IJavaScriptEntity, Expression {
	public Expression getConstructor();

	public void setConstructor(Expression constructor);

	public Expressions getArguments();

	public void setArguments(Expressions arguments);
}
