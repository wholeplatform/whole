package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface NameWithExtension extends IArtifactsEntity, FileName {
	public Name getName();

	public void setName(Name name);

	public Extension getExtension();

	public void setExtension(Extension extension);
}
