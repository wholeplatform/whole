package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SingleMemberAnnotation extends IJavaEntity, Annotation {
	public Expression getValue();

	public void setValue(Expression value);
}
