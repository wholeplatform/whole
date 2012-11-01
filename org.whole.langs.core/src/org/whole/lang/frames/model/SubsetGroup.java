package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface SubsetGroup extends IFramesEntity, Subfeature {
	public Cardinality getCardinality();

	public void setCardinality(Cardinality cardinality);

	public VariableFeatures getFeatures();

	public void setFeatures(VariableFeatures features);
}
