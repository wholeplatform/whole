package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ShortDataImpl extends AbstractDataEntity implements ShortData {
	private static final long serialVersionUID = 1;
	private short value;

	public short getValue() {
		return notifyRequested(value);
	}

	public void setValue(short value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.ShortData_ord;
	}

	public EntityDescriptor<ShortData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.ShortData;
	}

	public Object wGetValue() {
		return new Short(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Short) value).shortValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Short.valueOf(value).shortValue());
		} catch (NumberFormatException e) {
		}
	}

	public short wShortValue() {
		return getValue();
	}

	public void wSetValue(short value) {
		setValue(value);
	}
}
