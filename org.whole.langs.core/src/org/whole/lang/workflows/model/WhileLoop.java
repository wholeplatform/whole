package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface WhileLoop extends IWorkflowsEntity, FlowObject {
	public TestTime getTestTime();

	public void setTestTime(TestTime testTime);

	public Condition getCondition();

	public void setCondition(Condition condition);

	public FlowObject getFlowObject();

	public void setFlowObject(FlowObject flowObject);
}
