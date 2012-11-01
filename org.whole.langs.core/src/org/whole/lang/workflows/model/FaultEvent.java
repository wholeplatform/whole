package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface FaultEvent extends IWorkflowsEntity, FlowEvent {
	public Fault getFault();

	public void setFault(Fault fault);
}
