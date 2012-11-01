package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface FeatureRename extends IFramesEntity, SolitaryFeatureName {
	public FeatureName getName();

	public void setName(FeatureName name);

	public FeatureName getNewName();

	public void setNewName(FeatureName newName);
}
