package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MapTypeImpl extends AbstractSimpleEntity implements MapType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<MapType> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.MapType;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.MapType_ord;
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	private Type keyType;

	public Type getKeyType() {
		return notifyRequested(PojoFeatureDescriptorEnum.keyType, keyType);
	}

	public void setKeyType(Type keyType) {
		notifyChanged(PojoFeatureDescriptorEnum.keyType, this.keyType,
				this.keyType = keyType);
	}

	private Type valueType;

	public Type getValueType() {
		return notifyRequested(PojoFeatureDescriptorEnum.valueType, valueType);
	}

	public void setValueType(Type valueType) {
		notifyChanged(PojoFeatureDescriptorEnum.valueType, this.valueType,
				this.valueType = valueType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getKeyType().wGetAdaptee(false);
		case 1:
			return getValueType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setKeyType(value.wGetAdapter(PojoEntityDescriptorEnum.Type));
			break;
		case 1:
			setValueType(value.wGetAdapter(PojoEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
