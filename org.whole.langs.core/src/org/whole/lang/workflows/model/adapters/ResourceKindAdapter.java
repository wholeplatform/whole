package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.model.ResourceKindEnum.Value;

/** 
 * @generator Whole
 */
public class ResourceKindAdapter extends AbstractEntityAdapter implements
		ResourceKind {
	private static final long serialVersionUID = 1;

	public ResourceKindAdapter(IEntity implementor) {
		super(implementor);
	}

	public ResourceKindAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ResourceKind> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ResourceKind;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
