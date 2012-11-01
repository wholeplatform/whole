package org.whole.lang.versions.builders;

import org.whole.lang.builders.IBuilder;

/** 
 * @generator Whole
 */
public interface IVersionsBuilder extends IBuilder {
	public void visit();

	public void baseVersion();

	public void versionable();

	public void successors();

	public void predecessors();

	public void history();

	public void versionLabel();

	public void rootVersion();

	public void versions();

	public void History();

	public void History_();

	public void _History();

	public void Version();

	public void Version_();

	public void _Version();

	public void Versions();

	public void Versions_();

	public void Versions_(int initialCapacity);

	public void _Versions();

	public void VersionsRefs();

	public void VersionsRefs_();

	public void VersionsRefs_(int initialCapacity);

	public void _VersionsRefs();

	public void VersionLabel();

	public void VersionLabel(String value);
}
