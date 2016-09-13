package org.whole.lang.testentities.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class TestEntitiesEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int SimpleTestEntity_ord = 0;
	public static final int ListTestEntity_ord = 1;
	public static final int UListTestEntity_ord = 2;
	public static final int SetTestEntity_ord = 3;
	public static final int BagTestEntity_ord = 4;
	public static final int MapTestEntity_ord = 5;
	public static final int BooleanTestEntity_ord = 6;
	public static final int ByteTestEntity_ord = 7;
	public static final int CharTestEntity_ord = 8;
	public static final int DoubleTestEntity_ord = 9;
	public static final int FloatTestEntity_ord = 10;
	public static final int IntTestEntity_ord = 11;
	public static final int LongTestEntity_ord = 12;
	public static final int ShortTestEntity_ord = 13;
	public static final int StringTestEntity_ord = 14;
	public static final int DateTestEntity_ord = 15;
	public static final int EnumTestEntity_ord = 16;
	public static final int ObjectTestEntity_ord = 17;
	public static final int IDataEntity_ord = 18;
	public static final int ICompositeEntity_ord = 19;
	public static final int ITestEntity_ord = 20;
	public static final int IStructuralEntity_ord = 21;
	public static final TestEntitiesEntityDescriptorEnum instance = new TestEntitiesEntityDescriptorEnum();
	public static final EntityDescriptor<SimpleTestEntity> SimpleTestEntity = (EntityDescriptor<SimpleTestEntity>) instance
			.valueOf(SimpleTestEntity_ord);
	public static final EntityDescriptor<ListTestEntity> ListTestEntity = (EntityDescriptor<ListTestEntity>) instance
			.valueOf(ListTestEntity_ord);
	public static final EntityDescriptor<UListTestEntity> UListTestEntity = (EntityDescriptor<UListTestEntity>) instance
			.valueOf(UListTestEntity_ord);
	public static final EntityDescriptor<SetTestEntity> SetTestEntity = (EntityDescriptor<SetTestEntity>) instance
			.valueOf(SetTestEntity_ord);
	public static final EntityDescriptor<BagTestEntity> BagTestEntity = (EntityDescriptor<BagTestEntity>) instance
			.valueOf(BagTestEntity_ord);
	public static final EntityDescriptor<MapTestEntity> MapTestEntity = (EntityDescriptor<MapTestEntity>) instance
			.valueOf(MapTestEntity_ord);
	public static final EntityDescriptor<BooleanTestEntity> BooleanTestEntity = (EntityDescriptor<BooleanTestEntity>) instance
			.valueOf(BooleanTestEntity_ord);
	public static final EntityDescriptor<ByteTestEntity> ByteTestEntity = (EntityDescriptor<ByteTestEntity>) instance
			.valueOf(ByteTestEntity_ord);
	public static final EntityDescriptor<CharTestEntity> CharTestEntity = (EntityDescriptor<CharTestEntity>) instance
			.valueOf(CharTestEntity_ord);
	public static final EntityDescriptor<DoubleTestEntity> DoubleTestEntity = (EntityDescriptor<DoubleTestEntity>) instance
			.valueOf(DoubleTestEntity_ord);
	public static final EntityDescriptor<FloatTestEntity> FloatTestEntity = (EntityDescriptor<FloatTestEntity>) instance
			.valueOf(FloatTestEntity_ord);
	public static final EntityDescriptor<IntTestEntity> IntTestEntity = (EntityDescriptor<IntTestEntity>) instance
			.valueOf(IntTestEntity_ord);
	public static final EntityDescriptor<LongTestEntity> LongTestEntity = (EntityDescriptor<LongTestEntity>) instance
			.valueOf(LongTestEntity_ord);
	public static final EntityDescriptor<ShortTestEntity> ShortTestEntity = (EntityDescriptor<ShortTestEntity>) instance
			.valueOf(ShortTestEntity_ord);
	public static final EntityDescriptor<StringTestEntity> StringTestEntity = (EntityDescriptor<StringTestEntity>) instance
			.valueOf(StringTestEntity_ord);
	public static final EntityDescriptor<DateTestEntity> DateTestEntity = (EntityDescriptor<DateTestEntity>) instance
			.valueOf(DateTestEntity_ord);
	public static final EntityDescriptor<EnumTestEntity> EnumTestEntity = (EntityDescriptor<EnumTestEntity>) instance
			.valueOf(EnumTestEntity_ord);
	public static final EntityDescriptor<ObjectTestEntity> ObjectTestEntity = (EntityDescriptor<ObjectTestEntity>) instance
			.valueOf(ObjectTestEntity_ord);
	public static final EntityDescriptor<IDataEntity> IDataEntity = (EntityDescriptor<IDataEntity>) instance
			.valueOf(IDataEntity_ord);
	public static final EntityDescriptor<ICompositeEntity> ICompositeEntity = (EntityDescriptor<ICompositeEntity>) instance
			.valueOf(ICompositeEntity_ord);
	public static final EntityDescriptor<ITestEntity> ITestEntity = (EntityDescriptor<ITestEntity>) instance
			.valueOf(ITestEntity_ord);
	public static final EntityDescriptor<IStructuralEntity> IStructuralEntity = (EntityDescriptor<IStructuralEntity>) instance
			.valueOf(IStructuralEntity_ord);

	private TestEntitiesEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(SimpleTestEntity_ord, "SimpleTestEntity",
				SimpleTestEntity.class, false)
				.withFeature(TestEntitiesFeatureDescriptorEnum.anyEntityValue,
						ITestEntity_ord)
				.withFeature(
						TestEntitiesFeatureDescriptorEnum.structuralEntityValue,
						IStructuralEntity_ord)
				.withFeature(
						TestEntitiesFeatureDescriptorEnum.compositeEntityValue,
						ICompositeEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.dataEntityValue,
						IDataEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.booleanValue,
						BooleanTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.byteValue,
						ByteTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.charValue,
						CharTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.doubleValue,
						DoubleTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.floatValue,
						FloatTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.intValue,
						IntTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.longValue,
						LongTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.shortValue,
						ShortTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.stringValue,
						StringTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.dateValue,
						DateTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.enumValue,
						EnumTestEntity_ord)
				.withFeature(TestEntitiesFeatureDescriptorEnum.objectValue,
						ObjectTestEntity_ord);
		putCompositeEntity(
		ListTestEntity_ord, "ListTestEntity", ListTestEntity.class, false, ITestEntity_ord, true, false);
		putCompositeEntity(
		UListTestEntity_ord, "UListTestEntity", UListTestEntity.class, false, IStructuralEntity_ord, true, true);
		putCompositeEntity(
		SetTestEntity_ord, "SetTestEntity", SetTestEntity.class, false, ITestEntity_ord, false, true);
		putCompositeEntity(
		BagTestEntity_ord, "BagTestEntity", BagTestEntity.class, false, ITestEntity_ord, false, false);
		putMapEntity(MapTestEntity_ord, "MapTestEntity", MapTestEntity.class,
				false, ITestEntity_ord, IStructuralEntity_ord);
		putDataEntity(BooleanTestEntity_ord, "BooleanTestEntity",
				BooleanTestEntity.class, false, boolean.class);
		putDataEntity(ByteTestEntity_ord, "ByteTestEntity",
				ByteTestEntity.class, false, byte.class);
		putDataEntity(CharTestEntity_ord, "CharTestEntity",
				CharTestEntity.class, false, char.class);
		putDataEntity(DoubleTestEntity_ord, "DoubleTestEntity",
				DoubleTestEntity.class, false, double.class);
		putDataEntity(FloatTestEntity_ord, "FloatTestEntity",
				FloatTestEntity.class, false, float.class);
		putDataEntity(IntTestEntity_ord, "IntTestEntity", IntTestEntity.class,
				false, int.class);
		putDataEntity(LongTestEntity_ord, "LongTestEntity",
				LongTestEntity.class, false, long.class);
		putDataEntity(ShortTestEntity_ord, "ShortTestEntity",
				ShortTestEntity.class, false, short.class);
		putDataEntity(StringTestEntity_ord, "StringTestEntity",
				StringTestEntity.class, false, String.class);
		putDataEntity(DateTestEntity_ord, "DateTestEntity",
				DateTestEntity.class, false, java.util.Date.class);
		putDataEntity(EnumTestEntity_ord, "EnumTestEntity",
				EnumTestEntity.class, false, EnumTestEntityEnum.Value.class);
		putDataEntity(ObjectTestEntity_ord, "ObjectTestEntity",
				ObjectTestEntity.class, false, java.lang.Object.class);
		putSimpleEntity(IDataEntity_ord, "IDataEntity", IDataEntity.class,
				true, EnumTestEntity_ord, CharTestEntity_ord,
				StringTestEntity_ord, FloatTestEntity_ord,
				ObjectTestEntity_ord, DoubleTestEntity_ord, IntTestEntity_ord,
				LongTestEntity_ord, ShortTestEntity_ord, DateTestEntity_ord,
				ByteTestEntity_ord, BooleanTestEntity_ord);
		putSimpleEntity(ICompositeEntity_ord, "ICompositeEntity",
				ICompositeEntity.class, true, ListTestEntity_ord,
				BagTestEntity_ord, SetTestEntity_ord, MapTestEntity_ord,
				UListTestEntity_ord);
		putSimpleEntity(ITestEntity_ord, "ITestEntity", ITestEntity.class,
				true, EnumTestEntity_ord, CharTestEntity_ord,
				ObjectTestEntity_ord, SetTestEntity_ord, IntTestEntity_ord,
				LongTestEntity_ord, ListTestEntity_ord, DateTestEntity_ord,
				ByteTestEntity_ord, StringTestEntity_ord, BagTestEntity_ord,
				FloatTestEntity_ord, MapTestEntity_ord, DoubleTestEntity_ord,
				SimpleTestEntity_ord, ShortTestEntity_ord,
				BooleanTestEntity_ord, UListTestEntity_ord);
		putSimpleEntity(IStructuralEntity_ord, "IStructuralEntity",
				IStructuralEntity.class, true, ListTestEntity_ord,
				BagTestEntity_ord, SetTestEntity_ord, SimpleTestEntity_ord,
				MapTestEntity_ord, UListTestEntity_ord);
	}
}
