package org.whole.lang.versions.model;

/** 
 * @generator Whole
 */
public interface Version extends IVersionsEntity {
	public VersionLabel getVersionLabel();

	public void setVersionLabel(VersionLabel versionLabel);

	public History getHistory();

	public void setHistory(History history);

	public VersionsRefs getPredecessors();

	public void setPredecessors(VersionsRefs predecessors);

	public VersionsRefs getSuccessors();

	public void setSuccessors(VersionsRefs successors);

	public Versionable getVersionable();

	public void setVersionable(Versionable versionable);
}
