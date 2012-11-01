package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface Project extends IArtifactsEntity {
	public ProjectName getName();

	public void setName(ProjectName name);

	public Natures getNatures();

	public void setNatures(Natures natures);

	public Metadata getMetadata();

	public void setMetadata(Metadata metadata);

	public Artifacts getArtifacts();

	public void setArtifacts(Artifacts artifacts);

	public LocationURI getLocationURI();

	public void setLocationURI(LocationURI locationURI);
}
