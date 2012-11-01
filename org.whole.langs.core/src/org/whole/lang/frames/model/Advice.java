package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Advice extends IFramesEntity {
	public JoinpointExpression getJoinpoints();

	public void setJoinpoints(JoinpointExpression joinpoints);

	public Content getContent();

	public void setContent(Content content);
}
