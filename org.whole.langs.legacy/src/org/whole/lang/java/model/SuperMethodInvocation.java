package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SuperMethodInvocation extends IJavaEntity, Expression {
	public Name getQualifier();

	public void setQualifier(Name qualifier);

	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);

	public SimpleName getName();

	public void setName(SimpleName name);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
