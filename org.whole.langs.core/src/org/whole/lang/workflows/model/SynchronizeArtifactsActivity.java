package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface SynchronizeArtifactsActivity extends IWorkflowsEntity,
		ArtifactsActivity {
	public ArtifactsTraversalStrategy getTraversalStrategy();

	public void setTraversalStrategy(
			ArtifactsTraversalStrategy traversalStrategy);

	public ArtifactsSynchronizeStrategy getSynchronizeStrategy();

	public void setSynchronizeStrategy(
			ArtifactsSynchronizeStrategy synchronizeStrategy);

	public Expression getDefaultPersistence();

	public void setDefaultPersistence(Expression defaultPersistence);
}
