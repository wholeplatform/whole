package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SuperConstructorInvocation extends IJavaEntity, Statement {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
