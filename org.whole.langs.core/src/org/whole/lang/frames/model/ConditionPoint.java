package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface ConditionPoint extends IFramesEntity, VariationPoint {
	public FeatureName getEnabler();

	public void setEnabler(FeatureName enabler);

	public Content getContent();

	public void setContent(Content content);
}
