package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface DataEntity extends IModelsEntity, ModelDeclaration {
	public DataType getDataType();

	public void setDataType(DataType dataType);
}
