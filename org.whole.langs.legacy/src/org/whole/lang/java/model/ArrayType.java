package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface ArrayType extends IJavaEntity, Type {
	public Type getComponentType();

	public void setComponentType(Type componentType);
}
