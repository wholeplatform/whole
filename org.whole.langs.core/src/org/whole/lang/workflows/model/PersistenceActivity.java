package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface PersistenceActivity extends IWorkflowsEntity, Activity {
	public Variable getModel();

	public void setModel(Variable model);

	public Expression getPersistence();

	public void setPersistence(Expression persistence);

	public ResourceKind getResourceKind();

	public void setResourceKind(ResourceKind resourceKind);

	public Expression getResource();

	public void setResource(Expression resource);

	public Assignments getBindings();

	public void setBindings(Assignments bindings);
}
