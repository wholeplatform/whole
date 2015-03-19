package org.whole.lang.json.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.json.model.Int;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class IntImpl extends AbstractDataEntity implements Int {
    private static final long serialVersionUID = 1;
    private long value;

    public long getValue() {
        return notifyRequested(value);
    }

    public void setValue(long value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IJSONVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }

    public int wGetEntityOrd() {
        return JSONEntityDescriptorEnum.Int_ord;
    }

    public EntityDescriptor<Int> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Int;
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
