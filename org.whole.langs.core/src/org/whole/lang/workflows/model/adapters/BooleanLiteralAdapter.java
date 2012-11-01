package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class BooleanLiteralAdapter extends AbstractEntityAdapter implements
		BooleanLiteral {
	private static final long serialVersionUID = 1;

	public BooleanLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public BooleanLiteralAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BooleanLiteral> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.BooleanLiteral;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
