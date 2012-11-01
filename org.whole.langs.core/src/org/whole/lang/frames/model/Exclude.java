package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Exclude extends IFramesEntity, Relation {
	public FeatureName getFeature();

	public void setFeature(FeatureName feature);

	public FeatureNames getExcludedFeatures();

	public void setExcludedFeatures(FeatureNames excludedFeatures);
}
