package org.whole.lang.xsd.mapping.model;

/** 
 * @generator Whole
 */
public interface CustomDataType extends IMappingEntity, DataType {
	public BuiltInType getBuiltInType();

	public void setBuiltInType(BuiltInType builtInType);
}
