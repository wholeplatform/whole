package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DataNameImpl extends AbstractDataEntity implements DataName {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.DataName_ord;
	}

	public EntityDescriptor<DataName> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.DataName;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((String) value);
	}

	public String wStringValue() {
		return getValue();
	}

	public void wSetValue(String value) {
		setValue(value);
	}
}
