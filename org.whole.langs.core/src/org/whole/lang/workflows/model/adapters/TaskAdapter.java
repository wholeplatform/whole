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
public class TaskAdapter extends AbstractEntityAdapter implements Task {
	private static final long serialVersionUID = 1;

	public TaskAdapter(IEntity implementor) {
		super(implementor);
	}

	public TaskAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Task> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Task;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Description getDescription() {
		return wGet(WorkflowsFeatureDescriptorEnum.description).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Description);
	}

	public void setDescription(Description description) {
		wSet(WorkflowsFeatureDescriptorEnum.description, description);
	}

	public Assignments getAssignments() {
		return wGet(WorkflowsFeatureDescriptorEnum.assignments).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void setAssignments(Assignments assignments) {
		wSet(WorkflowsFeatureDescriptorEnum.assignments, assignments);
	}

	public Variable getFactory() {
		return wGet(WorkflowsFeatureDescriptorEnum.factory).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setFactory(Variable factory) {
		wSet(WorkflowsFeatureDescriptorEnum.factory, factory);
	}
}
