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
public class ResourceKindImpl extends AbstractDataEntity implements
		ResourceKind {
	private static final long serialVersionUID = 1;
	private org.whole.lang.workflows.model.ResourceKindEnum.Value value;

	public org.whole.lang.workflows.model.ResourceKindEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.workflows.model.ResourceKindEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.ResourceKind_ord;
	}

	public EntityDescriptor<ResourceKind> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ResourceKind;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.workflows.model.ResourceKindEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(ResourceKindEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.workflows.model.ResourceKindEnum.Value) value);
	}
}
