package org.whole.lang.testentities.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.testentities.reflect.TestEntitiesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SimpleTestEntityAdapter extends AbstractEntityAdapter implements
		SimpleTestEntity {
	private static final long serialVersionUID = 1;

	public SimpleTestEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleTestEntityAdapter() {
	}

	public void accept(ITestEntitiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.SimpleTestEntity;
	}

	public ITestEntity getAnyEntityValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.anyEntityValue)
				.wGetAdapter(TestEntitiesEntityDescriptorEnum.ITestEntity);
	}

	public void setAnyEntityValue(ITestEntity anyEntityValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.anyEntityValue, anyEntityValue);
	}

	public IStructuralEntity getStructuralEntityValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.structuralEntityValue)
				.wGetAdapter(TestEntitiesEntityDescriptorEnum.IStructuralEntity);
	}

	public void setStructuralEntityValue(IStructuralEntity structuralEntityValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.structuralEntityValue,
				structuralEntityValue);
	}

	public ICompositeEntity getCompositeEntityValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.compositeEntityValue)
				.wGetAdapter(TestEntitiesEntityDescriptorEnum.ICompositeEntity);
	}

	public void setCompositeEntityValue(ICompositeEntity compositeEntityValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.compositeEntityValue,
				compositeEntityValue);
	}

	public IDataEntity getDataEntityValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.dataEntityValue)
				.wGetAdapter(TestEntitiesEntityDescriptorEnum.IDataEntity);
	}

	public void setDataEntityValue(IDataEntity dataEntityValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.dataEntityValue, dataEntityValue);
	}

	public BooleanTestEntity getBooleanValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.booleanValue)
				.wGetAdapter(TestEntitiesEntityDescriptorEnum.BooleanTestEntity);
	}

	public void setBooleanValue(BooleanTestEntity booleanValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.booleanValue, booleanValue);
	}

	public ByteTestEntity getByteValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.byteValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.ByteTestEntity);
	}

	public void setByteValue(ByteTestEntity byteValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.byteValue, byteValue);
	}

	public CharTestEntity getCharValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.charValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.CharTestEntity);
	}

	public void setCharValue(CharTestEntity charValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.charValue, charValue);
	}

	public DoubleTestEntity getDoubleValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.doubleValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.DoubleTestEntity);
	}

	public void setDoubleValue(DoubleTestEntity doubleValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.doubleValue, doubleValue);
	}

	public FloatTestEntity getFloatValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.floatValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.FloatTestEntity);
	}

	public void setFloatValue(FloatTestEntity floatValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.floatValue, floatValue);
	}

	public IntTestEntity getIntValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.intValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.IntTestEntity);
	}

	public void setIntValue(IntTestEntity intValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.intValue, intValue);
	}

	public LongTestEntity getLongValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.longValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.LongTestEntity);
	}

	public void setLongValue(LongTestEntity longValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.longValue, longValue);
	}

	public ShortTestEntity getShortValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.shortValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.ShortTestEntity);
	}

	public void setShortValue(ShortTestEntity shortValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.shortValue, shortValue);
	}

	public StringTestEntity getStringValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.stringValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.StringTestEntity);
	}

	public void setStringValue(StringTestEntity stringValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.stringValue, stringValue);
	}

	public DateTestEntity getDateValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.dateValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.DateTestEntity);
	}

	public void setDateValue(DateTestEntity dateValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.dateValue, dateValue);
	}

	public EnumTestEntity getEnumValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.enumValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.EnumTestEntity);
	}

	public void setEnumValue(EnumTestEntity enumValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.enumValue, enumValue);
	}

	public ObjectTestEntity getObjectValue() {
		return wGet(TestEntitiesFeatureDescriptorEnum.objectValue).wGetAdapter(
				TestEntitiesEntityDescriptorEnum.ObjectTestEntity);
	}

	public void setObjectValue(ObjectTestEntity objectValue) {
		wSet(TestEntitiesFeatureDescriptorEnum.objectValue, objectValue);
	}
}
