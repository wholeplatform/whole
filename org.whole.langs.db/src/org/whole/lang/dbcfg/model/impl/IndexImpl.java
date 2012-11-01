package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IndexImpl extends AbstractDataEntity implements Index {
	private static final long serialVersionUID = 1;
	private int value;

	public int getValue() {
		return notifyRequested(value);
	}

	public void setValue(int value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IDBCFGVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.Index_ord;
	}

	public EntityDescriptor<Index> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.Index;
	}

	public Object wGetValue() {
		return new Integer(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Integer) value).intValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Integer.valueOf(value).intValue());
		} catch (NumberFormatException e) {
		}
	}

	public int wIntValue() {
		return getValue();
	}

	public void wSetValue(int value) {
		setValue(value);
	}
}
