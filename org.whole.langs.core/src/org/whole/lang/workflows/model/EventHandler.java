package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface EventHandler extends IWorkflowsEntity {
	public Name getName();

	public void setName(Name name);

	public Label getLabel();

	public void setLabel(Label label);

	public StartEvent getTriggerEvent();

	public void setTriggerEvent(StartEvent triggerEvent);

	public FlowObject getFlowObject();

	public void setFlowObject(FlowObject flowObject);
}
