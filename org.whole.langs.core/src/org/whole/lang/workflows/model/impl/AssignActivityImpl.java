package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class AssignActivityImpl extends AbstractSimpleEntity implements
		AssignActivity {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AssignActivity> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.AssignActivity;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.AssignActivity_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	private Label label;

	public Label getLabel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public void setLabel(Label label) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label,
				this.label = label);
	}

	private Assignments assignments;

	public Assignments getAssignments() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.assignments,
				assignments);
	}

	public void setAssignments(Assignments assignments) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.assignments,
				this.assignments, this.assignments = assignments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getAssignments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLabel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Label));
			break;
		case 1:
			setAssignments(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Assignments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
