package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface Annotation extends IJavaEntity, ExtendedModifier, Expression {
	public Name getTypeName();

	public void setTypeName(Name typeName);
}
