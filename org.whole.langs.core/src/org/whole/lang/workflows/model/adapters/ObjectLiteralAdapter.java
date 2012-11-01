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
public class ObjectLiteralAdapter extends AbstractEntityAdapter implements
		ObjectLiteral {
	private static final long serialVersionUID = 1;

	public ObjectLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public ObjectLiteralAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ObjectLiteral> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ObjectLiteral;
	}

	public Object getValue() {
		return (Object) wGetValue();
	}

	public void setValue(Object value) {
		wSetValue((Object) value);
	}
}
