package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class DialectImpl extends AbstractDataEntity implements Dialect {
	private static final long serialVersionUID = 1;
	private org.whole.lang.dbcfg.model.DialectEnum.Value value;

	public org.whole.lang.dbcfg.model.DialectEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.dbcfg.model.DialectEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IDBCFGVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.Dialect_ord;
	}

	public EntityDescriptor<Dialect> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.Dialect;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.dbcfg.model.DialectEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(DialectEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.dbcfg.model.DialectEnum.Value) value);
	}
}
