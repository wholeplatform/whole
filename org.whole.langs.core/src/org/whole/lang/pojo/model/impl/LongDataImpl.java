package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class LongDataImpl extends AbstractDataEntity implements LongData {
	private static final long serialVersionUID = 1;
	private long value;

	public long getValue() {
		return notifyRequested(value);
	}

	public void setValue(long value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.LongData_ord;
	}

	public EntityDescriptor<LongData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.LongData;
	}

	public Object wGetValue() {
		return new Long(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Long) value).longValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Long.valueOf(value).longValue());
		} catch (NumberFormatException e) {
		}
	}

	public long wLongValue() {
		return getValue();
	}

	public void wSetValue(long value) {
		setValue(value);
	}
}
