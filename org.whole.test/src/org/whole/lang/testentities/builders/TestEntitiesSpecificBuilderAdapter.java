package org.whole.lang.testentities.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.testentities.reflect.TestEntitiesFeatureDescriptorEnum;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import java.util.Date;
import org.whole.lang.testentities.model.EnumTestEntityEnum;

/** 
 * @generator Whole
 */
public class TestEntitiesSpecificBuilderAdapter extends GenericBuilderContext
		implements ITestEntitiesBuilder {
	public TestEntitiesSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public TestEntitiesSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void objectValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.objectValue);
	}

	public void enumValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.enumValue);
	}

	public void dateValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.dateValue);
	}

	public void stringValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.stringValue);
	}

	public void shortValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.shortValue);
	}

	public void longValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.longValue);
	}

	public void intValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.intValue);
	}

	public void floatValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.floatValue);
	}

	public void doubleValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.doubleValue);
	}

	public void charValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.charValue);
	}

	public void byteValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.byteValue);
	}

	public void booleanValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.booleanValue);
	}

	public void dataEntityValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.dataEntityValue);
	}

	public void compositeEntityValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.compositeEntityValue);
	}

	public void structuralEntityValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.structuralEntityValue);
	}

	public void anyEntityValue() {
		wFeature(TestEntitiesFeatureDescriptorEnum.anyEntityValue);
	}

	public void visit() {
	}

	public void SimpleTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
	}

	public void SimpleTestEntity_() {
		wEntity_(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
	}

	public void _SimpleTestEntity() {
		_wEntity(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
	}

	public void ListTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.ListTestEntity);
	}

	public void ListTestEntity_() {
		wEntity_(TestEntitiesEntityDescriptorEnum.ListTestEntity);
	}

	public void ListTestEntity_(int initialCapacity) {
		wEntity_(TestEntitiesEntityDescriptorEnum.ListTestEntity,
				initialCapacity);
	}

	public void _ListTestEntity() {
		_wEntity(TestEntitiesEntityDescriptorEnum.ListTestEntity);
	}

	public void UListTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.UListTestEntity);
	}

	public void UListTestEntity_() {
		wEntity_(TestEntitiesEntityDescriptorEnum.UListTestEntity);
	}

	public void UListTestEntity_(int initialCapacity) {
		wEntity_(TestEntitiesEntityDescriptorEnum.UListTestEntity,
				initialCapacity);
	}

	public void _UListTestEntity() {
		_wEntity(TestEntitiesEntityDescriptorEnum.UListTestEntity);
	}

	public void SetTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.SetTestEntity);
	}

	public void SetTestEntity_() {
		wEntity_(TestEntitiesEntityDescriptorEnum.SetTestEntity);
	}

	public void SetTestEntity_(int initialCapacity) {
		wEntity_(TestEntitiesEntityDescriptorEnum.SetTestEntity,
				initialCapacity);
	}

	public void _SetTestEntity() {
		_wEntity(TestEntitiesEntityDescriptorEnum.SetTestEntity);
	}

	public void BagTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.BagTestEntity);
	}

	public void BagTestEntity_() {
		wEntity_(TestEntitiesEntityDescriptorEnum.BagTestEntity);
	}

	public void BagTestEntity_(int initialCapacity) {
		wEntity_(TestEntitiesEntityDescriptorEnum.BagTestEntity,
				initialCapacity);
	}

	public void _BagTestEntity() {
		_wEntity(TestEntitiesEntityDescriptorEnum.BagTestEntity);
	}

	public void MapTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.MapTestEntity);
	}

	public void BooleanTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.BooleanTestEntity);
	}

	public void BooleanTestEntity(boolean value) {
		wEntity(TestEntitiesEntityDescriptorEnum.BooleanTestEntity, value);
	}

	public void ByteTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.ByteTestEntity);
	}

	public void ByteTestEntity(byte value) {
		wEntity(TestEntitiesEntityDescriptorEnum.ByteTestEntity, value);
	}

	public void CharTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.CharTestEntity);
	}

	public void CharTestEntity(char value) {
		wEntity(TestEntitiesEntityDescriptorEnum.CharTestEntity, value);
	}

	public void DoubleTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.DoubleTestEntity);
	}

	public void DoubleTestEntity(double value) {
		wEntity(TestEntitiesEntityDescriptorEnum.DoubleTestEntity, value);
	}

	public void FloatTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.FloatTestEntity);
	}

	public void FloatTestEntity(float value) {
		wEntity(TestEntitiesEntityDescriptorEnum.FloatTestEntity, value);
	}

	public void IntTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.IntTestEntity);
	}

	public void IntTestEntity(int value) {
		wEntity(TestEntitiesEntityDescriptorEnum.IntTestEntity, value);
	}

	public void LongTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.LongTestEntity);
	}

	public void LongTestEntity(long value) {
		wEntity(TestEntitiesEntityDescriptorEnum.LongTestEntity, value);
	}

	public void ShortTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.ShortTestEntity);
	}

	public void ShortTestEntity(short value) {
		wEntity(TestEntitiesEntityDescriptorEnum.ShortTestEntity, value);
	}

	public void StringTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.StringTestEntity);
	}

	public void StringTestEntity(String value) {
		wEntity(TestEntitiesEntityDescriptorEnum.StringTestEntity, value);
	}

	public void DateTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.DateTestEntity);
	}

	public void DateTestEntity(Date value) {
		wEntity(TestEntitiesEntityDescriptorEnum.DateTestEntity, value);
	}

	public void DateTestEntity(String value) {
		wEntity(TestEntitiesEntityDescriptorEnum.DateTestEntity, value);
	}

	public void EnumTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.EnumTestEntity);
	}

	public void EnumTestEntity(EnumTestEntityEnum.Value value) {
		wEntity(TestEntitiesEntityDescriptorEnum.EnumTestEntity, value);
	}

	public void EnumTestEntity(String value) {
		wEntity(TestEntitiesEntityDescriptorEnum.EnumTestEntity, value);
	}

	public void ObjectTestEntity() {
		wEntity(TestEntitiesEntityDescriptorEnum.ObjectTestEntity);
	}

	public void ObjectTestEntity(Object value) {
		wEntity(TestEntitiesEntityDescriptorEnum.ObjectTestEntity, value);
	}

	public void ObjectTestEntity(String value) {
		wEntity(TestEntitiesEntityDescriptorEnum.ObjectTestEntity, value);
	}
}
