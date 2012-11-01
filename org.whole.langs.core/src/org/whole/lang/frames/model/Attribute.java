package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface Attribute extends IFramesEntity, SolitaryFeature {
	public Type getType();

	public void setType(Type type);

	public Expression getValue();

	public void setValue(Expression value);
}
