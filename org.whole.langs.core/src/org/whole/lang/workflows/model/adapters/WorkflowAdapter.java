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
public class WorkflowAdapter extends AbstractEntityAdapter implements Workflow {
	private static final long serialVersionUID = 1;

	public WorkflowAdapter(IEntity implementor) {
		super(implementor);
	}

	public WorkflowAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Workflow> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Workflow;
	}

	public Name getName() {
		return wGet(WorkflowsFeatureDescriptorEnum.name).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(WorkflowsFeatureDescriptorEnum.name, name);
	}

	public Description getDescription() {
		return wGet(WorkflowsFeatureDescriptorEnum.description).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Description);
	}

	public void setDescription(Description description) {
		wSet(WorkflowsFeatureDescriptorEnum.description, description);
	}

	public Declarations getDeclarations() {
		return wGet(WorkflowsFeatureDescriptorEnum.declarations).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Declarations);
	}

	public void setDeclarations(Declarations declarations) {
		wSet(WorkflowsFeatureDescriptorEnum.declarations, declarations);
	}

	public StartEvent getStartEvent() {
		return wGet(WorkflowsFeatureDescriptorEnum.startEvent).wGetAdapter(
				WorkflowsEntityDescriptorEnum.StartEvent);
	}

	public void setStartEvent(StartEvent startEvent) {
		wSet(WorkflowsFeatureDescriptorEnum.startEvent, startEvent);
	}

	public FlowObject getFlowObject() {
		return wGet(WorkflowsFeatureDescriptorEnum.flowObject).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FlowObject);
	}

	public void setFlowObject(FlowObject flowObject) {
		wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
	}

	public FlowEvent getEndEvent() {
		return wGet(WorkflowsFeatureDescriptorEnum.endEvent).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FlowEvent);
	}

	public void setEndEvent(FlowEvent endEvent) {
		wSet(WorkflowsFeatureDescriptorEnum.endEvent, endEvent);
	}
}
