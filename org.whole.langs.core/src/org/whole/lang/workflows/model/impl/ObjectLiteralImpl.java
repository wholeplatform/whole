package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ObjectLiteralImpl extends AbstractDataEntity implements
		ObjectLiteral {
	private static final long serialVersionUID = 1;
	private Object value;

	public Object getValue() {
		return notifyRequested(value);
	}

	public void setValue(Object value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.ObjectLiteral_ord;
	}

	public EntityDescriptor<ObjectLiteral> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ObjectLiteral;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue(value);
	}
}
