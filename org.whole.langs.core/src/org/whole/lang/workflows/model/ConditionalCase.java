package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface ConditionalCase extends IWorkflowsEntity {
	public Label getLabel();

	public void setLabel(Label label);

	public Condition getCondition();

	public void setCondition(Condition condition);

	public FlowObject getFlowObject();

	public void setFlowObject(FlowObject flowObject);
}
