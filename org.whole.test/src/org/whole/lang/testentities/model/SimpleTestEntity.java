package org.whole.lang.testentities.model;

/** 
 * @generator Whole
 */
public interface SimpleTestEntity extends ITestEntitiesEntity,
		IStructuralEntity, ITestEntity {
	public ITestEntity getAnyEntityValue();

	public void setAnyEntityValue(ITestEntity anyEntityValue);

	public IStructuralEntity getStructuralEntityValue();

	public void setStructuralEntityValue(IStructuralEntity structuralEntityValue);

	public ICompositeEntity getCompositeEntityValue();

	public void setCompositeEntityValue(ICompositeEntity compositeEntityValue);

	public IDataEntity getDataEntityValue();

	public void setDataEntityValue(IDataEntity dataEntityValue);

	public BooleanTestEntity getBooleanValue();

	public void setBooleanValue(BooleanTestEntity booleanValue);

	public ByteTestEntity getByteValue();

	public void setByteValue(ByteTestEntity byteValue);

	public CharTestEntity getCharValue();

	public void setCharValue(CharTestEntity charValue);

	public DoubleTestEntity getDoubleValue();

	public void setDoubleValue(DoubleTestEntity doubleValue);

	public FloatTestEntity getFloatValue();

	public void setFloatValue(FloatTestEntity floatValue);

	public IntTestEntity getIntValue();

	public void setIntValue(IntTestEntity intValue);

	public LongTestEntity getLongValue();

	public void setLongValue(LongTestEntity longValue);

	public ShortTestEntity getShortValue();

	public void setShortValue(ShortTestEntity shortValue);

	public StringTestEntity getStringValue();

	public void setStringValue(StringTestEntity stringValue);

	public DateTestEntity getDateValue();

	public void setDateValue(DateTestEntity dateValue);

	public EnumTestEntity getEnumValue();

	public void setEnumValue(EnumTestEntity enumValue);

	public ObjectTestEntity getObjectValue();

	public void setObjectValue(ObjectTestEntity objectValue);
}
