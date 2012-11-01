package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface ArtifactsActivity extends IWorkflowsEntity, Activity {
	public Variable getModel();

	public void setModel(Variable model);

	public ResourceKind getRootResourceKind();

	public void setRootResourceKind(ResourceKind rootResourceKind);

	public Expression getRootResource();

	public void setRootResource(Expression rootResource);
}
