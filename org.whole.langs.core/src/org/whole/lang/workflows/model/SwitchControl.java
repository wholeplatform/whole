package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface SwitchControl extends IWorkflowsEntity, FlowObject {
	public SwitchType getSwitchType();

	public void setSwitchType(SwitchType switchType);

	public ConditionalCases getConditionalCases();

	public void setConditionalCases(ConditionalCases conditionalCases);

	public DefaultCase getDefaultCase();

	public void setDefaultCase(DefaultCase defaultCase);
}
