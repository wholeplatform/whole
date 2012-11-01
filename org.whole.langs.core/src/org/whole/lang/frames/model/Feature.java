package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Feature extends IFramesEntity, SolitaryFeature,
		JoinpointExpression {
	public Annotations getAnnotations();

	public void setAnnotations(Annotations annotations);

	public Subfeatures getFeatures();

	public void setFeatures(Subfeatures features);
}
