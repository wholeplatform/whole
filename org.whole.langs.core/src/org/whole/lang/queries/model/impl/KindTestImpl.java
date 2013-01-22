package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class KindTestImpl extends AbstractDataEntity implements KindTest {
	private static final long serialVersionUID = 1;
	private org.whole.lang.queries.model.KindTestEnum.Value value;

	public org.whole.lang.queries.model.KindTestEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.queries.model.KindTestEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.KindTest_ord;
	}

	public EntityDescriptor<KindTest> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.KindTest;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.queries.model.KindTestEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(KindTestEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.queries.model.KindTestEnum.Value) value);
	}
}
