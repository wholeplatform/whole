package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ColumnAdapter extends AbstractEntityAdapter implements Column {
	private static final long serialVersionUID = 1;

	public ColumnAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Column> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Column;
	}

	public StringData getName() {
		return wGet(RDBFeatureDescriptorEnum.name).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setName(StringData name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public Name getFeatureName() {
		return wGet(RDBFeatureDescriptorEnum.featureName).wGetAdapter(
				RDBEntityDescriptorEnum.Name);
	}

	public void setFeatureName(Name featureName) {
		wSet(RDBFeatureDescriptorEnum.featureName, featureName);
	}

	public Name getFeatureType() {
		return wGet(RDBFeatureDescriptorEnum.featureType).wGetAdapter(
				RDBEntityDescriptorEnum.Name);
	}

	public void setFeatureType(Name featureType) {
		wSet(RDBFeatureDescriptorEnum.featureType, featureType);
	}

	public Type getType() {
		return wGet(RDBFeatureDescriptorEnum.type).wGetAdapter(
				RDBEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(RDBFeatureDescriptorEnum.type, type);
	}

	public IntData getSize() {
		return wGet(RDBFeatureDescriptorEnum.size).wGetAdapter(
				RDBEntityDescriptorEnum.IntData);
	}

	public void setSize(IntData size) {
		wSet(RDBFeatureDescriptorEnum.size, size);
	}

	public IntData getDecimals() {
		return wGet(RDBFeatureDescriptorEnum.decimals).wGetAdapter(
				RDBEntityDescriptorEnum.IntData);
	}

	public void setDecimals(IntData decimals) {
		wSet(RDBFeatureDescriptorEnum.decimals, decimals);
	}

	public BooleanData getNullable() {
		return wGet(RDBFeatureDescriptorEnum.nullable).wGetAdapter(
				RDBEntityDescriptorEnum.BooleanData);
	}

	public void setNullable(BooleanData nullable) {
		wSet(RDBFeatureDescriptorEnum.nullable, nullable);
	}

	public StringData getDefaultValue() {
		return wGet(RDBFeatureDescriptorEnum.defaultValue).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setDefaultValue(StringData defaultValue) {
		wSet(RDBFeatureDescriptorEnum.defaultValue, defaultValue);
	}

	public StringData getRemarks() {
		return wGet(RDBFeatureDescriptorEnum.remarks).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setRemarks(StringData remarks) {
		wSet(RDBFeatureDescriptorEnum.remarks, remarks);
	}
}
