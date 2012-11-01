package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ExpressionStatement extends IJavaEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);
}
