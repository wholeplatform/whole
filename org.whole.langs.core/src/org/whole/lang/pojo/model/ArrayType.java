package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface ArrayType extends IPojoEntity, Type {
	public Type getElementType();

	public void setElementType(Type elementType);
}
