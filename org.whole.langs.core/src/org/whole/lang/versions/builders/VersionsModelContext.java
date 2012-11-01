package org.whole.lang.versions.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionsModelContext extends EntityContext {
	public VersionsModelContext(IEntity root) {
		super(root);
	}

	public VersionsModelContext getVersions() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.versions);
	}

	public void setVersions(VersionsModelContext versions) {
		wSet(VersionsFeatureDescriptorEnum.versions, versions);
	}

	public VersionsModelContext getRootVersion() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.rootVersion);
	}

	public void setRootVersion(VersionsModelContext rootVersion) {
		wSet(VersionsFeatureDescriptorEnum.rootVersion, rootVersion);
	}

	public VersionsModelContext getVersionLabel() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.versionLabel);
	}

	public void setVersionLabel(VersionsModelContext versionLabel) {
		wSet(VersionsFeatureDescriptorEnum.versionLabel, versionLabel);
	}

	public VersionsModelContext getHistory() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.history);
	}

	public void setHistory(VersionsModelContext history) {
		wSet(VersionsFeatureDescriptorEnum.history, history);
	}

	public VersionsModelContext getPredecessors() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.predecessors);
	}

	public void setPredecessors(VersionsModelContext predecessors) {
		wSet(VersionsFeatureDescriptorEnum.predecessors, predecessors);
	}

	public VersionsModelContext getSuccessors() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.successors);
	}

	public void setSuccessors(VersionsModelContext successors) {
		wSet(VersionsFeatureDescriptorEnum.successors, successors);
	}

	public VersionsModelContext getVersionable() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.versionable);
	}

	public void setVersionable(VersionsModelContext versionable) {
		wSet(VersionsFeatureDescriptorEnum.versionable, versionable);
	}

	public VersionsModelContext getBaseVersion() {
		return (VersionsModelContext) wGet(VersionsFeatureDescriptorEnum.baseVersion);
	}

	public void setBaseVersion(VersionsModelContext baseVersion) {
		wSet(VersionsFeatureDescriptorEnum.baseVersion, baseVersion);
	}
}
