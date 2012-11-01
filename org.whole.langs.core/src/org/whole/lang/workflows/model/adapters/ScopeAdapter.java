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
public class ScopeAdapter extends AbstractEntityAdapter implements Scope {
	private static final long serialVersionUID = 1;

	public ScopeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ScopeAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Scope> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Scope;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Declarations getDeclarations() {
		return wGet(WorkflowsFeatureDescriptorEnum.declarations).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Declarations);
	}

	public void setDeclarations(Declarations declarations) {
		wSet(WorkflowsFeatureDescriptorEnum.declarations, declarations);
	}

	public FlowObject getFlowObject() {
		return wGet(WorkflowsFeatureDescriptorEnum.flowObject).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FlowObject);
	}

	public void setFlowObject(FlowObject flowObject) {
		wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
	}

	public FlowObject getCompensationHandler() {
		return wGet(WorkflowsFeatureDescriptorEnum.compensationHandler)
				.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject);
	}

	public void setCompensationHandler(FlowObject compensationHandler) {
		wSet(WorkflowsFeatureDescriptorEnum.compensationHandler,
				compensationHandler);
	}

	public EventHandlers getEventHandlers() {
		return wGet(WorkflowsFeatureDescriptorEnum.eventHandlers).wGetAdapter(
				WorkflowsEntityDescriptorEnum.EventHandlers);
	}

	public void setEventHandlers(EventHandlers eventHandlers) {
		wSet(WorkflowsFeatureDescriptorEnum.eventHandlers, eventHandlers);
	}

	public FaultHandlers getFaultHandlers() {
		return wGet(WorkflowsFeatureDescriptorEnum.faultHandlers).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FaultHandlers);
	}

	public void setFaultHandlers(FaultHandlers faultHandlers) {
		wSet(WorkflowsFeatureDescriptorEnum.faultHandlers, faultHandlers);
	}
}
