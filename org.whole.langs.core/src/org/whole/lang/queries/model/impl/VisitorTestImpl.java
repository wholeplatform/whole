package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VisitorTestImpl extends AbstractDataEntity implements VisitorTest {
	private static final long serialVersionUID = 1;
	private org.whole.lang.visitors.IVisitor value;

	public org.whole.lang.visitors.IVisitor getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.visitors.IVisitor value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IQueriesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return QueriesEntityDescriptorEnum.VisitorTest_ord;
	}

	public EntityDescriptor<VisitorTest> wGetEntityDescriptor() {
		return QueriesEntityDescriptorEnum.VisitorTest;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.visitors.IVisitor) value);
	}
}
