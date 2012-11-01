package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface ForeachLoop extends IWorkflowsEntity, FlowObject {
	public Variable getCompositeVariable();

	public void setCompositeVariable(Variable compositeVariable);

	public Variable getElementVariable();

	public void setElementVariable(Variable elementVariable);

	public Variable getIndexVariable();

	public void setIndexVariable(Variable indexVariable);

	public FlowObject getFlowObject();

	public void setFlowObject(FlowObject flowObject);
}
