package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class AssignAdapter extends AbstractEntityAdapter implements Assign {
	private static final long serialVersionUID = 1;

	public AssignAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssignAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Assign> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Assign;
	}

	public Variable getName() {
		return wGet(WorkflowsFeatureDescriptorEnum.name).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setName(Variable name) {
		wSet(WorkflowsFeatureDescriptorEnum.name, name);
	}

	public Expression getExpression() {
		return wGet(WorkflowsFeatureDescriptorEnum.expression).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(WorkflowsFeatureDescriptorEnum.expression, expression);
	}
}
