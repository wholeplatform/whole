package org.whole.lang.versions.model;

/** 
 * @generator Whole
 */
public interface Versionable extends IVersionsEntity {
	public Version getBaseVersion();

	public void setBaseVersion(Version baseVersion);

	public VersionsRefs getPredecessors();

	public void setPredecessors(VersionsRefs predecessors);
}
