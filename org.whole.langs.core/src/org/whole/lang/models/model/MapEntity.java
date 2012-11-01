package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface MapEntity extends IModelsEntity, ModelDeclaration {
	public Type getKeyType();

	public void setKeyType(Type keyType);

	public Type getValueType();

	public void setValueType(Type valueType);
}
