package org.whole.lang.versions.model;

/** 
 * @generator Whole
 */
public interface History extends IVersionsEntity {
	public Versions getVersions();

	public void setVersions(Versions versions);

	public Version getRootVersion();

	public void setRootVersion(Version rootVersion);
}
