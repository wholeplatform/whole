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
public class StringLiteralAdapter extends AbstractEntityAdapter implements
		StringLiteral {
	private static final long serialVersionUID = 1;

	public StringLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringLiteralAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringLiteral> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.StringLiteral;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
