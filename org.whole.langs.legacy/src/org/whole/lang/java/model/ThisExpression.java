package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ThisExpression extends IJavaEntity, Expression {
	public Name getQualifier();

	public void setQualifier(Name qualifier);
}
