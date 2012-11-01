package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface ReturnEvent extends IWorkflowsEntity, FlowEvent {
	public Result getResult();

	public void setResult(Result result);
}
