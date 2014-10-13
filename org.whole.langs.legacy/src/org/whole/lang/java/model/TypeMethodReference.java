package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface TypeMethodReference extends IJavaEntity, MethodReference {
	public Type getType();

	public void setType(Type type);

	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);

	public SimpleName getName();

	public void setName(SimpleName name);
}
