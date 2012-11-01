package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface IterationPoint extends IFramesEntity, VariationPoint {
	public FeatureName getIterator();

	public void setIterator(FeatureName iterator);

	public Content getContent();

	public void setContent(Content content);
}
