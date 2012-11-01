package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Pointcut extends IFramesEntity, Relation {
	public Feature getFeature();

	public void setFeature(Feature feature);

	public JoinpointExpression getJoinpoints();

	public void setJoinpoints(JoinpointExpression joinpoints);
}
