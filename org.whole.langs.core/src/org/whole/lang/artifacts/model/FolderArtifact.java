package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface FolderArtifact extends IArtifactsEntity, Artifact {
	public FolderName getName();

	public void setName(FolderName name);

	public Metadata getMetadata();

	public void setMetadata(Metadata metadata);

	public Artifacts getArtifacts();

	public void setArtifacts(Artifacts artifacts);
}
