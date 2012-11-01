package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface SelectionPoint extends IFramesEntity, VariationPoint {
	public FeatureName getSelector();

	public void setSelector(FeatureName selector);

	public Variants getVariants();

	public void setVariants(Variants variants);
}
