package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface VariableFeature extends IFramesEntity, Subfeature {
	public SolitaryFeature getFeature();

	public void setFeature(SolitaryFeature feature);

	public VariableValue getValue();

	public void setValue(VariableValue value);
}
