package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ParameterizedType extends IJavaEntity, Type {
	public Type getType();

	public void setType(Type type);

	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);
}
