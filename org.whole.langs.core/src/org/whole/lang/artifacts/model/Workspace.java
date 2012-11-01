package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface Workspace extends IArtifactsEntity {
	public Metadata getMetadata();

	public void setMetadata(Metadata metadata);

	public Projects getProjects();

	public void setProjects(Projects projects);
}
