package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ClassInstanceCreation extends IJavaEntity, Expression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);

	public Type getType();

	public void setType(Type type);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);

	public AnonymousClassDeclaration getAnonymousClassDeclaration();

	public void setAnonymousClassDeclaration(
			AnonymousClassDeclaration anonymousClassDeclaration);
}
