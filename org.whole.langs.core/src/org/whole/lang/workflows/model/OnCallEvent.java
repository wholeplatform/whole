package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface OnCallEvent extends IWorkflowsEntity, StartEvent {
	public Parameters getParameters();

	public void setParameters(Parameters parameters);
}
