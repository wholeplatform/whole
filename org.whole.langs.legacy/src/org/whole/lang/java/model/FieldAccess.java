package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface FieldAccess extends IJavaEntity, Expression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public SimpleName getName();

	public void setName(SimpleName name);
}
