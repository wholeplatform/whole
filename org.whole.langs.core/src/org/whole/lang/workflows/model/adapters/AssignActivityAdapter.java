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
public class AssignActivityAdapter extends AbstractEntityAdapter implements
		AssignActivity {
	private static final long serialVersionUID = 1;

	public AssignActivityAdapter(IEntity implementor) {
		super(implementor);
	}

	public AssignActivityAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AssignActivity> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.AssignActivity;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Assignments getAssignments() {
		return wGet(WorkflowsFeatureDescriptorEnum.assignments).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void setAssignments(Assignments assignments) {
		wSet(WorkflowsFeatureDescriptorEnum.assignments, assignments);
	}
}
