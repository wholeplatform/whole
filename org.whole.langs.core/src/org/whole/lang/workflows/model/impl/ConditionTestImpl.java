package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class ConditionTestImpl extends AbstractDataEntity implements
		ConditionTest {
	private static final long serialVersionUID = 1;
	private org.whole.lang.workflows.model.ConditionTestEnum.Value value;

	public org.whole.lang.workflows.model.ConditionTestEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.workflows.model.ConditionTestEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.ConditionTest_ord;
	}

	public EntityDescriptor<ConditionTest> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ConditionTest;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.workflows.model.ConditionTestEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(ConditionTestEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.workflows.model.ConditionTestEnum.Value) value);
	}
}
