package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface CloneGroup extends IFramesEntity, Subfeature {
	public Cardinality getCardinality();

	public void setCardinality(Cardinality cardinality);

	public SolitaryFeatures getFeatures();

	public void setFeatures(SolitaryFeatures features);
}
