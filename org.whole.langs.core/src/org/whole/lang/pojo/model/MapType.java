package org.whole.lang.pojo.model;

/** 
 * @generator Whole
 */
public interface MapType extends IPojoEntity, Type {
	public Type getKeyType();

	public void setKeyType(Type keyType);

	public Type getValueType();

	public void setValueType(Type valueType);
}
