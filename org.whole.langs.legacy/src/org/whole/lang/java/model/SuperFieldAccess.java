package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SuperFieldAccess extends IJavaEntity, Expression {
	public Name getQualifier();

	public void setQualifier(Name qualifier);

	public SimpleName getName();

	public void setName(SimpleName name);
}
