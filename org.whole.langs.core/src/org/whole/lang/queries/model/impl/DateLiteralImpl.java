package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;
import java.util.Date;

/** 
 * @generator Whole
 */
public class DateLiteralImpl extends AbstractDataEntity implements DateLiteral {
	private static final long serialVersionUID = 1;
	private java.util.Date value;

	public java.util.Date getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.util.Date value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.DateLiteral_ord;
	}

	public EntityDescriptor<DateLiteral> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.DateLiteral;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.util.Date) value);
	}

	public String wStringValue() {
		return StringUtils.toExtendedISO8601DateTime(value);
	}

	public void wSetValue(String value) {
		try {
			setValue(StringUtils.fromExtendedISO8601DateTime(value));
		} catch (IllegalArgumentException e) {
		}
	}

	public Date wDateValue() {
		return value;
	}

	public void wSetValue(Date value) {
		setValue((Date) value);
	}
}
