package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface PackageArtifact extends IArtifactsEntity, Artifact {
	public PackageName getName();

	public void setName(PackageName name);

	public Metadata getMetadata();

	public void setMetadata(Metadata metadata);

	public Artifacts getArtifacts();

	public void setArtifacts(Artifacts artifacts);
}
