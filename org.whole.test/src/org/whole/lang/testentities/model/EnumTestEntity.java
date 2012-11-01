package org.whole.lang.testentities.model;

/** 
 * @generator Whole
 */
public interface EnumTestEntity extends ITestEntitiesEntity, IDataEntity,
		ITestEntity {
	public org.whole.lang.testentities.model.EnumTestEntityEnum.Value getValue();

	public void setValue(
			org.whole.lang.testentities.model.EnumTestEntityEnum.Value value);
}
