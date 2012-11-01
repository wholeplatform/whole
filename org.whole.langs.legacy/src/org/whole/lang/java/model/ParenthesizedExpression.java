package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ParenthesizedExpression extends IJavaEntity, Expression {
	public Expression getExpression();

	public void setExpression(Expression expression);
}
