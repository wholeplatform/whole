package org.whole.lang.environment.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import java.util.Date;

/** 
 * @generator Whole
 */
public class EnvironmentSpecificBuilderAdapter extends GenericBuilderContext
		implements IEnvironmentBuilder {
	public EnvironmentSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public EnvironmentSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void visit() {
	}

	public void BooleanData() {
		wEntity(EnvironmentEntityDescriptorEnum.BooleanData);
	}

	public void BooleanData(boolean value) {
		wEntity(EnvironmentEntityDescriptorEnum.BooleanData, value);
	}

	public void ByteData() {
		wEntity(EnvironmentEntityDescriptorEnum.ByteData);
	}

	public void ByteData(byte value) {
		wEntity(EnvironmentEntityDescriptorEnum.ByteData, value);
	}

	public void CharData() {
		wEntity(EnvironmentEntityDescriptorEnum.CharData);
	}

	public void CharData(char value) {
		wEntity(EnvironmentEntityDescriptorEnum.CharData, value);
	}

	public void DoubleData() {
		wEntity(EnvironmentEntityDescriptorEnum.DoubleData);
	}

	public void DoubleData(double value) {
		wEntity(EnvironmentEntityDescriptorEnum.DoubleData, value);
	}

	public void FloatData() {
		wEntity(EnvironmentEntityDescriptorEnum.FloatData);
	}

	public void FloatData(float value) {
		wEntity(EnvironmentEntityDescriptorEnum.FloatData, value);
	}

	public void IntData() {
		wEntity(EnvironmentEntityDescriptorEnum.IntData);
	}

	public void IntData(int value) {
		wEntity(EnvironmentEntityDescriptorEnum.IntData, value);
	}

	public void LongData() {
		wEntity(EnvironmentEntityDescriptorEnum.LongData);
	}

	public void LongData(long value) {
		wEntity(EnvironmentEntityDescriptorEnum.LongData, value);
	}

	public void ShortData() {
		wEntity(EnvironmentEntityDescriptorEnum.ShortData);
	}

	public void ShortData(short value) {
		wEntity(EnvironmentEntityDescriptorEnum.ShortData, value);
	}

	public void StringData() {
		wEntity(EnvironmentEntityDescriptorEnum.StringData);
	}

	public void StringData(String value) {
		wEntity(EnvironmentEntityDescriptorEnum.StringData, value);
	}

	public void DateData() {
		wEntity(EnvironmentEntityDescriptorEnum.DateData);
	}

	public void DateData(Date value) {
		wEntity(EnvironmentEntityDescriptorEnum.DateData, value);
	}

	public void DateData(String value) {
		wEntity(EnvironmentEntityDescriptorEnum.DateData, value);
	}

	public void ObjectData() {
		wEntity(EnvironmentEntityDescriptorEnum.ObjectData);
	}

	public void ObjectData(Object value) {
		wEntity(EnvironmentEntityDescriptorEnum.ObjectData, value);
	}

	public void ObjectData(String value) {
		wEntity(EnvironmentEntityDescriptorEnum.ObjectData, value);
	}

	public void Tuple() {
		wEntity(EnvironmentEntityDescriptorEnum.Tuple);
	}

	public void Tuple_() {
		wEntity_(EnvironmentEntityDescriptorEnum.Tuple);
	}

	public void Tuple_(int initialCapacity) {
		wEntity_(EnvironmentEntityDescriptorEnum.Tuple, initialCapacity);
	}

	public void _Tuple() {
		_wEntity(EnvironmentEntityDescriptorEnum.Tuple);
	}

	public void ContainmentTuple() {
		wEntity(EnvironmentEntityDescriptorEnum.ContainmentTuple);
	}

	public void ContainmentTuple_() {
		wEntity_(EnvironmentEntityDescriptorEnum.ContainmentTuple);
	}

	public void ContainmentTuple_(int initialCapacity) {
		wEntity_(EnvironmentEntityDescriptorEnum.ContainmentTuple,
				initialCapacity);
	}

	public void _ContainmentTuple() {
		_wEntity(EnvironmentEntityDescriptorEnum.ContainmentTuple);
	}

	public void Void() {
		wEntity(EnvironmentEntityDescriptorEnum.Void);
	}

	public void Void_() {
		wEntity_(EnvironmentEntityDescriptorEnum.Void);
	}

	public void _Void() {
		_wEntity(EnvironmentEntityDescriptorEnum.Void);
	}
}
