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
public class ScopeImpl extends AbstractSimpleEntity implements Scope {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Scope> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Scope;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.Scope_ord;
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

	private Declarations declarations;

	public Declarations getDeclarations() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.declarations,
				declarations);
	}

	public void setDeclarations(Declarations declarations) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.declarations,
				this.declarations, this.declarations = declarations);
	}

	private FlowObject flowObject;

	public FlowObject getFlowObject() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.flowObject,
				flowObject);
	}

	public void setFlowObject(FlowObject flowObject) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.flowObject,
				this.flowObject, this.flowObject = flowObject);
	}

	private FlowObject compensationHandler;

	public FlowObject getCompensationHandler() {
		return notifyRequested(
				WorkflowsFeatureDescriptorEnum.compensationHandler,
				compensationHandler);
	}

	public void setCompensationHandler(FlowObject compensationHandler) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.compensationHandler,
				this.compensationHandler,
				this.compensationHandler = compensationHandler);
	}

	private EventHandlers eventHandlers;

	public EventHandlers getEventHandlers() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.eventHandlers,
				eventHandlers);
	}

	public void setEventHandlers(EventHandlers eventHandlers) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.eventHandlers,
				this.eventHandlers, this.eventHandlers = eventHandlers);
	}

	private FaultHandlers faultHandlers;

	public FaultHandlers getFaultHandlers() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.faultHandlers,
				faultHandlers);
	}

	public void setFaultHandlers(FaultHandlers faultHandlers) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.faultHandlers,
				this.faultHandlers, this.faultHandlers = faultHandlers);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getDeclarations().wGetAdaptee(false);
		case 2:
			return getFlowObject().wGetAdaptee(false);
		case 3:
			return getCompensationHandler().wGetAdaptee(false);
		case 4:
			return getEventHandlers().wGetAdaptee(false);
		case 5:
			return getFaultHandlers().wGetAdaptee(false);
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
			setDeclarations(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Declarations));
			break;
		case 2:
			setFlowObject(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
			break;
		case 3:
			setCompensationHandler(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
			break;
		case 4:
			setEventHandlers(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.EventHandlers));
			break;
		case 5:
			setFaultHandlers(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FaultHandlers));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
