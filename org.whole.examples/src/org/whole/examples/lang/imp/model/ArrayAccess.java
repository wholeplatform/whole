package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface ArrayAccess extends IImpEntity, Expression {
	public Expression getArray();

	public void setArray(Expression array);

	public Expression getIndex();

	public void setIndex(Expression index);
}
