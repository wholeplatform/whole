package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface CreateEntity extends IWorkflowsEntity, Activity {
	public Variable getModel();

	public void setModel(Variable model);

	public Registry getRegistry();

	public void setRegistry(Registry registry);

	public Expression getEntityName();

	public void setEntityName(Expression entityName);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
