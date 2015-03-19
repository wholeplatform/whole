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
public class WorkflowImpl extends AbstractSimpleEntity implements Workflow {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Workflow> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Workflow;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.Workflow_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(WorkflowsFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Description description;

	public Description getDescription() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.description,
				description);
	}

	public void setDescription(Description description) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.description,
				this.description, this.description = description);
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

	private StartEvent startEvent;

	public StartEvent getStartEvent() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.startEvent,
				startEvent);
	}

	public void setStartEvent(StartEvent startEvent) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.startEvent,
				this.startEvent, this.startEvent = startEvent);
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

	private FlowEvent endEvent;

	public FlowEvent getEndEvent() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.endEvent,
				endEvent);
	}

	public void setEndEvent(FlowEvent endEvent) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.endEvent, this.endEvent,
				this.endEvent = endEvent);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getDescription().wGetAdaptee(false);
		case 2:
			return getDeclarations().wGetAdaptee(false);
		case 3:
			return getStartEvent().wGetAdaptee(false);
		case 4:
			return getFlowObject().wGetAdaptee(false);
		case 5:
			return getEndEvent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Name));
			break;
		case 1:
			setDescription(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Description));
			break;
		case 2:
			setDeclarations(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Declarations));
			break;
		case 3:
			setStartEvent(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.StartEvent));
			break;
		case 4:
			setFlowObject(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
			break;
		case 5:
			setEndEvent(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowEvent));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
