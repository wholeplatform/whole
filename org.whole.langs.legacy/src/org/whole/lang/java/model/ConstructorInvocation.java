package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ConstructorInvocation extends IJavaEntity, Statement {
	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
