package org.whole.lang.models.model;

/** 
 * @generator Whole
 */
public interface EnumEntity extends IModelsEntity, ModelDeclaration {
	public EnumValues getValues();

	public void setValues(EnumValues values);
}
