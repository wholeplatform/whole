package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface CastExpression extends IJavaEntity, Expression {
	public Type getType();

	public void setType(Type type);

	public Expression getExpression();

	public void setExpression(Expression expression);
}
