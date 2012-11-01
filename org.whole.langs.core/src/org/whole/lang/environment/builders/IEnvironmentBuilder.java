package org.whole.lang.environment.builders;

import org.whole.lang.builders.IBuilder;
import java.util.Date;

/** 
 * @generator Whole
 */
public interface IEnvironmentBuilder extends IBuilder {
	public void visit();

	public void BooleanData();

	public void BooleanData(boolean value);

	public void ByteData();

	public void ByteData(byte value);

	public void CharData();

	public void CharData(char value);

	public void DoubleData();

	public void DoubleData(double value);

	public void FloatData();

	public void FloatData(float value);

	public void IntData();

	public void IntData(int value);

	public void LongData();

	public void LongData(long value);

	public void ShortData();

	public void ShortData(short value);

	public void StringData();

	public void StringData(String value);

	public void DateData();

	public void DateData(Date value);

	public void DateData(String value);

	public void ObjectData();

	public void ObjectData(Object value);

	public void ObjectData(String value);

	public void Tuple();

	public void Tuple_();

	public void Tuple_(int initialCapacity);

	public void _Tuple();

	public void ContainmentTuple();

	public void ContainmentTuple_();

	public void ContainmentTuple_(int initialCapacity);

	public void _ContainmentTuple();

	public void Void();

	public void Void_();

	public void _Void();
}
