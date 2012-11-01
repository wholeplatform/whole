package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Require extends IFramesEntity, Relation {
	public FeatureName getFeature();

	public void setFeature(FeatureName feature);

	public FeatureNames getRequiredFeatures();

	public void setRequiredFeatures(FeatureNames requiredFeatures);
}
