package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface InvokeOperation extends IWorkflowsEntity, Activity {
	public Variable getModel();

	public void setModel(Variable model);

	public Operation getOperation();

	public void setOperation(Operation operation);

	public Assignments getBindings();

	public void setBindings(Assignments bindings);
}
