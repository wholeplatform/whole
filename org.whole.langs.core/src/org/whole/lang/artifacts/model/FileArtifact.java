package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface FileArtifact extends IArtifactsEntity, Artifact {
	public FileName getName();

	public void setName(FileName name);

	public Metadata getMetadata();

	public void setMetadata(Metadata metadata);

	public Content getContent();

	public void setContent(Content content);
}
