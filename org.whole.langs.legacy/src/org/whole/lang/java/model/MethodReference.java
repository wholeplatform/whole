package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface MethodReference extends IJavaEntity, Expression {
	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);
}
