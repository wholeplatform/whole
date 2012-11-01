package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface JoinPoint extends IFramesEntity, VariationPoint {
	public FeatureName getName();

	public void setName(FeatureName name);

	public Content getContent();

	public void setContent(Content content);
}
