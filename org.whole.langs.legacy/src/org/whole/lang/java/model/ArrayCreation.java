package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ArrayCreation extends IJavaEntity, Expression {
	public ArrayType getType();

	public void setType(ArrayType type);

	public Expressions getDimensions();

	public void setDimensions(Expressions dimensions);

	public ArrayInitializer getInitializer();

	public void setInitializer(ArrayInitializer initializer);
}
