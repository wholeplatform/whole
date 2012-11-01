package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Scope extends IWorkflowsEntity, FlowObject {
	public Declarations getDeclarations();

	public void setDeclarations(Declarations declarations);

	public FlowObject getFlowObject();

	public void setFlowObject(FlowObject flowObject);

	public FlowObject getCompensationHandler();

	public void setCompensationHandler(FlowObject compensationHandler);

	public EventHandlers getEventHandlers();

	public void setEventHandlers(EventHandlers eventHandlers);

	public FaultHandlers getFaultHandlers();

	public void setFaultHandlers(FaultHandlers faultHandlers);
}
