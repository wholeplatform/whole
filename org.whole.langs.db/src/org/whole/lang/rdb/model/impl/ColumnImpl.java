package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ColumnImpl extends AbstractSimpleEntity implements Column {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Column> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Column;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Column_ord;
	}

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName()
					.wEquals(entity.wGet(RDBFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private StringData name;

	public StringData getName() {
		return notifyRequested(RDBFeatureDescriptorEnum.name, name);
	}

	public void setName(StringData name) {
		notifyChanged(RDBFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Name featureName;

	public Name getFeatureName() {
		return notifyRequested(RDBFeatureDescriptorEnum.featureName,
				featureName);
	}

	public void setFeatureName(Name featureName) {
		notifyChanged(RDBFeatureDescriptorEnum.featureName, this.featureName,
				this.featureName = featureName);
	}

	private Name featureType;

	public Name getFeatureType() {
		return notifyRequested(RDBFeatureDescriptorEnum.featureType,
				featureType);
	}

	public void setFeatureType(Name featureType) {
		notifyChanged(RDBFeatureDescriptorEnum.featureType, this.featureType,
				this.featureType = featureType);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(RDBFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(RDBFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private IntData size;

	public IntData getSize() {
		return notifyRequested(RDBFeatureDescriptorEnum.size, size);
	}

	public void setSize(IntData size) {
		notifyChanged(RDBFeatureDescriptorEnum.size, this.size,
				this.size = size);
	}

	private IntData decimals;

	public IntData getDecimals() {
		return notifyRequested(RDBFeatureDescriptorEnum.decimals, decimals);
	}

	public void setDecimals(IntData decimals) {
		notifyChanged(RDBFeatureDescriptorEnum.decimals, this.decimals,
				this.decimals = decimals);
	}

	private BooleanData nullable;

	public BooleanData getNullable() {
		return notifyRequested(RDBFeatureDescriptorEnum.nullable, nullable);
	}

	public void setNullable(BooleanData nullable) {
		notifyChanged(RDBFeatureDescriptorEnum.nullable, this.nullable,
				this.nullable = nullable);
	}

	private StringData defaultValue;

	public StringData getDefaultValue() {
		return notifyRequested(RDBFeatureDescriptorEnum.defaultValue,
				defaultValue);
	}

	public void setDefaultValue(StringData defaultValue) {
		notifyChanged(RDBFeatureDescriptorEnum.defaultValue, this.defaultValue,
				this.defaultValue = defaultValue);
	}

	private StringData remarks;

	public StringData getRemarks() {
		return notifyRequested(RDBFeatureDescriptorEnum.remarks, remarks);
	}

	public void setRemarks(StringData remarks) {
		notifyChanged(RDBFeatureDescriptorEnum.remarks, this.remarks,
				this.remarks = remarks);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getFeatureName().wGetAdaptee(false);
		case 2:
			return getFeatureType().wGetAdaptee(false);
		case 3:
			return getType().wGetAdaptee(false);
		case 4:
			return getSize().wGetAdaptee(false);
		case 5:
			return getDecimals().wGetAdaptee(false);
		case 6:
			return getNullable().wGetAdaptee(false);
		case 7:
			return getDefaultValue().wGetAdaptee(false);
		case 8:
			return getRemarks().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		case 1:
			setFeatureName(value.wGetAdapter(RDBEntityDescriptorEnum.Name));
			break;
		case 2:
			setFeatureType(value.wGetAdapter(RDBEntityDescriptorEnum.Name));
			break;
		case 3:
			setType(value.wGetAdapter(RDBEntityDescriptorEnum.Type));
			break;
		case 4:
			setSize(value.wGetAdapter(RDBEntityDescriptorEnum.IntData));
			break;
		case 5:
			setDecimals(value.wGetAdapter(RDBEntityDescriptorEnum.IntData));
			break;
		case 6:
			setNullable(value.wGetAdapter(RDBEntityDescriptorEnum.BooleanData));
			break;
		case 7:
			setDefaultValue(value
					.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		case 8:
			setRemarks(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 9;
	}
}
