package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SuperMethodReference extends IJavaEntity, MethodReference {
	public Name getQualifier();

	public void setQualifier(Name qualifier);

	public Types getTypeArguments();

	public void setTypeArguments(Types typeArguments);

	public SimpleName getName();

	public void setName(SimpleName name);
}
