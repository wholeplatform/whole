package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface NormalAnnotation extends IJavaEntity, Annotation {
	public MemberValuePairs getValues();

	public void setValues(MemberValuePairs values);
}
