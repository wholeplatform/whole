package org.whole.lang.frames.model;

/** 
 * @generator Whole
 */
public interface CustomAnnotation extends IFramesEntity, Annotation {
	public Name getName();

	public void setName(Name name);

	public Expression getValue();

	public void setValue(Expression value);
}
