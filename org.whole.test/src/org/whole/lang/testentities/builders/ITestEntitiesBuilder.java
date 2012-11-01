package org.whole.lang.testentities.builders;

import org.whole.lang.builders.IBuilder;
import java.util.Date;
import org.whole.lang.testentities.model.EnumTestEntityEnum;

/** 
 * @generator Whole
 */
public interface ITestEntitiesBuilder extends IBuilder {
	public void visit();

	public void objectValue();

	public void enumValue();

	public void dateValue();

	public void stringValue();

	public void shortValue();

	public void longValue();

	public void intValue();

	public void floatValue();

	public void doubleValue();

	public void charValue();

	public void byteValue();

	public void booleanValue();

	public void dataEntityValue();

	public void compositeEntityValue();

	public void structuralEntityValue();

	public void anyEntityValue();

	public void SimpleTestEntity();

	public void SimpleTestEntity_();

	public void _SimpleTestEntity();

	public void ListTestEntity();

	public void ListTestEntity_();

	public void ListTestEntity_(int initialCapacity);

	public void _ListTestEntity();

	public void UListTestEntity();

	public void UListTestEntity_();

	public void UListTestEntity_(int initialCapacity);

	public void _UListTestEntity();

	public void SetTestEntity();

	public void SetTestEntity_();

	public void SetTestEntity_(int initialCapacity);

	public void _SetTestEntity();

	public void BagTestEntity();

	public void BagTestEntity_();

	public void BagTestEntity_(int initialCapacity);

	public void _BagTestEntity();

	public void MapTestEntity();

	public void BooleanTestEntity();

	public void BooleanTestEntity(boolean value);

	public void ByteTestEntity();

	public void ByteTestEntity(byte value);

	public void CharTestEntity();

	public void CharTestEntity(char value);

	public void DoubleTestEntity();

	public void DoubleTestEntity(double value);

	public void FloatTestEntity();

	public void FloatTestEntity(float value);

	public void IntTestEntity();

	public void IntTestEntity(int value);

	public void LongTestEntity();

	public void LongTestEntity(long value);

	public void ShortTestEntity();

	public void ShortTestEntity(short value);

	public void StringTestEntity();

	public void StringTestEntity(String value);

	public void DateTestEntity();

	public void DateTestEntity(Date value);

	public void DateTestEntity(String value);

	public void EnumTestEntity();

	public void EnumTestEntity(EnumTestEntityEnum.Value value);

	public void EnumTestEntity(String value);

	public void ObjectTestEntity();

	public void ObjectTestEntity(Object value);

	public void ObjectTestEntity(String value);
}
