package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface CreateModel extends IWorkflowsEntity, Activity {
	public Variable getModel();

	public void setModel(Variable model);

	public Variable getTemplate();

	public void setTemplate(Variable template);

	public Assignments getBindings();

	public void setBindings(Assignments bindings);
}
