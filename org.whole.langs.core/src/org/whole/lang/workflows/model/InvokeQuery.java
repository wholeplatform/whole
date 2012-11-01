package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface InvokeQuery extends IWorkflowsEntity, Activity {
	public Variable getQueryName();

	public void setQueryName(Variable queryName);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
