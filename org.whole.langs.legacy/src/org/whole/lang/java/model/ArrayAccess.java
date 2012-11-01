package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ArrayAccess extends IJavaEntity, Expression {
	public Expression getArray();

	public void setArray(Expression array);

	public Expression getIndex();

	public void setIndex(Expression index);
}
