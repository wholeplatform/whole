package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface MethodInvocation extends IJavaEntity, Expression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);

	public SimpleName getName();

	public void setName(SimpleName name);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
