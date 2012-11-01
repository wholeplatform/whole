package org.whole.lang.testentities.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.testentities.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEntitiesEntityFactory extends GenericEntityFactory {
	public static final TestEntitiesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static TestEntitiesEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new TestEntitiesEntityFactory(provider);
	}

	protected TestEntitiesEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public SimpleTestEntity createSimpleTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
	}

	public SimpleTestEntity createSimpleTestEntity(ITestEntity anyEntityValue,
			IStructuralEntity structuralEntityValue,
			ICompositeEntity compositeEntityValue, IDataEntity dataEntityValue,
			BooleanTestEntity booleanValue, ByteTestEntity byteValue,
			CharTestEntity charValue, DoubleTestEntity doubleValue,
			FloatTestEntity floatValue, IntTestEntity intValue,
			LongTestEntity longValue, ShortTestEntity shortValue,
			StringTestEntity stringValue, DateTestEntity dateValue,
			EnumTestEntity enumValue, ObjectTestEntity objectValue) {
		return create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity,
				anyEntityValue, structuralEntityValue, compositeEntityValue,
				dataEntityValue, booleanValue, byteValue, charValue,
				doubleValue, floatValue, intValue, longValue, shortValue,
				stringValue, dateValue, enumValue, objectValue);
	}

	public IEntityBuilder<SimpleTestEntity> buildSimpleTestEntity() {
		return new EntityBuilder<SimpleTestEntity>(
				create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity));
	}

	public ListTestEntity createListTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.ListTestEntity);
	}

	public ListTestEntity createListTestEntity(ITestEntity... entities) {
		return create(TestEntitiesEntityDescriptorEnum.ListTestEntity,
				(IEntity[]) entities);
	}

	public ListTestEntity createListTestEntity(int initialSize) {
		return clone(TestEntitiesEntityDescriptorEnum.ListTestEntity,
				initialSize);
	}

	public UListTestEntity createUListTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.UListTestEntity);
	}

	public UListTestEntity createUListTestEntity(IStructuralEntity... entities) {
		return create(TestEntitiesEntityDescriptorEnum.UListTestEntity,
				(IEntity[]) entities);
	}

	public UListTestEntity createUListTestEntity(int initialSize) {
		return clone(TestEntitiesEntityDescriptorEnum.UListTestEntity,
				initialSize);
	}

	public SetTestEntity createSetTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.SetTestEntity);
	}

	public SetTestEntity createSetTestEntity(ITestEntity... entities) {
		return create(TestEntitiesEntityDescriptorEnum.SetTestEntity,
				(IEntity[]) entities);
	}

	public SetTestEntity createSetTestEntity(int initialSize) {
		return clone(TestEntitiesEntityDescriptorEnum.SetTestEntity,
				initialSize);
	}

	public BagTestEntity createBagTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.BagTestEntity);
	}

	public BagTestEntity createBagTestEntity(ITestEntity... entities) {
		return create(TestEntitiesEntityDescriptorEnum.BagTestEntity,
				(IEntity[]) entities);
	}

	public BagTestEntity createBagTestEntity(int initialSize) {
		return clone(TestEntitiesEntityDescriptorEnum.BagTestEntity,
				initialSize);
	}

	public MapTestEntity createMapTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.MapTestEntity);
	}

	public MapTestEntity createMapTestEntity(ITestEntity... IStructuralEntity) {
		return create(TestEntitiesEntityDescriptorEnum.MapTestEntity,
				(IEntity[]) IStructuralEntity);
	}

	public BooleanTestEntity createBooleanTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity);
	}

	public BooleanTestEntity createBooleanTestEntity(boolean value) {
		return create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity, value);
	}

	public ByteTestEntity createByteTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.ByteTestEntity);
	}

	public ByteTestEntity createByteTestEntity(byte value) {
		return create(TestEntitiesEntityDescriptorEnum.ByteTestEntity, value);
	}

	public CharTestEntity createCharTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.CharTestEntity);
	}

	public CharTestEntity createCharTestEntity(char value) {
		return create(TestEntitiesEntityDescriptorEnum.CharTestEntity, value);
	}

	public DoubleTestEntity createDoubleTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.DoubleTestEntity);
	}

	public DoubleTestEntity createDoubleTestEntity(double value) {
		return create(TestEntitiesEntityDescriptorEnum.DoubleTestEntity, value);
	}

	public FloatTestEntity createFloatTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.FloatTestEntity);
	}

	public FloatTestEntity createFloatTestEntity(float value) {
		return create(TestEntitiesEntityDescriptorEnum.FloatTestEntity, value);
	}

	public IntTestEntity createIntTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.IntTestEntity);
	}

	public IntTestEntity createIntTestEntity(int value) {
		return create(TestEntitiesEntityDescriptorEnum.IntTestEntity, value);
	}

	public LongTestEntity createLongTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.LongTestEntity);
	}

	public LongTestEntity createLongTestEntity(long value) {
		return create(TestEntitiesEntityDescriptorEnum.LongTestEntity, value);
	}

	public ShortTestEntity createShortTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.ShortTestEntity);
	}

	public ShortTestEntity createShortTestEntity(short value) {
		return create(TestEntitiesEntityDescriptorEnum.ShortTestEntity, value);
	}

	public StringTestEntity createStringTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.StringTestEntity);
	}

	public StringTestEntity createStringTestEntity(String value) {
		return create(TestEntitiesEntityDescriptorEnum.StringTestEntity, value);
	}

	public DateTestEntity createDateTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.DateTestEntity);
	}

	public DateTestEntity createDateTestEntity(java.util.Date value) {
		return create(TestEntitiesEntityDescriptorEnum.DateTestEntity, value);
	}

	public EnumTestEntity createEnumTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.EnumTestEntity);
	}

	public EnumTestEntity createEnumTestEntity(EnumTestEntityEnum.Value value) {
		return create(TestEntitiesEntityDescriptorEnum.EnumTestEntity, value);
	}

	public ObjectTestEntity createObjectTestEntity() {
		return create(TestEntitiesEntityDescriptorEnum.ObjectTestEntity);
	}

	public ObjectTestEntity createObjectTestEntity(java.lang.Object value) {
		return create(TestEntitiesEntityDescriptorEnum.ObjectTestEntity, value);
	}
}
