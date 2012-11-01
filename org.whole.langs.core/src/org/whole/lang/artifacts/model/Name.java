package org.whole.lang.artifacts.model;

/** 
 * @generator Whole
 */
public interface Name extends IArtifactsEntity, ProjectName, PackageName,
		FolderName, FileName {
	public String getValue();

	public void setValue(String value);
}
