package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SimpleTestEntityImpl extends AbstractSimpleEntity implements
		SimpleTestEntity {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SimpleTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.SimpleTestEntity;
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.SimpleTestEntity_ord;
	}

	public void accept(ITestEntitiesVisitor visitor) {
		visitor.visit(this);
	}

	private ITestEntity anyEntityValue;

	public ITestEntity getAnyEntityValue() {
		return notifyRequested(
				TestEntitiesFeatureDescriptorEnum.anyEntityValue,
				anyEntityValue);
	}

	public void setAnyEntityValue(ITestEntity anyEntityValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.anyEntityValue,
				this.anyEntityValue, this.anyEntityValue = anyEntityValue);
	}

	private IStructuralEntity structuralEntityValue;

	public IStructuralEntity getStructuralEntityValue() {
		return notifyRequested(
				TestEntitiesFeatureDescriptorEnum.structuralEntityValue,
				structuralEntityValue);
	}

	public void setStructuralEntityValue(IStructuralEntity structuralEntityValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.structuralEntityValue,
				this.structuralEntityValue,
				this.structuralEntityValue = structuralEntityValue);
	}

	private ICompositeEntity compositeEntityValue;

	public ICompositeEntity getCompositeEntityValue() {
		return notifyRequested(
				TestEntitiesFeatureDescriptorEnum.compositeEntityValue,
				compositeEntityValue);
	}

	public void setCompositeEntityValue(ICompositeEntity compositeEntityValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.compositeEntityValue,
				this.compositeEntityValue,
				this.compositeEntityValue = compositeEntityValue);
	}

	private IDataEntity dataEntityValue;

	public IDataEntity getDataEntityValue() {
		return notifyRequested(
				TestEntitiesFeatureDescriptorEnum.dataEntityValue,
				dataEntityValue);
	}

	public void setDataEntityValue(IDataEntity dataEntityValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.dataEntityValue,
				this.dataEntityValue, this.dataEntityValue = dataEntityValue);
	}

	private BooleanTestEntity booleanValue;

	public BooleanTestEntity getBooleanValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.booleanValue,
				booleanValue);
	}

	public void setBooleanValue(BooleanTestEntity booleanValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.booleanValue,
				this.booleanValue, this.booleanValue = booleanValue);
	}

	private ByteTestEntity byteValue;

	public ByteTestEntity getByteValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.byteValue,
				byteValue);
	}

	public void setByteValue(ByteTestEntity byteValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.byteValue,
				this.byteValue, this.byteValue = byteValue);
	}

	private CharTestEntity charValue;

	public CharTestEntity getCharValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.charValue,
				charValue);
	}

	public void setCharValue(CharTestEntity charValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.charValue,
				this.charValue, this.charValue = charValue);
	}

	private DoubleTestEntity doubleValue;

	public DoubleTestEntity getDoubleValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.doubleValue,
				doubleValue);
	}

	public void setDoubleValue(DoubleTestEntity doubleValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.doubleValue,
				this.doubleValue, this.doubleValue = doubleValue);
	}

	private FloatTestEntity floatValue;

	public FloatTestEntity getFloatValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.floatValue,
				floatValue);
	}

	public void setFloatValue(FloatTestEntity floatValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.floatValue,
				this.floatValue, this.floatValue = floatValue);
	}

	private IntTestEntity intValue;

	public IntTestEntity getIntValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.intValue,
				intValue);
	}

	public void setIntValue(IntTestEntity intValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.intValue,
				this.intValue, this.intValue = intValue);
	}

	private LongTestEntity longValue;

	public LongTestEntity getLongValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.longValue,
				longValue);
	}

	public void setLongValue(LongTestEntity longValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.longValue,
				this.longValue, this.longValue = longValue);
	}

	private ShortTestEntity shortValue;

	public ShortTestEntity getShortValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.shortValue,
				shortValue);
	}

	public void setShortValue(ShortTestEntity shortValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.shortValue,
				this.shortValue, this.shortValue = shortValue);
	}

	private StringTestEntity stringValue;

	public StringTestEntity getStringValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.stringValue,
				stringValue);
	}

	public void setStringValue(StringTestEntity stringValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.stringValue,
				this.stringValue, this.stringValue = stringValue);
	}

	private DateTestEntity dateValue;

	public DateTestEntity getDateValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.dateValue,
				dateValue);
	}

	public void setDateValue(DateTestEntity dateValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.dateValue,
				this.dateValue, this.dateValue = dateValue);
	}

	private EnumTestEntity enumValue;

	public EnumTestEntity getEnumValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.enumValue,
				enumValue);
	}

	public void setEnumValue(EnumTestEntity enumValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.enumValue,
				this.enumValue, this.enumValue = enumValue);
	}

	private ObjectTestEntity objectValue;

	public ObjectTestEntity getObjectValue() {
		return notifyRequested(TestEntitiesFeatureDescriptorEnum.objectValue,
				objectValue);
	}

	public void setObjectValue(ObjectTestEntity objectValue) {
		notifyChanged(TestEntitiesFeatureDescriptorEnum.objectValue,
				this.objectValue, this.objectValue = objectValue);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getAnyEntityValue().wGetAdaptee(false);
		case 1:
			return getStructuralEntityValue().wGetAdaptee(false);
		case 2:
			return getCompositeEntityValue().wGetAdaptee(false);
		case 3:
			return getDataEntityValue().wGetAdaptee(false);
		case 4:
			return getBooleanValue().wGetAdaptee(false);
		case 5:
			return getByteValue().wGetAdaptee(false);
		case 6:
			return getCharValue().wGetAdaptee(false);
		case 7:
			return getDoubleValue().wGetAdaptee(false);
		case 8:
			return getFloatValue().wGetAdaptee(false);
		case 9:
			return getIntValue().wGetAdaptee(false);
		case 10:
			return getLongValue().wGetAdaptee(false);
		case 11:
			return getShortValue().wGetAdaptee(false);
		case 12:
			return getStringValue().wGetAdaptee(false);
		case 13:
			return getDateValue().wGetAdaptee(false);
		case 14:
			return getEnumValue().wGetAdaptee(false);
		case 15:
			return getObjectValue().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setAnyEntityValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.ITestEntity));
			break;
		case 1:
			setStructuralEntityValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.IStructuralEntity));
			break;
		case 2:
			setCompositeEntityValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.ICompositeEntity));
			break;
		case 3:
			setDataEntityValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.IDataEntity));
			break;
		case 4:
			setBooleanValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.BooleanTestEntity));
			break;
		case 5:
			setByteValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.ByteTestEntity));
			break;
		case 6:
			setCharValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.CharTestEntity));
			break;
		case 7:
			setDoubleValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.DoubleTestEntity));
			break;
		case 8:
			setFloatValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.FloatTestEntity));
			break;
		case 9:
			setIntValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.IntTestEntity));
			break;
		case 10:
			setLongValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.LongTestEntity));
			break;
		case 11:
			setShortValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.ShortTestEntity));
			break;
		case 12:
			setStringValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.StringTestEntity));
			break;
		case 13:
			setDateValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.DateTestEntity));
			break;
		case 14:
			setEnumValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.EnumTestEntity));
			break;
		case 15:
			setObjectValue(value
					.wGetAdapter(TestEntitiesEntityDescriptorEnum.ObjectTestEntity));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 16;
	}
}
