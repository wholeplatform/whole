package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface AnnotatedType extends IJavaEntity, Type {
	public Annotations getAnnotations();

	public void setAnnotations(Annotations annotations);

	public Type getType();

	public void setType(Type type);
}
