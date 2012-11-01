package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface FaultHandler extends IWorkflowsEntity {
	public Name getName();

	public void setName(Name name);

	public Label getLabel();

	public void setLabel(Label label);

	public Fault getFaultName();

	public void setFaultName(Fault faultName);

	public Variable getFaultVariable();

	public void setFaultVariable(Variable faultVariable);

	public FlowObject getFlowObject();

	public void setFlowObject(FlowObject flowObject);
}
